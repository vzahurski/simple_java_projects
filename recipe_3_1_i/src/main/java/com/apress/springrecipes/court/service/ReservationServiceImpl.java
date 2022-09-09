package com.apress.springrecipes.court.service;

import com.apress.springrecipes.court.domain.Player;
import com.apress.springrecipes.court.domain.Reservation;
import com.apress.springrecipes.court.domain.SportType;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

// @Service содержит внутри себя @Component для создания бина. Технически достаточно @Component, но для чтения человеком
// дучше указать, что это сервис.
@Service
public class ReservationServiceImpl implements ReservationService {
    // Две константы типа SportType
    public static final SportType TENNIS = new SportType(1, "Tennis");
    public static final SportType SOCCER = new SportType(2, "Soccer");

    private final List<Reservation> reservations = new ArrayList<>();
    // Все объекты класса ReservationServiceImpl содержат один и тот же список бронирований
    public ReservationServiceImpl() {

        reservations.add(new Reservation("Tennis #1", LocalDate.of(2008, 1, 14), 16,
                new Player("Roger", "N/A"), TENNIS));
        reservations.add(new Reservation("Tennis #2", LocalDate.of(2008, 1, 14), 20,
                new Player("James", "N/A"), TENNIS));
    }

    // Реализация метода интерфейса
    @Override
    public List<Reservation> query(String courtName) {

        return this.reservations.stream()
                .filter(reservation -> Objects.equals(reservation.getCourtName(), courtName))
                .collect(Collectors.toList());
    }
}
