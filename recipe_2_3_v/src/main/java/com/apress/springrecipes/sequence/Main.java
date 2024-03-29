package com.apress.springrecipes.sequence;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new GenericXmlApplicationContext("appContext.xml");
        SequenceGenerator generator =
                (SequenceGenerator) context.getBean("sequenceGenerator");
        System.out.println(generator.getSequence()); // 20220826100000A
        System.out.println(generator.getSequence()); // 20220826100001A
    }
}
