package task;

import database.SqlStoreData;

import java.sql.Date;

/**
 * Created by lerai on 12/23/2016.
 */
public class Task {
    private String title;
    private Date dueDate;
    private int dueTime;
    private  String location;
    private String priority;
    public Task(){

    }


    public Task (String title, Date dueDate, int dueTime,String location,String priority){
        this.title=title;
        this.dueDate=dueDate;
        this.dueTime=dueTime;
        this.location=location;
        this.priority=priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public int getDueTime() {
        return dueTime;
    }

    public void setDueTime(int dueTime) {
        this.dueTime = dueTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
    public void storeData(){
        SqlStoreData sql=new SqlStoreData();
        sql.openConnection();
        sql.insertData("task","\""+title+"\","+"\""+dueDate.toString()+"\","+dueTime+",\""+location+"\",\""+priority+"\"");
        sql.closeConnection();

        ;
    }
    public void  storeData(String userName,String remoteIp,String password){
        SqlStoreData sql=new SqlStoreData();
        sql.setUserName(userName);
        sql.setPassword(password);
        sql.openConnection();


        sql.insertData("task","\""+title+"\","+"\""+dueDate.toString()+"\","+dueTime+",\""+location+"\",\""+priority+"\"");
        sql.closeConnection();



    }
}
