package StoreManagement.IHM.LigneDeCommande;

import StoreManagement.DAO.Client.Client;
import StoreManagement.DAO.Vente.LigneDeCommande;
import StoreManagement.DAO.Vente.LigneDeCommandeDaoImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class AddLigneDeCommandeHandler {

    public AddLigneDeCommandeHandler(LigneDeCommande ligneDeCommande) {
        LigneDeCommandeDaoImpl ldcDao=new LigneDeCommandeDaoImpl();
        ldcDao.add(ligneDeCommande);
    }
}
