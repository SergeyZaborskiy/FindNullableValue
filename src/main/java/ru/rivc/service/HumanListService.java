package ru.rivc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rivc.dictionary.HumanEmbeddedDictionary;


@Service
public class HumanListService {
    private final HumanEmbeddedDictionary dictionary;

    @Autowired
    public HumanListService(HumanEmbeddedDictionary dictionary) {
        this.dictionary = dictionary;
    }

    //TODO findById


    //TODO groupByName


    //TODO getRandomHumanForLottery()

}
