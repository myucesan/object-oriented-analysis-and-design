package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQL implements DatabaseLanguage{

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private String dbName;
    private String dbPass;
    private String dbHost;
    private Connection conn;

    public SQL(String dbName, String dbPass, String dbHost){
        this.dbName = dbName;
        this.dbPass = dbPass;
        this.dbHost = "jdbc:mysql://" + dbHost;

        try {
//            Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver: com.mysql.jdbc.Driver not found");
            e.printStackTrace();
        }

        try {
            this.conn = DriverManager.getConnection(this.dbHost, this.dbName, this.dbPass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    //TODO: add joins and where
    public List<List<Column>> select(String table, List<Column> columns, List<Join> joins, String where) {
        List<List<Column>> result = new ArrayList<>();

        StringBuilder sql = new StringBuilder("SELECT ");
        String sep = "";
        for (Column c : columns) {
            sql.append(sep).append("`").append(c.name).append("`");
            sep = ", ";
        }
        sql.append(" FROM `").append(table).append("`");

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql.toString());

            while (rs.next()) {
                List<Column> row = new ArrayList<>();
                for (Column c : columns) {
                    row.add(new Column(c.name, rs.getString(c.name)));
                }
                result.add(row);
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public void update(String table, List<Column> columns, String where) {

        StringBuilder sqlBuilder = new StringBuilder("UPDATE `" + table + "` SET ");
        for (Column c: columns) {
            sqlBuilder.append("`").append(c.name).append("` = '").append(c.value).append("'");
        }
        sqlBuilder.append(" WHERE ");
        sqlBuilder.append(where);

        String sql = sqlBuilder.toString();

        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql, Statement.NO_GENERATED_KEYS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(String table, List<Column> columns) {

        StringBuilder sqlColumns = new StringBuilder();
        StringBuilder sqlValues = new StringBuilder();
        String sep = "";

        for (Column c: columns) {
            sqlColumns.append(sep).append("`").append(c.name).append("`");
            sqlValues.append(sep).append("'").append(c.value).append("'");

            sep = " ,";
        }

        String sql = "INSERT INTO `"+ table +"` (";
        sql += sqlColumns;
        sql += ") VALUES (";
        sql += sqlValues;
        sql += "')";

        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql, Statement.NO_GENERATED_KEYS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String table, int id) {

    }
}
