package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/* 
Генератор паролей
Реализуй логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов.
2) только цифры и латинские буквы разного регистра.
3) обязательно должны присутствовать цифры, и буквы разного регистра.
Все сгенерированные пароли должны быть уникальные.

Пример правильного пароля:
wMh7smNu


Требования:
1. Класс Solution должен содержать метод getPassword(), который возвращает ByteArrayOutputStream со сгенерированным паролем.
2. Длина пароля должна составлять 8 символов.
3. Пароль должен содержать хотя бы одну цифру.
4. Пароль должен содержать хотя бы одну латинскую букву нижнего регистра.
5. Пароль должен содержать хотя бы одну латинскую букву верхнего регистра.
6. Пароль не должен содержать других символов, кроме цифр и латинских букв разного регистра.
7. Сгенерированные пароли должны быть уникальными.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; i++) {
            ByteArrayOutputStream password = getPassword();
            System.out.println(password.toString());
        }
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        for (int i = 0; i < 2; i++) {
            addLowerCaseLetter(byteArrayOutputStream);
            addRandomNumber(byteArrayOutputStream);
            addUpperCaseLetter(byteArrayOutputStream);
        }
        addLowerCaseLetter(byteArrayOutputStream);
        addUpperCaseLetter(byteArrayOutputStream);

        return byteArrayOutputStream;
    }

    private static void addRandomNumber(ByteArrayOutputStream stream) {
        stream.write(48 + ((int) (Math.random() * 10)));
    }

    private static void addUpperCaseLetter(ByteArrayOutputStream stream) {
        stream.write(97 + ((int) (Math.random() * 26)));
    }

    private static void addLowerCaseLetter(ByteArrayOutputStream stream) {
        stream.write(65 + ((int) (Math.random() * 26)));
    }
}