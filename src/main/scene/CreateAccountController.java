package main.scene;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.scene.Node;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Node;

public class CreateAccountController implements Initializable {

    @FXML
    private ComboBox<String> month;

    @FXML
    private ToggleGroup gender;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        month.getItems().addAll("January","Febuary","March","April","May","June","July","August","September","October","November","December");


    }
    @FXML
    void signUp(ActionEvent event) {
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