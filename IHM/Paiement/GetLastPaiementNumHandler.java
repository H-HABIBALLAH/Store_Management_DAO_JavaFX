package StoreManagement.IHM.Paiement;

import StoreManagement.DAO.Paiement.PaiementDaoImpl;
import StoreManagement.DAO.Paiement.Paiement;
import StoreManagement.DAO.Paiement.PaiementDaoImpl;

import java.util.List;

public class GetLastPaiementNumHandler {
    private PaiementDaoImpl pdao = new PaiementDaoImpl();
    private List<Paiement> paiementsList;
    private long num;

    public GetLastPaiementNumHandler(){
        paiementsList = pdao.getAll();
        if(paiementsList.isEmpty())
            num=0;
        else
            num = paiementsList.get(paiementsList.size()-1).getNumero();
    }

    public long getNum() {
        return num;
    }
}
