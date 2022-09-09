// FINAL
package com.apress.springrecipes.court.web;

import com.apress.springrecipes.court.domain.Reservation;
import com.apress.springrecipes.court.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller
// URL-сегмент "/reservationQuery" означает как бы идентификация внутри dispatcherServlet,
//т.е. "http://localhost:8080/court" + "ничего или что-то еще, следующие сегменты отделенные /"
//= "http://localhost:8080/court" + "/welcome" = "http://localhost:8080/court/reservationQuery")
@RequestMapping("/reservationQuery")
public class ReservationQueryController {

    private final ReservationService reservationService;

    // Wire service in constructor, available in application context 
    public ReservationQueryController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    // Controller will always look for a default GET method to call first, irrespective of name
    // In this case, named setupForm to ease identification
    @GetMapping
    public String setupForm() {
        // /WEB-INF/jsp/reservationQuery.jsp
        return "reservationQuery";
    }

    // Controller will always look for a default POST method irrespective of name
    // when a submission ocurrs on the URL (i.e.@RequestMapping(/reservationQuery)) 
    // In this case, named submitForm to ease identification
    @PostMapping
    // Submission will come with courtName field, also add Model to return results 
    public String submitForm(@RequestParam("courtName") String courtName, Model model) {
        // Create reservation list
        List<Reservation> reservations = java.util.Collections.emptyList();
        // Make a query if parameter is not null
        if (courtName != null) {
            reservations = reservationService.query(courtName);
        }
        // Update model to include reservations
        model.addAttribute("reservations", reservations);
        // Эта строка нужна, чтобы передать courtName в поле поиска, а то оно обнуляется при нажатии кнопки Query
        model.addAttribute("courtName", courtName);
        // Return view as a string
        // Based on resolver configuration the reservationQuery view
        // will be mapped to a JSP in /WEB-INF/jsp/reservationQuery.jsp
        return "reservationQuery";
    }
}