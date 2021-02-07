package StoreManagement.DAO.Vente;

import StoreManagement.DAO.IDao;

import java.util.List;

public interface ILigneDeCommandeDao extends IDao<LigneDeCommande> {
    public List<LigneDeCommande> getAll(String nom);
}
