package StoreManagement.DAO.Produit;

import StoreManagement.DAO.IDao;

import java.util.List;

public interface IProduitDao extends IDao<Produit> {
    public List<Produit> getAll(String des);
}
