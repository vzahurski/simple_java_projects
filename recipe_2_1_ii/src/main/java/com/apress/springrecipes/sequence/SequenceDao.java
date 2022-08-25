package com.apress.springrecipes.sequence;

public interface SequenceDao {
    // метод getSequence() загружает POJO объект (Sequence) из таблицы базы данных по его идентификатору
    Sequence getSequence(String sequenceId);
    // метод getNextValue() извлекает следующее значение идентификатора.
    int getNextValue(String sequenceId);
} 
