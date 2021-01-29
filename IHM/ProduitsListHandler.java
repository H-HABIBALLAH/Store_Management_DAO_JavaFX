package StoreManagement.IHM;

import StoreManagement.DAO.Produit;
import StoreManagement.DAO.ProduitDaoImpl;

import java.util.List;

public class ProduitsListHandler {
    ListProduitWindow listProduitsWindow = null;

    public ProduitsListHandler(ListProduitWindow listProduitsWindow){
        this.listProduitsWindow=listProduitsWindow;
    }

    void updateProduitsListWIndow(){
        ProduitDaoImpl pdao=new ProduitDaoImpl();
        List<Produit> productsList = pdao.getAll();
        listProduitsWindow.productsObservableList.addAll(productsList);
    }

}
