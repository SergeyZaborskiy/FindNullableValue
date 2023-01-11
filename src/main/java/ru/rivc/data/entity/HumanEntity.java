package ru.rivc.data.entity;

import ru.rivc.pojo.Education;
import ru.rivc.pojo.Nationality;
import ru.rivc.pojo.Qualification;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "humans")
public class HumanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    String name;

    @Basic
    LocalDate birthday;

    @Basic
    @Enumerated
    Nationality nationality;


    @Basic
    @Enumerated
    Qualification qualification;


    @Basic
    @Enumerated
    Education education;

    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }
}
