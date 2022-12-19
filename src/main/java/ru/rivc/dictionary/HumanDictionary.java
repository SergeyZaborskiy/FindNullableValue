package ru.rivc.dictionary;

import ru.rivc.pojo.Adult;
import ru.rivc.pojo.Human;

import java.util.List;
import java.util.Optional;

public class HumanDictionary {

    private List<? extends Human> humans;

    public HumanDictionary() {
        //TOOO
    }

    Optional<? extends Human> findById(int id) {
        //TODO
        return Optional.empty();
    }

}
