package StoreManagement.IHM.Client;

import StoreManagement.DAO.Client.ClientDaoImpl;

public class DeleteClientHandler {
    public DeleteClientHandler(String code, ListClientWindow listClientWindow) {
        ClientDaoImpl cdao=new ClientDaoImpl();
        cdao.delete(Long.valueOf(code));
        listClientWindow.window.close();
        new ListClientWindow();
    }
}
