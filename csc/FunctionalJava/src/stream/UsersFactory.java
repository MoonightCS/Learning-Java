package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UsersFactory {

    public static List<User> getAllUsers(int n){

        List<User> users = new ArrayList<>(n);
        Random random = new Random();

        for (int i = 0; i < n; i++) {

            int tmp = random.nextInt(100) + 1;
            String tmpName = "User" + tmp;
            users.add(new User(tmpName, tmp));

        }

        return users;

    }
}
