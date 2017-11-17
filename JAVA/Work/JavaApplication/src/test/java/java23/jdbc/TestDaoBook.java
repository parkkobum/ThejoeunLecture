package java23.jdbc;

import static org.junit.Assert.*;

import java.awt.print.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestDaoBook {
    static java.sql.Connection conn = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        conn = DBConnect.makeConnection();
    }
    
    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void testGetCount() throws SQLException {
        
        DaoBook dao = new DaoBook(conn);
        ModelBook model = new ModelBook();
        int result = dao.getCount(model);
        
        assertEquals(4, result);
        
    }
    
    @Test
    public void testGetMaxBookid() {
        DaoBook dao = new DaoBook(conn);
        int result = dao.getMaxBookid();
        
        assertEquals(4, result);
    }
    
    @Test
    public void testSelectAll() throws SQLException {
        DaoBook dao = new DaoBook(conn);
        ResultSet rs = dao.selectAll();
        rs.next();
        int bookid = rs.getInt("bookid");
        String bookname = rs.getString("bookname");
        assertEquals(1, bookid);
        assertEquals("operating system", bookname);
    }
    
    @Test
    public void testSelectLike() throws SQLException {
        DaoBook dao = new DaoBook(conn);
        ResultSet rs = dao.selectLike("ja");
        rs.next();
        int rowNum = rs.getRow();
        assertNotNull(rs);
        assertTrue(rs.getRow() >= 1);
        String bookname = rs.getString("bookname");
        assertEquals("java", bookname);
        assertTrue(bookname.contains("ja"));
    }
    
    @Test
    public void testSelectEqual() throws SQLException {
        DaoBook dao = new DaoBook(conn);
        ModelBook book = new ModelBook();
        book.setBookname("mysql");
        ResultSet rs = dao.selectEqual(book);
        rs.next();
        assertNotNull(rs);
        String bookname = rs.getString("bookname");
        assertEquals("mysql", bookname);
        assertTrue(bookname.contains("mysql"));
    }
    
    @Test
    public void testInsertBook() {
        DaoBook dao = new DaoBook(conn);
        ModelBook book = new ModelBook();
        
        book.setBookname("mysql2");
        book.setPublisher("oreilly");
        book.setYear("2017");
        book.setPrice(63000);
        book.setDtm(java.sql.Date.valueOf("2017-11-08"));
        book.setAuthid(3);
        book.setUse_yn(true);
        
        int rs = -1;
        try {
            rs = dao.insertBook(book);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        assertTrue(rs == 1);
    }
    
    @Test
    public void testUpdateBook() {
        DaoBook dao = new DaoBook(conn);
        ModelBook wherebook = new ModelBook();
        ModelBook setbook = new ModelBook();
        
        wherebook.setBookname("mysql2");
        setbook.setYear("2017");
        setbook.setPrice(63000);
        
        int rs = -1;
        rs = dao.updateBook(wherebook, setbook);
        assertTrue(rs >= 0);
    }
    
    @Test
    public void testDeleteBook() throws SQLException {
        DaoBook dao = new DaoBook(conn);
        ModelBook book = new ModelBook();
        
        book.setBookname("mysql2");
        
        int rs = -1;
        rs = dao.deleteBook(book);
        assertTrue(rs >= 0);
    }
    
    @Test
    public void testSelectDynamic() throws SQLException {
        DaoBook dao = new DaoBook(conn);
        ModelBook book = new ModelBook();
        ResultSet rs = dao.selectDynamic(book);
        assertNotNull(rs);
        
        book.setBookname("");
        rs = dao.selectDynamic(book);
        assertNotNull(rs);
        
        rs.next();
        int bookid = rs.getInt("bookid");
        String name = rs.getString("bookname");
        
        assertEquals(1, bookid);
        assertEquals("operating system", name);
        
        book.setBookid(2);
        book.setBookname("mysql");
        rs = dao.selectDynamic(book);
        bookid = rs.getInt("bookid");
        name = rs.getString("bookname");
        
        assertEquals(2, bookid);
        assertEquals("mysql", name);
        
        
    }
    
    // resultset 사용법
    // rs.next(); 커서를 다음 row로 이동
    // rs.last(); 마지막 row로 이동
    // rs.first(); 첫번째 row로 이동
    // rs.getInt(idx or "컬럼명");
    // rs.getString(idx or "컬럼명");
    // rs.getBoolean("컬럼명");
    // rs.getData("컬럼명");
}
