package simple_java_projects.rest_example.service;

import org.springframework.stereotype.Service;
import simple_java_projects.rest_example.JdbcManager;
import simple_java_projects.rest_example.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// Аннотация @Service говорит спрингу, что данный класс является сервисом. Это специальный тип классов, в котором
// реализуется некоторая бизнес логика приложения. Впоследствии, благодаря этой аннотации Spring будет предоставлять
// нам экземпляр данного класса в местах, где это, нужно с помощью Dependency Injection.
@Service
public class ClientServiceJdbcImpl implements ClientService{
    // Соединение к базе данных, где хранятся клиенты. Оно единственно для всех объектов типа ClientServiceJdbcImpl
    private static final Connection connection = JdbcManager.getConnection();

    @Override
    public void create(Client client) throws SQLException {
        // Запрос с указанием мест для параметров в виде знака "?"
        String sql = "INSERT INTO public.\"Clients\" (name, email, phone) VALUES (?, ?, ?)";
        // Создание запроса с интерфесом PreparedStatement: предварительно компилирует запросы, которые могут содержать
        // входные параметры
        PreparedStatement statement = connection.prepareStatement(sql);
        // Установка параметров запроса statement
        statement.setString(1, client.getName());
        statement.setString(2, client.getEmail());
        statement.setString(3, client.getPhone());
        // Выполнение запроса
        //                                      Демонстрация использования транзакций
        // Шаг первый - выставляем свойство AutoCommit в false. Стартуем ручное управление транзакциями.
        connection.setAutoCommit(false);
        // Выполняем действия с бд
        statement.executeUpdate();
        // Завершаем транзакцию - подтверждаем
        connection.commit();
        // Вызов rollback отменит все внесенные изменения
        // connection.rollback();
    }

    @Override
    public List<Client> readAll() throws SQLException {
        // Запрос с указанием мест для параметров в виде знака "?"
        String sql = "SELECT client_id, name, email, phone FROM public.\"Clients\"";
        PreparedStatement statement = connection.prepareStatement(sql);
        // выполняем запрос
        ResultSet result = statement.executeQuery();

        List<Client> list = new ArrayList<>();

        while (result.next()) {
            Client client = new Client();
            client.setId(result.getInt("client_id"));
            client.setName(result.getString("name"));
            client.setEmail(result.getString("email"));
            client.setPhone(result.getString("phone"));
            list.add(client);
        }

        if (list.size() > 0 ) return list;
        else return null;
    }

    @Override
    public Client read(int id) throws SQLException {
        // Запрос с указанием мест для параметров в виде знака "?"
        String sql = "SELECT client_id, name, email, phone FROM public.\"Clients\" WHERE client_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        // Установка параметров запроса statement
        statement.setInt(1, id);
        // выполняем запрос
        ResultSet result = statement.executeQuery();
        Client client = null;

        if(result.next()) {
            client = new Client();
            client.setId(result.getInt("client_id"));
            client.setName(result.getString("name"));
            client.setEmail(result.getString("email"));
            client.setPhone(result.getString("phone"));
        }
        return client;
    }

    @Override
    public boolean update(Client client, int id) throws SQLException {
        // Запрос с указанием мест для параметров в виде знака "?"
        String sql = "UPDATE public.\"Clients\" SET name=?, email=?, phone=? WHERE client_id = ?";
        // Создание запроса с интерфесом PreparedStatement: предварительно компилирует запросы, которые могут содержать
        // входные параметры
        PreparedStatement statement = connection.prepareStatement(sql);
        // Установка параметров запроса statement
        statement.setString(1, client.getName());
        statement.setString(2, client.getEmail());
        statement.setString(3, client.getPhone());
        statement.setInt(4,id);
        // Выполняем запрос и возвращаем в rows количество обновленных записей
        int rows = statement.executeUpdate();
        if (rows != 0) return true;
        else return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        // Запрос с указанием мест для параметров в виде знака "?"
        String sql = "DELETE FROM public.\"Clients\" WHERE client_id = ?";
        // Создание запроса с интерфесом PreparedStatement: предварительно компилирует запросы, которые могут содержать
        // входные параметры
        PreparedStatement statement = connection.prepareStatement(sql);
        // Установка параметров запроса statement
        statement.setInt(1, id);
        // Выполняем запрос и возвращаем в rows количество удаленных записей
        int rows = statement.executeUpdate();
        if (rows != 0) return true;
        else return false;
    }
}
