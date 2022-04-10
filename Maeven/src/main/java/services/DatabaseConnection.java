package services;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    public void ConnectToDatabase() {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:8080/",
                            "postgres", "heslo");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
}
