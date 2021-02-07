package StoreManagement.IHM.Vente;

import StoreManagement.DAO.Client.Client;
import StoreManagement.DAO.Vente.LigneDeCommande;
import StoreManagement.DAO.Vente.LigneDeCommandeDaoImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class AddLigneDeCommandeHandler {
    private ObservableList<LigneDeCommande> commandeObservableList = FXCollections.observableArrayList();
    private List<LigneDeCommande> ligneDeCommandelist;

    public AddLigneDeCommandeHandler(LigneDeCommande ligneDeCommande, FormVenteWindow formVenteWindow) {
        LigneDeCommandeDaoImpl ldcDao=new LigneDeCommandeDaoImpl();
        formVenteWindow.commandeTable.getColumns().clear();
        formVenteWindow.commandeTable.getItems().clear();
        ldcDao.add(ligneDeCommande);
        ligneDeCommandelist=ldcDao.getAll();
        commandeObservableList.addAll(ligneDeCommandelist);
        formVenteWindow.addCommandeColumnsToTableView(commandeObservableList);
        formVenteWindow.updateCommandeColmuns();
    }
}
