package StoreManagement.IHM.Client;

import StoreManagement.DAO.Client.Client;
import StoreManagement.DAO.Client.ClientDaoImpl;
import StoreManagement.IHM.Client.ListClientWindow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class SearchClientHandler {
    private ObservableList<Client> clientsObservableList = FXCollections.observableArrayList();
    private List<Client> clientlist;
    public SearchClientHandler(String designation, ListClientWindow listClientWindow) {
        ClientDaoImpl pdao=new ClientDaoImpl();
        listClientWindow.table.getColumns().clear();
        listClientWindow.table.getItems().clear();
        clientlist=pdao.getAll(designation);
        clientsObservableList.addAll(clientlist);
        listClientWindow.addColumnsToTableView(clientsObservableList);
        listClientWindow.updateColmuns();
    }
}
