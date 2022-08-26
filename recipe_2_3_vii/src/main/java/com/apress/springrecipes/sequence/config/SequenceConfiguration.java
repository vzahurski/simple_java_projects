package com.apress.springrecipes.sequence.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import com.apress.springrecipes.sequence.PrefixGenerator;
import com.apress.springrecipes.sequence.SequenceGenerator;

@Configuration
@Import(PrefixConfiguration.class)
public class SequenceConfiguration {
    @Value("#{datePrefixGenerator}") // prefixGenerator получит значение бина datePrefixGenerator из PrefixConfiguration.class
    private PrefixGenerator prefixGenerator; // Это объвление переменной внутри класса конфигурации, поэтому private
    @Bean
    public SequenceGenerator sequenceGenerator() {
        SequenceGenerator sequence = new SequenceGenerator();
        sequence.setInitial(100000);
        sequence.setSuffix("A");
        sequence.setPrefixGenerator(prefixGenerator); // вызываем сеттер с переменной из класса конфигурации prefixGenerator
        return sequence;
    }
}
