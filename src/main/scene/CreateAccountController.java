package main.scene;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
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
    private String[] monthInNumber;

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
        monthInNumber=new String[]{"01","02","03","04","05","06","07","08","09","10","11","12"};
        radioButFemale.setUserData("Female");
        radioButMale.setUserData("Male");
        radioButOther.setUserData("Other");


    }
    @FXML
    void signUp(ActionEvent event) {
        //convert date to string format
        String mth="01";//set default
        try {
             mth= monthInNumber[month.selectionModelProperty().get().getSelectedIndex()];
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e);

        }
        String birthDateText=yearField.getText()+"-"+mth+"-"+dayField.getText();

        User user=new User(
                nameField.getText(),                                               //name
                genderGroup.getSelectedToggle().getUserData().toString(),         //gender
                java.sql.Date.valueOf(birthDateText),                            //date in sql.Date format
                passwordField.getText(),                                        //pass
                adminNoField.getText(),                                        //adminNo
                emailField.getText());                                        //email
        user.storeData();

       /* try{
            Stage stage=(Stage)((Node)event.getTarget()).getScene().getWindow();
            Parent parent= FXMLLoader.load(getClass().getResource("Login.fxml"));
            Scene scene=new Scene(parent);
            stage.hide();

            stage.setScene(scene);
            //stage.sizeToScene();
            stage.show();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }*/

    }
    @FXML
    void cancel(ActionEvent event){
        Stage stage=(Stage)((Node)event.getTarget()).getScene().getWindow();
        stage.close();

    }
    private void closeStage(){

    }
}