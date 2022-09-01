package org.example;

import java.time.LocalDate;

public class People extends AbstractPeople {
    public People(String name, String surname, int year, String country, String town, String street, Integer house) {
        super(name, surname, LocalDate.ofEpochDay(year), country, town, street, house);
    }
}

