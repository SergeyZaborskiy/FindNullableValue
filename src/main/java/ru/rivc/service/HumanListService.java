package ru.rivc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rivc.dictionary.HumanEmbeddedDictionary;
import ru.rivc.pojo.Adult;
import ru.rivc.pojo.Human;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class HumanListService {
    private final HumanEmbeddedDictionary dictionary;

    @Autowired
    public HumanListService(HumanEmbeddedDictionary dictionary) {
        this.dictionary = dictionary;
    }

    //TODO findById() as example below

    public Optional<? super Human> findById(int id) {
        return dictionary.getHumans().stream()
                .filter(human -> human instanceof Human)
                .filter(human -> ((Human) human).getId() == id)
                .findAny();
    }

    //TODO groupByName() as example below

    public Map<String, List<Adult>> groupByName() {
        return  dictionary.getHumans().stream()
                .filter(human -> human instanceof Adult)
                .map(human -> (Adult)human)
                .filter(adult -> Objects.nonNull(adult.getName()))
                .collect(Collectors.groupingBy(Adult::getName));
    }

    //TODO getRandomHumanForLottery() as example below

    public Human getRandomHumanForLottery() {
        Random random = new Random();
        return (Human) dictionary.getHumans().get(random.nextInt(dictionary.getHumans().size()));
    }


}
