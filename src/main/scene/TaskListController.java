package main.scene;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by lerai on 12/7/2016.
 */
public class TaskListController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void addTask(ActionEvent event) throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("AddTask.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setTitle("Add Task");
        stage.setScene(scene);
        stage.show();

    }



}
