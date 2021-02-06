package StoreManagement.DAO.Vente;

import StoreManagement.DAO.Produit.Produit;

public class LigneCommande {
    private long id;
    private int qte;
    private Produit produit;
    private double sousTotal;

    public LigneCommande(long id, int qte, Produit produit) {
        this.id = id;
        this.qte = qte;
        this.produit = produit;
        this.sousTotal=0;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public double getSousTotal() {
        calculerSousTotal();
        return sousTotal;
    }

    public void calculerSousTotal() {
        sousTotal = produit.getPrixVente()*qte;
    }

    @Override
    public String toString() {
        return "LigneCommande{" +
                "id=" + id +
                ", qte=" + qte +
                ", produit=" + produit +
                ", sousTotal=" + sousTotal +
                '}';
    }
}
