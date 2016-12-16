package main.scene;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import database.SqlAccess;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Node;
import util.User;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Node;

public class CreateAccountController implements Initializable {

    @FXML
    private ComboBox<String> month;
    @FXML
    private TextField yearField;

    @FXML
    private TextField adminNoField;

    @FXML
    private ToggleGroup genderGroup;

    @FXML
    private TextField dayField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private RadioButton radioButMale;

    @FXML
    private RadioButton radioButOther;

    @FXML
    private RadioButton radioButFemale;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        month.getItems().addAll("January","Febuary","March","April","May","June","July","August","September","October","November","December");
        radioButFemale.setUserData("Female");
        radioButMale.setUserData("Male");
        radioButOther.setUserData("Other");


    }
    @FXML
    void signUp(ActionEvent event) {
        User user=new User(
                nameField.getText(),
                genderGroup.getSelectedToggle().getUserData().toString(),
                new Date(yearField.getText(),,dayField.getText()),
                passwordField.getText(),
                adminNoField.getText(),
                emailField.getText());
        user.updateDataBase();

        try{
            Stage stage=(Stage)((Node)event.getTarget()).getScene().getWindow();
            Parent parent= FXMLLoader.load(getClass().getResource("Login.fxml"));
            Scene scene=new Scene(parent);
            stage.hide();
            stage.setScene(scene);
            stage.show();



        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}