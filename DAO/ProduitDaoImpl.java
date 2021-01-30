package StoreManagement.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProduitDaoImpl extends AbstractDao implements IProduitDao{

    @Override
    public void add(Produit obj) {
        PreparedStatement pst=null;
        String sql = "INSERT INTO produit (designation, qte, prix, date, stotal) VALUES (?,?,?,?,?)";
        try {
            pst=connection.prepareStatement(sql);
            pst.setString(1,obj.getDesignation());
            pst.setInt(2,obj.getQuantity());
            pst.setDouble(3,obj.getPrix());
            pst.setDate(4, Date.valueOf(obj.getDate()));
            pst.setDouble(5, obj.getPrix()*obj.getQuantity());
            pst.executeUpdate();
            System.out.println("Success d'exec requete");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(long id) {
        PreparedStatement pst=null;
        String sql = "DELETE FROM produit WHERE id=?";
        try {
            pst=connection.prepareStatement(sql);
            pst.setString(1, String.valueOf(id));
            System.out.println("Success d'exec requete");
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteAll() {
        PreparedStatement pst=null;
        String sql = "DELETE FROM produit";
        try {
            pst=connection.prepareStatement(sql);
            System.out.println("Success d'exec requete");
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Produit getOne(long id) {
        PreparedStatement pst=null;
        String sql = "SELECT * FROM produit WHERE id = ?";
        Produit produit=null;
        try {
            pst=connection.prepareStatement(sql);
            pst.setNString(1,String.valueOf(id));
            System.out.println("Success d'exec requete");
            ResultSet rs=pst.executeQuery();
            if(rs.next())
            return new Produit(rs.getLong("id"),rs.getString("designation"),rs.getInt("qte"),rs.getDouble("prix"),rs.getDate("date").toLocalDate());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
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

    public void update(Produit produit) {
        List<Produit> list = new ArrayList<Produit>();
        PreparedStatement pst=null;
        String sql = "UPDATE produit SET designation = ?, prix = ?, qte = ?, stotal = ? , date = ? WHERE id = ?";
        try {
            pst=connection.prepareStatement(sql);
            pst.setString(1,produit.getDesignation());
            pst.setDouble(2,produit.getPrix());
            pst.setInt(3,produit.getQuantity());
            pst.setDouble(4, produit.getPrix()*produit.getQuantity());
            pst.setDate(5, Date.valueOf(produit.getDate()));
            pst.setLong(6, produit.getId());
            System.out.println("Success d'exec requete");
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
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
