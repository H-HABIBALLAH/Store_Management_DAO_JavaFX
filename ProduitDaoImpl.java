package StoreManagement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProduitDaoImpl extends AbstractDao implements IProduitDao{

    @Override
    public void add(Produit obj) {
        List<Produit> list = new ArrayList<Produit>();
        PreparedStatement pst=null;
        String sql = "INSERT INTO `produit`(`id`, `designation`, `qte`, `prix`, `date`) VALUES (["+obj.getId()+"],["+obj.getDesignation()+"],["+obj.getQuantity()+"],["+obj.getPrix()+"],["+obj.getDate()+"])";
        try {
            pst=connection.prepareStatement(sql);
            System.out.println("Success d'exec requete");
            ResultSet rs=pst.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public Produit getOne(long id) {
        PreparedStatement pst=null;
        String sql = "SELECT * FROM produit WHERE id Like ?";
        Produit produit=null;
        try {
            pst=connection.prepareStatement(sql);
            System.out.println("Success d'exec requete");
            ResultSet rs=pst.executeQuery();
            produit=new Produit(rs.getLong("id"),rs.getString("designation"),rs.getInt("qte"),rs.getDouble("prix"),rs.getDate("date").toLocalDate());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return produit;
    }

    @Override
    public List<Produit> getAll() {
        List<Produit> list = new ArrayList<Produit>();
        PreparedStatement pst=null;
        String sql = "SELECT * FROM produit";
        try {
            pst=connection.prepareStatement(sql);
            System.out.println("Success d'exec requete");
            ResultSet rs=pst.executeQuery();
            while (rs.next()){
                list.add(new Produit(rs.getLong("id"),rs.getString("designation"),rs.getInt("qte"),rs.getDouble("prix"),rs.getDate("date").toLocalDate()));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public List<Produit> getAll(String des) {
        List<Produit> list = new ArrayList<Produit>();
        PreparedStatement pst=null;
        String sql = "SELECT * FROM produit WHERE designation LIKE ?";
        try {
            pst=connection.prepareStatement(sql);
            System.out.println("Success d'exec requete");
            pst.setNString(1,des+"%");
            ResultSet rs=pst.executeQuery();
            while (rs.next()){
                list.add(new Produit(rs.getLong("id"),rs.getString("designation"),rs.getInt("qte"),rs.getDouble("prix"),rs.getDate("date").toLocalDate()));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
