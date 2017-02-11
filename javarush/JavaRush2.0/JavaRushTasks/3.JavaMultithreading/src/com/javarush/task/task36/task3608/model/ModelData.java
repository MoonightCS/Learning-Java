package com.javarush.task.task36.task3608.model;

/*
1. Создай пакет model, в котором создай класс ModelData.
ModelData — это объект, который будет хранить необходимые данные для отображения на клиенте.
Создай поле с геттером и сеттером List<User> users — это будет список пользователей для отображения.
 */

import com.javarush.task.task36.task3608.bean.User;

import java.util.List;

public class ModelData {
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
