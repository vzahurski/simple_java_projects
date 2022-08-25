package com.apress.springrecipes.sequence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SequenceService {
    @Autowired
    private SequenceDao sequenceDao;
    // Итак при построении класса SequenceService в него должен быть вложен объект, который является sequenceDao
    // Используем все три стиля внедрения (поля, конструктор, сеттер)
    // В данном случае мы делаем инъекцию зависимости через поле класса
    // Запись @Autowired private SequenceDao sequenceDao; равносильна конструкции объявления с присвоением значения
    // private SequenceDao sequenceDao = подходящий бин из контекста, т.е. объект класса помеченного @Component
    // и являющегося sequenceDao;

    // Пустой конструктор
    public SequenceService() {}
    // Конструктор с sequenceDao
    @Autowired
    public SequenceService(SequenceDao sequenceDao) {
        this.sequenceDao=sequenceDao;
    }
    // В данном случае мы делаем инъекцию зависимости через конструктор класса
    // Запись @Autowired public SequenceService(SequenceDao sequenceDao) { this.sequenceDao=sequenceDao;}
    // равносильна вызову конструктора SequenceService с внедренным из контекста бином sequenceDao, т.е. объект класса
    // помеченного @Component и являющегося sequenceDao;
    @Autowired
    public void setSequenceDao(SequenceDao sequenceDao) {
        this.sequenceDao = sequenceDao;
    }
    // Также инъекцию зависимости можно сделать через сеттер
    // Запись @Autowired public void setSequenceDao(SequenceDao sequenceDao) { this.sequenceDao = sequenceDao;}
    // равносильна вызову сеттера setSequenceDao с внедренным из контекста бином sequenceDao, т.е. объект класса
    // помеченного @Component и являющегося sequenceDao;
    public String generate(String sequenceId) {
        Sequence sequence = sequenceDao.getSequence(sequenceId);
        int value = sequenceDao.getNextValue(sequenceId);
        return sequence.getPrefix() + value + sequence.getSuffix();
    }
}
