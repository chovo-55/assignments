package repository;

import java.sql.*;
import java.util.Optional;


public class Database {
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

    private void close(String sql) {
        try {
            stmt.executeUpdate(sql);
            connection.commit();
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    private void closePstmt(PreparedStatement pstmt) {
        try {
            pstmt.executeUpdate();
            pstmt.close();
            connection.commit();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public void insertIntoCommon(String choice, int id, String name, double area, double price, String hs, String ht, String desc) {
        Optional<String> l1 = Optional.ofNullable(hs);
        Optional<String> l2 = Optional.ofNullable(ht);
        Optional<String> l3 = Optional.ofNullable(desc);

        String a = l1.orElse("Not Given");
        String b = l2.orElse("Not Given");
        String c = l3.orElse("Not Given");

        String sql;
        try {
            connection();
            switch (choice) {
                case ("COMMON"):
                    sql = "INSERT INTO COMMON (ID,NAME,AREA,PRICE) VALUES (?,?,?,?)";
                    PreparedStatement pstmt = connection.prepareStatement(sql);
                    insertion(pstmt, id, name, area, price);

                    closePstmt(pstmt);
                    break;
                case ("CUSTOM"):
                    sql = "INSERT INTO CUSTOM (ID,NAME,AREA,PRICE,HEATING_SOURCE, HEATING_TYPE) VALUES (?,?,?,?,?,?)";
                    pstmt = connection.prepareStatement(sql);
                    insertion(pstmt, id, name, area, price);
                    pstmt.setString(5, a);
                    pstmt.setString(6, b);

                    closePstmt(pstmt);
                    break;
                case ("INTERIOR"):
                    sql = "INSERT INTO INTERIOR (ID,NAME,AREA,PRICE,DESCRIPTION) VALUES (?,?,?,?,?)";
                    pstmt = connection.prepareStatement(sql);
                    insertion(pstmt, id, name, area, price);
                    pstmt.setString(5, c);
                    closePstmt(pstmt);
                    break;
            }
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

    public void updateProject(String choice, int id, String name, double area, double price, String hs, String ht, String desc) {
        Optional<String> l1 = Optional.ofNullable(hs);
        Optional<String> l2 = Optional.ofNullable(ht);
        Optional<String> l3 = Optional.ofNullable(desc);

        String a = l1.orElse("Not Given");
        String b = l2.orElse("Not Given");
        String c = l3.orElse("Not Given");
        String sql;
        try {
            connection();
            switch (choice) {
                case ("COMMON") -> {
                    sql = "UPDATE COMMON SET NAME = '" + name + "', AREA = " + area + ", PRICE = " + price + " where ID=" + id + ";";
                    close(sql);
                }
                case ("CUSTOM") -> {
                    sql = "UPDATE CUSTOM SET NAME = '" + name + "', AREA = " + area + ", PRICE = " + price + ", HEATING_SOURCE = '" + a + "', HEATING_TYPE = '" + b + "' where ID=" + id + ";";
                    close(sql);
                }
                case ("INTERIOR") -> {
                    sql = "UPDATE INTERIOR SET NAME = '" + name + "', DESCRIPTION = '" + c + "', PRICE = " + price + " where ID=" + id + ";";
                    close(sql);
                }
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Operation done successfully");
    }

    public void delete(String type, int id) {
        try {
            connection();
            String sql = "DELETE from " + type + " where ID = " + id + ";";
            close(sql);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Operation done successfully");
    }
}