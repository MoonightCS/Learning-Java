package com.javarush.task.task32.task3209;


import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.File;

/*
Добавь в контроллер метод resetDocument(), который будет сбрасывать текущий документ. Он должен:
15.1. Удалять у текущего документа document слушателя правок которые можно отменить/вернуть (найди подходящий для этого метод, унаследованный от AbstractDocument). Слушателя нужно запросить у представления (метод getUndoListener()).
Не забудь проверить, что текущий документ существует (не null).
15.2. Создавать новый документ по умолчанию и присваивать его полю document.

Подсказка: воспользуйся подходящим методом класса HTMLEditorKit.

15.3. Добавлять новому документу слушателя правок.
15.4. Вызывать у представления метод update().
 */

public class Controller {

    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public void init() {

    }

    /*
    Метод resetDocument() должен удалять у текущего документа document слушателя правок через метод removeUndoableEditListener().
     */

    public void resetDocument() {

        if (this.document != null && view != null) {
            document.removeUndoableEditListener(view.getUndoListener());
        }
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        if (document.getUndoableEditListeners() == null) {
            this.document.addUndoableEditListener(view.getUndoListener());
        }
        view.update();
    }

    public void exit() {
        System.exit(0);
    }

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
        //view.exit();
    }

    public HTMLDocument getDocument() {
        return document;
    }

}
