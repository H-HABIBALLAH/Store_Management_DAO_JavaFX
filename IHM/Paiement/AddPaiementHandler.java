package StoreManagement.IHM.Paiement;

import StoreManagement.DAO.Paiement.Paiement;
import StoreManagement.DAO.Paiement.PaiementDaoImpl;
import StoreManagement.DAO.Vente.Vente;

public class AddPaiementHandler {
    PaiementDaoImpl pdao = new PaiementDaoImpl();
    Vente vente;
    Paiement paiement;

    public AddPaiementHandler(Vente vente, Paiement paiement) {
        this.paiement = paiement;
        paiement.setVente(vente);
        this.vente = vente;
        pdao.add(paiement);
    }
}
