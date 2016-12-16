package test;

import database.SqlAccess;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by hehef on 12/15/2016.
 */
public class test {
    public static void main(String[] args) {
        SqlAccess sqlAccess=new SqlAccess();
        sqlAccess.openConnection();
        ResultSet rs=sqlAccess.retriveData("SELECT name,gender,birthDate,adminNo,email,password FROM user");
        try {
            while (rs.next()) {
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("gender"));

            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());

        }

    }
}
