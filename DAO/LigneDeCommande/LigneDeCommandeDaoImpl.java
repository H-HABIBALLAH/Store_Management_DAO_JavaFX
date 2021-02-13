package StoreManagement.DAO.LigneDeCommande;

import StoreManagement.DAO.AbstractDao;
import StoreManagement.DAO.Produit.Produit;
import StoreManagement.DAO.Produit.ProduitDaoImpl;
import StoreManagement.DAO.Vente.Vente;
import StoreManagement.DAO.Vente.VenteDaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LigneDeCommandeDaoImpl extends AbstractDao{
    ProduitDaoImpl pdao = new ProduitDaoImpl();
    VenteDaoImpl vdao = new VenteDaoImpl();
    Vente vente = null;
    Produit produit = null;

    public void add(LigneDeCommande ligneDeCommande){
        PreparedStatement pst=null;
        String sql = "INSERT INTO lignedecommande (qte, sousTotal, numVente, idProduit) VALUES (?,?,?,?)";
        try {
            pst=connection.prepareStatement(sql);
            pst.setInt(1,ligneDeCommande.getQte());
            pst.setDouble(2,ligneDeCommande.getSousTotal());
            pst.setLong(3,ligneDeCommande.getVente().getNumero());
            pst.setLong(4,ligneDeCommande.getProduit().getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteAll(long venteNumero) {
        PreparedStatement pst=null;
        String sql = "DELETE FROM LigneDeCommande WHERE numVente = ?";
        try {
            pst=connection.prepareStatement(sql);
            pst.setLong(1,venteNumero);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteAll() {
        PreparedStatement pst=null;
        String sql = "DELETE FROM LigneDeCommande";
        try {
            pst=connection.prepareStatement(sql);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(long id) {
        PreparedStatement pst=null;
        String sql = "DELETE FROM LigneDeCommande WHERE id = ?";
        try {
            pst=connection.prepareStatement(sql);
            pst.setString(1, String.valueOf(id));
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
/*
    public void deleteAll() {
        PreparedStatement pst=null;
        String sql = "DELETE FROM LigneDeCommande";
        try {
            pst=connection.prepareStatement(sql);
            System.out.println("Success d'exec requete");
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(LigneDeCommande obj) {

    }
*/

    public LigneDeCommande getOne(long id) {
        PreparedStatement pst=null;
        String sql = "SELECT * FROM LigneDeCommande WHERE id = ?";
        try {
            pst=connection.prepareStatement(sql);
            pst.setLong(1,id);
            System.out.println("Success d'exec requete");
            ResultSet rs=pst.executeQuery();
            if(rs.next()) {
                produit = pdao.getOne(rs.getLong("idProduit"));
                vente = vdao.getOne(Long.valueOf(rs.getString("numVente")));
                LigneDeCommande ligneDeCommande = new LigneDeCommande(rs.getLong("id"), rs.getInt("qte"), vente, produit);
                return ligneDeCommande;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<LigneDeCommande> getAll(long numeroVente) {
        List<LigneDeCommande> list = new ArrayList<LigneDeCommande>();
        PreparedStatement pst=null;
        Vente vente = null;
        Produit produit = null;
        String sql = "SELECT * FROM LigneDeCommande WHERE numVente = ?";
        try {
            pst=connection.prepareStatement(sql);
            pst.setLong(1,numeroVente);
            ResultSet rs=pst.executeQuery();
            while (rs.next()){
                produit = pdao.getOne(rs.getLong("idProduit"));
                vente = vdao.getOne(Long.valueOf(rs.getString("numVente")));
                list.add(new LigneDeCommande(rs.getLong("id"), rs.getInt("qte"), vente, produit));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
/*
    @Override
    public List<LigneDeCommande> getAll(String nom) {
        List<LigneDeCommande> list = new ArrayList<LigneDeCommande>();
        PreparedStatement pst=null;
        String sql = "SELECT * FROM LigneDeCommande WHERE nom LIKE ?";
        try {
            pst=connection.prepareStatement(sql);
            System.out.println("Success d'exec requete");
            pst.setNString(1,nom+"%");
            ResultSet rs=pst.executeQuery();
            while (rs.next()){
                list.add(new LigneDeCommande(rs.getLong("code"),rs.getString("nom"),rs.getString("prenom"),rs.getString("tel"),rs.getString("email"),rs.getString("adresse")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }*/
}
