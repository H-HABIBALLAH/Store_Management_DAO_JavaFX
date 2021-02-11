package StoreManagement.DAO.Vente;

import StoreManagement.DAO.Client.Client;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Vente {
    private static long numero = 0;
    private LocalDate date = LocalDate.now();
    private double total;
    Client client = null;
    private List<LigneDeCommande> ligneDeCommandeList = new ArrayList<LigneDeCommande>();

    public Vente(Client client){
        this.client = client;
    }

    public Vente(long numero, LocalDate date, Client client) {
        this.numero = numero;
        this.date = date;
        this.client = client;
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

    public double getTotal() {
        calculerTotal();
        return total;
    }

    public void calculerTotal() {
        total = 0;
        for(LigneDeCommande ligneDeCommande : ligneDeCommandeList){
            total+= ligneDeCommande.getSousTotal();
        }
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<LigneDeCommande> getLigneCommandeList() {
        return ligneDeCommandeList;
    }

    public void setLigneCommandeList(List<LigneDeCommande> ligneDeCommandeList) {
        this.ligneDeCommandeList = ligneDeCommandeList;
    }

    @Override
    public String toString() {
        return "Vente{" +
                "numero='" + numero + '\'' +
                ", date=" + date +
                ", total=" + total +
                ", ligneCommandeList=" + ligneDeCommandeList +
                '}';
    }
}
