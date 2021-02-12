package StoreManagement.IHM.Vente;

import StoreManagement.DAO.Vente.Vente;
import StoreManagement.DAO.Vente.VenteDaoImpl;


public class SearchVenteHandler {
    ListVenteWindow listVenteWindow = null;
    VenteDaoImpl vdao = null;

    public SearchVenteHandler(long numero, ListVenteWindow listVenteWindow) {
        this.listVenteWindow = listVenteWindow;
        vdao = new VenteDaoImpl();
        searchByNumero(numero);
    }

    private void searchByNumero(long numero) {
        listVenteWindow.getTable().getItems().clear();
        listVenteWindow.getTable().getColumns().clear();
        listVenteWindow.getVentesObservableList().add(vdao.getOne(numero));
        listVenteWindow.addColumnsToTableView(listVenteWindow.getVentesObservableList());
        listVenteWindow.updateColmuns();
    }
}
