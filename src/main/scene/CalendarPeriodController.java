package main.scene;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Liu Woon Kit on 16/12/2016.
 */
public class CalendarPeriodController extends CalendarController implements Initializable {
    @FXML
    Label dateLabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dateLabel.setText(cal.getSelectedDay() + " " + cal.getStringDate());
    }

}
