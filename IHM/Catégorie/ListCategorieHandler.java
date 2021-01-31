/*package StoreManagement.IHM.Catégorie;

import StoreManagement.DAO.Produit.Produit;
import StoreManagement.DAO.Produit.ProduitDaoImpl;
import StoreManagement.IHM.Produit.ListProduitWindow;

import java.util.List;

public class ListCategorieHandler {
    ListProduitWindow listProduitsWindow = null;

    public ListProduitsHandler(ListProduitWindow listProduitsWindow){
        this.listProduitsWindow=listProduitsWindow;
    }

    void updateProduitsListWIndow(){
        ProduitDaoImpl pdao=new ProduitDaoImpl();
        List<Produit> productsList = pdao.getAll();
        listProduitsWindow.productsObservableList.addAll(productsList);
    }

}
*/