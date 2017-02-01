package com.javarush.test.level20.lesson02.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Читаем и пишем в файл: Human
Реализуйте логику записи в файл и чтения из файла для класса Human
Поле name в классе Human не может быть пустым
В файле your_file_name.tmp может быть несколько объектов Human
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

            File myFile = File.createTempFile("love_my_life", null);
            OutputStream outputStream = new FileOutputStream(myFile);
            InputStream inputStream = new FileInputStream(myFile);

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();
            outputStream.close();

            Human somePerson = new Human();
            somePerson.load(inputStream);


//            Assert.assertEquals(ivanov.name, somePerson.name);
//            for (Asset asset : ivanov.assets) {
//                boolean match = false;
//                for (Asset asset1 : somePerson.assets) {
//                    if (asset1.getName().equals(asset.getName())) {
//                        match = true;
//                    }
//                }
//                if (!match) {
//                    System.out.println("not equals");
//                } else {
//                    System.out.println("true");
//                }
//            }

            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriter = new PrintWriter(outputStream);
            String hasName = (this.name != null) ? "yes" : "no";
            printWriter.println(hasName);
            if (hasName.equals("yes")) {
                printWriter.println(this.name);
                if (this.assets.size() > 0) {
                    for (Asset asset : assets) {
                        printWriter.println(asset.getName());
                    }
                }
            }
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String hasName = reader.readLine();
            if (hasName.equals("yes")) {
                this.name = reader.readLine();
                String assetName;
                while ((assetName = reader.readLine()) != null) {
                    this.assets.add(new Asset(assetName));
                }
            }
            reader.close();
        }
    }
}
