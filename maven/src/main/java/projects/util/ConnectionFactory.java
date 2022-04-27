package projects.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection init() throws SQLException {
        return DriverManager
                .getConnection("jdbc:postgresql://localhost:8080/",
                        "postgres", "heslo");
    }

}
