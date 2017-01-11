package main.scene;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by hehef on 2017/1/10.
 */
public class EmailContentController implements Initializable {
    private Message message;
    StringBuffer bodyText=new StringBuffer();



    @FXML
    private Label cc;

    @FXML
    private Label sender;

    @FXML
    private Label subject;

    @FXML
    private Label receiveDate;

    @FXML
    private Pane messageBody;
    @FXML
    private ScrollPane scrollPane;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //no scroll to hroizontal;
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);


    }
    public void setMessage(Message message) {
        this.message = message;
        displayContent();
    }

    public void displayContent(){

        try {
            //for header
            subject.setText(message.getSubject().toString());
            Address[] froms=message.getFrom();
            String address=froms==null?null:((InternetAddress)froms[0]).getAddress();
            sender.setText(address);
            Address[] receipients=message.getAllRecipients();
            String receipientText="";
            for(Address add:receipients) receipientText+=add.toString()+",";
            cc.setText(receipientText);
            receiveDate.setText(message.getSentDate().toString());

            //for email body
            Object messageContent=message.getContent();
            if(messageContent instanceof String){
                bodyText.append(messageContent.toString());

            }else if(messageContent instanceof  Multipart) {
                Multipart multipart=(Multipart)messageContent;
                for(int i=0;i<multipart.getCount();i++) {
                    getMailContent(multipart.getBodyPart(i));

                }


               //getMailContent((Part) message.getContent());



            }
            WebView webView=new WebView();
            WebEngine webEngine=webView.getEngine();
            webEngine.loadContent(bodyText.toString());


            //TextArea textArea=new TextArea();
            //textArea.setText(bodyText.toString());
            messageBody.getChildren().add(webView);




        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void getMailContent(Part part) throws Exception{
        String contentType=part.getContentType();
        System.out.println("email type of mimitype"+contentType);
        int nameIndex=contentType.indexOf("name");

        System.out.println("type content "+contentType);
        if(part.isMimeType("text/plain")){
            System.out.println("text/plain");
            bodyText.append(part.getContent().toString());

        }else if(part.isMimeType("text/html")){
            System.out.println("text/html");
            bodyText.append(part.getContent().toString());

        }else if(part.isMimeType("multipart/*")){
            System.out.println("multipart/*");
            Multipart multipart=(Multipart)part.getContent();
            for(int i=0;i<multipart.getCount();i++){
                getMailContent(multipart.getBodyPart(i));
            }
        }else if(part.isMimeType("message/rfc822")) {
            System.out.println("message/rfc822");
            getMailContent((Part) part.getContent());

        }


    }

}
