package StoreManagement.IHM.Produit;

import StoreManagement.DAO.Produit.ProduitDaoImpl;

public class DeleteAllProduitHandler {
    public DeleteAllProduitHandler(ListProduitWindow listProduitWindow) {
        ProduitDaoImpl pdao=new ProduitDaoImpl();
        pdao.deleteAll();
        listProduitWindow.window.close();
        new ListProduitWindow();
    }
}
