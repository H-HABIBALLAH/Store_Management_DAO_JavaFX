package StoreManagement.DAO.Produit;

import StoreManagement.DAO.Catégorie.Categorie;

public class Produit {
    private long id;
    private String designation;
    private int quantity;
    private double prixAchat;
    private double prixVente;
    private double sTotal;
    Categorie categorie;

    public Produit(long id, String designation, int quantity, double prixAchat, double prixVente, Categorie categorie) {
        this.id = id;
        this.designation = designation;
        this.quantity = quantity;
        this.prixAchat = prixAchat;
        this.prixVente = prixVente;
        this.categorie = categorie;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String description) {
        this.designation = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(double prixAchat) {
        this.prixAchat = prixAchat;
    }

    public double getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(double prixVente) {
        this.prixVente = prixVente;
    }


    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public String getIntituleCategorie() {
        return categorie.getIntitule();
    }

    public void setIntituleCategorie(String intitule) {
        this.categorie.setIntitule(intitule);
    }

    @Override
    public String toString() {
        return   id +
                ", " + designation +
                ", " + quantity +
                ", " + prixAchat +
                ", " + prixVente +
                ", " + categorie ;}
}
