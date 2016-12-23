package main.scene;

import email.RetriveEmail;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * Created by hehef on 12/6/2016.
 */
public class emailController implements Initializable{
    @FXML
    private ListView<String> emailList;
    ObservableList<String> inboxList=FXCollections.observableArrayList();
    ObservableList<String> sentList=FXCollections.observableArrayList("crescens","crescens","crescens","crescens");
    //mail list
    private Message[] messages;



    @FXML
    private Label emailDate;

    @FXML
    private Label sentDate;

    @FXML
    private Label emailTitle;

    @FXML
    private TextArea emailContent;


    @FXML
    private ToggleButton inboxButton;

    @FXML
    private Label topicText;




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        retriveMail();

        emailList.setOnMouseClicked(event -> openMail(event,messages.length-1-emailList.getSelectionModel().getSelectedIndex()));


        for(int i=(messages.length-1);i>=0;i--){
            try {
                inboxList.add(messages[i].getSubject()+" "+messages[i].getSentDate().toString());
            }catch(MessagingException e){
                e.printStackTrace();
            }/*catch(IOException e){
                e.printStackTrace();

            }*/

        }

        emailList.setItems(inboxList);


        topicText.setText("Inbox");
        inboxButton.setSelected(true);

    }
    public void openMail(MouseEvent event,int index){
        Message message=messages[index];

        try {

            emailTitle.setText(message.getSubject());
            sentDate.setText(message.getSentDate().toString());
            emailContent.setText(message.getContentType());
            //System.out.println(emailList.getSelectionModel().getSelectedIndex()+"  inddex: "+index);

        } catch (MessagingException e) {
            e.printStackTrace();
        }/*catch (IOException e){
            e.printStackTrace();
        }*/


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
    public void retriveMail(){
        RetriveEmail re=new RetriveEmail("","");
        re.openConnection();
        messages= re.retriveEmail();



    }
}
