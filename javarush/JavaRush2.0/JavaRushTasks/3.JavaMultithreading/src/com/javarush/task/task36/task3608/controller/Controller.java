package com.javarush.task.task36.task3608.controller;

/*
2. Добавь в контроллер поле Model model вместе с сеттером.

3. В контроллере создай публичный метод void onShowAllUsers(), который должен обратиться к модели и инициировать загрузку пользователей.

4. Создай пакет view. В нем создай интерфейс View.

5. В интерфейс View добавь два метода: void refresh(ModelData modelData) и void setController(Controller controller)
 */

import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.view.UsersView;

public class Controller {

    private Model model;
    private UsersView usersView;

    public void onShowAllUsers() {
        model.loadUsers();
        usersView.refresh(model.getModelData());
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void setUsersView(UsersView usersView) {
        this.usersView = usersView;
    }

}
