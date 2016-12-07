package main.scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.GregorianCalendar;

/**
 * Created by Liu Woon Kit on 23/11/2016.
 */
public class Calendar {
    private GregorianCalendar date = new GregorianCalendar();
    Label[] daysLabel = new Label[7];
    Button[] daysButton = new Button[42];
    Button[] monthButton = new Button[12];

    private int selectedDay = date.get(GregorianCalendar.DAY_OF_MONTH);
    private int selectedMonth = date.get(GregorianCalendar.MONTH);
    private int selectedYear = date.get(GregorianCalendar.YEAR);

    private int firstDay;
    private int lastDayOfMonth;
    private int currentMonth= date.get(GregorianCalendar.MONTH);

    private String currentMode = "DayPicker";

    public int getSelectedDay() {
        return date.get(GregorianCalendar.DAY_OF_MONTH);
    }

    public void setSelectedDay(int selectedDay) {
        date.set(GregorianCalendar.DAY_OF_MONTH, selectedDay);
    }

    public int getSelectedMonth() {
        return (date.get(GregorianCalendar.MONTH) + 1);
    }

    public void setSelectedMonth(int selectedMonth) {
        date.set(GregorianCalendar.MONTH, selectedMonth - 1);
    }

    public int getSelectedYear() {
        return date.get(GregorianCalendar.YEAR);
    }

    public void setSelectedYear(int selectedYear) {
        date.set(GregorianCalendar.YEAR, selectedYear);
    }

    public int getFirstDay() {
        date.set(GregorianCalendar.DAY_OF_MONTH, 1);
        return date.get(GregorianCalendar.DAY_OF_WEEK);
    }

    public int getLastDayOfMonth() {
        return lastDayOfMonth = date.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
    }

    public void setCurrentMode(String uzi) {
        currentMode = uzi;
    }

    public String getCurrentMode() {
        return currentMode;
    }

    public String getStringDate() {
        String x = date.get(GregorianCalendar.MONTH) +"";
        switch(x) {
            case "0":
                x = "January";
                break;
            case "1":
                x = "February";
                break;
            case "2":
                x = "March";
                break;
            case "3":
                x = "April";
                break;
            case "4":
                x = "May";
                break;
            case "5":
                x = "June";
                break;
            case "6":
                x = "July";
                break;
            case "7":
                x = "August";
                break;
            case "8":
                x = "September";
                break;
            case "9":
                x = "October";
                break;
            case "10":
                x = "November";
                break;
            case "11":
                x = "December";
                break;
        }
        String StringDate = x + " " + date.get(GregorianCalendar.YEAR);
        return StringDate;
    }

    public void setSelectedButton (int tempNum) {
        if(currentMode == "DayPicker") {
            int x = date.get(GregorianCalendar.MONTH);
            x += tempNum;
            date.set(GregorianCalendar.MONTH, x);
        }

        else if(currentMode == "MonthPicker") {
            int x = date.get(GregorianCalendar.YEAR);
            x += tempNum;
            date.set(GregorianCalendar.YEAR, x);
        }
    }
}