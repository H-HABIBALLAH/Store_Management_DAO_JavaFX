package StoreManagement;

import java.util.Date;

public class Produit {
    private int id;
    private String description;
    private int quantity;
    private double prix;
    private Date date;

    public Produit(int id, String description, int quantity, double prix, Date date) {
        this.id = id;
        this.description = description;
        this.quantity = quantity;
        this.prix = prix;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
