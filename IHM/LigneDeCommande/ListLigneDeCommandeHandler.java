package StoreManagement.IHM.LigneDeCommande;

import StoreManagement.DAO.LigneDeCommande.LigneDeCommande;
import StoreManagement.DAO.LigneDeCommande.LigneDeCommandeDaoImpl;
import StoreManagement.DAO.Vente.Vente;

import java.util.List;

public class ListLigneDeCommandeHandler {
    ListLigneDeCommandeWindow listLigneDeCommandeWindow;
    Vente vente;
    List<LigneDeCommande> ligneDeCommandeList;
    LigneDeCommandeDaoImpl ldao;

    public ListLigneDeCommandeHandler(Vente vente, ListLigneDeCommandeWindow listLigneDeCommandeWindow){
        this.listLigneDeCommandeWindow = listLigneDeCommandeWindow;
        this.vente = vente;
        ldao=new LigneDeCommandeDaoImpl();
    }

    public void updateVentesListWIndow(){
        listLigneDeCommandeWindow.getTable().getItems().clear();
        ligneDeCommandeList = ldao.getAll(vente.getNumero());
        listLigneDeCommandeWindow.getLigneDeCommandesObservableList().addAll(ligneDeCommandeList);
    }
}
