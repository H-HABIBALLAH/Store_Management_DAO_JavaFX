package StoreManagement.IHM.Produit;

import StoreManagement.DAO.Produit.Produit;
import StoreManagement.DAO.Produit.ProduitDaoImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class ModifyProduitHandler {
    private ObservableList<Produit> productsObservableList = FXCollections.observableArrayList();
    private List<Produit> productlist;

    public ModifyProduitHandler(Produit produit, ListProduitWindow listProduitWindow) {
        ProduitDaoImpl pdao=new ProduitDaoImpl();
        pdao.update(produit);
        listProduitWindow.table.getColumns().clear();
        listProduitWindow.table.getItems().clear();
        productlist=pdao.getAll();
        productsObservableList.addAll(productlist);
        listProduitWindow.addColumnsToTableView(productsObservableList);
        listProduitWindow.updateColmuns();
    }
}
