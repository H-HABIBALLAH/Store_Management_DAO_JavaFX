package StoreManagement.IHM.Vente;


import StoreManagement.DAO.Vente.Vente;
import StoreManagement.DAO.Vente.VenteDaoImpl;

public class AddVenteHandler {
    public AddVenteHandler(Vente vente){
        VenteDaoImpl vdao=new VenteDaoImpl();
        vdao.add(vente);
    }
}
