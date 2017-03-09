package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
Реализуй метод инициализации панелей редактора initEditor(). Он должен:
6.1. Устанавливать значение «text/html» в качестве типа контента для компонента htmlTextPane.
Найди и используй подходящий метод.
6.2. Создавать новый локальный компонент JScrollPane на базе htmlTextPane.
6.3. Добавлять вкладку в панель tabbedPane с именем «HTML» и компонентом из предыдущего
пункта.
6.4. Создавать новый локальный компонент JScrollPane на базе plainTextPane.
6.5. Добавлять еще одну вкладку в tabbedPane с именем «Текст» и компонентом из
предыдущего пункта.
6.6. Устанавливать предпочтительный размер панели tabbedPane.
6.7. Создавать объект класса TabbedPaneChangeListener и устанавливать его в качестве слушателя изменений в tabbedPane.
6.8. Добавлять по центру панели контента текущего фрейма нашу панель с вкладками.
Получить панель контента текущего фрейма можно с помощью метода getContentPane(), его реализация унаследовалась от JFrame.
После запуска приложения можно будет увидеть текущие результаты: две независимые закладки (HTML и Текст), в каждой из которых можно набирать свой текст.
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
    /*
    В методе initEditor() для компонента tabbedPane должна добавляться вкладка с именем "HTML" и созданным компонентом JScrollPane на базе htmlTextPane.
    В методе initEditor() для компонента tabbedPane должна добавляться вкладка с именем "Текст" и созданным компонентом JScrollPane на базе plainTextPane.
     */

    public void initEditor() {
        //Устанавливать значение "text/html" в качестве типа контента для компонента htmlTextPane
        htmlTextPane.setContentType("text/html");

        //Создавать новый локальный компонент JScrollPane на базе htmlTextPane
        //Добавлять вкладку в панель tabbedPane с именем "HTML" и компонентом из предыдущего пункта
        tabbedPane.addTab("HTML", new JScrollPane(htmlTextPane));

        //Создавать новый локальный компонент JScrollPane на базе plainTextPane
        //Добавлять еще одну вкладку в tabbedPane с именем "Текст" и компонентом из предыдущего пункта
        tabbedPane.addTab("Текст", new JScrollPane(plainTextPane));

        //Устанавливать предпочтительный размер панели tabbedPane
        tabbedPane.setPreferredSize(new Dimension(800, 600));

        //Создавать объект класса TabbedPaneChangeListener и устанавливать его в качестве слушателя изменений в tabbedPane
        tabbedPane.addChangeListener(new TabbedPaneChangeListener (this));

        //Добавлять по центру панели контента текущего фрейма нашу панель с вкладками
        getContentPane().add(tabbedPane,BorderLayout.CENTER);

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

    public void selectedTabChanged() {

    }
}
