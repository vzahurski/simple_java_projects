package com.apress.springrecipes.sequence;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.apress.springrecipes.sequence.config.SequenceGeneratorConfiguration;

public class Main {
    public static void main(String[] args) {
        // После создания экземпляра контекста приложения
        // ссылка на объект контекста — предоставляет точку
        // входа для доступа к экземплярам POJO или компонентам.
        ApplicationContext context =
                new AnnotationConfigApplicationContext(SequenceGeneratorConfiguration.class);
        // Получение бинов разными способами A,B,C,D смотри SequenceGeneratorConfiguration.java

        // Способ A вызывает исключение, так как в конфигурации есть другие методы возвращающие
        // объект класса SequenceGenerator
        // SequenceGenerator generatorA = context.getBean(SequenceGenerator.class);
        SequenceGenerator generatorB = (SequenceGenerator) context.getBean("sequenceGeneratorB");
        SequenceGenerator generatorC = context.getBean("sequenceGeneratorC",SequenceGenerator.class);
        SequenceGenerator generatorD = (SequenceGenerator) context.getBean("vza");
        //System.out.println(generatorA.getSequence());
        //System.out.println(generatorA.getSequence());
        System.out.println(generatorB.getSequence());
        System.out.println(generatorB.getSequence());
        System.out.println(generatorC.getSequence());
        System.out.println(generatorD.getSequence());
    }
}