import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.PomodoroTimer;

import java.awt.*;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("/main/scene/Login.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/main/scene/email.fxml"));
        primaryStage.setTitle("Personal Manager");
        primaryStage.setScene(new Scene(root));
        //primaryStage.setResizable(false);
        //primaryStage.sizeToScene();
        //primaryStage.setWidth(root.getScene().getWidth());
        primaryStage.show();
    }


    public static void main(String[] args) {

        //PomodoroTimer timer=new PomodoroTimer();
        //timer.start();
        launch(args);
    }
}
