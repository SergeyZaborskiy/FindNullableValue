package ru.rivc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rivc.data.entity.HumanEntity;
import ru.rivc.data.repository.HumanEntityRepository;

import java.util.List;

@Service
public class HumanEntityService {

    private final HumanEntityRepository humanEntityRepository;

    @Autowired
    public HumanEntityService(HumanEntityRepository humanEntityRepository) {
        this.humanEntityRepository = humanEntityRepository;
    }

    public List<HumanEntity> getUsersBySearchQuery() {
        // TODO

        return null;
    }
}
