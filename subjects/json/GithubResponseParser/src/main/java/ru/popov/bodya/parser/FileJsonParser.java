package ru.popov.bodya.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.popov.bodya.pojo.Response;
import ru.popov.bodya.pojo.User;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileJsonParser {

    public static void main(String[] args) throws IOException {
        for (User user: makeUsersList()) {
            System.out.println(user);
        }
    }

    private static List<User> makeUsersList() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String filePath = "src/test/resources/users.json";
        Response response = mapper.readValue(new File(filePath), Response.class);
        return response.getUserList();
    }


}
