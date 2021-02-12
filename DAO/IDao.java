package StoreManagement.DAO;

import StoreManagement.DAO.Produit.Produit;

import java.util.List;

public interface IDao<T> {
    public void add(T obj);
    public void delete(long id);
    public T getOne(long id);
    public List<T> getAll();
    public void deleteAll();
    public void update(T obj);

}
