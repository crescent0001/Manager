package main.scene;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NotesController implements Initializable{

    @FXML
    private ListView<String> memberListView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList memberList= FXCollections.observableArrayList();
        memberList.addAll("Crescens");
        memberListView.setItems(memberList);


    }
    @FXML
    void noteClick(ActionEvent event)throws IOException{
        Stage noteStage=new Stage();
        Parent p= FXMLLoader.load(getClass().getResource("NotesPage.fxml"));
        Scene noteScene=new Scene(p);
        noteStage.setTitle("Note");
        noteStage.setScene(noteScene);
        noteStage.show();


    }
}
