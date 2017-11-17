package java99.library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoBook implements IBook {
    private java.sql.Connection conn = null;
    
    public DaoBook(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public int getCount(ModelBook book) throws java.sql.SQLException {
        int result = -1;
        // SQL 문장
        String query = "SELECT count(*) as total from book where 1 = 1 ";
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
    public int getMaxBookid() {
        int result = -1;
        // SQL 문장
        String query = " select max(bookid) maxid from book ";
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
        String query = "SELECT * FROM book ORDER BY bookid ASC ";
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
    public ResultSet selectLike(String bookname) {
        ResultSet rs = null;
        try {
            // SQL 문장 생성
            String query = "SELECT * FROM book where bookname like ? ";
            // 문장 객체 생성
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, "%" + bookname + "%");
            // SQL 문장 실행
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public ResultSet selectEqual(ModelBook book) throws SQLException {
        ResultSet rs = null;
        try {
            // SQL 문장 생성
            String query = "SELECT * FROM book where bookname = ? ";
            // 문장 객체 생성
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, book.getBookname());
            // SQL 문장 실행
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public int insertBook(ModelBook book) throws SQLException {
        int rs = 0;
        try {
            String query = " INSERT INTO ";
            query += " BOOK( BOOKNAME, PUBLISHER, TYPE, WRITER, PRICE, USE_YN) ";
            query += " VALUES( ?, ?, ?, ?, ?, ? ) ";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, book.getBookname());
            stmt.setString(2, book.getPublisher());
            stmt.setString(3, book.getType());
            stmt.setString(4, book.getWriter());
            stmt.setInt(5, book.getPrice());
            stmt.setBoolean(6, book.getUse_yn());
            rs = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
        
    }
    
    @Override
    public int updateBook(ModelBook wherebook, ModelBook setbook) {
        int rs = 0;
        try {
            // SQL 문장 생성
            String query = "UPDATE book \n";
            query += " SET type = ?, price = ? \n";
            query += " WHERE bookname = ? \n";
            // 문장 객체 생성
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, setbook.getType());
            stmt.setInt(2, setbook.getPrice());
            stmt.setString(3, wherebook.getBookname());
            // SQL 문장 실행
            rs = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public int deleteBook(ModelBook book) throws SQLException {
        int result = -1;
        try {
            // 트랜잭션 시작
            conn.setAutoCommit(false);
            DaoBook dao = new DaoBook(conn);
            result = dao.deleteBook(book);
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            conn.rollback();
        }
        return result;
    }
    
    @Override
    public ResultSet selectDynamic(ModelBook book) throws SQLException {
        ResultSet rs = null;
        try {
            // 트랜잭션 시작
            conn.setAutoCommit(false);
            DaoBook dao = new DaoBook(conn);
            rs = dao.selectDynamic(book);
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            conn.rollback();
        }
        return rs;
    }
}
