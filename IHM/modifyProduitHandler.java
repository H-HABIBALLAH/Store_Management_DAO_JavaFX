package StoreManagement.IHM;

import StoreManagement.DAO.Produit;
import StoreManagement.DAO.ProduitDaoImpl;

public class modifyProduitHandler {
    public modifyProduitHandler(Produit produit, ListProduitWindow listProduitWindow) {
        ProduitDaoImpl pdao=new ProduitDaoImpl();
        pdao.update(produit);
        listProduitWindow.window.close();
        new ListProduitWindow();
    }
}
