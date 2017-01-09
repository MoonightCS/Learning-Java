package com.javarush.test.level08.lesson08.task05;

import java.util.*;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> hashMap = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            hashMap.put("LastName" + i, "Name");
        }
        for (int i = 5; i < 10; i++) {
            hashMap.put("LastName" + i, "Name" + i);
        }

        return hashMap;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        Set<String> uniqueNames = new HashSet<>();
        Set<String> namesToDelete = new HashSet<>();

        for (String name : map.values()) {
            if (uniqueNames.contains(name)) {
                namesToDelete.add(name);
            } else {
                uniqueNames.add(name);
            }
        }
        for (String name : namesToDelete) {
            removeItemFromMapByValue(map, name);
        }

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> map = createMap();
        System.out.println(map);
        removeTheFirstNameDuplicates(map);
        System.out.println(map);
    }
}
