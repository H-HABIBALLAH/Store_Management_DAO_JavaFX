package StoreManagement.IHM.LigneDeCommande;

import StoreManagement.DAO.LigneDeCommande.LigneDeCommandeDaoImpl;
import StoreManagement.DAO.LigneDeCommande.LigneDeCommande;
import StoreManagement.DAO.Vente.Vente;

import java.util.ArrayList;
import java.util.List;

public class DeleteAllLigneDeCommandeHandler {
    List<LigneDeCommande> LigneDeCommandesList = new ArrayList<>();
    LigneDeCommandeDaoImpl ldao = null;
    ListLigneDeCommandeWindow listLigneDeCommandeWindow = null;
    Vente vente;
    public DeleteAllLigneDeCommandeHandler(Vente vente, ListLigneDeCommandeWindow listLigneDeCommandeWindow) {
        this.vente = vente;
        ldao = new LigneDeCommandeDaoImpl();
        this.listLigneDeCommandeWindow = listLigneDeCommandeWindow;
        deleteAll();
    }

    private void deleteAll() {
        ldao.deleteAll(vente.getNumero());
        listLigneDeCommandeWindow.getTable().getColumns().clear();
        listLigneDeCommandeWindow.getTable().getItems().clear();
        LigneDeCommandesList=ldao.getAll(0);
        listLigneDeCommandeWindow.getLigneDeCommandesObservableList().addAll(LigneDeCommandesList);
        listLigneDeCommandeWindow.addColumnsToTableView();
        listLigneDeCommandeWindow.updateColmuns();
    }
}
