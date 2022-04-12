package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseCreation {
    public void CreateTable() {

        Connection connection = null;
        Statement stmt = null;
        try {
            connection = DriverManager
                    .getConnection("jdbc:postgresql://localhost:8080/",
                            "postgres", "heslo");
            System.out.println("Opened database successfully");

            stmt = connection.createStatement();

            String Common = "CREATE TABLE Common " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " NAME           TEXT    NOT NULL, " +
                    " AREA            FLOAT    NOT NULL, " +
                    " PRICE        FLOAT, " +
                    " DATE_OF_CREATION         DATE)";

            String Custom = "CREATE TABLE Custom " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " NAME           TEXT    NOT NULL, " +
                    " AREA            FLOAT    NOT NULL, " +
                    " PRICE        FLOAT, " +
                    " HEATING_SOURCE        TEXT, " +
                    " HEATING_TYPE        TEXT, " +
                    " DATE_OF_CREATION         DATE)";

            String Interior = "CREATE TABLE Interior " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " NAME           TEXT    NOT NULL, " +
                    " DESCRIPTION            TEXT    NOT NULL, " +
                    " PRICE        FLOAT, " +
                    " DATE_OF_CREATION         DATE)";

            stmt.executeUpdate(Interior);
            stmt.executeUpdate(Custom);
            stmt.executeUpdate(Common);

            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }
}
