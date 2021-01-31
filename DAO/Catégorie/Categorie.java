package StoreManagement.DAO.Catégorie;

import java.time.LocalDate;

public class Categorie {
    private long code;
    private String intitule;

    public Categorie(long code, String intitule) {
        this.code = code;
        this.intitule = intitule;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    @Override
    public String toString() {
        return
                "code = " + code + ", intitule = " + intitule;
    }
}
