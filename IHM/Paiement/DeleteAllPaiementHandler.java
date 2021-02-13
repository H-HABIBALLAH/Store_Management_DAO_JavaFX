package StoreManagement.IHM.Paiement;

import StoreManagement.DAO.Paiement.PaiementDaoImpl;

public class DeleteAllPaiementHandler {
    PaiementDaoImpl pdao = new PaiementDaoImpl();
    public DeleteAllPaiementHandler(long numero) {
        pdao.deleteAll(numero);
    }
}
