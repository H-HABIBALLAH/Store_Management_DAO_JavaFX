package StoreManagement.IHM.Client;

import StoreManagement.DAO.Client.ClientDaoImpl;

public class DeleteClientHandler {
    public DeleteClientHandler(String id, ListClientWindow listClientWindow) {
        ClientDaoImpl cdao=new ClientDaoImpl();
        cdao.delete(Long.valueOf(id));
        listClientWindow.window.close();
        new ListClientWindow();
    }
}
