package StoreManagement.DAO.Vente;

import StoreManagement.DAO.Produit.Produit;

public class LigneDeCommande {
    private long id;
    private int qte;
    Vente vente;
    private Produit produit;
    private double sousTotal;

    public LigneDeCommande(long id, int qte, Vente vente, Produit produit) {
        this.id = id;
        this.qte = qte;
        this.vente = vente;
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

    public String getProduitDesignation() {
        return produit.getDesignation();
    }

    public void setProduitDesignation(String des) {
        this.produit.setDesignation(des);
    }

    public double getProduitPrixVente() {
        return produit.getPrixVente();
    }

    public void setProduitPrixVente(double prixVente) {
        this.produit.setPrixVente(prixVente);
    }

    public long getProduitId() {
        return produit.getId();
    }

    public void setProduitId(long id) {
        this.produit.setId(id);
    }


    public double getSousTotal() {
        calculerSousTotal();
        return sousTotal;
    }

    public void calculerSousTotal() {
        sousTotal = produit.getPrixVente()*qte;
    }

    public Vente getVente() {
        return vente;
    }

    public void setVente(Vente vente) {
        this.vente = vente;
    }

    @Override
    public String toString() {
        return "LigneDeCommande{" +
                "id=" + id +
                ", qte=" + qte +
                ", vente=" + vente +
                ", produit=" + produit +
                ", sousTotal=" + sousTotal +
                '}';
    }
}
