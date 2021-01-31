package StoreManagement.IHM.Produit;

import StoreManagement.DAO.Produit.Produit;
import StoreManagement.DAO.Produit.ProduitDaoImpl;

public class modifyProduitHandler {
    public modifyProduitHandler(Produit produit, ListProduitWindow listProduitWindow) {
        ProduitDaoImpl pdao=new ProduitDaoImpl();
        pdao.update(produit);
        listProduitWindow.window.close();
        new ListProduitWindow();
    }
}
