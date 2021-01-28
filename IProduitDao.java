package StoreManagement;

import java.util.List;

public interface IProduitDao extends IDao{
    public List<Produit> getAll(String des);
}
