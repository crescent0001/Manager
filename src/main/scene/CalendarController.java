package main.scene;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import util.Calendar;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Liu Woon Kit on 1/12/2016.
 */
public class CalendarController extends MainSceneController implements Initializable {
    Calendar cal = new Calendar();

    @FXML
    GridPane calGrid;

    @FXML
    Button calPicker;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        daySelector();
    }

    @FXML
    void setPicker(ActionEvent event) {
        if(cal.getCurrentMode() == "PeriodPicker") {
            cal.setCurrentMode("DayPicker");
            daySelector();
        }
        else if(cal.getCurrentMode() == "DayPicker")
            monthSelector();
        else if (cal.getCurrentMode() == "MonthPicker")
            yearSelector();
    }

    public CalendarController() {

    }

    public void periodSelector() throws IOException {
        Stage secondaryStage = new Stage();
        Parent p =  FXMLLoader.load(getClass().getResource("CalendarPeriod.fxml"));
        Scene periodScene = new Scene(p);
        secondaryStage.setScene(periodScene);
        secondaryStage.setTitle("Add Task");
        secondaryStage.setResizable(false);
        secondaryStage.show();
    }

    public void daySelector() {
        clearGrid();
        calPicker.setText(cal.getStringDate());
        //To-do: clean up more codes

        //set labels
        for(int u = 0; u < 7; u++) {
            calGrid.add(cal.daysLabel[u] = new Label(cal.dayOfWeek[u]), u, 0);
        }

        //create blank buttons with events
        //row is x, column is y, set using column by row
        for(int i = 0, x = 1, y = 0; i < 42; i++) {
            if(y > 6) {
                y = 0;
                x++;
            }
            calGrid.add(cal.daysButton[i] = new Button(), y, x);
            int tempIndex = i;
            cal.daysButton[i].setOnAction(ActionEvent -> {
                cal.setCurrentMode("PeriodPicker");
                //debug line
                System.out.println(Integer.parseInt(cal.daysButton[tempIndex].getText()));
                cal.setSelectedDay(Integer.parseInt(cal.daysButton[tempIndex].getText()));
                try {
                    periodSelector();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            y++;
        }

        //fill blank buttons with numbers
        for(int i = cal.getFirstDay(), j = 0; j < cal.getLastDayOfMonth(); i++) {
            cal.daysButton[i - 1].setText((j + 1) + "");
            j++;
        }
    }

    public void monthSelector(){
        clearGrid();
        cal.setCurrentMode("MonthPicker");
        calPicker.setText(cal.getSelectedYear() + "");

        for(int i = 0, x = 0, y = 0; i<11; i++) {
            if(x > 6) {
                y = 1;
                x = 0;
            }
            calGrid.add(cal.monthButton[i] = new Button(cal.monthOfYear[i]), x, y);
            x++;

            //set j = i to bypass error
            int j = i;
            //set onclick event
            cal.monthButton[i].setOnAction(ActionEvent -> {
                cal.setCurrentMode("DayPicker");
                System.out.println(cal.monthButton[j].getText());
                //To-do: clean up this part using array, note please don't touch this team
                for(int p = 0; p < 6; p++) {
                    if (cal.monthButton[j].getText() == cal.monthOfYear[p]) {
                        cal.setSelectedMonth(p);
                        break;
                    }
                }
                daySelector();
            });


        }
    }

    public void yearSelector() {
        clearGrid();
        cal.setCurrentMode("YearPicker");
        calPicker.setText("2000 - 2099");
    }

    public void clearGrid() {
        //wipe grid of elements
        calGrid.getChildren().clear();
    }

    public void ButtonPlus() {
        cal.setSelectedButton(1);
        ButtonCommon();
    }

    public void ButtonMinus() {
        cal.setSelectedButton(-1);
        ButtonCommon();
    }

    public void ButtonCommon() {
        if(cal.getCurrentMode() == "DayPicker")
            daySelector();
        else if(cal.getCurrentMode() == "MonthPicker")
            monthSelector();
        else if(cal.getCurrentMode() == "YearPicker")
            yearSelector();
    }
}
