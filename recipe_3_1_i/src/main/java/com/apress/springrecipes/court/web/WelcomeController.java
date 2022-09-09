//FINAL 
package com.apress.springrecipes.court.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
// DispatcherServlet (Front Controller) отправляет запрос рядовым контроллерам/обработчикам HTTP-запросов
// для выполнения определённых функций.
// Аннотация @Controller указывает, что конкретный класс является контроллером (сервлетом).
// Кроме того, контроллеры создаются в папке  web)
@Controller
// Bind controller to URL /welcome
// initial view will be resolved to the name returned in the default GET method

// @RequestMapping указывает, что URL-сегмент "/welcome" означает как бы идентификация внутри dispatcherServlet,
//т.е. "http://localhost:8080/court" + "ничего или что-то еще, следующие сегменты отделенные /"
// = "http://localhost:8080/court" + "/welcome" = "http://localhost:8080/court/welcome")
@RequestMapping("/welcome")
public class WelcomeController {
    // Controller will always look for a default GET method to call first, irrespective of name
    // In this case, named welcome to ease identification
    @RequestMapping(method = RequestMethod.GET)
    // Method contains Model input to setup date object
    public String welcome(Model model) {
        // Model - Интерфейс, который определяет как бы "мешок,вешалку,держатель" для атрибутов модели.
        // Model это по сути словарь типа имя и значение ссылка на объект
        // В первую очередь предназначен для добавления атрибутов в модель.
        Date today = new Date();
        // Add date to model so it can be display in view
        model.addAttribute("today", today);
        // Return view welcome. Via resolver the view
        // will be mapped to /WEB-INF/jsp/welcome.jsp
        // смотри CourtConfiguration.java InternalResourceViewResolver
        return "welcome";
    }
}
