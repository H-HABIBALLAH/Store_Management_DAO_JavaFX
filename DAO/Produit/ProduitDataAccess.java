package StoreManagement.DAO.Produit;

import StoreManagement.DAO.Catégorie.Categorie;

import java.sql.*;
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
        PreparedStatement pst=null;
        String sql = "SELECT * FROM produit";
        try {
            pst=connection.prepareStatement(sql);
            System.out.println("Success d'exec requete");
            ResultSet rs=pst.executeQuery();
            while (rs.next()){
                list.add(new Produit(rs.getLong("id"),rs.getString("designation"),rs.getInt("qte"),rs.getDouble("prixAchat"),rs.getDouble("prixVente"),new Categorie(0,rs.getString("categorie"))));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public List<Produit> getProductByKeyWord(String searched){
        List<Produit> list = new ArrayList<Produit>();
        PreparedStatement pst=null;
        String sql = "SELECT * FROM produit WHERE designation LIKE ?";
        try {
            pst=connection.prepareStatement(sql);
            pst.setNString(1,searched+"%");
            System.out.println("Success d'exec requete");
            ResultSet rs=pst.executeQuery();
            while (rs.next()){
                list.add(new Produit(rs.getLong("id"),rs.getString("designation"),rs.getInt("qte"),rs.getDouble("prixAchat"),rs.getDouble("prixVente"),new Categorie(0,rs.getString("categorie"))));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

}
