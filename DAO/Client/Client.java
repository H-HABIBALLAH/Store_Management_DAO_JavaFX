package StoreManagement.DAO.Client;

import java.time.LocalDate;

public class Client {
    private long id;
    private String nom;
    private String prenom;
    private int age;
    private LocalDate date;

    public Client(long id, String nom, String prenom, int age, LocalDate date) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return  "id= " + id +
                ", nom= " + nom +
                ", prenom= " + prenom +
                ", age= " + age +
                ", date= " + date ;
    }
}
