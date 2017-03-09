package com.javarush.task.task32.task3209.actions;

import com.javarush.task.task32.task3209.View;

import javax.swing.*;
import java.awt.event.ActionEvent;

/*
12.1. Напиши реализацию класса RedoAction:
12.1.1. Добавь в класс поле View. Добавь его инициализацию в конструкторе.
12.1.2. Реализуй метод actionPerformed(ActionEvent actionEvent), он должен вызывать метод redo() у представления.
12.2. Напиши реализацию класса UndoAction по аналогии с RedoAction.
12.3. Изучи реализацию класса StrikeThroughAction, которую ты получил вместе с заданием и реализуй аналогичным образом классы:
12.3.1. SubscriptAction
12.3.2. SuperscriptAction
Запусти программу и убедись, что пункты меню Подстрочный знак, Надстрочный знак и Зачеркнутый работают. Пункты, отвечающие за отмену и возврат действия пока не подключены к контроллеру и мы не сможем их проверить.


 */

public class RedoAction extends AbstractAction {

    private View view;

    public RedoAction(View view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        view.redo();
    }
}
