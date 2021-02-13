package StoreManagement.DAO.Vente;

import StoreManagement.DAO.Client.Client;
import StoreManagement.DAO.LigneDeCommande.LigneDeCommande;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Vente {
    private long numero = 0;
    private LocalDate date = LocalDate.now();
    private double total;
    Client client = null;
    private List<LigneDeCommande> ligneDeCommandeList = new ArrayList<LigneDeCommande>();

    public Vente(Client client){
        this.client = client;
    }

    public Vente(long numero, LocalDate date, double total, Client client) {
        this.numero = numero;
        this.date = date;
        this.total = total;
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

    public double getTotalOfTable() {
        return total;
    }

    public void setTotalOfTable(double total) {
        this.total = total;
    }

    public void calculerTotal() {
        total = 0;
        for(LigneDeCommande ligneDeCommande : ligneDeCommandeList){
            System.out.println(ligneDeCommande);
            total+= ligneDeCommande.getSousTotal();
            System.out.println(total);
        }
        System.out.println(this);
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public long getCodeClient() {
        return client.getCode();
    }

    public void setCodeClient(long codeClient) {
        client.setCode(codeClient);
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
