package StoreManagement.IHM.Produit;

import StoreManagement.DAO.Produit.Produit;
import StoreManagement.DAO.Produit.ProduitDaoImpl;

public class FormProduitHandler {
    public FormProduitHandler(Produit produit, FormProduitWindow formProduitWindow) {
        ProduitDaoImpl pdao=new ProduitDaoImpl();
        pdao.add(produit);
        formProduitWindow.window.close();
    }
}
