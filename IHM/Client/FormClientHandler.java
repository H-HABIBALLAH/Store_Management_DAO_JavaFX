package StoreManagement.IHM.Client;

import StoreManagement.DAO.Client.Client;
import StoreManagement.DAO.Client.ClientDaoImpl;

public class FormClientHandler {
    public FormClientHandler(Client client, FormClientWindow formClientWindow) {
        ClientDaoImpl cdao=new ClientDaoImpl();
        cdao.add(client);
        formClientWindow.window.close();
    }
}
