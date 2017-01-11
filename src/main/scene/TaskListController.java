package main.scene;

import database.SqlRetriveData;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import task.Task;

import javax.swing.text.html.ListView;

/**
 * Created by lerai on 12/7/2016.
 */
public class TaskListController implements Initializable {

    private ResultSet rs;
    private ObservableList<String> personalList = FXCollections.observableArrayList();
    private ArrayList<Task> personalTaskList = new ArrayList<Task>();
    @FXML
    private javafx.scene.control.ListView listContent;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        retriveData ();

    }

    @FXML
    void addTask(ActionEvent event) throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("AddTask.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Add Task");
        stage.setScene(scene);
        stage.showAndWait();
        retriveData();

    }
    private void retriveData (){
        SqlRetriveData data= new SqlRetriveData();
        data.openConnection();

        rs=data.retriveWholeTable("task");
        data.closeConnection();
        try {
            while(rs.next()){
                Task task = new Task();
                task.setTitle(rs.getString("title"));
                task.setLocation(rs.getString("location"));
                task.setPriority(rs.getString("priority"));
                task.setDueDate(rs.getDate("dueDate"));
                task.setDueTime(rs.getInt("dueTime"));

               personalTaskList.add(task);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        for(int i = 0;i<personalTaskList.size();i++ ){
            Task t= personalTaskList.get(i);
            personalList.add(t.getTitle());
        }
        listContent.getItems().removeAll();
        personalTaskList.clear();
        personalList.removeAll();

        listContent.setItems(personalList);


    }



}
