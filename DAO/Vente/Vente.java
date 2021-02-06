package StoreManagement.DAO.Vente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Vente {
    private String numero;
    private LocalDate date;
    private double total;
    private List<LigneCommande> ligneCommandeList = new ArrayList<LigneCommande>();

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
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
        for(LigneCommande ligneCommande : ligneCommandeList){
            total+=ligneCommande.getSousTotal();
        }
    }

    public List<LigneCommande> getLigneCommandeList() {
        return ligneCommandeList;
    }

    public void setLigneCommandeList(List<LigneCommande> ligneCommandeList) {
        this.ligneCommandeList = ligneCommandeList;
    }

    @Override
    public String toString() {
        return "Vente{" +
                "numero='" + numero + '\'' +
                ", date=" + date +
                ", total=" + total +
                ", ligneCommandeList=" + ligneCommandeList +
                '}';
    }
}
