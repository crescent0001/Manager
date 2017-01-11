package main.scene;

import email.RetriveEmail;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * Created by hehef on 12/6/2016.
 */
public class EmailController implements Initializable{
    @FXML
    private ListView<String> emailList;
    ObservableList<String> inboxList=FXCollections.observableArrayList();
    ObservableList<Message> sentList;
    //mail list
    private Message[] messages;

    @FXML
    private ToggleButton inboxButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        retriveMail();

        emailList.setOnMouseClicked(event -> openMail(event,messages.length-1-emailList.getSelectionModel().getSelectedIndex()));
        if(messages==null){
            System.out.println("null");
        }


        for(int i=(messages.length-1);i>=0;i--){
            try {
                inboxList.add(messages[i].getSubject());
            }catch(MessagingException e){
                e.printStackTrace();
            }/*catch(IOException e){
                e.printStackTrace();

            }*/

        }

        emailList.setItems(inboxList);



        inboxButton.setSelected(true);

    }
    //open email in new window
    public void openMail(MouseEvent event,int index){

        Message message=messages[index];
        try {
            Stage emailContentStage=new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("emailContent.fxml"));
            Parent root=loader.load();//call initiable method during load
            EmailContentController ctl=loader.<EmailContentController>getController();
            ctl.setMessage(message);//passmessage to another stage
            Scene scene=new Scene(root);
            emailContentStage.setScene(scene);
            emailContentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void inbox(ActionEvent event) {

        emailList.setItems(inboxList);

    }

    @FXML
    void sent(ActionEvent event) {

        //emailList.setItems(sentList);
    }
    @FXML
    void trash(ActionEvent event) {


    }

    @FXML
    void important(ActionEvent event) {


    }
    public void retriveMail(){
        RetriveEmail re=new RetriveEmail("160244J","g0415123u");
        re.openConnection();
        messages= re.retriveEmail();



    }
}
