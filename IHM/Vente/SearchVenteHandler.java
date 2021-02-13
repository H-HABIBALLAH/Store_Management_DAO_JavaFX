package StoreManagement.IHM.Vente;

import StoreManagement.DAO.Client.Client;
import StoreManagement.DAO.Vente.VenteDaoImpl;


public class SearchVenteHandler {
    ListVenteWindow listVenteWindow = null;
    VenteDaoImpl vdao = null;

    public SearchVenteHandler(long numero, Client client, ListVenteWindow listVenteWindow) {
        this.listVenteWindow = listVenteWindow;
        vdao = new VenteDaoImpl();
        searchByNumero(numero,client);
    }

    private void searchByNumero(long numero, Client client) {
        listVenteWindow.getTable().getItems().clear();
        listVenteWindow.getTable().getColumns().clear();
        listVenteWindow.getVentesObservableList().add(vdao.getOne(numero,client.getCode()));
        listVenteWindow.addColumnsToTableView(listVenteWindow.getVentesObservableList());
        listVenteWindow.updateColmuns();
    }
}
