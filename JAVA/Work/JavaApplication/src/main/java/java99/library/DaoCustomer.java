package java99.library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoCustomer implements ICustomer {
    private java.sql.Connection conn = null;
    
    public DaoCustomer(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public int getCount(ModelCustomer customer) throws java.sql.SQLException {
        int result = -1;
        // SQL 문장
        String query = "SELECT count(*) as total from customer where 1 = 1 ";
        try {
            // 문장 객체 생성
            PreparedStatement stmt = conn.prepareStatement(query);
            // SQL 문장 실행
            ResultSet rs = stmt.executeQuery();
            rs.next(); // 커서 이동. ResultSet 첫번째로 로우로.
            result = rs.getInt("total"); // total 컬럼의 값을 가져온다. rs.getInt(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    @Override
    public int getMaxCustomerid() {
        int result = -1;
        // SQL 문장
        String query = " select max(cid) maxid from customer ";
        try {
            // 문장 객체 생성
            PreparedStatement stmt = conn.prepareStatement(query);
            // SQL 문장 실행
            ResultSet rs = stmt.executeQuery();
            rs.next(); // 커서 이동. ResultSet 첫번째로 로우로.
            result = rs.getInt("maxid"); // maxid 컬럼의 값을 가져온다.
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    @Override
    public ResultSet selectAll() {
        ResultSet rs = null;
        // SQL 문장 실행
        String query = "SELECT * FROM customer ORDER BY cid ASC ";
        try {
            // 문장 객체 생성
            PreparedStatement stmt = conn.prepareStatement(query);
            // SQL 문장 실행
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public ResultSet selectLike(String customername) {
        ResultSet rs = null;
        try {
            // SQL 문장 생성
            String query = "SELECT * FROM customer where name like ? ";
            // 문장 객체 생성
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, "%" + customername + "%");
            // SQL 문장 실행
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public ResultSet selectEqual(ModelCustomer customer) throws SQLException {
        ResultSet rs = null;
        try {
            // SQL 문장 생성
            String query = "SELECT * FROM customer where name = ? ";
            // 문장 객체 생성
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, customer.getName());
            // SQL 문장 실행
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public int insertCustomer(ModelCustomer customer) throws SQLException {
        int rs = 0;
        try {
            String query = " INSERT INTO ";
            query += " CUSTOMER( NAME, MINBUN, PHONENUM, EMAIL) ";
            query += " VALUES( ?, ?, ?, ? ) ";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getMinBun());
            stmt.setString(3, customer.getPhoneNum());
            stmt.setString(4, customer.getEmail());
            rs = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
        
    }
    
    @Override
    public int updateCustomer(ModelCustomer wherecustomer, ModelCustomer setcustomer) {
        int rs = 0;
        try {
            // SQL 문장 생성
            String query = "UPDATE customer \n";
            query += " SET phoneNum = ?, email = ? \n";
            query += " WHERE name = ? \n";
            // 문장 객체 생성
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, setcustomer.getPhoneNum());
            stmt.setString(2, setcustomer.getEmail());
            stmt.setString(3, wherecustomer.getName());
            // SQL 문장 실행
            rs = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public int deleteCustomer(ModelCustomer customer) throws SQLException {
        int result = -1;
        try {
            // 트랜잭션 시작
            conn.setAutoCommit(false);
            DaoCustomer dao = new DaoCustomer(conn);
            result = dao.deleteCustomer(customer);
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            conn.rollback();
        }
        return result;
    }
    
    @Override
    public ResultSet selectDynamic(ModelCustomer customer) throws SQLException {
        ResultSet rs = null;
        try {
            // 트랜잭션 시작
            conn.setAutoCommit(false);
            DaoCustomer dao = new DaoCustomer(conn);
            rs = dao.selectDynamic(customer);
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            conn.rollback();
        }
        return rs;
    }
}
