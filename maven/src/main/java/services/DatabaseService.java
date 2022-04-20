package services;

import java.sql.*;
import java.util.Optional;


public class DatabaseService {
    private Connection connection;
    private Statement stmt;

    private void connection() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager
                    .getConnection("jdbc:postgresql://localhost:8080/",
                            "postgres", "heslo");
            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = connection.createStatement();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    private void insertion(PreparedStatement pstmt, int id, String name, double area, double price) {
        try {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setDouble(3, area);
            pstmt.setDouble(4, price);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    private void selection(ResultSet rs) {
        try {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double area = rs.getDouble("area");
            double price = rs.getDouble("price");
            System.out.print(" | ID = " + id);
            System.out.print(" | NAME = " + name);
            System.out.print(" | AGE = " + area);
            System.out.print(" | PRICE = " + price);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }


    public void insertIntoCommon(int id, String name, double area, double price) {
        try {
            connection();
            String sql = "INSERT INTO COMMON (ID,NAME,AREA,PRICE) VALUES (?,?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            insertion(pstmt, id, name, area, price);

            pstmt.executeUpdate();
            pstmt.close();
            connection.commit();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Records created successfully");
    }

    public void insertIntoCustom(int id, String name, double area, double price, String hs, String ht) {
        try {
            connection();
            String sql = "INSERT INTO CUSTOM (ID,NAME,AREA,PRICE,HEATING_SOURCE, HEATING_TYPE) VALUES (?,?,?,?,?,?)";

            PreparedStatement pstmt = connection.prepareStatement(sql);

            insertion(pstmt, id, name, area, price);
            pstmt.setString(5, hs);
            pstmt.setString(6, ht);
            pstmt.executeUpdate();
            pstmt.close();
            connection.commit();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Records created successfully");
    }

    public void insertIntoInterior(int id, String name, double area, double price, String desc) {
        try {
            connection();

            String sql = "INSERT INTO INTERIOR (ID,NAME,AREA,PRICE,DESCRIPTION) VALUES (?,?,?,?,?)";

            PreparedStatement pstmt = connection.prepareStatement(sql);

            insertion(pstmt, id, name, area, price);
            pstmt.setString(5, desc);

            pstmt.executeUpdate();
            pstmt.close();
            connection.commit();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Records created successfully");
    }


    public void select(String choice) {
        try {
            connection();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + choice + ";");
            switch (choice) {
                case "COMMON":
                    while (rs.next()) {
                        selection(rs);
                    }
                    break;
                case "CUSTOM":
                    while (rs.next()) {
                        selection(rs);
                        String hs = rs.getString("heating_source");
                        String ht = rs.getString("heating_type");
                        System.out.print(" | HEATING SOURCE = " + hs);
                        System.out.println(" | HEATING TYPE = " + ht);
                    }
                    break;
                case "INTERIOR":
                    while (rs.next()) {
                        selection(rs);
                        String desc = rs.getString("description");
                        System.out.println(" | DESCRIPTION = " + desc);
                    }
                    break;
            }
            rs.close();
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public void updateCommon(String choice, int id, String name, double area, double price, String hs, String ht, String desc) {
        Optional<String> l1 = Optional.ofNullable(hs);
        Optional<String> l2 = Optional.ofNullable(ht);
        Optional<String> l3 = Optional.ofNullable(desc);
        String sql;
        try {
            connection();
            switch (choice) {
                case ("COMMON"):
                    sql = "UPDATE COMMON SET NAME = '" + name + "', AREA = " + area + ", PRICE = " + price + " where ID=" + id + ";";
                    break;
                case ("CUSTOM"):
                    sql = "UPDATE CUSTOM SET NAME = '" + name + "', AREA = " + area + ", PRICE = " + price + ", HEATING_SOURCE = '" + l1 + "', HEATING_TYPE = '" + l2 + "' where ID=" + id + ";";
                    break;
                case ("INTERIOR"):
                    sql = "UPDATE INTERIOR SET NAME = '" + name + "', DESCRIPTION = '" + l3 + "', PRICE = " + price + " where ID=" + id + ";";

                    stmt.executeUpdate(sql);
                    connection.commit();
                    stmt.close();
                    connection.close();
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Operation done successfully");
    }

    public void updateCustom(int id, String name, double area, double price, String hs, String ht) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:8080/",
                    "postgres", "heslo");
            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = connection.createStatement();
            String sql = "UPDATE COMMON SET NAME = '" + name + "', AREA = " + area + ", PRICE = " + price + ", HEATING_SOURCE = '" + hs + "', HEATING_TYPE = '" + ht + "' where ID=" + id + ";";
            stmt.executeUpdate(sql);
            connection.commit();
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }

    public void updateInterior(int id, String name, String desc, double price) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:8080/",
                    "postgres", "heslo");
            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = connection.createStatement();
            String sql = "UPDATE COMMON SET NAME = '" + name + "', DESCRIPTION = '" + desc + "', PRICE = " + price + " where ID=" + id + ";";
            stmt.executeUpdate(sql);
            connection.commit();
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }

    public void delete(String type, int id) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager
                    .getConnection("jdbc:postgresql://localhost:8080/",
                            "postgres", "heslo");
            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = connection.createStatement();
            String sql = "DELETE from " + type + " where ID = " + id + ";";
            stmt.executeUpdate(sql);
            connection.commit();

            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
}