package ru.rivc.pojo;

import java.time.LocalDate;

public class Adult extends Human {

    Qualification qualification;

    public Adult(int id, String name, LocalDate birthday) {
        super(id, name, birthday);
    }

    public Adult(int id, String name, LocalDate birthday, Nationality nationality, Qualification qualification) {
        super(id, name, birthday);
        this.nationality = nationality;
        this.qualification = qualification;
    }

}
