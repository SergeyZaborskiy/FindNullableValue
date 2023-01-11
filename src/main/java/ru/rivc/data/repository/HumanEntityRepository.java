package ru.rivc.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;
import ru.rivc.data.entity.HumanEntity;
import ru.rivc.pojo.Qualification;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface HumanEntityRepository extends JpaRepository<HumanEntity, Long> {

    //TODO example as below
    List<HumanEntity> findAllByBirthdayBetweenAndQualification(
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate upperBound,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate lowerBound,
            Qualification qualification
    );
}