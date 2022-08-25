package com.apress.springrecipes.sequence;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        // Сканируем пакет com.apress.springrecipes.sequence для обранужения классов конфигурации
        // а в классах конфигурации прописано, какие пакеты сканируем для обнаружения компонентов
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.apress.springrecipes.sequence");
        // Достаем из контекста бин по ключу SequenceDao.class.
        // Хотя это только интерфейс, который реализован классом SequenceDaoImpl, помеченный @Component("sequenceDao")
        // SequenceDao sequenceDao = context.getBean(SequenceDao.class);

        // Вопрос. Объекты типа интерфейс извлекаются из контекста по данным класса, которые реализуют этот интерфейс
        // Этот класс должен быть помечен @Component
        SequenceDao sequenceDao = (SequenceDao) context.getBean("sequenceDao");

        System.out.println(sequenceDao.getNextValue("IT"));
        System.out.println(sequenceDao.getNextValue("IT"));
    }
}
