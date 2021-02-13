package StoreManagement.IHM.Vente;

import StoreManagement.DAO.Vente.Vente;
import StoreManagement.DAO.Vente.VenteDaoImpl;

import java.util.List;

public class GetLastVenteNumHandler {
    private VenteDaoImpl vdao = new VenteDaoImpl();
    private List<Vente> ventesList;
    private long num;

    public GetLastVenteNumHandler(){
        ventesList = vdao.getAll();
        num = ventesList.get(ventesList.size()-1).getNumero();
    }

    public long getNum() {
        return num;
    }
}
