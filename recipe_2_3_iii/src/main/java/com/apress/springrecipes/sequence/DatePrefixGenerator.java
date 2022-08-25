package com.apress.springrecipes.sequence;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePrefixGenerator implements PrefixGenerator {
    private DateFormat formatter;
    public void setPattern(String pattern) {
        this.formatter = new SimpleDateFormat(pattern);
    }
    // Класс DatePrefixGenerator использует внутри себя объект класса SimpleDateFormat, параметрируемый паттерном pattern
    // Инъекцию объекта класса SimpleDateFormat можно сделать через сеттер setPattern
    // Реализация интерфейса PrefixGenerator
    public String getPrefix() {
        return formatter.format(new Date());
    }
}
