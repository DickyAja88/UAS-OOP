/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author DICKY SAPUTRA
 */
public class connectionDatabase {
    private static final String url = "jdbc:mysql://localhost:3306/aplikasi_keuangan";
    private static final String username = "root";
    private static final String password = "";
    private Connection connection;
    private ResultSet resultSet;
    
    public  connectionDatabase(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e){
            System.out.println("Failed to load MySQL JDBC Driver");
            e.printStackTrace();
        }
    }
    public Connection getConnection(){
        if(connection == null){
            try{
                connection = DriverManager.getConnection(url, username, password);
                connection.setAutoCommit(true);
            } catch(SQLException e){
            System.out.println("Failed to connect to the database");
            }
        }
        return connection;
    }
    public void disconnect(){
        if (connection != null){
            try{
                connection.close();
            } catch (SQLException e){
                System.out.println("Failed to close the database connection");
                e.printStackTrace();
            }
        }
    }
public ResultSet executeQueryRead(String sql, Object... values) throws SQLException {
    ResultSet resultSet = null;
    try {
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        for (int i = 0; i < values.length; i++) {
            statement.setObject(i + 1, values[i]);
        }
        resultSet = statement.executeQuery();
    } catch (SQLException e) {
        throw new SQLException("Failed to execute query: " + sql, e);
    }
    return resultSet;
}

public int executeQueryDml(String sql, Object... values) throws SQLException {
    int rowsAffected = 0;
    try {
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        for (int i = 0; i < values.length; i++) {
            if (values[i] instanceof Byte) {
                statement.setByte(i + 1, (byte) values[i]);
            } else {
                statement.setObject(i + 1, values[i]);
            }
        }

        rowsAffected = statement.executeUpdate();
    } catch (SQLException e) {
        throw new SQLException("Failed to execute update: " + sql, e);
    }
    return rowsAffected;
}


   public void checkConnection () throws SQLException {
       try{
           connection = DriverManager.getConnection(url, username,password);
           connection.setAutoCommit(true);
       }catch(SQLException e){
           System.err.println("teuing error");
           e.printStackTrace();
       }
   }
   public void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                System.out.println("Failed to close the result set.");
                e.printStackTrace();
            }
        }
    }
   public void closeStatement(PreparedStatement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Failed to close the statement.");
                e.printStackTrace();
            }
        }
    }

    public PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
   

   
}
