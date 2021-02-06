package StoreManagement.IHM.Produit;

import StoreManagement.DAO.Produit.Produit;
import StoreManagement.DAO.Produit.ProduitDaoImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class RefreshProduitHandler {
    private ObservableList<Produit> productsObservableList = FXCollections.observableArrayList();
    private List<Produit> productlist;

    public RefreshProduitHandler(ListProduitWindow listProduitWindow) {
        ProduitDaoImpl pdao=new ProduitDaoImpl();
        listProduitWindow.table.getColumns().clear();
        listProduitWindow.table.getItems().clear();
        productlist=pdao.getAll();
        productsObservableList.addAll(productlist);
        listProduitWindow.addColumnsToTableView(productsObservableList);
        listProduitWindow.updateColmuns();
    }
}
