package StoreManagement.DAO.Catégorie;

import StoreManagement.DAO.AbstractDao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategorieDaoImpl extends AbstractDao implements ICategorieDao {

    @Override
    public List<Categorie> getAll() {
        List<Categorie> list = new ArrayList<Categorie>();
        PreparedStatement pst=null;
        String sql = "SELECT * FROM Client";
        try {
            pst=connection.prepareStatement(sql);
            System.out.println("Success d'exec requete");
            ResultSet rs=pst.executeQuery();
            while (rs.next()){
                list.add(new Categorie(rs.getLong("code"),rs.getString("intitule")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

}
