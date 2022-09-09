package com.apress.springrecipes.court.web;

import com.apress.springrecipes.court.config.CourtConfiguration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.Set;

// Версии программных компонентов на которых я запускаю recipe_3_1_i
// Контейнер сервлетов tomcat 8.5.82
// Java 9 (jdk-9.0.4) смотри build.gradle там стоит JavaVersion.VERSION_1_9
// Gradle 7.1.1

// Приложение - система бронирования кортов для спортивного центра. Отображаются бронирования запрашиваемого корта.

// Configure Apache Tomcat in Intellij IDEA community edition
// https://www.youtube.com/watch?v=iuR22ADTNk8
/**
 * {@link ServletContainerInitializer} implementation to bootstrap the {@link DispatcherServlet}.
 */
// Создаем дескриптор веб-развертывания - указываем контейнеру сервлетов как инициализировать наше приложение (конфигурация)
// Здесь подвязываем наше веб-приложение к контейнеру сервлетов. Создаем нашему web-app объект DispatcherServlet
// и к DispatcherServlet подвязываем наши контроллеры, классы помеченные @Controller
// Внимание!!! Смысл понятий: Dispatcher Servlet = Front Controller, но Servlet <> Controller
// В Spring MVC когда говорят Servlet, то имеют в виду Dispatcher Servlet, но точно это не Controller

public class CourtServletContainerInitializer implements ServletContainerInitializer {

    public static final String MSG = "Starting Court Web Application";

    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        // Веб-приложению соответствует уникальный объект ServletContext - это
        // общий контекст(область данных) для всех Dispatcher Servlet контейнера сервлетов.
        // Через ссылку ServletContext мы имеем связь "с вышестоящим управляющим" - контейнером сервлетов.
        System.out.println(MSG);
        // Вывод сообщения в лог контейнера сервлетов в файл d:\tomcat_8\logs\localhost.2022-09-02.log
        ctx.log(MSG);
        //==============================================================================================================
        // Создаем веб-контекст нашего веб-приложения applicationContext (бины классов), сначала инициальный объект
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        // Потом регестрируем у applicationContext классы java конфигурации, у нас он один
        applicationContext.register(CourtConfiguration.class);
        //===========Создание DispatcherServlet и регистрация его у ServletContext=====================================
        // DispatcherServlet (Front-Controller !!!) является сервлетом (он реализует интерфейс HttpServlet)
        // Создаем объект dispatcherServlet, которому передаем ссылку на applicationContext (бины классов) нашего приложения
        // DispatcherServlet - это наш единственный! сервлет (Front Controller),синглтон, который получает http-запросы
        // и перенаправляет их соответствующим  Controller-обработчикам.
        DispatcherServlet dispatcherServlet = new DispatcherServlet(applicationContext);

        // Динамическая регистрация DispatcherServlet. Сообщаем объекту ServletContext, что в нашем веб-приложении
        // назначен Front Controller сервлетом dispatcherServlet с именем "my_court" - это имя не играет роли для URL!
        ServletRegistration.Dynamic courtRegistration = ctx.addServlet("my_court", dispatcherServlet);
        // метод ctx.addServlet возвращает объект ServletRegistration, который может использоваться для
        // дальнейшей настройки dispatcherServlet

        // Указываем контейнеру приоритет инициализации сервлета dispatcherServlet "my_court"
        courtRegistration.setLoadOnStartup(1);
        // Говорят, что ServletContext имеет ContextPath - это префикс URL-адресов, по которым конечный пользователь
        // может получить доступ к этому приложению.

        // Для URL-маппинга имеет значение имя war-файла приложения, указанное в build.gradle - war {archiveName 'court.war'}

        // Метод addMapping добавляет сопоставление dispatcherServlet "my_court" с множеством URL-адресов.
        // Т.е. какие URL-адреса обслуживает наш dispatcherServlet "my_court",  привязка («маппинг») URL к dispatcherServlet
        courtRegistration.addMapping("/");
        // Шаблон "/" означает, как бы пусто, что мы не будем делить множество URL-путей нашего приложения на части и
        // dispatcherServlet будет обслуживать все запросы с URL-адресами, которые начинаются с  "/court"
        // А именно URL-пути "/court" + "ничего или что-то еще, следующие сегменты отделенные /"
        // Или  URL-адреса "http://localhost:8080/court" + "ничего или что-то еще, следующие сегменты отделенные /"
        //  http://localhost:8080/court/welcome
        //  http://localhost:8080/court/reservationQuery
        //==============================================================================================================
    }
}
