package StoreManagement.IHM.Produit;

import StoreManagement.DAO.Produit.ProduitDaoImpl;

public class DeleteProduitHandler {
    public DeleteProduitHandler(String id,ListProduitWindow listProduitWindow) {
        ProduitDaoImpl pdao=new ProduitDaoImpl();
        pdao.delete(Long.valueOf(id));
        listProduitWindow.window.close();
        new ListProduitWindow();
    }
}
