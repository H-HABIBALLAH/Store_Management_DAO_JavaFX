package StoreManagement;

import java.sql.Connection;

public class SingleConnection {
    Connection connection;

    private SingleConnection(){

    }

    public Connection getConnection() {
        return connection;
    }
}
