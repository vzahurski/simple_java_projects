package simple_java_projects.rest_example.service;

import simple_java_projects.rest_example.model.Client;

import java.sql.SQLException;
import java.util.List;

public interface ClientService {

    /**
     * Создает нового клиента
     * @param client - клиент для создания
     */
    void create(Client client) throws SQLException;

    /**
     * Возвращает список всех имеющихся клиентов
     * @return список клиентов
     */
    List<Client> readAll() throws SQLException;

    /**
     * Возвращает клиента по его ID
     * @param id - ID клиента
     * @return - объект клиента с заданным ID
     */
    Client read(int id) throws SQLException;

    /**
     * Обновляет клиента с заданным ID,
     * в соответствии с переданным клиентом
     * @param client - клиент в соответсвии с которым нужно обновить данные
     * @param id - id клиента которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    boolean update(Client client, int id) throws SQLException;

    /**
     * Удаляет клиента с заданным ID
     * @param id - id клиента, которого нужно удалить
     * @return - true если клиент был удален, иначе false
     */
    boolean delete(int id) throws SQLException;
}
