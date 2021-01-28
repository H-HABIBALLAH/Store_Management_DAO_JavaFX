package StoreManagement;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

public class MainToTest {
    public static void main(String[] args) {
        ProduitDaoImpl produitDao=new ProduitDaoImpl();
        Calendar date=new Calendar();
        Produit produit=new Produit(4,"Galaxy s8",5,4000,date.toLocalDate());
        produitDao.add(produit);
    }
}
