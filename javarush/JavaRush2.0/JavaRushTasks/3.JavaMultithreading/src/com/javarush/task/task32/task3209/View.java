package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
4.1. Объяви методы initMenuBar() и initEditor() в классе View. Они будут отвечать за инициализацию меню и панелей редактора.
4.2. Объяви в представлении метод initGui(). Он будет инициализировать графический интерфейс. Вызови из него инициализацию меню initMenuBar(), инициализацию редактора initEditor() и метод pack(),
реализацию которого мы унаследовали от класса JFrame.
Разберись что делает метод pack().
4.3. Реализуй метод init() представления. Он должен:
4.3.1. Вызывать инициализацию графического интерфейса initGui().
4.3.2. Добавлять слушателя событий нашего окна. В качестве подписчика создай и используй объект класса FrameListener.
В качестве метода для добавления подписчика используй подходящий метод из класса Window от которого наследуется и наш класс через классы JFrame и Frame.
4.3.3. Показывать наше окно. Используй метод setVisible с правильным параметром.
На этом этапе приложение при запуске должно показывать окно, которое можно растягивать, разворачивать, закрыть и т.д.


 */


public class View extends JFrame implements ActionListener {

    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane(); // это будет панель с двумя вкладками.
    private JTextPane htmlTextPane = new JTextPane(); // это будет компонент для визуального редактирования html. Он будет размещен на первой вкладке.
    private JEditorPane plainTextPane = new JEditorPane(); // это будет компонент для редактирования html в виде текста, он будет отображать код html (теги и их содержимое).

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void init() {
        initGui();
        FrameListener frameListener = new FrameListener(this);
        this.addWindowListener(frameListener);
        this.setVisible(true);
    }

    public void initGui() {
        initMenuBar();
        initEditor();
        pack();
    }

    public void initMenuBar() {

    }

    public void initEditor() {

    }

    public void exit() {
        controller.exit();
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
