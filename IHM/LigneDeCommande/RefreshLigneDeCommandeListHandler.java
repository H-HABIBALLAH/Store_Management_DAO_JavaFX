package StoreManagement.IHM.LigneDeCommande;

import StoreManagement.DAO.LigneDeCommande.LigneDeCommande;
import StoreManagement.DAO.LigneDeCommande.LigneDeCommandeDaoImpl;
import StoreManagement.IHM.LigneDeCommande.ListLigneDeCommandeWindow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class RefreshLigneDeCommandeListHandler {
    private ObservableList<LigneDeCommande> LigneDeCommandesObservableList = FXCollections.observableArrayList();
    private List<LigneDeCommande> LigneDeCommandeslist;

    public RefreshLigneDeCommandeListHandler(Long numVente, ListLigneDeCommandeWindow listLigneDeCommandeWindow) {
        LigneDeCommandeDaoImpl ldao=new LigneDeCommandeDaoImpl();
        listLigneDeCommandeWindow.getTable().getColumns().clear();
        listLigneDeCommandeWindow.getTable().getItems().clear();
        LigneDeCommandeslist=ldao.getAll(numVente);
        LigneDeCommandesObservableList.addAll(LigneDeCommandeslist);
        listLigneDeCommandeWindow.addColumnsToTableView();
        listLigneDeCommandeWindow.updateColmuns();
    }
}
