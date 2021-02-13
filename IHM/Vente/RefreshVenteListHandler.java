package StoreManagement.IHM.Vente;

import StoreManagement.DAO.Vente.Vente;
import StoreManagement.DAO.Vente.VenteDaoImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class RefreshVenteListHandler {
    private ObservableList<Vente> ventesObservableList = FXCollections.observableArrayList();
    private List<Vente> venteslist;

    public RefreshVenteListHandler(Long codeClient,ListVenteWindow listVenteWindow) {
        VenteDaoImpl vdao=new VenteDaoImpl();
        listVenteWindow.getTable().getColumns().clear();
        listVenteWindow.getTable().getItems().clear();
        venteslist=vdao.getAll(codeClient);
        ventesObservableList.addAll(venteslist);
        listVenteWindow.addColumnsToTableView(ventesObservableList);
        listVenteWindow.updateColmuns();
    }
}
