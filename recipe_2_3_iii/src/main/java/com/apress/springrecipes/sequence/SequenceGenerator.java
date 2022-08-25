package com.apress.springrecipes.sequence;

import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.beans.factory.annotation.Autowired;

public class SequenceGenerator {
    @Autowired
    private PrefixGenerator[] prefixGenerators;
    // Интересно, то что @Autowired не внутри @Component, а будет учитываться при создании класса SequenceGenerator
    // вызовом метода sequenceGenerator() внутри класса конфигурации.
    // Аннотация @Autowired здесь применяется к типу массива
    // Spring будет искать компоненты, которые являются PrefixGenerator, для каждого такого класса
    // спринг создаст его бин и поместит в массив.
    // Таким образом спринг столько элементов поместит в массив, сколько компонентов являющихся PrefixGenerator ему
    // удалось найти. В данном случае два компонента DatePrefixGenerator и NumberPrefixGenerator
    // Это можно понять из вывода в Main 20220825-036-1000000A
    // Но можно ли управлять порядком помещения элементов в массив? Он алфавитноцифровой?
    // В данном случае это имеет значение
    private String suffix;
    private int initial;
    private AtomicInteger counter = new AtomicInteger();

    public SequenceGenerator() {
    }
    // Конструктор SequenceGenerator с параметрами не вызывается в нашем приложении
    public SequenceGenerator(PrefixGenerator[] prefixGenerators, String suffix, int initial) {
        this.prefixGenerators = prefixGenerators;
        this.suffix = suffix;
        this.initial = initial;
    }
    public void setPrefixGenerator(PrefixGenerator[] prefixGenerators) {
        this.prefixGenerators = prefixGenerators;
    }
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
    public void setInitial(int initial) {
        this.initial = initial;
    }
    public String getSequence() {
        StringBuilder builder = new StringBuilder();
        for (PrefixGenerator prefix : prefixGenerators) {
            builder.append(prefix.getPrefix());
            builder.append("-");
        }
        builder.append(initial).append(counter.getAndIncrement()).append(suffix);
        return builder.toString();
    }
}
