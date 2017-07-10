package core.annotation.view;

import com.google.auto.service.AutoService;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;

/**
 * @author DrkCore
 * @since 2017-7-10
 */
@AutoService(Processor.class)
public class ContentViewProcessor extends AbstractProcessor {

    private Filer filer;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        this.filer = processingEnv.getFiler();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> annotationTypes = new LinkedHashSet<>(1);
        annotationTypes.add(ContentView.class.getCanonicalName());
        return annotationTypes;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    public static final String API_PKG = "core.annotation.view";
    public static final String API_NAME = "ContentViews";
    public static final String API_PATH = API_PKG + "." + API_NAME;

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Map<String, Integer> map = new HashMap<>();
        Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(ContentView.class);
        for (Element element : elements) {
            TypeElement type = (TypeElement) element;
            ContentView annotation = type.getAnnotation(ContentView.class);
            String name = type.getQualifiedName().toString();
            map.put(name, annotation.value());
        }

        try {
            JavaFileObject sourceFile = filer.createSourceFile(API_PATH);
            Writer writer = sourceFile.openWriter();
            writer.write(generateCode(map));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    public String generateCode(Map<String, Integer> map) {
        StringBuilder builder = new StringBuilder();

        builder.append("/*Generated code. Do not modify !!!*/").append("\n");

        builder.append("package ").append(API_PKG).append(";").append("\n\n");

        builder.append("import java.util.HashMap;").append("\n");
        builder.append("import java.util.Map;").append("\n\n");

        builder.append("public class ").append(API_NAME).append(" {");
        builder.append("\n\n");

        builder.append("    private static final Map<Class, Integer> map = new HashMap<>(").append(map.size()).append(");");
        builder.append("\n\n");

        builder.append("    public static int get(Object obj) {").append("\n");
        builder.append("        return map.get(obj.getClass());").append("\n");
        builder.append("    }").append("\n\n");

        builder.append("    static {").append("\n");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            builder.append("        map.put(").append(entry.getKey()).append(".class, ").append(entry.getValue()).append(");").append("\n");
        }
        builder.append("    }").append("\n\n");

        builder.append("}\n");

        return builder.toString();
    }
}
