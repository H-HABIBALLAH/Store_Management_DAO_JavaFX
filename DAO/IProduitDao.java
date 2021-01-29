package StoreManagement.DAO;

import java.util.List;

public interface IProduitDao extends IDao<Produit>{
    public List<Produit> getAll(String des);
}
