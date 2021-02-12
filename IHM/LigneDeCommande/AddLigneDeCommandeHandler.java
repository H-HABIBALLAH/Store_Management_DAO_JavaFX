package StoreManagement.IHM.LigneDeCommande;

import StoreManagement.DAO.LigneDeCommande.LigneDeCommande;
import StoreManagement.DAO.LigneDeCommande.LigneDeCommandeDaoImpl;

public class AddLigneDeCommandeHandler {

    public AddLigneDeCommandeHandler(LigneDeCommande ligneDeCommande) {
        LigneDeCommandeDaoImpl ldcDao=new LigneDeCommandeDaoImpl();
        ldcDao.add(ligneDeCommande);
    }
}
