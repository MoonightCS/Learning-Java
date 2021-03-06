package com.javarush.task.task36.task3608.model;

/*
4. В интерфейсе Model создай метод void loadUsers().
Реализуй его в FakeModel: инициализируй список пользователей modelData любыми данными. Они не влияют на тестирование.
 */

public interface Model {

    ModelData getModelData();

    void loadUsers();

    void loadDeletedUsers();

    void loadUserById(long userId);

    void deleteUserById(long id);

    void changeUserData(String name, long id, int level);
}
