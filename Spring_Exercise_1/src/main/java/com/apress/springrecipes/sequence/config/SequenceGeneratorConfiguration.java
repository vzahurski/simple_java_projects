package com.apress.springrecipes.sequence.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.apress.springrecipes.sequence.SequenceGenerator;
/*
Create a Java Config with @Configuration and @Bean to Create POJOs

Обратите внимание, что
класс конфигурации SequenceGeneratorConfiguration помечен аннотацией @Configuration;
это говорит Spring, что это класс конфигурации.
Когда Spring сталкивается с классом с аннотацией @Configuration,
он ищет методы Java, помеченные аннотацией @Bean.
Spring возвращает бин (экземпляр) класса (компонента) возвращаемого бин методом с помощью getBean
--------------------------------------------------------------------------------------
Ключ контекста, по которому можно вытаскивать экземпляры (бины) из контекста.
т.е. идентификатор бина в контексте это как бы координаты, которые идентифицируют бин

A. Идентификатор = <Имя класса объекта возвращаемого бин методом>.class
получаем объект по getBean(<Имя класса объекта возвращаемого бин методом>.class)

SequenceGenerator generator = context.getBean(SequenceGenerator.class);
не требуется приведение типа
Нельзя иметь в конфигурации два разных метода возвращающих объект этого класса.
Иначе исключение при выполнении, поскольку Spring не сможет определить какой метод
создания бина вызвать

B. Идентификатор = Имя метода в классе конфигурации строящего SequenceGenerator

SequenceGenerator generator  = (SequenceGenerator) context.getBean("sequenceGenerator");
требуется приведение типа
Можно иметь в конфигурации два разных метода возвращающих объект этого класса.
Spring найдет метод создания бина по имени метода указываемому в getBean

C. Идентификатор = Имя метода в классе конфигурации строящего SequenceGenerator и
<Имя класса объекта возвращаемого бин методом>.class

SequenceGenerator generator = context.getBean("sequenceGenerator",SequenceGenerator.class);
не требуется приведение типа
Можно иметь в конфигурации два разных метода возвращающих объект этого класса.
Spring найдет метод создания бина по имени метода указываемому в getBean

D. Идентификатор = параметр name присоединенный к аннотации @Bean
Например @Bean(name="vza") Тогда говорят, что vza - это имя компонента

SequenceGenerator generator = (SequenceGenerator) context.getBean("vza");
требуется приведение типа
*/

@Configuration
public class SequenceGeneratorConfiguration {
    // В Main будем cоздавать бин способом A
    // SequenceGenerator generatorA = context.getBean(SequenceGenerator.class);
    @Bean
    public SequenceGenerator sequenceGeneratorA() {
        SequenceGenerator seqgen = new SequenceGenerator();
        seqgen.setPrefix("30");
        seqgen.setSuffix("A");
        seqgen.setInitial(100000);
        return seqgen;
    }
    // В Main будем cоздавать бин способом B
    // SequenceGenerator generatorB = (SequenceGenerator) context.getBean("sequenceGeneratorB");
    @Bean
    public SequenceGenerator sequenceGeneratorB() {
        SequenceGenerator seqgen = new SequenceGenerator();
        seqgen.setPrefix("40");
        seqgen.setSuffix("B");
        seqgen.setInitial(100000);
        return seqgen;
    }
    // В Main будем cоздавать бин способом C
    // SequenceGenerator generatorC = context.getBean("sequenceGeneratorC",SequenceGenerator.class);
    @Bean
    public SequenceGenerator sequenceGeneratorC() {
        SequenceGenerator seqgen = new SequenceGenerator();
        seqgen.setPrefix("50");
        seqgen.setSuffix("C");
        seqgen.setInitial(100000);
        return seqgen;
    }
    // В Main будем cоздавать бин способом D
    // SequenceGenerator generatorD = (SequenceGenerator) context.getBean("vza");
    @Bean(name="vza")
    public SequenceGenerator sequenceGeneratorD() {
        SequenceGenerator seqgen = new SequenceGenerator();
        seqgen.setPrefix("60");
        seqgen.setSuffix("D");
        seqgen.setInitial(100000);
        return seqgen;
    }
}