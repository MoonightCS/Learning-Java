package ru.popov.bodya.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.popov.bodya.pojo.Response;
import ru.popov.bodya.pojo.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

public class GithubResponseParser {

    public static void main(String[] args) {
        List<User> users = null;
        try {
            users = makeUsersList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (users != null) {
            users.forEach(System.out::println);
        }
    }

    private static List<User> makeUsersList() throws IOException {
        System.out.println("Enter the name:");
        String name;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            name = reader.readLine();
        }
        Response response = getResponseWithSpecifiedValue(name);
        return response.getUserList();
    }

    private static Response getResponseWithSpecifiedValue(String value) throws IOException {
        URL url = new URL("https://api.github.com/search/users?q=" + value);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(url, Response.class);
    }
}
