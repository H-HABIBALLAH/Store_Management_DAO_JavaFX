package StoreManagement.IHM.Client;

import StoreManagement.DAO.Client.ClientDaoImpl;

public class DeleteAllClientHandler {
    public DeleteAllClientHandler(ListClientWindow listClientWindow) {
        ClientDaoImpl cdao=new ClientDaoImpl();
        cdao.deleteAll();
        listClientWindow.window.close();
        new ListClientWindow();
    }
}