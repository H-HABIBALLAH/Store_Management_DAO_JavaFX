package StoreManagement.IHM.Vente;


import StoreManagement.DAO.Vente.Vente;
import StoreManagement.DAO.Vente.VenteDaoImpl;

import java.util.List;

public class AddVenteHandler {
    List<Vente> ventesList = null;
    VenteDaoImpl vdao = null;
    public AddVenteHandler(Vente vente){
        vdao = new VenteDaoImpl();
        addVente(vente);
    }

    private void addVente(Vente vente){
        vdao.add(vente);
        ventesList = vdao.getAll();
        vente.setNumero(ventesList.get(ventesList.size()-1).getNumero());
    }
}
