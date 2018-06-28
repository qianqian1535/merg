package org.mypackage.tc;

/**
 *
 * @author o7planning
 * modified based on :
 * https://o7planning.org/en/10285/create-a-simple-java-web-application-using-servlet-jsp-and-jdbc#a812142
 * 
 */
import java.sql.*;

public class MySQLConn {

    public static Connection getConnection()
            throws ClassNotFoundException, SQLException {
        // Note: Change the connection parameters accordingly.
        String hostName = "localhost";
        String dbName = "ensat";
        String userName = "root";
        String password = "audrey970925";
        return getConnection(hostName, dbName, userName, password);
        
    }

    public static Connection getConnection(String hostName, String dbName,
            String userName, String password) throws SQLException,
            ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");

        // URL Connection for MySQL:
        // Example: 
        // jdbc:mysql://localhost:3306/simplehr
        String timezone = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName+ timezone;
        Connection conn = DriverManager.getConnection(connectionURL, userName,
                password);
        return conn;
    }
     public static void closeQuietly(Connection conn) {
        try {
            conn.close();
        } catch (Exception e) {
        }
    }
      public static void rollbackQuietly(Connection conn) {
        try {
            conn.rollback();
        } catch (Exception e) {
        }
    }
}
