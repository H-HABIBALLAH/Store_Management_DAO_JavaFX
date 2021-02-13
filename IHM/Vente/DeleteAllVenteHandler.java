package StoreManagement.IHM.Vente;

import StoreManagement.DAO.Client.Client;
import StoreManagement.DAO.LigneDeCommande.LigneDeCommandeDaoImpl;
import StoreManagement.DAO.Vente.Vente;
import StoreManagement.DAO.Vente.VenteDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class DeleteAllVenteHandler {
    List<Vente> ventesList = new ArrayList<>();
    VenteDaoImpl vdao = null;
    LigneDeCommandeDaoImpl ldao = null;
    ListVenteWindow listVenteWindow = null;
    Client client;

    public DeleteAllVenteHandler(Client client, ListVenteWindow listVenteWindow) {
        this.client = client;
        vdao = new VenteDaoImpl();
        ldao = new LigneDeCommandeDaoImpl();
        this.listVenteWindow = listVenteWindow;
        deleteAll();
    }

    private void deleteAll() {
        ldao.deleteAll();
        vdao.deleteAll(client);
        listVenteWindow.getTable().getColumns().clear();
        listVenteWindow.getTable().getItems().clear();
        ventesList=vdao.getAll();
        listVenteWindow.getVentesObservableList().addAll(ventesList);
        listVenteWindow.addColumnsToTableView(listVenteWindow.getVentesObservableList());
        listVenteWindow.updateColmuns();
    }
}
