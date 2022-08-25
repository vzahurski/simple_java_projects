package com.apress.springrecipes.sequence.config;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
@Configuration
@ComponentScan(
        includeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.REGEX, // отобрать классы по шаблону на полное имя класса
                        pattern = {"com.apress.springrecipes.sequence.*Dao", "com.apress.springrecipes.sequence.*Service"})
        },
        excludeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.ANNOTATION, // Исключить из отобранных includeFilters классов, отмеченные заданной аннотацией @Controller.
                        classes = {org.springframework.stereotype.Controller.class}) }
                )
public class SequenceGeneratorConfiguration {
}
// При сканировании должен найтись один класс SequenceDaoImpl, помеченный @Component("sequenceDao")