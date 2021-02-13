package StoreManagement.DAO.Vente;

import StoreManagement.DAO.AbstractDao;
import StoreManagement.DAO.Client.Client;
import StoreManagement.DAO.Client.ClientDaoImpl;
import StoreManagement.DAO.LigneDeCommande.LigneDeCommande;
import StoreManagement.DAO.LigneDeCommande.LigneDeCommandeDaoImpl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VenteDaoImpl extends AbstractDao implements IVenteDao {
    Client client = null;
    ClientDaoImpl clientDao = new ClientDaoImpl();

    @Override
    public void add(Vente vente) {
        PreparedStatement pst=null;
        String sql = "INSERT INTO vente (date, total, codeClient) VALUES (?,?,?)";
        try {
            pst=connection.prepareStatement(sql);
            pst.setDate(1, Date.valueOf(vente.getDate()));
            pst.setDouble(2,vente.getTotal());
            pst.setLong(3,vente.getClient().getCode());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(long numero) {
        PreparedStatement pst=null;
        String sql = "DELETE FROM Vente WHERE numero = ?";
        try {
            pst=connection.prepareStatement(sql);
            pst.setString(1, String.valueOf(numero));
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Vente getOne(long numero, long codeClient) {
        PreparedStatement pst=null;
        String sql = "SELECT * FROM vente WHERE numero = ? AND codeClient = ?";
        try {
            pst=connection.prepareStatement(sql);
            pst.setLong(1,numero);
            pst.setLong(2,codeClient);
            ResultSet rs=pst.executeQuery();
            Client client = clientDao.getOne(codeClient);
            if(rs.next())
                return new Vente(numero, rs.getDate("date").toLocalDate(), client);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List getAll(Long codeClient) {
        List<Vente> list = new ArrayList<>();
        PreparedStatement pst=null;
        String sql = "SELECT * FROM vente WHERE codeClient = ?";
        try {
            pst=connection.prepareStatement(sql);
            pst.setLong(1,codeClient);
            ResultSet rs=pst.executeQuery();
            client = clientDao.getOne(codeClient);
            Vente vente = null;
            while (rs.next()){
                vente = new Vente(rs.getLong("numero"), rs.getDate("date").toLocalDate(), rs.getDouble("total"), client);
                System.out.println(rs.getDouble("total"));
                list.add(vente);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public List getAll() {
        List<Vente> list = new ArrayList<>();
        PreparedStatement pst=null;
        String sql = "SELECT * FROM vente";
        try {
            pst=connection.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            Vente vente = null;
            while (rs.next()){
                vente = new Vente(rs.getLong("numero"), rs.getDate("date").toLocalDate(), client);
                list.add(vente);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public void deleteAll() {
        PreparedStatement pst=null;
        String sql = "DELETE FROM vente";
        try {
            pst=connection.prepareStatement(sql);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Vente vente) {

    }

    @Override
    public Vente getOne(long numero) {
        PreparedStatement pst=null;
        String sql = "SELECT * FROM vente WHERE numero = ?";
        try {
            pst=connection.prepareStatement(sql);
            pst.setLong(1,numero);
            ResultSet rs=pst.executeQuery();
            if(rs.next())
                return new Vente(numero, rs.getDate("date").toLocalDate(), null);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
