package constructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class ConstructorUsage {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Bodya", "Maryana", "Dima", "Maria");
        List<User> users = map(names, User::new);
        users.forEach(System.out::println);

    }

    public static <S, T> List<T> map(List<S> list, Function<S, T> function) {
        List<T> result = new ArrayList<>(list.size());
        list.forEach((s -> result.add(function.apply(s))));
        return result;
    }
}
