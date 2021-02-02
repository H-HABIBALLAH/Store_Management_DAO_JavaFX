package StoreManagement.IHM.Produit;

import StoreManagement.DAO.Produit.Produit;
import StoreManagement.DAO.Produit.ProduitDaoImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class DeleteAllProduitHandler {
    private ObservableList<Produit> productsObservableList = FXCollections.observableArrayList();
    private List<Produit> productlist;
    public DeleteAllProduitHandler(ListProduitWindow listProduitWindow) {
        ProduitDaoImpl pdao=new ProduitDaoImpl();
        pdao.deleteAll();
        listProduitWindow.table.getColumns().clear();
        listProduitWindow.table.getItems().clear();
        productlist=pdao.getAll();
        productsObservableList.addAll(productlist);
        listProduitWindow.addColumnsToTableView(productsObservableList);
        listProduitWindow.updateColmuns();
    }
}
