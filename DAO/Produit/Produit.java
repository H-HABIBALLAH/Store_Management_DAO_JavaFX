package StoreManagement.DAO.Produit;

import StoreManagement.DAO.Catégorie.Categorie;

import java.sql.Date;
import java.time.LocalDate;

public class Produit {
    private long id;
    private String designation;
    private int quantity;
    private double prix;
    private LocalDate date;
    private double sTotal;
    Categorie categorie;

    public Produit(long id, String designation, int quantity, double prix, LocalDate date, Categorie categorie) {
        this.id = id;
        this.designation = designation;
        this.quantity = quantity;
        this.prix = prix;
        this.date = date;
        this.sTotal= this.prix*this.quantity;
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

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getSTotal() {
        return sTotal;
    }

    public void setSTotal(double sTotal) {
        sTotal=this.quantity*this.prix;
        this.sTotal = sTotal;
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
                ", " + prix +
                ", " + date +
                ", " + date +
                ", " + categorie +
                ", " + getSTotal();
    }
}
