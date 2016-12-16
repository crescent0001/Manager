package util;
///nnned update fotr field date
import database.SqlAccess;

import java.util.Date;

/**
 * Created by hehef on 12/16/2016.
 */
public class User {
    private String name;
    private String gender;
    private Date birthDate;
    private String password;
    private String adminNo;
    private String email;
    public User(String name,String gender,Date birthDate,String password,String adminNo,String email){
        this.name=name;
        this.gender=gender;
        this.birthDate=birthDate;
        this.password=password;
        this.adminNo=adminNo;
        this.email=email;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdminNo() {
        return adminNo;
    }

    public void setAdminNo(String adminNo) {
        this.adminNo = adminNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(){

    }
    public void updateDataBase(){
        SqlAccess sqlAccess=new SqlAccess();
        sqlAccess.openConnection();
        sqlAccess.insertData("user","\""+name+"\",\""+gender+"\","+"3/25/2016"+",\""+adminNo+"\",\""+email+"\",\""+password+"\"");
        sqlAccess.closeConnection();
    }
}
