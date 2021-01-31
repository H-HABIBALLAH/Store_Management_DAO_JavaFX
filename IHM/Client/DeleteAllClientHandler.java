package StoreManagement.IHM.Client;

import StoreManagement.DAO.Produit.ProduitDaoImpl;

public class DeleteAllClientHandler {
    public DeleteAllClientHandler(ListProduitWindow listProduitWindow) {
        ProduitDaoImpl pdao=new ProduitDaoImpl();
        pdao.deleteAll();
        listProduitWindow.window.close();
        new ListProduitWindow();
    }
}
