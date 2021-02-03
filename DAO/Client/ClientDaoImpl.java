package StoreManagement.DAO.Client;

import StoreManagement.DAO.AbstractDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoImpl extends AbstractDao implements IClientDao {

    @Override
    public void add(Client obj) {
        PreparedStatement pst=null;
        String sql = "INSERT INTO Client (nom, prenom, tel, email, adresse) VALUES (?,?,?,?,?)";
        try {
            pst=connection.prepareStatement("ALTER TABLE client AUTO_INCREMENT = 1");
            pst.executeUpdate();
            pst=connection.prepareStatement(sql);
            pst.setString(1,obj.getNom());
            pst.setString(2,obj.getPrenom());
            pst.setString(3,obj.getTel());
            pst.setString(4,obj.getEmail());
            pst.setString(5,obj.getAdresse());
            pst.executeUpdate();
            System.out.println("Success d'exec requete");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(long code) {
        PreparedStatement pst=null;
        String sql = "DELETE FROM Client WHERE code = ?";
        try {
            pst=connection.prepareStatement(sql);
            pst.setString(1, String.valueOf(code));
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
        String sql = "SELECT * FROM Client WHERE code = ?";
        Client Client=null;
        try {
            pst=connection.prepareStatement(sql);
            pst.setNString(1,String.valueOf(id));
            System.out.println("Success d'exec requete");
            ResultSet rs=pst.executeQuery();
            if(rs.next())
            return new Client(rs.getLong("code"),rs.getString("nom"),rs.getString("prenom"),rs.getString("tel"),rs.getString("email"),rs.getString("adresse"));
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
                list.add(new Client(rs.getLong("code"),rs.getString("nom"),rs.getString("prenom"),rs.getString("tel"),rs.getString("email"),rs.getString("adresse")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void update(Client Client) {
        List<Client> list = new ArrayList<Client>();
        PreparedStatement pst=null;
        String sql = "UPDATE Client SET nom = ?, prenom = ?, tel = ? , email = ? , adresse = ?  WHERE code = ?";
        try {
            pst=connection.prepareStatement(sql);
            pst.setString(1,Client.getNom());
            pst.setString(2,Client.getPrenom());
            pst.setString(3,Client.getTel());
            pst.setString(4,Client.getEmail());
            pst.setString(5,Client.getAdresse());
            pst.setLong(6, Client.getCode());
            System.out.println("Success d'exec requete");
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Client> getAll(String nom) {
        List<Client> list = new ArrayList<Client>();
        PreparedStatement pst=null;
        String sql = "SELECT * FROM Client WHERE nom LIKE ?";
        try {
            pst=connection.prepareStatement(sql);
            System.out.println("Success d'exec requete");
            pst.setNString(1,nom+"%");
            ResultSet rs=pst.executeQuery();
            while (rs.next()){
                list.add(new Client(rs.getLong("code"),rs.getString("nom"),rs.getString("prenom"),rs.getString("tel"),rs.getString("email"),rs.getString("adresse")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
