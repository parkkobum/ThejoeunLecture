package java99.library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoRent implements IRent {
    private java.sql.Connection conn = null;
    
    public DaoRent(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public int getCount(ModelRent rent) throws java.sql.SQLException {
        int result = -1;
        // SQL 문장
        String query = "SELECT count(*) as total from rent where 1 = 1 ";
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
    public int getMaxRentid() {
        int result = -1;
        // SQL 문장
        String query = " select max(rentid) maxid from rent ";
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
        String query = "SELECT * FROM rent ORDER BY rentid ASC ";
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
    public ResultSet selectLike(String rentname) {
        ResultSet rs = null;
        try {
            // SQL 문장 생성
            String query = "SELECT * FROM rent where rentname like ? ";
            // 문장 객체 생성
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, "%" + rentname + "%");
            // SQL 문장 실행
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public ResultSet selectEqual(ModelRent rent) throws SQLException {
        ResultSet rs = null;
        try {
            // SQL 문장 생성
            String query = "SELECT * FROM rent where name = ? ";
            // 문장 객체 생성
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, rent.getName());
            // SQL 문장 실행
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public int insertRent(ModelRent rent) throws SQLException {
        int rs = 0;
        try {
            String query = " INSERT INTO ";
            query += " RENT( BOOKNAME, NAME, RENTDATE, CID, BID) ";
            query += " VALUES( ?, ?, ?, ?, ?) ";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, rent.getBookname());
            stmt.setString(2, rent.getName());
            stmt.setString(3, rent.getRentdate());
            stmt.setInt(4, rent.getCid());
            stmt.setInt(5, rent.getBid());
            rs = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
        
    }
    
    @Override
    public int updateRent(ModelRent whererent, ModelRent setrent) {
        int rs = 0;
        try {
            // SQL 문장 생성
            String query = "UPDATE rent \n";
            query += " SET rentdate = ? \n";
            query += " WHERE name = ? \n";
            // 문장 객체 생성
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, setrent.getRentdate());
            stmt.setString(2, whererent.getName());
            // SQL 문장 실행
            rs = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public int deleteRent(ModelRent rent) throws SQLException {
        int result = -1;
        try {
            // 트랜잭션 시작
            conn.setAutoCommit(false);
            DaoRent dao = new DaoRent(conn);
            result = dao.deleteRent(rent);
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            conn.rollback();
        }
        return result;
    }
    
    @Override
    public ResultSet selectDynamic(ModelRent rent) throws SQLException {
        ResultSet rs = null;
        try {
            // 트랜잭션 시작
            conn.setAutoCommit(false);
            DaoRent dao = new DaoRent(conn);
            rs = dao.selectDynamic(rent);
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            conn.rollback();
        }
        return rs;
    }
    
    @Override
    public ResultSet selectRent() {
        ResultSet rs = null;
        // SQL 문장 실행
        String query = " SELECT R.rentid, c.name, c.phoneNum, c.minBun, c.email, "
                     + "      b.bookname, b.publisher, b.type, b.writer, b.bookid, r.rentdate"
                     + "        FROM RENT R INNER JOIN CUSTOMER C ON R.CID = C.CID "
                     + "        inner join BOOK B on R.bid = b.bookid"
                     + "        order by r.rentid asc;";    
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
}
