package StoreManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProduitDataAccess {
    String db="Store_DB";
    String user="root";
    String pwd="";
    String url="jdbc:mysql://localhost:3306/"+db;

    Connection connection;

    public ProduitDataAccess() {
        {
            try {
                connection = DriverManager.getConnection(url, user, pwd);
                System.out.println("connected");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Produit> getAll(){
        List<Produit> list = new ArrayList<Produit>();

        String sql = "SELECT * FROM produit";
        try {
            PreparedStatement pst=connection.prepareStatement(sql);
            System.out.println("Success d'exec requete");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

}
