package StoreManagement.IHM.Client;

import StoreManagement.DAO.Client.ClientDaoImpl;
import StoreManagement.DAO.Client.Client;
import StoreManagement.DAO.Client.ClientDaoImpl;
import StoreManagement.IHM.Client.ListClientWindow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class DeleteClientHandler {
    private ObservableList<Client> clientsObservableList = FXCollections.observableArrayList();
    private List<Client> productlist;

    public DeleteClientHandler(String code, ListClientWindow listClientWindow) {
        ClientDaoImpl pdao=new ClientDaoImpl();
        pdao.delete(Long.valueOf(code));
        listClientWindow.table.getColumns().clear();
        listClientWindow.table.getItems().clear();
        productlist=pdao.getAll();
        clientsObservableList.addAll(productlist);
        listClientWindow.addColumnsToTableView(clientsObservableList);
        listClientWindow.updateColmuns();
    }
}

