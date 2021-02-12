package StoreManagement.DAO.Vente;

import StoreManagement.DAO.IDao;

import java.util.List;

public interface IVenteDao{
        public void add(Vente vente);
        public void delete(long numero);
        public List getAll(Long codeClient);
        public void deleteAll();
        public void update(Vente vente);
        public Vente getOne(long numero);
    }
