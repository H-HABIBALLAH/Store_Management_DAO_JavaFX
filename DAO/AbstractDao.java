package StoreManagement.DAO;

import StoreManagement.DAO.SingleConnection;

import java.sql.Connection;

public class AbstractDao {
    protected Connection connection= SingleConnection.getConnection();
}
