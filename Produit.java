package StoreManagement;

import java.util.Date;

public class Produit {
    private long id;
    private String description;
    private int quantity;
    private double prix;
    private Date date;

    public Produit(long id, String description, int quantity, double prix, Date date) {
        this.id = id;
        this.description = description;
        this.quantity = quantity;
        this.prix = prix;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    @Override
    public String toString() {
        return   id +
                ", " + description +
                ", " + quantity +
                ", " + prix +
                ", " + date ;
    }
}
