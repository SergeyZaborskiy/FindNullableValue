package ru.rivc.service;

import org.springframework.stereotype.Service;
import ru.rivc.data.entity.HumanEntity;
import ru.rivc.data.repository.HumanEntityRepository;
import ru.rivc.pojo.Qualification;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class HumanEntityService {

    private final HumanEntityRepository humanEntityRepository;

    public HumanEntityService(HumanEntityRepository humanEntityRepository) {
        this.humanEntityRepository = humanEntityRepository;
    }

    public List<HumanEntity> getUsersBySearchQuery() {
        return humanEntityRepository.findAllByBirthdayBetweenAndQualification(
                        LocalDate.of(1990, 1, 1),
                        LocalDate.of(1992, 1, 1),
                        Qualification.ENGINEER)
                .stream()
                .filter(human -> Objects.nonNull(human.getNationality()))
                .collect(Collectors.toList());
    }
}
