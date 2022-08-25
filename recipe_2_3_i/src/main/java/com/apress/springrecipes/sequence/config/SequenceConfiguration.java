package com.apress.springrecipes.sequence.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.apress.springrecipes.sequence.DatePrefixGenerator;
import com.apress.springrecipes.sequence.SequenceGenerator;

@Configuration
public class SequenceConfiguration {
    @Bean
    public DatePrefixGenerator datePrefixGenerator() {
        DatePrefixGenerator dpg = new DatePrefixGenerator();
        dpg.setPattern("yyyyMMdd");
        return dpg;
    }
    @Bean
    public SequenceGenerator sequenceGenerator() {
        SequenceGenerator sequence = new SequenceGenerator();
        sequence.setInitial(100000);
        sequence.setSuffix("A");
        sequence.setPrefixGenerator(datePrefixGenerator());
        return sequence;
    }
}
// Чтобы получить бин SequenceGenerator нужно создать объект SequenceGenerator конструктором без параметров
// Затем сеттерами установить его свойства. Чтобы засетать PrefixGenerator мы должны создать объект такого типа
// PrefixGenerator. Будем его создавать через бин метод класса конфигурации datePrefixGenerator()
// Так как SequenceGenerator зависит от DatePrefixGenerator то сначала будет создан объект DatePrefixGenerator
// а потом он внедрен в  SequenceGenerator
// В этом случае зависимость между бинами прописыввается в классе конфигурации, через вызов бин методов





