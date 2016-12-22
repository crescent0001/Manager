package database;

import java.sql.SQLException;

/**
 * Created by Liu Woon Kit on 22/12/2016.
 */
public class LoginAccess extends SqlAccess{
    //Insecure connection af but its a project, so who cares?

    //Sign up method
    public void signUp(String name, String gender, String adminNo, String email, String password) {
        openConnection();
        insertData("user", name, gender, adminNo, email, password);
        System.out.println("Successful Registration!");
        closeConnection();
    }


    //Login check method, return true or false
    public boolean checkLogin(String username, String password) throws SQLException {
        openConnection();

        //default to true because why not? Should be false though, right? Halp Miss Phoon
        boolean loginCheck = true;

        //Create statement to give to SQL server
        String SQL = "SELECT * FROM user WHERE name='" + username + "' && password='" + password+ "'" ;

        //give statement to hhff's method and get set
        //set false if set is empty
        if(!retrieveData(SQL).next()) {
            loginCheck = false;
        }

        System.out.println("Login successful? " + loginCheck);

        closeConnection();
        return loginCheck;
    }

}