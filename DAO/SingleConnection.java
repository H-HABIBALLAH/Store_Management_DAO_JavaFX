package StoreManagement.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingleConnection {
    private static Connection connection;
    String db="Store_DB";
    String user="root";
    String pwd="";
    String url="jdbc:mysql://localhost:3306/"+db;

    private SingleConnection(){
        try {
            connection = DriverManager.getConnection(url,user,pwd);
            System.out.println("construction");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if(connection == null)
            new SingleConnection();
        return connection;
    }
}
