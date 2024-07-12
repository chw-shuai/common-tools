package io.github.opensabe.mapstruct.processor;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;
import io.github.opensabe.mapstruct.core.Binding;

import javax.annotation.processing.*;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import java.io.IOException;
import java.io.Writer;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 根据{@link Binding}注解，自动生成相应的Mapper
 * @author heng.ma
 */
@SupportedAnnotationTypes("io.github.opensabe.mapstruct.core.Binding")
public class MapperGeneratorProcessor extends AbstractProcessor {

    private Elements elementUtils;

    private Filer filer;

    private Types typeUtils;

    private TypeMirror bindingMirror;

    //保存已经创建过的mapper
    final static MapperRep mappers = new MapperRep();

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        elementUtils = processingEnv.getElementUtils();
        filer = processingEnv.getFiler();
        typeUtils = processingEnv.getTypeUtils();
        bindingMirror = elementUtils.getTypeElement(Binding.class.getName()).asType();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        //待创建的mapper，最后Processor结束以后清空

        if (!roundEnv.processingOver()) {
            Set<AbstractMapper> maps = new HashSet<>();
            for (TypeElement annotation : annotations) {
                Set<? extends Element> beans = roundEnv.getElementsAnnotatedWith(annotation);
                for (Element bean : beans) {
                    List<? extends AnnotationMirror> bindings = bean.getAnnotationMirrors()
                            .stream().filter(m -> typeUtils.isSameType(m.getAnnotationType(), bindingMirror))
                            .collect(Collectors.toList());
                    maps.addAll(MetaDataFactory.create(elementUtils, bean, bindings));
                }
            }
            for (AbstractMapper mapper : maps) {
                if (!mappers.contains(mapper)) {
                    String className = mapper.getPackageName() + "." + mapper.getMapperName();
                    try (Writer writer = filer.createSourceFile(className)
                            .openWriter()) {
                        Configuration cfg = new Configuration(new Version("2.3.32"));
                        cfg.setClassForTemplateLoading(MapperGeneratorProcessor.class, "/");
                        cfg.setDefaultEncoding("UTF-8");

                        Template template = cfg.getTemplate(mapper.template());
                        template.process(mapper, writer);
                        writer.flush();
                        mappers.add(mapper);

                    } catch (TemplateException | IOException ex) {
                        throw new IllegalStateException(ex);
                    }
                }
            }
        }
        return false;
    }
}
