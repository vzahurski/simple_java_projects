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

			// Закрываею соединение к базе данных в случае нормального завершения программы
			// смотри http://espressocode.top/jvm-shutdown-hook-java/
			Runtime.getRuntime().addShutdownHook(new Thread()
			{
				public void run()
				{
					try {
						JdbcManager.closeConnection();
						// System.out.println("Exit rest_example VZA"); // Можно проверить что код закрытия отработал
					} catch (Exception e) { System.err.println(e.getMessage());	}
				}
			});
			// Стартуем Spring
			SpringApplication.run(RestExampleApplication.class, args);
			// Почему при работе приложения соединение оказывается уже закрытым, если оно закрывается в этом месте после run?
			// JdbcManager.closeConnection();
			// Ответ - потому что SpringApplication.run работает в параллельном потоке с кодом main.
		} catch (ClassNotFoundException | SQLException | NullPointerException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
