package StoreManagement;

import java.sql.Connection;

public class AbstractDao {
    Connection connection=SingleConnection.getConnection();
}
