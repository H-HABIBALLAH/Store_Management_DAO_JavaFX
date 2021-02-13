package StoreManagement.DAO.Paiement;

import StoreManagement.DAO.Vente.Vente;

import java.time.LocalDate;
import java.util.Date;

public class Paiement {
    private long numero;
    private LocalDate date;
    private double montant;
    private String type;
    //private Cheque cheque;
    private Vente vente;

    public Paiement(long numero, LocalDate date, double montant, String type, Vente vente) {
        this.numero = numero;
        this.date = date;
        this.montant = montant;
        this.type = type;
        this.vente = vente;
    }

    public Paiement(LocalDate date, double montant, String type, Vente vente) {
        this.date = date;
        this.montant = montant;
        this.type = type;
        this.vente = vente;
    }


    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Vente getVente() {
        return vente;
    }

    public void setVente(Vente vente) {
        this.vente = vente;
    }

    @Override
    public String toString() {
        return "Paiement{" +
                "numero=" + numero +
                ", date=" + date +
                ", Montant=" + montant +
                ", type='" + type + '\'' +
                '}';
    }
}
