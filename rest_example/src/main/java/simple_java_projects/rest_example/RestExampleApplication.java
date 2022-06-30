package simple_java_projects.rest_example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class RestExampleApplication {

	public static void main(String[] args) {
		try {
			JdbcManager.createConnection();
			// Соединение к бд единственно и хранится в классе JdbcManager в виде статического поля
			SpringApplication.run(RestExampleApplication.class, args);
			//JdbcManager.closeConnection();
		} catch (ClassNotFoundException | SQLException | NullPointerException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
