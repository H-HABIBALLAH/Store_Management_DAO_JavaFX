package StoreManagement.IHM.Client;

import StoreManagement.DAO.Client.Client;
import StoreManagement.DAO.Client.ClientDaoImpl;

public class modifyClientHandler {
    public modifyClientHandler(Client Client, ListClientWindow listClientWindow) {
        ClientDaoImpl cdao=new ClientDaoImpl();
        cdao.update(Client);
        listClientWindow.window.close();
        new ListClientWindow();
    }
}
