package ru.popov.bodya.humancollection;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class CollectionsHelper<T extends Human> {

    public T findFirst(final List<T> humans, final String namePrefix, final Sex sex) {
        return humans.stream()
                .filter(human -> (human.getName().startsWith(namePrefix) && (human.getSex().equals(sex))))
                .findFirst()
                .get();
    }
}

