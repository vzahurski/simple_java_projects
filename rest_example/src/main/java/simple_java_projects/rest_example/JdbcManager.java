package simple_java_projects.rest_example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcManager {
    //URL к базе данных состоит из протокола:подпротокола://[хоста]:[порта_СУБД]/[БД]
    private static String url = "jdbc:postgresql://127.0.0.1:5432/rest_example";
    //Имя и пароль пользователя БД
    private static String name = "postgres";
    private static String password = "W8vCoi7n37N85KxRbeKQ";
    private static Connection connection = null;

    public static Connection createConnection() throws ClassNotFoundException, SQLException {
        // Подключаем драйвер
        Class.forName("org.postgresql.Driver");
        // Создаём соединение
        connection = DriverManager.getConnection(url, name, password);
        return connection;
    }

    public static Connection getConnection() throws NullPointerException{
        if (connection == null) { throw new NullPointerException(); }
        return connection;
    }

    public static void closeConnection() throws SQLException{
        if (connection != null) {connection.close();}
    }
}
