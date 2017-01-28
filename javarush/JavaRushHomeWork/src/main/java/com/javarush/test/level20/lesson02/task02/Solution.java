package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File my_file_name = File.createTempFile("love_my_life_javarush", null);
            OutputStream outputStream = new FileOutputStream(my_file_name);
            InputStream inputStream = new FileInputStream(my_file_name);
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);

            JavaRush javaRush = new JavaRush();

            User user1 = new User();
            user1.setBirthDate(dateFormat.parse("17.10.1917"));
            user1.setCountry(User.Country.RUSSIA);
            user1.setFirstName("Communist");
            user1.setLastName("Bolshevikov");
            user1.setMale(true);

            User user2 = new User();
            user2.setBirthDate(dateFormat.parse("25.06.1995"));
            user2.setCountry(User.Country.OTHER);
            user2.setFirstName("Bodya");
            user2.setLastName("Popov");
            user2.setMale(true);

            javaRush.users.add(user1);
            javaRush.users.add(user2);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);


            for (User user : loadedObject.users) {
                System.out.println("@User");
                System.out.println(user.getFirstName());
                System.out.println(user.getLastName());
                System.out.println(user.getCountry());
                System.out.println(user.getBirthDate());
                System.out.println();
            }
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);

        public void save(OutputStream outputStream) throws Exception {

            PrintWriter printWriter = new PrintWriter(outputStream);

            for (User user : users) {

                printWriter.println("@User");
                String firstName = user.getFirstName();
                if (firstName == null) {
                    firstName = "noName";
                }
                printWriter.println(firstName);
                String lastName = user.getLastName();
                if (lastName == null) {
                    lastName = "noLastname";
                }
                printWriter.println(lastName);
                printWriter.println(dateFormat.format(user.getBirthDate()));
                printWriter.println(String.valueOf(user.isMale()));
                printWriter.println(user.getCountry());
            }
            printWriter.close();
        }

        public void load(InputStream inputStream) throws IOException, ParseException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while (reader.ready()) {
                String newUser = reader.readLine();
                if (newUser.equals("@User")) {
                    User user = new User();

                    String name = reader.readLine();
                    if (name.equals("noName")) {
                        name = null;
                    }
                    user.setFirstName(name);

                    String lastName = reader.readLine();
                    if (lastName.equals("noLastname")) {
                        lastName = null;
                    }
                    user.setLastName(lastName);

                    user.setBirthDate(dateFormat.parse(reader.readLine()));

                    if (reader.readLine().equals("true")) {
                        user.setMale(true);
                    } else user.setMale(false);
                    user.setCountry(User.Country.valueOf(reader.readLine()));

                    users.add(user);
                }
            }
            reader.close();
        }

    }
}
