package com.apress.springrecipes.sequence;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.apress.springrecipes.sequence.config.SequenceConfiguration;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(SequenceConfiguration.class);

        SequenceGenerator generator = context.getBean(SequenceGenerator.class);

        System.out.println(generator.getSequence()); // 202208251000000A
        System.out.println(generator.getSequence()); // 202208251000001A
    }
}
