package com.apress.springrecipes.sequence;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        // Сканируем пакет на построение контекста на основе классов с @Component
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.apress.springrecipes.sequence");
        SequenceService sequenceService =
                context.getBean(SequenceService.class);
        System.out.println(sequenceService.generate("IT")); // 3010000A
        System.out.println(sequenceService.generate("IT")); // 3010001A
    }
}
