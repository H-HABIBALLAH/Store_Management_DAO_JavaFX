package StoreManagement.DAO.Vente;

import StoreManagement.DAO.AbstractDao;
import StoreManagement.DAO.Produit.Produit;
import StoreManagement.DAO.Produit.ProduitDaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LigneDeCommandeDaoImpl extends AbstractDao{
    ProduitDaoImpl pdao = new ProduitDaoImpl();
    VenteDaoImpl vdao = new VenteDaoImpl();

    public void add(LigneDeCommande ligneDeCommande){
        vdao.add(ligneDeCommande.getVente());
        PreparedStatement pst=null;
        String sql = "INSERT INTO lignedecommande (qte, sousTotal, numVente, idProduit) VALUES (?,?,?,?)";
        try {
            pst=connection.prepareStatement(sql);
            pst.setInt(1,ligneDeCommande.getQte());
            pst.setDouble(2,ligneDeCommande.getSousTotal());
            pst.setString(3,ligneDeCommande.getVente().getNumero());
            pst.setLong(4,ligneDeCommande.getProduit().getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


 /*   @Override
    public void delete(long code) {
        PreparedStatement pst=null;
        String sql = "DELETE FROM LigneDeCommande WHERE code = ?";
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

    @Override
    public LigneDeCommande getOne(long id) {
        PreparedStatement pst=null;
        String sql = "SELECT * FROM LigneDeCommande WHERE code = ?";
        LigneDeCommande LigneDeCommande=null;
        try {
            pst=connection.prepareStatement(sql);
            pst.setNString(1,String.valueOf(id));
            System.out.println("Success d'exec requete");
            ResultSet rs=pst.executeQuery();
            if(rs.next())
            return new LigneDeCommande(rs.getLong("code"),rs.getString("nom"),rs.getString("prenom"),rs.getString("tel"),rs.getString("email"),rs.getString("adresse"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }*/

    public List<LigneDeCommande> getAll() {
        List<LigneDeCommande> list = new ArrayList<LigneDeCommande>();
        PreparedStatement pst=null;
        Vente vente = null;
        Produit produit = null;
        String sql = "SELECT * FROM LigneDeCommande";
        try {
            pst=connection.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            while (rs.next()){
                produit = pdao.getOne(rs.getLong("idProduit"));
                vente = vdao.getOne(Long.valueOf(rs.getString("numVente")));
                list.add(new LigneDeCommande(0, rs.getInt("qte"), vente, produit));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
/*
    public void update(LigneDeCommande LigneDeCommande) {
        List<LigneDeCommande> list = new ArrayList<LigneDeCommande>();
        PreparedStatement pst=null;
        String sql = "UPDATE LigneDeCommande SET nom = ?, prenom = ?, tel = ? , email = ? , adresse = ?  WHERE code = ?";
        try {
            pst=connection.prepareStatement(sql);
            pst.setString(1,LigneDeCommande.getNom());
            pst.setString(2,LigneDeCommande.getPrenom());
            pst.setString(3,LigneDeCommande.getTel());
            pst.setString(4,LigneDeCommande.getEmail());
            pst.setString(5,LigneDeCommande.getAdresse());
            pst.setLong(6, LigneDeCommande.getCode());
            System.out.println("Success d'exec requete");
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

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
