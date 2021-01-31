package StoreManagement.DAO.Client;

import StoreManagement.DAO.AbstractDao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoImpl extends AbstractDao implements IClientDao {

    @Override
    public void add(Client obj) {
        PreparedStatement pst=null;
        String sql = "INSERT INTO Client (nom, prenom, age, date) VALUES (?,?,?,?)";
        try {
            pst=connection.prepareStatement(sql);
            pst.setString(1,obj.getNom());
            pst.setString(2,obj.getPrenom());
            pst.setInt(3,obj.getAge());
            pst.setDate(4, Date.valueOf(obj.getDate()));
            pst.executeUpdate();
            System.out.println("Success d'exec requete");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(long id) {
        PreparedStatement pst=null;
        String sql = "DELETE FROM Client WHERE id=?";
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
        String sql = "DELETE FROM Client";
        try {
            pst=connection.prepareStatement(sql);
            System.out.println("Success d'exec requete");
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Client getOne(long id) {
        PreparedStatement pst=null;
        String sql = "SELECT * FROM Client WHERE id = ?";
        Client Client=null;
        try {
            pst=connection.prepareStatement(sql);
            pst.setNString(1,String.valueOf(id));
            System.out.println("Success d'exec requete");
            ResultSet rs=pst.executeQuery();
            if(rs.next())
            return new Client(rs.getLong("id"),rs.getString("nom"),rs.getString("prenom"),rs.getInt("age"),rs.getDate("date").toLocalDate());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Client> getAll() {
        List<Client> list = new ArrayList<Client>();
        PreparedStatement pst=null;
        String sql = "SELECT * FROM Client";
        try {
            pst=connection.prepareStatement(sql);
            System.out.println("Success d'exec requete");
            ResultSet rs=pst.executeQuery();
            while (rs.next()){
                list.add(new Client(rs.getLong("id"),rs.getString("nom"),rs.getString("prenom"),rs.getInt("age"),rs.getDate("date").toLocalDate()));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void update(Client Client) {
        List<Client> list = new ArrayList<Client>();
        PreparedStatement pst=null;
        String sql = "UPDATE Client SET designation = ?, prix = ?, qte = ?, stotal = ? , date = ? WHERE id = ?";
        try {
            pst=connection.prepareStatement(sql);
            pst.setString(1,Client.getNom());
            pst.setString(2,Client.getPrenom());
            pst.setInt(3,Client.getAge());
            pst.setDate(5, Date.valueOf(Client.getDate()));
            pst.setLong(6, Client.getId());
            System.out.println("Success d'exec requete");
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Client> getAll(String des) {
        List<Client> list = new ArrayList<Client>();
        PreparedStatement pst=null;
        String sql = "SELECT * FROM Client WHERE designation LIKE ?";
        try {
            pst=connection.prepareStatement(sql);
            System.out.println("Success d'exec requete");
            pst.setNString(1,des+"%");
            ResultSet rs=pst.executeQuery();
            while (rs.next()){
                list.add(new Client(rs.getLong("id"),rs.getString("nom"),rs.getString("prenom"),rs.getInt("age"),rs.getDate("date").toLocalDate()));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
