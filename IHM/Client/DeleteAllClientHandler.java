package StoreManagement.IHM.Client;

import StoreManagement.DAO.Client.ClientDaoImpl;
import StoreManagement.DAO.Client.Client;
import StoreManagement.DAO.Client.ClientDaoImpl;
import StoreManagement.IHM.Client.ListClientWindow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class DeleteAllClientHandler {
    private ObservableList<Client> clientsObservableList = FXCollections.observableArrayList();
    private List<Client> clientslist;
    public DeleteAllClientHandler(ListClientWindow listClientWindow) {
        ClientDaoImpl cdao=new ClientDaoImpl();
        cdao.deleteAll();
        listClientWindow.table.getColumns().clear();
        listClientWindow.table.getItems().clear();
        clientslist=cdao.getAll();
        clientsObservableList.addAll(clientslist);
        listClientWindow.addColumnsToTableView(clientsObservableList);
        listClientWindow.updateColmuns();
    }
}
