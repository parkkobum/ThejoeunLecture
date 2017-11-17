package java99.library;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceCustomer implements IServiceCustomer {
    private java.sql.Connection conn = null;
    
    public ServiceCustomer() {
        super();
        this.conn = DBConnect.makeConnection();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public int getCount(ModelCustomer customer) throws SQLException {
        int rs = -1;
        try {
            // 트랜잭션 시작
            conn.setAutoCommit(false);
            DaoCustomer dao = new DaoCustomer(conn);
            rs = dao.getCount(customer);
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            conn.rollback();
        }
        return rs;
    }
    
    @Override
    public int getMaxCustomerid() throws SQLException {
        int rs = -1;
        try {
            // 트랜잭션 시작
            conn.setAutoCommit(false);
            DaoCustomer dao = new DaoCustomer(conn);
            rs = dao.getMaxCustomerid();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            conn.rollback();
        }
        return rs;
    }
    
    @Override
    public ResultSet selectAll() throws SQLException {
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
    public ResultSet selectLike(ModelCustomer customer) throws SQLException {
        ResultSet rs = null;
        try {
            // SQL 문장 생성
            String query = "SELECT * FROM customer where name like ? ";
            // 문장 객체 생성
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, "%" + customer.getName() + "%");
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
    public ResultSet selectDynamic(ModelCustomer customer) throws SQLException {
        ResultSet result = null;
        try {
            // query 작성
            String query = " select * from customer \n";
            query += " where 1 = 1 \n";
            if (customer.getCid() != null)
                query += " and cid = ? \n";
            if (!customer.getName().isEmpty())
                query += " and name = ? \n";
            // 문장 객체 생성
            PreparedStatement stmt = conn.prepareStatement(query);
            int c = 1;
            if (customer.getCid() != null)
                stmt.setInt(c++, customer.getCid());
            if (!customer.getName().isEmpty())
                stmt.setString(c++, customer.getName());
            // query 실행
            result = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    @Override
    public int insertCustomer(ModelCustomer customer) throws SQLException {
        int result = -1;
        try {
            // 트랜잭션 시작
            conn.setAutoCommit(false);
            DaoCustomer dao = new DaoCustomer(conn);
            result = dao.insertCustomer(customer);
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            conn.rollback();
        }
        return result;
    }
    
    @Override
    public int updateCustomer(ModelCustomer wherecustomer, ModelCustomer setcustomer) {
        int rs = 0;
        try {
            // SQL 문장 생성
            String query = "UPDATE customer \n";
            query += " SET name = ?, minBun = ?, phoneNum = ?, Email = ? \n";
            query += " WHERE cid = ? \n";
            // 문장 객체 생성
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, setcustomer.getName());
            stmt.setString(2, setcustomer.getMinBun());
            stmt.setString(3, setcustomer.getPhoneNum());
            stmt.setString(4, setcustomer.getEmail());
            stmt.setInt(5, wherecustomer.getCid());
            // SQL 문장 실행
            rs = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public int deleteCustomer(ModelCustomer customer) throws SQLException {
        int rs = 0;
        try {
            // SQL 문장 생성
            String query = "delete from customer where cid = ? ";
            // 문장 객체 생성
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, customer.getCid());
            // SQL 문장 실행
            rs = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public int transCommit(ModelCustomer b1, ModelCustomer b2) {
        return 0;
        
    }
    
    @Override
    public int TransRollback(ModelCustomer b1, ModelCustomer b2) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public ResultSet selectLike(String customername) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }
    
}
