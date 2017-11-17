package java99.library;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceRent implements IServiceRent {
    private java.sql.Connection conn = null;
    
    public ServiceRent() {
        super();
        this.conn = DBConnect.makeConnection();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public int getCount(ModelRent rent) throws SQLException {
        int rs = -1;
        try {
            // 트랜잭션 시작
            conn.setAutoCommit(false);
            DaoRent dao = new DaoRent(conn);
            rs = dao.getCount(rent);
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            conn.rollback();
        }
        return rs;
    }
    
    @Override
    public int getMaxRentid() throws SQLException {
        int rs = -1;
        try {
            // 트랜잭션 시작
            conn.setAutoCommit(false);
            DaoRent dao = new DaoRent(conn);
            rs = dao.getMaxRentid();
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
    public ResultSet selectLike(ModelRent rent) throws SQLException {
        ResultSet rs = null;
        try {
            // SQL 문장 생성
            String query = "SELECT * FROM rent where name like ? ";
            // 문장 객체 생성
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, "%" + rent.getName() + "%");
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
    public ResultSet selectDynamic(ModelRent rent) throws SQLException {
        ResultSet result = null;
        try {
            // query 작성
            String query = " select * from rent \n";
            query += " where 1 = 1 \n";
            if (rent.getRentid() != null)
                query += " and rentid = ? \n";
            if (!rent.getName().isEmpty())
                query += " and rentname = ? \n";
            // 문장 객체 생성
            PreparedStatement stmt = conn.prepareStatement(query);
            int c = 1;
            if (rent.getRentid() != null)
                stmt.setInt(c++, rent.getRentid());
            if (!rent.getName().isEmpty())
                stmt.setString(c++, rent.getName());
            // query 실행
            result = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    @Override
    public int insertRent(ModelRent rent) throws SQLException {
        int result = -1;
        try {
            // 트랜잭션 시작
            conn.setAutoCommit(false);
            DaoRent dao = new DaoRent(conn);
            result = dao.insertRent(rent);
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            conn.rollback();
        }
        return result;
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
        int rs = 0;
        try {
            // SQL 문장 생성
            String query = " delete from rent where rentid = ? ";
            // 문장 객체 생성
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, rent.getRentid());
            // SQL 문장 실행
            rs = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public int transCommit(ModelRent b1, ModelRent b2) {
        return 0;
        
    }
    
    @Override
    public int TransRollback(ModelRent b1, ModelRent b2) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public ResultSet selectLike(String rentname) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResultSet selectRent() throws SQLException {
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
