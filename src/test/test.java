package test;

import database.SqlDDL;
import database.SqlUpdateData;

/**
 * Created by hehef on 12/18/2016.
 */
public class test {
    public static void main(String[] args) {
        SqlDDL ss=new SqlDDL();
        ss.setUserName("root");
        ss.setPassword("g0415123u");
        ss.openConnection();
        ss.createTable("task","title VARCHAR(100)","dueDate DATE","dueTime Time","location VARCHAR(100)","priority varchar(20)","complete BOOLEAN","adminNo VARCHAR(7)");
        ss.closeConnection();
    }
}
