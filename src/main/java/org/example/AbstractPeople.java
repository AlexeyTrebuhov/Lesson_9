package org.example;

import java.time.LocalDate;

public abstract class AbstractPeople {

    private static String name;
    private static String surname;
    private static LocalDate year;
    private static String country;
    private static String town;
    private static String street;
    private static Integer house;


    public AbstractPeople(String name, String surname, LocalDate year, String country, String town, String street, Integer house) {

    AbstractPeople.name = name;
    AbstractPeople.surname = surname;
    AbstractPeople.year = year;
    AbstractPeople.country = country;
    AbstractPeople.town = town;
    AbstractPeople.street = street;
    AbstractPeople. house = house;
    }

    @Override
    public String toString() {
       return  name + surname + year + country + town + street + house ;
    }
  }