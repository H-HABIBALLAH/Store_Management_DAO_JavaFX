package StoreManagement.DAO.Vente;

import StoreManagement.DAO.AbstractDao;
import StoreManagement.DAO.Catégorie.Categorie;
import StoreManagement.DAO.Client.Client;
import StoreManagement.DAO.Client.ClientDaoImpl;
import StoreManagement.DAO.IDao;
import StoreManagement.DAO.Produit.Produit;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VenteDaoImpl extends AbstractDao implements IVenteDao{

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
    public void delete(long id) {

    }

    @Override
    public Vente getOne(long numero) {
        PreparedStatement pst=null;
        String sql = "SELECT * FROM vente WHERE numero = ?";
        Produit produit=null;
        try {
            pst=connection.prepareStatement(sql);
            pst.setLong(1,numero);
            ResultSet rs=pst.executeQuery();
            client=clientDao.getOne(1);
            if(rs.next()) {
                return new Vente(numero, rs.getDate("date").toLocalDate(), client);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage()+" 1");
        }
        return null;
    }

    @Override
    public List getAll() {
        List<Vente> list = new ArrayList<Vente>();
        PreparedStatement pst=null;
        String sql = "SELECT * FROM vente";
        try {
            pst=connection.prepareStatement(sql);
            System.out.println("Success d'exec requete");
            ResultSet rs=pst.executeQuery();
            while (rs.next()){
                list.add(new Vente(rs.getLong("numero"), rs.getDate("date").toLocalDate(), client));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void update(Vente vente) {

    }
}
