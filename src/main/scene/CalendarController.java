package main.scene;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
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

    @FXML
    private void add(ActionEvent event) {
    }

    public void periodSelector() {
        clearGrid();

        calGrid.add(new Label("Setting tasks for"), 0, 0);
        calGrid.add(new Label(cal.getSelectedDay() + " " + cal.getStringDate()), 1, 0);

    }

    public void daySelector() {
        clearGrid();
        //Ms Phoon halp
        String temp = null;
        for(int u = 0; u < 7; u++) {
            switch(u) {
                case 0:
                    temp = "Sunday";
                    break;
                case 1:
                    temp = "Monday";
                    break;
                case 2:
                    temp = "Tuesday";
                    break;
                case 3:
                    temp = "Wednesday";
                    break;
                case 4:
                    temp = "Thursday";
                    break;
                case 5:
                    temp = "Friday";
                    break;
                case 6:
                    temp = "Saturday";
                    break;
            }
            calGrid.add(cal.daysLabel[u] = new Label(temp), u, 0);
            cal.daysLabel[u].setMaxWidth(Double.MAX_VALUE);
            cal.daysLabel[u].setMaxHeight(Double.MAX_VALUE);
            cal.daysLabel[u].setStyle("-fx-background-color: #616161; -fx-text-fill:white");
            cal.daysLabel[u].setAlignment(Pos.CENTER);
        }

        //row is x
        int x = 1;

        //column is y
        int y = 0;

        //column by row
        for(int i = 0; i <42; i++) {
            if(y > 6) {
                y = 0;
                x++;
            }
            calGrid.add(cal.daysButton[i] = new Button(), y, x);
            cal.daysButton[i].setMaxWidth(Double.MAX_VALUE);
            cal.daysButton[i].setMaxHeight(Double.MAX_VALUE);
            int tempIndex = i;
            cal.daysButton[i].setOnAction(ActionEvent -> {
                    cal.setCurrentMode("PeriodPicker");
                    System.out.println(Integer.parseInt(cal.daysButton[tempIndex].getText()));
                    cal.setSelectedDay(Integer.parseInt(cal.daysButton[tempIndex].getText()));
                    periodSelector();
            });

            y++;
        }
        calPicker.setText(cal.getStringDate());
        int tempX = 0;
        for(int i = cal.getFirstDay(); tempX < cal.getLastDayOfMonth(); i++) {
            cal.daysButton[i - 1].setText((tempX + 1) + "");
            tempX++;
        }
    }

    public void monthSelector(){
        clearGrid();
        cal.setCurrentMode("MonthPicker");
        calPicker.setText(cal.getSelectedYear() + "");
        calGrid.add(cal.monthButton[0] = new Button("January"), 0, 0);
        calGrid.add(cal.monthButton[1] = new Button("February"), 1, 0);
        calGrid.add(cal.monthButton[2] = new Button("March"), 2, 0);
        calGrid.add(cal.monthButton[3] = new Button("April"), 3, 0);
        calGrid.add(cal.monthButton[4] = new Button("May"), 4, 0);
        calGrid.add(cal.monthButton[5] = new Button("June"), 5, 0);
        calGrid.add(cal.monthButton[6] = new Button("July"), 6, 0);
        calGrid.add(cal.monthButton[7] = new Button("August"), 0, 1);
        calGrid.add(cal.monthButton[8] = new Button("September"), 1, 1);
        calGrid.add(cal.monthButton[9] = new Button("October"), 2, 1);
        calGrid.add(cal.monthButton[10] = new Button("November"), 3, 1);
        calGrid.add(cal.monthButton[11] = new Button("December"), 4, 1);
        for(int i = 0; i<12; i ++) {
            cal.monthButton[i].setMaxWidth(Double.MAX_VALUE);
            cal.monthButton[i].setMaxHeight(Double.MAX_VALUE);
            int tempIndex = i;
            cal.monthButton[i].setOnAction(ActionEvent -> {
                cal.setCurrentMode("DayPicker");
                System.out.println(cal.monthButton[tempIndex].getText());
                int micron = 0;
                switch(cal.monthButton[tempIndex].getText()) {
                    case "January":
                        micron = 1;
                        break;
                    case "February":
                        micron = 2;
                        break;
                    case "March":
                        micron = 3;
                        break;
                    case "April":
                        micron = 4;
                        break;
                    case "May":
                        micron = 5;
                        break;
                    case "June":
                        micron = 6;
                        break;
                    case "July":
                        micron = 7;
                        break;
                    case "August":
                        micron = 8;
                        break;
                    case "September":
                        micron = 9;
                        break;
                    case "October":
                        micron = 10;
                        break;
                    case "November":
                        micron = 11;
                        break;
                    case "December":
                        micron = 12;
                        break;
                }
                cal.setSelectedMonth(micron);
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
        calGrid.getChildren().clear();
    }

    public void ButtonPlus() {
        cal.setSelectedButton(1);
        if(cal.getCurrentMode() == "DayPicker")
            daySelector();
        else if(cal.getCurrentMode() == "MonthPicker")
            monthSelector();
        else if(cal.getCurrentMode() == "YearPicker")
            yearSelector();
    }

    public void ButtonMinus() {
        cal.setSelectedButton(-1);
        if(cal.getCurrentMode() == "DayPicker")
            daySelector();
        else if(cal.getCurrentMode() == "MonthPicker")
            monthSelector();
        else if(cal.getCurrentMode() == "YearPicker")
            yearSelector();
    }
}
