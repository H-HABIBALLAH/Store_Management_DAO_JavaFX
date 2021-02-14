package StoreManagement.IHM.Paiement;

import StoreManagement.DAO.Paiement.Paiement;
import StoreManagement.DAO.Paiement.PaiementDaoImpl;
import StoreManagement.DAO.Vente.Vente;
import StoreManagement.IHM.Paiement.ListPaiementWindow;

import java.util.List;

public class ListPaiementHandler {
    ListPaiementWindow listPaiementWindow;
    Vente vente;
    List<Paiement> paiementList;
    PaiementDaoImpl ldao;

    public ListPaiementHandler(Vente vente, ListPaiementWindow listPaiementWindow){
        this.listPaiementWindow = listPaiementWindow;
        this.vente = vente;
        ldao=new PaiementDaoImpl();
    }

    public void updateVentesListWIndow(){
        listPaiementWindow.getTable().getItems().clear();
        paiementList = ldao.getAll(vente.getNumero());
        listPaiementWindow.getPaiementsObservableList().addAll(paiementList);
    }
}
