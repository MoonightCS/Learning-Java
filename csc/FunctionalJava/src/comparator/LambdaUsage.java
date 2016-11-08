package comparator;

import java.util.*;

public class LambdaUsage {

    public static void main(String[] args) {

        List<User> users = UsersFactory.getAllUsers(50);
        System.out.println("List of users before sorting");
        users.forEach(System.out::println);
        System.out.println("_____________\n");
        Collections.sort(users, (o1, o2) -> o1.getNumber() > o2.getNumber() ? 1 : -1);
        System.out.println("List of users after sorting");
        users.forEach(System.out::println);
    }
}
