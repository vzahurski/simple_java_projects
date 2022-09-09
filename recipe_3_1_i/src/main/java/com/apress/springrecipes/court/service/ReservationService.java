package com.apress.springrecipes.court.service;

import com.apress.springrecipes.court.domain.Reservation;

import java.util.List;

// какие процессы происходят с нашими объектами предметной области находится в пакете service

// Интерфейс сущность со способностью сервиса резервирования
public interface ReservationService {
    // Должен быть реализован метод query (запрос) на вход ему подается имя корта, а он возвращает
    // список объектов бронирований с именно этим именем корта внутри
    // В настоящем приложении этот интерфейс реализуется с чтением из базы данных
    List<Reservation> query(String courtName);
}
