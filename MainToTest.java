package StoreManagement;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class MainToTest {
    public static void main(String[] args) {
        ProduitDaoImpl produitDao=new ProduitDaoImpl();
        Date date=new Date(2020,1,28);
        Produit produit=new Produit(3,"Galaxy s8",5,4000,date.toLocalDate());
        produitDao.add(produit);
    }
}
