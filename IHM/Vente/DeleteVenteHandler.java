package StoreManagement.IHM.Vente;

import StoreManagement.DAO.Vente.Vente;
import StoreManagement.DAO.Vente.VenteDaoImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class DeleteVenteHandler {
    private ObservableList<Vente> ventesObservableList = FXCollections.observableArrayList();
    private List<Vente> ventelist;

    public DeleteVenteHandler(Long code, ListVenteWindow listVenteWindow) {
        VenteDaoImpl vdao=new VenteDaoImpl();
        vdao.delete(Long.valueOf(code));
        listVenteWindow.table.getColumns().clear();
        listVenteWindow.table.getItems().clear();
        ventelist=vdao.getAll(code);
        ventesObservableList.addAll(ventelist);
        listVenteWindow.addColumnsToTableView(ventesObservableList);
        listVenteWindow.updateColmuns();
    }
}
