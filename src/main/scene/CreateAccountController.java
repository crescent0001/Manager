package main.scene;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import database.SqlAccess;
import database.LoginAccess;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.scene.Node;

public class CreateAccountController implements Initializable {

    @FXML
    private TextField nameField;

    @FXML
    private TextField genderField;

    @FXML
    private TextField adminNoField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField passwordField;

    @FXML
    private ComboBox<String> month;

    @FXML
    private ToggleGroup gender;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        month.getItems().addAll("January","February","March","April","May","June","July","August","September","October","November","December");


    }
    @FXML
    void signUp(ActionEvent event) {
        try{
            SqlAccess sqlAccess=new SqlAccess();
            sqlAccess.openConnection();
            String name = nameField.getText();
            //char gender = genderField.getText();
            String adminNo = adminNoField.getText();
            String email = emailField.getText();
            String password = passwordField.getText();
            ///LoginAccess.signUp("user", name, 'M', adminNo, email, password);
            sqlAccess.closeConnection();
            System.out.println("Successful registration!");

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