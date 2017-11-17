package java99.library;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;

public class DBConnect {
    
    public static java.sql.Connection connectionMySQL() {
        String url = "jdbc:mysql://localhost:3306/lib_db?useUnicode=yes&characterEncoding=utf8";
        String user = "root";
        String password = "1234";
        java.sql.Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver"); // driver 적재
            conn = java.sql.DriverManager.getConnection(url, user, password); // DB 연결
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    public static java.sql.Connection makeConnection() {
        return connectionMySQL(); // Oracle과 연결할 때
    }
    
}
