package main.scene;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import database.SqlAccess;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class AddTaskController implements Initializable{
    @FXML
    private JFXComboBox<String> priority;
    @FXML
    private JFXButton save;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        priority.getItems().addAll("Very urgent","Urgent","Normal");
    }
    @FXML private javafx.scene.control.Button saveButton;

    @FXML
    private void saveButtonAction(ActionEvent event){
        // get a handle to the stage
        Stage stage = (Stage) saveButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    private void setTask() {
        SqlAccess sqlAccess = new SqlAccess();
        sqlAccess.openConnection();
    }
}
