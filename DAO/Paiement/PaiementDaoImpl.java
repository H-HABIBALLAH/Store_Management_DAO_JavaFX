package StoreManagement.DAO.Paiement;

import StoreManagement.DAO.AbstractDao;
import StoreManagement.DAO.Client.Client;
import StoreManagement.DAO.Client.ClientDaoImpl;
import StoreManagement.DAO.Paiement.IPaiementDao;
import StoreManagement.DAO.Paiement.Paiement;
import StoreManagement.DAO.Vente.Vente;
import StoreManagement.DAO.Vente.VenteDaoImpl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaiementDaoImpl extends AbstractDao implements IPaiementDao {
    Vente vente = null;
    VenteDaoImpl vDao = new VenteDaoImpl();

    @Override
    public void add(Paiement Paiement) {
        PreparedStatement pst=null;
        String sql = "INSERT INTO Paiement (date, montant, type, numVente) VALUES (?,?,?,?)";
        try {
            pst=connection.prepareStatement(sql);
            pst.setDate(1, Date.valueOf(Paiement.getDate()));
            pst.setDouble(2,Paiement.getMontant());
            pst.setString(3,Paiement.getType());
            pst.setLong(4,Paiement.getVente().getNumero());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(long numero) {
        PreparedStatement pst=null;
        String sql = "DELETE FROM Paiement WHERE numero = ?";
        try {
            pst=connection.prepareStatement(sql);
            pst.setLong(1, numero);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Paiement getOne(long numero, long numVente) {
        PreparedStatement pst=null;
        String sql = "SELECT * FROM Paiement WHERE numero = ? AND numVente = ?";
        try {
            pst=connection.prepareStatement(sql);
            pst.setLong(1,numero);
            pst.setLong(2,numVente);
            ResultSet rs=pst.executeQuery();
            Vente vente = vDao.getOne(numVente);
            if(rs.next())
                return new Paiement(numero, rs.getDate("date").toLocalDate(), rs.getDouble("montant"), rs.getString("type"), vente);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List getAll(long numVente) {
        List<Paiement> list = new ArrayList<>();
        PreparedStatement pst=null;
        String sql = "SELECT * FROM Paiement WHERE numVente = ?";
        try {
            pst=connection.prepareStatement(sql);
            pst.setLong(1,numVente);
            ResultSet rs=pst.executeQuery();
            vente = vDao.getOne(numVente);
            Paiement Paiement = null;
            while (rs.next()){
                Paiement = new Paiement(rs.getLong("numero"), rs.getDate("date").toLocalDate(), rs.getDouble("montant"), rs.getString("type"), vente);
                list.add(Paiement);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public List getAll() {
        List<Paiement> list = new ArrayList<>();
        PreparedStatement pst=null;
        String sql = "SELECT * FROM Paiement";
        try {
            pst=connection.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            Paiement Paiement = null;
            while (rs.next()){
                Paiement = new Paiement(rs.getLong("numero"), rs.getDate("date").toLocalDate(), rs.getDouble("montant"), rs.getString("type"), null);
                list.add(Paiement);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void deleteAll(long numVente) {
        PreparedStatement pst=null;
        String sql = "DELETE FROM Paiement WHERE numVente = ?";
        try {
            pst=connection.prepareStatement(sql);
            pst.setLong(1,numVente);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteAll() {
        PreparedStatement pst=null;
        String sql = "DELETE FROM Paiement";
        try {
            pst=connection.prepareStatement(sql);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Paiement Paiement) {

    }

    @Override
    public Paiement getOne(long numero) {
        PreparedStatement pst=null;
        String sql = "SELECT * FROM Paiement WHERE numero = ?";
        try {
            pst=connection.prepareStatement(sql);
            pst.setLong(1,numero);
            ResultSet rs=pst.executeQuery();
            if(rs.next())
                return new Paiement(rs.getLong("numero"), rs.getDate("date").toLocalDate(), rs.getDouble("montant"), rs.getString("type"), null);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
