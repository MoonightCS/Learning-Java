package com.javarush.task.task36.task3608;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.FakeModel;
import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.view.UsersView;

/*
5. Класс Solution будет эмулятором пользователя. Открой класс Solution, стань на красный метод,

с помощью горячих клавиш Идеи создай проперти(поле) для usersView.

Нужен только сеттер. Если у тебя создался геттер, то удали его.

6. Запусти main. Упс, ничего не вывело :(

Это получилось потому, что данные пришли с сервера, обновились в ModelData, но Вью ничего о них не знает.

Вью сама не умеет себя обновлять. Это делает Контроллер.

Пойди в контроллер и добавь обновление данных во Вью.

Напомню, данные хранятся в Модели.

7. Запусти main. У меня теперь такой вывод:

All users:

User{name='A', id=1, level=1}

User{name='B', id=2, level=1}
 */

public class Solution {
    public static void main(String[] args) {
        Model model = new FakeModel();
        UsersView usersView = new UsersView();
        Controller controller = new Controller();

        usersView.setController(controller);
        controller.setModel(model);
        controller.setUsersView(usersView);

        usersView.fireEventShowAllUsers();
    }
}