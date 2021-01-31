package StoreManagement.IHM.Client;

import StoreManagement.DAO.Client.Client;
import StoreManagement.DAO.Client.ClientDaoImpl;

import java.util.List;

public class ListClientHandler {
    ListClientWindow listClientsWindow = null;

    public ListClientHandler(ListClientWindow listClientsWindow){
        this.listClientsWindow=listClientsWindow;
    }

    void updateClientsListWIndow(){
        ClientDaoImpl cdao=new ClientDaoImpl();
        List<Client> clientsList = cdao.getAll();
        listClientsWindow.clientsObservableList.addAll(clientsList);
    }

}
