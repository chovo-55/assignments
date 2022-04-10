import services.DatabaseConnection;

public class Main {
    public static void main(String args[]) {
        DatabaseConnection conn = new DatabaseConnection();

        conn.ConnectToDatabase();
    }
}