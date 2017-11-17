package java23.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoAuth implements IAuth {
    private java.sql.Connection conn = null;
    
    public DaoAuth(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public int getCount(ModelAuth auth) throws java.sql.SQLException {
        int result = -1;
        // SQL 문장
        String query = "SELECT count(*) as total from auth where 1 = 1 ";
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
    public int getMaxAuthid() {
        int result = -1;
        // SQL 문장
        String query = " select max(authid) maxid from auth ";
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
        String query = " SELECT * FROM auth ORDER BY authid ASC ";
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
    public ResultSet selectLike(String name) {
        ResultSet rs = null;
        try {
            // SQL 문장 생성
            String query = " SELECT * FROM auth where name like ? ";
            // 문장 객체 생성
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, "%" + name + "%");
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
            String query = " SELECT * FROM auth where name = ? ";
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
    public int insertAuth(ModelAuth auth) throws SQLException {
        int rs = 0;
        try {
            String query = " INSERT INTO ";
            query += " AUTH( AUTHID, NAME, BIRTH) ";
            query += " VALUES( ?, ?, ?) ";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, auth.getAuthid());
            stmt.setString(2, auth.getName());
            stmt.setString(3, auth.getBirth());
            rs = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
        
    }
    
    @Override
    public int updateAuth(ModelAuth whereauth, ModelAuth setauth) {
        int rs = 0;
        try {
            // SQL 문장 생성
            String query = " UPDATE auth \n";
            query += " SET birth = ? \n";
            query += " WHERE name = ? \n";
            // 문장 객체 생성
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, setauth.getBirth());
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
            String query = " delete from auth where name = ? ";
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
    public ResultSet selectDynamic(ModelAuth auth) throws SQLException {
        ResultSet result = null;
        try {
            // query 작성
                         String             query = " select * from auth \n";
                                            query += " where 1 = 1 \n";
            if (auth.getAuthid() != null)   query += " and authid = ? \n";
            if (!auth.getName().isEmpty())
                                            query += " and name = ? \n";
            // 문장 객체 생성
            System.out.println(query);
            PreparedStatement stmt = conn.prepareStatement(query);
            int c = 1;
            if (auth.getAuthid() != null) stmt.setInt(c++, auth.getAuthid());
            if (!auth.getName().isEmpty())
                stmt.setString(c++, auth.getName());
            // query 실행
            result = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
