package com.apress.springrecipes.sequence;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        // Сканируем пакет com.apress.springrecipes.sequence для обранужения классов конфигурации
        // а в классах конфигурации прописано, какие пакеты сканируем для обнаружения компонентов
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.apress.springrecipes.sequence");
        // Интерфейс является классом, поэтому имеет смысл SequenceDao.class , несмотря на то что SequenceDao - интерфейс
        // Переменную типа SequenceDaoImpl можно положить в переменную типа интерфейса SequenceDao
        // SequenceDao как бы родительский класс по отношению к SequenceDaoImpl - для него Спрингом будет создан бин компонент
        // Вопрос: Мы можем использовать в качестве ключа в контексте родительские классы для класса помеченного @Component?
        // Что если у нас два класса помечено @Component, которые реализуют интерфейс SequenceDao?
        // Попробовал => исключение с непонятным стектрейсом. Хитрая ошибка

        // Достаем из контекста бин по ключу родительского класса интерфейс SequenceDao.class.
        // SequenceDao sequenceDao = context.getBean(SequenceDao.class);
        SequenceDao sequenceDao = (SequenceDao) context.getBean("sequenceDao");
        System.out.println(sequenceDao.getClass()); // com.apress.springrecipes.sequence.SequenceDaoImpl

        System.out.println(sequenceDao.getNextValue("IT"));
        System.out.println(sequenceDao.getNextValue("IT"));
    }
}
