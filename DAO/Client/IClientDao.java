package StoreManagement.DAO.Client;

import StoreManagement.DAO.IDao;

import java.util.List;

public interface IClientDao extends IDao<Client> {
    public List<Client> getAll(String nom);
}
