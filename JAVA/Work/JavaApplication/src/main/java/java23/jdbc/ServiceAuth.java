package java23.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceAuth implements IServiceAuth {
    private java.sql.Connection conn = null;
    
    public ServiceAuth() {
        super();
        this.conn = DBConnect.makeConnection();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public int getCount(ModelAuth auth) throws SQLException {
        int rs = -1;
        try {
            // 트랜잭션 시작
            conn.setAutoCommit(false);
            DaoAuth dao = new DaoAuth(conn);
            rs = dao.getCount(auth);
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            conn.rollback();
        }
        return rs;
    }
    
    @Override
    public int getMaxAuthid() throws SQLException {
        int rs = -1;
        try {
            // 트랜잭션 시작
            conn.setAutoCommit(false);
            DaoAuth dao = new DaoAuth(conn);
            rs = dao.getMaxAuthid();
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
        String query = "SELECT * FROM auth ORDER BY authid ASC ";
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
    public ResultSet selectLike(ModelAuth auth) throws SQLException {
        ResultSet rs = null;
        try {
            // SQL 문장 생성
            String query = "SELECT * FROM auth where name like ? ";
            // 문장 객체 생성
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, "%" + auth.getName() + "%");
            // SQL 문장 실행
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public ResultSet selectEqual(ModelAuth auth) throws SQLException {
        ResultSet rs = null;
        try {
            // SQL 문장 생성
            String query = "SELECT * FROM auth where name = ? ";
            // 문장 객체 생성
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, auth.getName());
            // SQL 문장 실행
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public ResultSet selectDynamic(ModelAuth auth) throws SQLException {
        ResultSet result = null;
        try {
            // query 작성
            String query = " select * from auth \n";
            query += " where 1 = 1 \n";
            if (auth.getAuthid() != null)
                query += " and authid = ? \n";
            if (!auth.getName().isEmpty())
                query += " and name = ? \n";
            if (!auth.getBirth().isEmpty())
                query += " and birth = ? \n";
            
            // 문장 객체 생성
            PreparedStatement stmt = conn.prepareStatement(query);
            int c = 1;
            if (auth.getAuthid() != null)
                stmt.setInt(c++, auth.getAuthid());
            if (!auth.getName().isEmpty())
                stmt.setString(c++, auth.getName());
            if (!auth.getBirth().isEmpty())
                stmt.setString(c++, auth.getBirth());
            // query 실행
            result = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    @Override
    public int insertAuth(ModelAuth auth) throws SQLException {
        int result = -1;
        try {
            // 트랜잭션 시작
            conn.setAutoCommit(false);
            DaoAuth dao = new DaoAuth(conn);
            result = dao.insertAuth(auth);
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            conn.rollback();
        }
        return result;
    }
    
    @Override
    public int updateAuth(ModelAuth whereauth, ModelAuth setauth) {
        int rs = 0;
        try {
            // SQL 문장 생성
            String query = "UPDATE auth \n";
            query += " SET Birth = ?, Authid = ? \n";
            query += " WHERE name = ? \n";
            // 문장 객체 생성
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, setauth.getBirth());
            stmt.setInt(2, setauth.getAuthid());
            stmt.setString(3, whereauth.getName());
            // SQL 문장 실행
            rs = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public int deleteAuth(ModelAuth auth) throws SQLException {
        int rs = 0;
        try {
            // SQL 문장 생성
            String query = "delete from auth where name = ? ";
            // 문장 객체 생성
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, auth.getName());
            // SQL 문장 실행
            rs = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public int transCommit(ModelAuth b1, ModelAuth b2) {
        return 0;
        
    }
    
    @Override
    public int TransRollback(ModelAuth b1, ModelAuth b2) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public ResultSet selectLike(String authname) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }
    
}
