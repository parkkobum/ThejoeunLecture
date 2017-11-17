package java23.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceBook implements IServiceBook {
    private java.sql.Connection conn = null;
    
    public ServiceBook() {
        super();
        this.conn = DBConnect.makeConnection();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public int getCount(ModelBook book) throws SQLException {
        int rs = -1;
        try {
            // 트랜잭션 시작
            conn.setAutoCommit(false);
            DaoBook dao = new DaoBook(conn);
            rs = dao.getCount(book);
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            conn.rollback();
        }
        return rs;
    }
    
    @Override
    public int getMaxBookid() throws SQLException {
        int rs = -1;
        try {
            // 트랜잭션 시작
            conn.setAutoCommit(false);
            DaoBook dao = new DaoBook(conn);
            rs = dao.getMaxBookid();
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
    public ResultSet selectLike(ModelBook book) throws SQLException {
        ResultSet rs = null;
        try {
            // SQL 문장 생성
            String query = "SELECT * FROM book where bookname like ? ";
            // 문장 객체 생성
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, "%" + book.getBookname() + "%");
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
    public ResultSet selectDynamic(ModelBook book) throws SQLException {
        ResultSet result = null;
        try {
            // query 작성
            String query = " select * from book \n";
            query += " where 1 = 1 \n";
            if (book.getBookid() != null)
                query += " and bookid = ? \n";
            if (!book.getBookname().isEmpty())
                query += " and bookname = ? \n";
            // 문장 객체 생성
            PreparedStatement stmt = conn.prepareStatement(query);
            int c = 1;
            if (book.getBookid() != null)
                stmt.setInt(c++, book.getBookid());
            if (!book.getBookname().isEmpty())
                stmt.setString(c++, book.getBookname());
            // query 실행
            result = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    @Override
    public int insertBook(ModelBook book) throws SQLException {
        int result = -1;
        try {
            // 트랜잭션 시작
            conn.setAutoCommit(false);
            DaoBook dao = new DaoBook(conn);
            result = dao.insertBook(book);
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            conn.rollback();
        }
        return result;
    }
    
    @Override
    public int updateBook(ModelBook wherebook, ModelBook setbook) {
        int rs = 0;
        try {
            // SQL 문장 생성
            String query = "UPDATE book \n";
            query += " SET year = ?, price = ? \n";
            query += " WHERE bookname = ? \n";
            // 문장 객체 생성
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, setbook.getYear());
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
        int rs = 0;
        try {
            // SQL 문장 생성
            String query = "delete from book where bookname = ? ";
            // 문장 객체 생성
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, book.getBookname());
            // SQL 문장 실행
            rs = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public int transCommit(ModelBook b1, ModelBook b2) {
        return 0;
        
    }
    
    @Override
    public int TransRollback(ModelBook b1, ModelBook b2) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public ResultSet selectLike(String bookname) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }
    
}
