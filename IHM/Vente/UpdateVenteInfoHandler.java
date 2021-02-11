package StoreManagement.IHM.Vente;

import StoreManagement.DAO.Vente.Vente;
import StoreManagement.DAO.Vente.VenteDaoImpl;

import java.util.List;

public class UpdateVenteInfoHandler {
    public UpdateVenteInfoHandler(Vente vente) {
        VenteDaoImpl vdao=new VenteDaoImpl();
        List<Vente> ventesList = vdao.getAll();
        vente = ventesList.get(ventesList.size()-1);
    }
}
