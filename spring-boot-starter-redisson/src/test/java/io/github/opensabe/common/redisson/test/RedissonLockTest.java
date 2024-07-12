package io.github.opensabe.common.redisson.test;

import io.github.opensabe.common.redisson.annotation.RedissonLock;
import io.github.opensabe.common.redisson.annotation.RedissonLockName;
import io.github.opensabe.common.redisson.config.RedissonAopConfiguration;
import io.github.opensabe.common.redisson.exceptions.RedissonClientException;
import io.github.opensabe.common.redisson.test.common.SingleRedisIntegrationTest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.moditect.jfrunit.JfrEventTest;
import org.moditect.jfrunit.JfrEvents;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.actuate.observability.AutoConfigureObservability;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertThrows;

@AutoConfigureObservability
@JfrEventTest
@ExtendWith({SpringExtension.class, SingleRedisIntegrationTest.class})
@SpringBootTest(properties = {
        //spring-boot 2.6.x 开始，禁止循环依赖（A -> B, B -> A），字段注入一般会导致这种循环依赖，但是我们字段注入太多了，挨个检查太多了
        "spring.main.allow-circular-references=true",
        "spring.redis.redisson.aop.order=" + RedissonLockTest.ORDER,
        "spring.data.redis.host=127.0.0.1",
        "spring.data.redis.lettuce.pool.enabled=true",
        "spring.data.redis.lettuce.pool.max-active=2",
        "spring.data.redis.port="+ SingleRedisIntegrationTest.PORT,
})
public class RedissonLockTest {
    public static final int ORDER = -100000;
    private static final int THREAD_COUNT = 10;
    private static final int ADD_COUNT = 10000;

    public JfrEvents jfrEvents = new JfrEvents();

    @Autowired
    private RedissonAopConfiguration redissonAopConfiguration;

    @EnableAutoConfiguration
    @Configuration
    public static class App {
        @Autowired
        private RedissonClient redissonClient;

        @Bean
        @Primary
        public TestRedissonLockClass testRedissonLockClass() {
            return new TestRedissonLockClass(redissonClient);
        }

        @Bean
        public TestRedissonLockClassExtends testRedissonLockClassExtends() {
            return new TestRedissonLockClassExtends(redissonClient);
        }

        @Bean
        public TestRedissonLockInterfaceImpl testRedissonLockInterface() {
            return new TestRedissonLockInterfaceImpl(redissonClient);
        }
    }

    public interface TestRedissonLockInterface1 {
        @RedissonLock(lockType = RedissonLock.BLOCK_LOCK)
        void testBlockLockWithName(@RedissonLockName String name) throws InterruptedException;
    }

    public interface TestRedissonLockInterface2 {
        @RedissonLock(lockType = RedissonLock.BLOCK_LOCK, lockFeature = RedissonLock.LockFeature.SPIN)
        void testBlockSpinLock(@RedissonLockName String name) throws InterruptedException;
    }

    @Data
    public static class BaseClass {
        protected volatile int count = 0;
        protected final RedissonClient redissonClient;

        public void reset() {
            count = 0;
        }

        protected void add() throws InterruptedException {
            for (int i = 0; i < ADD_COUNT; i++) {
                count = count + 1;
            }
        }
    }


    public static class TestRedissonLockInterfaceImpl extends BaseClass implements TestRedissonLockInterface1, TestRedissonLockInterface2{
        public TestRedissonLockInterfaceImpl(RedissonClient redissonClient) {
            super(redissonClient);
        }

        @Override
        public void testBlockLockWithName(String name) throws InterruptedException {
            add();
        }

        @Override
        public void testBlockSpinLock(String name) throws InterruptedException {
            add();
        }
    }

    public static class TestRedissonLockClass extends BaseClass {
        public TestRedissonLockClass(RedissonClient redissonClient) {
            super(redissonClient);
        }

        @RedissonLock(lockType = RedissonLock.BLOCK_LOCK)
        public void testNoLock() throws InterruptedException {
            add();
        }

        @RedissonLock(lockType = RedissonLock.BLOCK_LOCK, name = "testBlockLockWithNoName")
        public void testBlockLockWithNoName() throws InterruptedException {
            add();
        }

        @RedissonLock(lockType = RedissonLock.BLOCK_LOCK)
        public void testBlockLock(@RedissonLockName String name) throws InterruptedException {
            add();
        }

        @RedissonLock(lockType = RedissonLock.BLOCK_LOCK, lockFeature = RedissonLock.LockFeature.SPIN)
        public void testBlockSpinLock(@RedissonLockName String name) throws InterruptedException {
            add();
        }

        @RedissonLock(lockType = RedissonLock.BLOCK_LOCK, lockFeature = RedissonLock.LockFeature.FAIR)
        public void testBlockFairLock(@RedissonLockName String name) throws InterruptedException {
            add();
        }

        @RedissonLock(lockType = RedissonLock.TRY_LOCK, waitTime = 100000, timeUnit = TimeUnit.MILLISECONDS)
        public void testTryLock(@RedissonLockName String name) throws InterruptedException {
            add();
        }

        @RedissonLock(lockType = RedissonLock.TRY_LOCK_NOWAIT)
        public void testTryLockNoWait(@RedissonLockName String name) throws InterruptedException {
            add();
            //3s 肯定够100个线程都 try lock 失败
            TimeUnit.SECONDS.sleep(3);
        }

        @RedissonLock
        public void testRedissonLockNameProperty(@RedissonLockName(prefix = "test:", expression = "#{id==null?name:id}") Student student, String params) throws InterruptedException {
            String lockName = student.getId() == null ? student.getName() : student.getId();
            RLock lock = redissonClient.getLock("test:" + lockName);
            Assertions.assertTrue(lock.isHeldByCurrentThread());
        }

        @RedissonLock(leaseTime = 1000L)
        public void testLockTime(@RedissonLockName String name) throws InterruptedException {
            RLock lock = redissonClient.getLock(RedissonLockName.DEFAULT_PREFIX + name);
            //验证获取了锁
            Assertions.assertTrue(lock.isHeldByCurrentThread());
            TimeUnit.SECONDS.sleep(2);
            //过了两秒，锁应该被释放了
            Assertions.assertFalse(lock.isLocked());
        }

        //waitTime只对于 trylock 有效
        @RedissonLock(lockType = RedissonLock.TRY_LOCK, waitTime = 1000L)
        public void testWaitTime(@RedissonLockName String name) throws InterruptedException {
            RLock lock = redissonClient.getLock(RedissonLockName.DEFAULT_PREFIX + name);
            //验证获取了锁
            Assertions.assertTrue(lock.isHeldByCurrentThread());
            TimeUnit.SECONDS.sleep(10);
        }
    }
    public static class TestRedissonLockClassExtends extends TestRedissonLockClass {

        public TestRedissonLockClassExtends(RedissonClient redissonClient) {
            super(redissonClient);
        }

        @Override
        public void testBlockLockWithNoName() throws InterruptedException {
            add();
        }
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Student {
        private String name;
        private String id;
        private int age;
    }

    @Autowired
    private TestRedissonLockClass testRedissonLockClass;
    @Autowired
    private TestRedissonLockClassExtends testRedissonLockClassExtends;
    @Autowired
    private TestRedissonLockInterfaceImpl testRedissonLockInterfaceImpl;
    @Autowired
    private TestRedissonLockInterface1 testRedissonLockInterface1;
    @Autowired
    private TestRedissonLockInterface2 testRedissonLockInterface2;

    @Test
    public void testAopConfiguration() {
        Assertions.assertEquals(redissonAopConfiguration.getOrder(), ORDER);
    }

    @Test
    public void testMultipleLock() throws InterruptedException {
        testRedissonLockClass.reset();
        //首先测无锁试多线程更新，这样最后的值肯定小于等于期望
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                try {
                    testRedissonLockClass.testNoLock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threads[i].start();
        }
        for (Thread item : threads) {
            item.join();
        }
        Assertions.assertTrue(testRedissonLockClass.getCount() <= THREAD_COUNT * ADD_COUNT);
        //测试阻塞锁，最后的值应该等于期望值
        testRedissonLockClass.reset();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                try {
                    testRedissonLockClass.testBlockLock("same");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threads[i].start();
        }
        for (Thread value : threads) {
            value.join();
        }
        Assertions.assertEquals(testRedissonLockClass.getCount(), THREAD_COUNT * ADD_COUNT);
        //测试阻塞锁，最后的值应该等于期望值
        testRedissonLockClass.reset();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                try {
                    testRedissonLockClass.testBlockLockWithNoName();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threads[i].start();
        }
        for (Thread value : threads) {
            value.join();
        }
        Assertions.assertEquals(testRedissonLockClass.getCount(), THREAD_COUNT * ADD_COUNT);

        testRedissonLockClass.reset();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                try {
                    testRedissonLockClass.testBlockSpinLock("same");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threads[i].start();
        }
        for (Thread value : threads) {
            value.join();
        }
        Assertions.assertEquals(testRedissonLockClass.getCount(), THREAD_COUNT * ADD_COUNT);

        testRedissonLockClass.reset();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                try {
                    testRedissonLockClass.testBlockFairLock("same");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threads[i].start();
        }
        for (Thread value : threads) {
            value.join();
        }
        Assertions.assertEquals(testRedissonLockClass.getCount(), THREAD_COUNT * ADD_COUNT);

        //测试 tryLock锁 + 等待时间，由于是本地 redis 这个 10s 等待时间应该足够，最后的值应该等于期望值
        testRedissonLockClass.reset();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                try {
                    testRedissonLockClass.testTryLock("same");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        Assertions.assertEquals(testRedissonLockClass.getCount(), THREAD_COUNT * ADD_COUNT);
        //测试 tryLock锁，不等待
        testRedissonLockClass.reset();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                try {
                    testRedissonLockClass.testTryLockNoWait("same");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (RedissonClientException e) {
                    System.out.println(e.getMessage());
                }
            });
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        //由于锁住的时间比较久，只有一个线程执行了 add()
        Assertions.assertEquals(testRedissonLockClass.getCount(), ADD_COUNT);

        testRedissonLockInterfaceImpl.reset();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                try {
                    testRedissonLockInterfaceImpl.testBlockLockWithName("same");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (RedissonClientException e) {
                    System.out.println(e.getMessage());
                }
            });
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        //由于锁住的时间比较久，只有一个线程执行了 add()
        Assertions.assertEquals(testRedissonLockInterfaceImpl.getCount(), THREAD_COUNT * ADD_COUNT);

        testRedissonLockInterfaceImpl.reset();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                try {
                    testRedissonLockInterfaceImpl.testBlockSpinLock("same");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (RedissonClientException e) {
                    System.out.println(e.getMessage());
                }
            });
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        //由于锁住的时间比较久，只有一个线程执行了 add()
        Assertions.assertEquals(testRedissonLockInterfaceImpl.getCount(), THREAD_COUNT * ADD_COUNT);

        testRedissonLockInterfaceImpl.reset();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                try {
                    testRedissonLockInterface1.testBlockLockWithName("same");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (RedissonClientException e) {
                    System.out.println(e.getMessage());
                }
            });
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        //由于锁住的时间比较久，只有一个线程执行了 add()
        Assertions.assertEquals(testRedissonLockInterfaceImpl.getCount(), THREAD_COUNT * ADD_COUNT);

        testRedissonLockInterfaceImpl.reset();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                try {
                    testRedissonLockInterface2.testBlockSpinLock("same");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (RedissonClientException e) {
                    System.out.println(e.getMessage());
                }
            });
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        //由于锁住的时间比较久，只有一个线程执行了 add()
        Assertions.assertEquals(testRedissonLockInterfaceImpl.getCount(), THREAD_COUNT * ADD_COUNT);

        testRedissonLockClassExtends.reset();
        //测试阻塞锁，最后的值应该等于期望值
        testRedissonLockClassExtends.reset();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                try {
                    testRedissonLockClassExtends.testBlockLock("same");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threads[i].start();
        }
        for (Thread value : threads) {
            value.join();
        }
        Assertions.assertEquals(testRedissonLockClassExtends.getCount(), THREAD_COUNT * ADD_COUNT);
        //测试阻塞锁，最后的值应该等于期望值
        testRedissonLockClassExtends.reset();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                try {
                    testRedissonLockClassExtends.testBlockLockWithNoName();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threads[i].start();
        }
        for (Thread value : threads) {
            value.join();
        }
        Assertions.assertEquals(testRedissonLockClassExtends.getCount(), THREAD_COUNT * ADD_COUNT);
    }

    @Test
    public void testBlockProperty() throws InterruptedException {
        testRedissonLockClass.reset();
        testRedissonLockClass.testRedissonLockNameProperty(Student.builder().name("zhx").build(), "zhx");
        testRedissonLockClass.testRedissonLockNameProperty(Student.builder().id("111111").build(), "zhx");
    }

    @Test
    public void testLockTime() throws InterruptedException {
        testRedissonLockClass.reset();
        testRedissonLockClass.testLockTime("same");
    }

    @Test
    public void testWaitTime() throws InterruptedException {
        testRedissonLockClass.reset();
        Thread thread = new Thread(() -> {
            try {
                testRedissonLockClass.testWaitTime("same");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(3);
        //在等待时间内获取不到锁，抛异常
        assertThrows(RedissonClientException.class, () -> testRedissonLockClass.testWaitTime("same"));
    }

    @Test
    public void testMultiNameLock() throws InterruptedException {
        testRedissonLockClass.reset();
        //首先测无锁试多线程更新，这样最后的值肯定小于等于期望
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < threads.length; i++) {
            int finalI = i;
            threads[i] = new Thread(() -> {
                try {
                    //相当于没有锁住
                    testRedissonLockClass.testBlockLock(threads[finalI].getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
        Assertions.assertTrue(testRedissonLockClass.getCount() <= THREAD_COUNT * ADD_COUNT);
    }
}