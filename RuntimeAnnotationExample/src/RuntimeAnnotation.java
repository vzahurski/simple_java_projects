import java.lang.annotation.*;

public class RuntimeAnnotation {
    public static void main(String[] args) {
        System.out.println("Start");

        // Получим все аннотации класса MyClass1
        Class aClass = MyClass1.class;
        Annotation[] annotations = aClass.getAnnotations();
        for (Annotation annotation : annotations) {
            if(annotation instanceof Service) {
                Service mAnnotation = (Service) annotation;
                System.out.println("name: " + mAnnotation.name());
                System.out.println("value: " + mAnnotation.value());
            }
        }
        // Как среди классов MyClass1-2-3 найти имена классов помеченных аннотацией Service



    }
}

@Service(name="vza",  value = "metadata")
class MyClass1 {
}

class MyClass2 {
}