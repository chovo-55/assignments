package services;
import java.sql.*;


public class ProjectService{
    private Connection connection = null;
    private Statement stmt = null;

    public void insertIntoCommon( int id, String name,double area, double price) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager
                    .getConnection("jdbc:postgresql://localhost:8080/",
                            "postgres", "heslo");
            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = connection.createStatement();
            String sql = "INSERT INTO COMMON (ID,NAME,AREA,PRICE) VALUES (?,?,?,?)";

            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setDouble(3, area);
            pstmt.setDouble(4, price);
            pstmt.executeUpdate();
            pstmt.close();
            connection.commit();
            connection.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }
    public void insertIntoCustom( int id, String name,double area, double price, String hs, String ht) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager
                    .getConnection("jdbc:postgresql://localhost:8080/",
                            "postgres", "heslo");
            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = connection.createStatement();
            String sql = "INSERT INTO CUSTOM (ID,NAME,AREA,PRICE,HEATING_SOURCE, HEATING_TYPE) VALUES (?,?,?,?,?,?)";

            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setDouble(3, area);
            pstmt.setDouble(4, price);
            pstmt.setString(5, hs);
            pstmt.setString(6, ht);
            pstmt.executeUpdate();
            pstmt.close();
            connection.commit();
            connection.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }
    public void insertIntoInterior( int id, String name, double price, String desc) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager
                    .getConnection("jdbc:postgresql://localhost:8080/",
                            "postgres", "heslo");
            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = connection.createStatement();
            String sql = "INSERT INTO INTERIOR (ID,NAME,PRICE,DESCRIPTION) VALUES (?,?,?,?)";

            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setDouble(3, price);
            pstmt.setString(4, desc);
            pstmt.executeUpdate();
            pstmt.close();
            connection.commit();
            connection.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }

    public void select(String choice) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager
                    .getConnection("jdbc:postgresql://localhost:8080/",
                            "postgres", "heslo");
            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM "+choice+";" );

            if (choice.equals("COMMON")){
                while ( rs.next() ) {
                    int id = rs.getInt("id");
                    String  name = rs.getString("name");
                    double area  = rs.getDouble("area");
                    double  price = rs.getDouble("price");
                    System.out.print( " | ID = " + id );
                    System.out.print( " | NAME = " + name );
                    System.out.print( " | AGE = " + area );
                    System.out.println( " | PRICE = " + price );
                }
            } else if(choice.equals("CUSTOM")){
                while ( rs.next() ) {
                    int id = rs.getInt("id");
                    String  name = rs.getString("name");
                    double area  = rs.getDouble("area");
                    double  price = rs.getDouble("price");
                    String  ht = rs.getString("ht");
                    String  hs = rs.getString("hs");
                    System.out.print( " | ID = " + id );
                    System.out.print( " | NAME = " + name );
                    System.out.print( " | AGE = " + area );
                    System.out.print( " | PRICE = " + price );
                    System.out.print( " | HEATING TYPE = " + ht );
                    System.out.println( " | HEATING SOURCE = " + hs );
                }
            }else if(choice.equals("INTERIOR")){
                while ( rs.next() ) {
                    int id = rs.getInt("id");
                    String  name = rs.getString("name");
                    double  price = rs.getDouble("price");
                    String  desc = rs.getString("description");
                    System.out.print( "ID = " + id );
                    System.out.print( " | NAME = " + name );
                    System.out.print( " | PRICE = " + price );
                    System.out.println( " | DESCRIPTION = " + desc );
                }
            }
            rs.close();
            stmt.close();
            connection.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
    }

    public void updateCommon(int id, String name,double area, double price) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager                    .getConnection("jdbc:postgresql://localhost:8080/",
                            "postgres", "heslo");
            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = connection.createStatement();
            String sql = "UPDATE COMMON SET NAME = '"+name+"', AREA = "+area+", PRICE = "+price+" where ID="+id+";";
            stmt.executeUpdate(sql);
            connection.commit();
            stmt.close();
            connection.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
    public void updateCustom(int id, String name,double area, double price, String hs, String ht) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager                    .getConnection("jdbc:postgresql://localhost:8080/",
                    "postgres", "heslo");
            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = connection.createStatement();
            String sql = "UPDATE COMMON SET NAME = '"+name+"', AREA = "+area+", PRICE = "+price+", HEATING_SOURCE = '"+hs+"', HEATING_TYPE = '"+ht+"' where ID="+id+";";
            stmt.executeUpdate(sql);
            connection.commit();
            stmt.close();
            connection.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
    public void updateInterior(int id, String name, String desc,double price) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager                    .getConnection("jdbc:postgresql://localhost:8080/",
                    "postgres", "heslo");
            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = connection.createStatement();
            String sql = "UPDATE COMMON SET NAME = '"+name+"', DESCRIPTION = '"+desc+"', PRICE = "+price+" where ID="+id+";";
            stmt.executeUpdate(sql);
            connection.commit();
            stmt.close();
            connection.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
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
            String sql = "DELETE from "+type+" where ID = "+id+";";
            stmt.executeUpdate(sql);
            connection.commit();

            stmt.close();
            connection.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
}