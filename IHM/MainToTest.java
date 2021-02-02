package StoreManagement.IHM;

import StoreManagement.DAO.Produit.Produit;
import StoreManagement.DAO.Produit.ProduitDaoImpl;

import java.time.LocalDate;

public class MainToTest {
    public static void main(String[] args) {
        ProduitDaoImpl produitDao=new ProduitDaoImpl();
        Produit produit=new Produit(3,"Galaxy s8",5,4000,4200,null);
        produitDao.add(produit);
    }
}
