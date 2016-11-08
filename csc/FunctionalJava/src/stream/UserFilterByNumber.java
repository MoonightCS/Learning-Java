package stream;

import java.util.Comparator;
import java.util.List;

public class UserFilterByNumber {

    public static void main(String[] args) {

        List<User> users = UsersFactory.getAllUsers(50);
        System.out.println("List of users before using stream api");
        users.forEach(System.out::println);
        System.out.println("_________\n");
        users.stream()
                .filter(user -> user.getNumber() > 18)
                .sorted(Comparator.comparing(User::getNumber))
                .limit(5)
                .forEach(System.out::println);

    }

}
