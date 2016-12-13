package ru.popov.bodya.preparedstatement;

public class Product {

    private int id;
    private int age;
    private String name;
    private String email;

    public Product() {
    }

    public Product(int id, int age, String name, String email) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
