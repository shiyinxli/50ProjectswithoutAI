package org.example.todolist;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class todoController {
    @FXML
    private TextField enterTasks;
    @FXML
    private Button addTask;
    @FXML
    private ListView<CheckBox> taskList;

    @FXML
    private void toaddTask(){
        String taskText = enterTasks.getText().trim();
        if(taskText != null){
            taskList.getItems().add(new CheckBox(taskText));
            enterTasks.clear();
        }
    }

}
