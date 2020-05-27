package reflection;

import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import java.util.Set;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {

//        JAVA REFLECTION
//        https://www.youtube.com/watch?v=agnblS47F18
//        http://www.newthinktank.com/2012/09/abstract-factory-design-pattern/
        Reflections r = new Reflections(new ConfigurationBuilder()
                .setScanners(new SubTypesScanner(false), new ResourcesScanner())
                .addUrls(ClasspathHelper.forJavaClassPath())
                .filterInputsBy(new FilterBuilder().include(FilterBuilder.prefix(
                        "reflection")))
        );

        Set<Class<?>> classes = r.getSubTypesOf(Object.class);
//        classes.forEach(System.out::println);
        classes.forEach(new Consumer<Class<?>>() {
            @Override
            public void accept(Class<?> clazz) {
                if (clazz.isAnnotationPresent(Hype.class)) {
                    Hype ann = clazz.getAnnotation(Hype.class);
                    if (ann.level() > 50) {
                        System.out.println(clazz);
                        System.out.println(ann.level());
                    }
                }
            }
        });





    }
}
