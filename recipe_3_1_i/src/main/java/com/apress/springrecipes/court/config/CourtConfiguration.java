package com.apress.springrecipes.court.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
/**
 * Configuration class for the Court reservation application. Enables component scannig so that all services and
 * controllers will be detected (as long as they are part of the {@code com.apress.springrecipes.court} package (or in a
 * sub-package).
 */
// @Configuration - это java класс конфигурации
@Configuration
// @ComponentScan - автоматически просканируй пакет и создай бины нужных классов
@ComponentScan("com.apress.springrecipes.court")
public class CourtConfiguration {
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        // ViewResolver - это интерфейс, через который можно возвратить ссылку на конкретную реализацию представления View
        // для логического имени представления View.
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        // Префикс, который добавляется к именам view при создании URL-адреса.
        viewResolver.setPrefix("/WEB-INF/jsp/");
        // Суффикс, который добавляется к именам view при создании URL-адреса.
        viewResolver.setSuffix(".jsp");
        // Шаблон выглядит так d:\tomcat_8\webapps\court\WEB-INF\jsp\*.jsp
        // Значит метод обработчик запроса в контроллере возвращает имя_View
        // dispatcherServlet будет искать Jsp-файл View под таким именем
        // d:\tomcat_8\webapps\court\WEB-INF\jsp\имя_View.jsp
        // В этот jsp-файл будет передан экземпляр Model.
        // имя_View.jsp - это HTML-код с доступом к Java-объекту типа Model

        // d:\tomcat_8\webapps\court\WEB-INF\jsp\welcome.jsp
        // d:\tomcat_8\webapps\court\WEB-INF\jsp\reservationQuery.jsp
        return viewResolver;
    }
}
