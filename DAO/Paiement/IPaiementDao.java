package StoreManagement.DAO.Paiement;

import StoreManagement.DAO.Paiement.Paiement;

import java.util.List;

public interface IPaiementDao {
        public void add(Paiement paiement);
        public void delete(long numero);
        public List getAll(long numVente);
        public void deleteAll();
        public void update(Paiement Paiement);
        public Paiement getOne(long numero);
        public Paiement getOne(long numero,long numVente);
    }
