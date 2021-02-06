package StoreManagement.IHM.Vente;

import StoreManagement.DAO.Produit.Produit;
import StoreManagement.DAO.Produit.ProduitDaoImpl;
import StoreManagement.IHM.Vente.FormVenteWindow;

import java.util.List;

public class ListProduitVenteHandler {

    FormVenteWindow formVenteWindow = null;

    public ListProduitVenteHandler(FormVenteWindow formVenteWindow){
        this.formVenteWindow = formVenteWindow;
    }

    void updateObservableProduitsList(){
        ProduitDaoImpl pdao=new ProduitDaoImpl();
        List<Produit> productsList = pdao.getAll();
        formVenteWindow.getProductsObservableList().addAll(productsList);
    }
}
