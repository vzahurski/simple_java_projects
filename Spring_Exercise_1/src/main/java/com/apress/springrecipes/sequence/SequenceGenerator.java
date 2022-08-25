package com.apress.springrecipes.sequence;

import java.util.concurrent.atomic.AtomicInteger;
// Мой POJO класс
public class SequenceGenerator {
    private String prefix;
    private String suffix;
    private int initial;
    // Creates a new AtomicInteger with initial value 0.
    private final AtomicInteger counter = new AtomicInteger();
    // Состояние номера последовательности (prefix,initial,counter,suffix),
    // которое будет возвращено вызовом getSequence()

    // В конструкторе не инициализируются поля класса
    // prefix, suffix = null, initial = 0, counter = 0
    public SequenceGenerator() {
    }
    public void setPrefix(String prefix) { this.prefix = prefix; }
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
    public void setInitial(int initial) { this.initial = initial; }
    // Метод возвращает состояние порядкового номера в последовательности
    // и генерирует следующий номер
    // getAndIncrement значит отдай текущее значение counter и увеличь его на 1
    public String getSequence() {
        StringBuilder builder = new StringBuilder();
        builder.append(prefix)
                .append(initial)
                .append(counter.getAndIncrement())
                .append(suffix);
        return builder.toString();
    }
}