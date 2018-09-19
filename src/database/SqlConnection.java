package database;

import ooad.Complaint;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlConnection {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    //private static final String DB_URL = "jdbc:mysql://localhost/photobooth";
    private static final String DB_URL = "jdbc:mysql://185.177.59.153:3306/ooad";
    //Database credentials
    private static final String USER = "root";
    //private static final String PASS = "";
    private static final String PASS = "fys-resort5";

    //Database connection and Statement
    private static Connection conn;
    private static Statement stmt;
    private static ResultSet rs;

    private static SqlConnection __instance;

    private SqlConnection(){

    }

    public static SqlConnection getInstance(){
        if(__instance == null){
            __instance = new SqlConnection();
            try {
                __instance.Open();
            } catch (SQLException c) {
                System.out.println(c);
                c.printStackTrace();
            }
        }
        return __instance;
    }

    public void Open() throws SQLException {

        //STEP 2: Register JDBC driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver: com.mysql.jdbc.Driver not found");
            e.printStackTrace();
        }

        //STEP 3: Open a connection
        System.out.println("Connecting to a selected database...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);

        System.out.println("Connection Established!\n");
    }

    public void InsertComplaint(String name, String description) throws SQLException {
        stmt = conn.createStatement();

        String sql = "INSERT INTO klachten (name, description) "
                + "VALUES ('" + name + "','" + description + "')";
        stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
        rs = stmt.getGeneratedKeys();
        System.out.println("Complaint inserted!");
    }

    public void UpdateComplaint(int id, String name, String description) throws SQLException {
        stmt = conn.createStatement();

        String sql = "UPDATE klachten SET name = '"+ name +"', description = '" + description + "' WHERE id = "+id;
        stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
        rs = stmt.getGeneratedKeys();
        System.out.println("Complaint updated!");
    }

    public List<Complaint> getComplaints() {

        List<Complaint> complaints = new ArrayList<Complaint>();

        try {
            stmt = conn.createStatement();
            String sql = "SELECT * FROM `klachten`";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                Complaint.Status st;
                switch (rs.getString("status")){
                    case "NEW":
                        st = Complaint.Status.NEW;
                        break;
                    case "OPEN":
                        st = Complaint.Status.OPEN;
                        break;
                    case "ASSIGNED":
                        st = Complaint.Status.ASSIGNED;
                        break;
                    case "CLOSED":
                        st = Complaint.Status.CLOSED;
                        break;
                    default:
                        st = Complaint.Status.NEW;
                }

                Complaint c = new Complaint(rs.getInt("id"), rs.getString("name"), rs.getString("description"), null, st, rs.getString("assignee"));
                complaints.add(c);
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return complaints;
    }

    public void Close() throws SQLException{

        if (stmt != null) {
            conn.close();
        }
        if (conn != null) {
            conn.close();
        }
        System.out.println("SQL connection closed");
    }


}
