package main.scene;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

/**
 * Created by hehef on 12/6/2016.
 */
public class emailController implements Initializable{
    @FXML
    private ListView<String> emailList;
    ObservableList<String> inboxList=FXCollections.observableArrayList("hefeiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii","hefei2","hefei3","hefei4");
    ObservableList<String> sentList=FXCollections.observableArrayList("crescens","crescens","crescens","crescens");



    @FXML
    private Label emailDate;


    @FXML
    private ToggleButton inboxButton;

    @FXML
    private Label topicText;


    @Override
    public void initialize(URL location, ResourceBundle resources) {



        emailList.setItems(inboxList);


        topicText.setText("Inbox");
        inboxButton.setSelected(true);





    }

    @FXML
    void inbox(ActionEvent event) {
        topicText.setText("Inbox");
        emailList.setItems(inboxList);

    }

    @FXML
    void sent(ActionEvent event) {
        topicText.setText("Sent");
        emailList.setItems(sentList);


    }
    @FXML
    void trash(ActionEvent event) {
        topicText.setText("Trash");

    }

    @FXML
    void important(ActionEvent event) {
        topicText.setText("Important");

    }
}
