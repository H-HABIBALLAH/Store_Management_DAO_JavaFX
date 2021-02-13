package StoreManagement.IHM.Vente;


import StoreManagement.DAO.Client.Client;
import StoreManagement.DAO.Vente.Vente;
import StoreManagement.DAO.Vente.VenteDaoImpl;

import java.util.List;

public class ListVenteHandler {
    private Client client = null;
    private ListVenteWindow listVentesWindow = null;

    public ListVenteHandler(Client client, ListVenteWindow listVentesWindow){
        this.client = client;
        this.listVentesWindow=listVentesWindow;
    }

    void updateVentesListWIndow(){
        listVentesWindow.getTable().getItems().clear();
        VenteDaoImpl vdao=new VenteDaoImpl();
        List<Vente> VentesList = vdao.getAll(client.getCode());
        listVentesWindow.getVentesObservableList().addAll(VentesList);
    }
}
