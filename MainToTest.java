package StoreManagement;

import java.util.List;

public class MainToTest {
    public static void main(String[] args) {
        ProduitDataAccess produitDataAccess=new ProduitDataAccess();
        List<Produit> produitList=produitDataAccess.getProductByKeyWord("Galax");
        System.out.println(produitList);
    }
}
