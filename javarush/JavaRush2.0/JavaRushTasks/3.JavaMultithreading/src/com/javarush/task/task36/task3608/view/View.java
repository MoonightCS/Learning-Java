package com.javarush.task.task36.task3608.view;

// 5. В интерфейс View добавь два метода: void refresh(ModelData modelData) и void setController(Controller controller)


import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

public interface View {

    void refresh(ModelData modelData);

    void setController(Controller controller);
}
