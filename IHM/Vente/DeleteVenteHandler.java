package StoreManagement.IHM.Vente;

import StoreManagement.DAO.LigneDeCommande.LigneDeCommandeDaoImpl;
import StoreManagement.DAO.Vente.Vente;
import StoreManagement.DAO.Vente.VenteDaoImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class DeleteVenteHandler {
    private ObservableList<Vente> ventesObservableList = FXCollections.observableArrayList();
    private List<Vente> ventelist;

    public DeleteVenteHandler(long numero, long codeClient, ListVenteWindow listVenteWindow) {
        VenteDaoImpl vdao=new VenteDaoImpl();
        LigneDeCommandeDaoImpl ldao = new LigneDeCommandeDaoImpl();
        ldao.deleteAll(numero);
        vdao.delete(Long.valueOf(numero));
        if(listVenteWindow != null){
            listVenteWindow.getTable().getColumns().clear();
            listVenteWindow.getTable().getItems().clear();
        }
        ventelist=vdao.getAll(codeClient);
        ventesObservableList.addAll(ventelist);
        if(listVenteWindow !=null){
            listVenteWindow.addColumnsToTableView(ventesObservableList);
            listVenteWindow.updateColmuns();
        }
    }
}
