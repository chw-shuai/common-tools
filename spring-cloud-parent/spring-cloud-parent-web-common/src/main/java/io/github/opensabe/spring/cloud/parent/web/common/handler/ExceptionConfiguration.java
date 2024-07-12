package io.github.opensabe.spring.cloud.parent.web.common.handler;

import io.github.opensabe.common.observation.UnifiedObservationFactory;
import io.github.opensabe.spring.cloud.parent.common.handler.I18nMessageResolver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 拓展validation
 *
 * @author heng.ma
 */
@Configuration(proxyBeanMethods = false)
public class ExceptionConfiguration {

    @Bean
    public ExceptionHandlerObservationAop exceptionHandlerObservationAop(UnifiedObservationFactory unifiedObservationFactory) {
        return new ExceptionHandlerObservationAop(unifiedObservationFactory);
    }

    @Bean
    public I18nMessageResolver i18nMessageResolver (MessageSource messageSource) {
        return new I18nMessageResolver(messageSource);
    }

    @Bean
    @ConditionalOnMissingBean
    public GexceptionHandler gexceptionHandler(I18nMessageResolver i18nMessageResolver) {
        return new GexceptionHandler(i18nMessageResolver);
    }

    @Bean
    @ConditionalOnMissingBean
    public ThrowableHandler throwableHandler() {
        return new ThrowableHandler();
    }
}
