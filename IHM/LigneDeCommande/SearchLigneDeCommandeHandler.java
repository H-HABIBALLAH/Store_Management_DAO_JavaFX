package StoreManagement.IHM.LigneDeCommande;

import StoreManagement.DAO.LigneDeCommande.LigneDeCommande;
import StoreManagement.DAO.LigneDeCommande.LigneDeCommandeDaoImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class SearchLigneDeCommandeHandler {
    private ObservableList<LigneDeCommande> ligneDeCommandeObservableList = FXCollections.observableArrayList();
    private LigneDeCommande ligneDeCommande;

    public SearchLigneDeCommandeHandler(Long id, ListLigneDeCommandeWindow listLigneDeCommandeWindow) {
        LigneDeCommandeDaoImpl ldao=new LigneDeCommandeDaoImpl();
        listLigneDeCommandeWindow.getTable().getColumns().clear();
        listLigneDeCommandeWindow.getTable().getItems().clear();
        ligneDeCommande=ldao.getOne(id);
        listLigneDeCommandeWindow.getLigneDeCommandesObservableList().clear();
        listLigneDeCommandeWindow.getLigneDeCommandesObservableList().add(ligneDeCommande);
        listLigneDeCommandeWindow.addColumnsToTableView();
        listLigneDeCommandeWindow.updateColmuns();
    }
}
