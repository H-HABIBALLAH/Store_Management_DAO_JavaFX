package StoreManagement.IHM.LigneDeCommande;

import StoreManagement.DAO.LigneDeCommande.LigneDeCommandeDaoImpl;
import StoreManagement.DAO.Vente.Vente;

public class DeleteLigneDeCommandeHandler {
    LigneDeCommandeDaoImpl ldao;
    ListLigneDeCommandeWindow listLigneDeCommandeWindow;
    long id;
    Vente vente;

    public DeleteLigneDeCommandeHandler(long id, Vente vente, ListLigneDeCommandeWindow listLigneDeCommandeWindow) {
        this.id = id;
        this.listLigneDeCommandeWindow = listLigneDeCommandeWindow;
        this.ldao = new LigneDeCommandeDaoImpl();
        this.vente = vente;
        deleteLigneDeCommande();
    }

    public void deleteLigneDeCommande(){
        ldao.delete(id);
        listLigneDeCommandeWindow.getTable().getColumns().clear();
        listLigneDeCommandeWindow.getTable().getItems().clear();
        listLigneDeCommandeWindow.getLigneDeCommandesObservableList().addAll(ldao.getAll(vente.getNumero()));
        listLigneDeCommandeWindow.updateColmuns();
        listLigneDeCommandeWindow.addColumnsToTableView();
    }
}
