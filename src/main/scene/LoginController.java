package main.scene;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {
    private String password="12345";
    private String username="crescens";
    @FXML
    private TextField nameTextField;

    @FXML
    private Label wrongText;

    @FXML
    private PasswordField passTextField;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
    void login(ActionEvent event) throws IOException{
        if(nameTextField.getText().equals(username)&&passTextField.getText().equals(password)){
            Parent p = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
            Stage stage=(Stage)((Node)event.getTarget()).getScene().getWindow();
            Scene scene=new Scene(p);
            stage.hide();
            stage.setScene(scene);
            stage.show();

        }
        else {
            wrongText.setText("Wrong username or password");
        }






    }

    @FXML
    void signUp(ActionEvent event) {



        try {
            Parent p = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
            Stage stage=(Stage)((Node)event.getTarget()).getScene().getWindow();
            Scene scene=new Scene(p);
            stage.hide();
            stage.setScene(scene);
            stage.show();
        }catch(IOException e){
            System.out.print(e);

        }




    }

}