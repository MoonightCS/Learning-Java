package com.javarush.task.task32.task3209.listeners;

import com.javarush.task.task32.task3209.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;

/*

13.3. В классе TextEditMenuListener переопредели метод menuSelected(MenuEvent menuEvent). Он должен:
13.3.1. Из переданного параметра получать объект, над которым было совершено действие. В нашем случае это будет объект с типом JMenu.
13.3.2. У полученного меню получать список компонентов (пунктов меню).
13.3.3. Для каждого пункта меню вызывать метод setEnabled, передав в качестве параметра результат вызова метода isHtmlTabSelected() из представления. Запусти приложение и убедись, что пункты меню стиль, выравнивание,
цвет и шрифт доступны только, когда активна закладка HTML и не доступны для закладки Текст.


 */

public class TextEditMenuListener implements MenuListener {

    private View view;

    public TextEditMenuListener(View view) {
        this.view = view;
    }

    @Override
    public void menuSelected(MenuEvent e) {
        //Из переданного параметра получать объект, над которым было совершено действие
        JMenu jMenu = (JMenu) e.getSource();
        //У полученного меню получать список компонентов (пунктов меню)
        Component[] components = jMenu.getMenuComponents();
        //Для каждого пункта меню вызывать метод setEnabled, передав в качестве параметра
        //результат вызова метода isHtmlTabSelected() из представления.
        for (Component component : components) {
            component.setEnabled(view.isHtmlTabSelected());
        }
    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }
}
