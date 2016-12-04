package ru.popov.bodya.humancollection;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class CollectionsHelper<T extends Human> {

    public T findFirst(final List<T> humans, final String namePrefix, final Sex sex) {
        // BEGIN (write your solution here)

        try {
            return humans.stream()
                    .filter(human -> (human.getName().startsWith(namePrefix) && (human.getSex().equals(sex))))
                    .findFirst()
                    .get();
        } catch (NoSuchElementException e) {
            return null;
        }


    }

    public static void main(String[] args) {

        CollectionsHelper<Human> collectionsHelper = new CollectionsHelper<>();

        List<Human> list = new ArrayList<>();
        list.add(new Man("Dima"));
        list.add(new Woman("Maryna"));
        list.add(new Man("Bodya"));
        list.add(new Man("Bor"));

        System.out.println(collectionsHelper.findFirst(list,"Bo", Sex.M).toString());
        System.out.println(collectionsHelper.findFirst(list,"Ma", Sex.F).toString());
    }

}

