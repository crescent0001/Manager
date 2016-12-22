package database;

import java.sql.*;

/**
 * Created by hehef on 12/15/2016.
 */
public class SqlAccess {
    private final String DRIVER="com.mysql.jdbc.Driver";
    private String databaseURL="jdbc:mysql://localhost:3306/manager?useSSL=false";
    private Connection connection=null;
    private Statement statement=null;
    private ResultSet rs;

    private String userName;
    private String password;


    public SqlAccess(){
        //register driver
        userName="user";
        password="12345";

        try{
            Class.forName(DRIVER);
        }catch(ClassNotFoundException e){
            System.out.println("Driver not fount :"+e.getMessage());
        }
    }
    public void openConnection(){
        try{
            connection= DriverManager.getConnection(databaseURL,userName,password);
            statement=connection.createStatement();
        }catch (SQLException e){
            System.out.println("Connection fail "+e.getMessage()+" either wrong password or username");
        }
    }
    public void insertData(String tableName,String ...values){

        if(statement!=null){
            try{
                for(String v : values){
                    System.out.println("INSERT INTO "+tableName+" VALUES("+v+")");
                    statement.executeUpdate("INSERT INTO "+tableName+" VALUES("+v+")");
                }
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }


        }
        else{
            System.out.println("Open connection first");
        }


    }
    public ResultSet retrieveData(String query){

        try {
            rs = statement.executeQuery(query);

        }catch (SQLException e){
            System.out.println("Error:"+e.getMessage());
        }
        return rs;
    }
    public void closeConnection(){
        if(rs!=null){
            try{
                rs.close();
            } catch (Exception e){ /*do nothing*/}
        }
        if(statement!=null){
            try{
                rs.close();
            }catch (Exception e){/*do nothing*/}
        }


    }

}