package com.javarush.task.task36.task3608.model;

/*
Реализуй его в FakeModel: инициализируй список пользователей modelData любыми данными. Они не влияют на тестирование.
 */

import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;
import java.util.List;

public class FakeModel implements Model {

    private ModelData modelData = new ModelData();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {

        List<User> usr = new ArrayList<>();

        usr.add(new User("Bodya", 1, 24));
        usr.add(new User("Maryana", 2, 23));
        usr.add(new User("Dima", 3, 22));

        modelData.setUsers(usr);
    }

    @Override
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }
}
