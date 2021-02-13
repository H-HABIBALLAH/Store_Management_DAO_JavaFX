package StoreManagement.IHM.Vente;

import StoreManagement.DAO.Vente.Vente;
import StoreManagement.DAO.Vente.VenteDaoImpl;

public class UpdateVenteHandler {
    VenteDaoImpl vdao = new VenteDaoImpl();
    public UpdateVenteHandler(Vente vente) {
        vdao.update(vente);
    }
}
