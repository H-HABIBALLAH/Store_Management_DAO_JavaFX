package StoreManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProduitDataAccess {
    String db="Store_DB";
    String user="root";
    String pwd="";
    String url="jdbc"+db;

    Connection connection;

    public ProduitDataAccess() {
        {
            try {
                connection = DriverManager.getConnection(url, user, pwd);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
