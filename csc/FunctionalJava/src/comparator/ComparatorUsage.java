package comparator;

import java.util.*;

public class ComparatorUsage {

    public static void main(String[] args) {

        List<User> users = UsersFactory.getAllUsers(50);
        System.out.println("List of users before sorting");
        users.forEach(System.out::println);
        System.out.println("_____________\n");
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getNumber() > o2.getNumber() ? 1 : -1;
            }
        });
        System.out.println("List of users after sorting");
        users.forEach(System.out::println);
    }
}
