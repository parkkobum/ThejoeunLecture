package java23.jdbc;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestServiceBook {
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }
    
    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void testServiceBook() {
    }
    
    @Test
    public void testGetCount() throws SQLException {
        ServiceBook svr = new ServiceBook();
        ModelBook model = new ModelBook();
        int result = svr.getCount(model);
        
        assertEquals(4, result);
    }
    
    @Test
    public void testGetMaxBookid() throws SQLException {
        ServiceBook svr = new ServiceBook();
        int result = svr.getMaxBookid();
        
        assertEquals(4, result);
    }
    
    @Test
    public void testSelectAll() throws SQLException {
        ServiceBook svr = new ServiceBook();
        ResultSet rs = svr.selectAll();
        rs.next();
        int bookid = rs.getInt("bookid");
        String bookname = rs.getString("bookname");
        assertEquals(1, bookid);
        assertEquals("operating system", bookname);
    }
    
    @Test
    public void testSelectLike() throws SQLException {
        ServiceBook svr = new ServiceBook();
        ModelBook book = new ModelBook();
        book.setBookname("ja");
        ResultSet rs = svr.selectLike(book);
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
        ServiceBook svr = new ServiceBook();
        ModelBook book = new ModelBook();
        book.setBookname("mysql");
        ResultSet rs = svr.selectEqual(book);
        rs.next();
        assertNotNull(rs);
        String bookname = rs.getString("bookname");
        assertEquals("mysql", bookname);
        assertTrue(bookname.contains("mysql"));
    }
    
    @Test
    public void testSelectDynamic() throws SQLException {
        ServiceBook svr = new ServiceBook();
        ModelBook book = new ModelBook();
        ResultSet rs = svr.selectDynamic(book);
        
        assertNotNull(rs);
        rs.last();
        assertEquals(svr.getCount(book), rs.getRow());
        
    }
    
    @Test
    public void testInsertBook() {
        ServiceBook svr = new ServiceBook();
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
            rs = svr.insertBook(book);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        assertTrue(rs == 1);
    }
    
    @Test
    public void testUpdateBook() {
        ServiceBook svr = new ServiceBook();
        ModelBook wherebook = new ModelBook();
        ModelBook setbook = new ModelBook();
        
        wherebook.setBookname("mysql2");
        setbook.setYear("2017");
        setbook.setPrice(63000);
        
        int rs = -1;
        rs = svr.updateBook(wherebook, setbook);
        assertTrue(rs >= 0);
    }
    
    @Test
    public void testDeleteBook() throws SQLException {
        ServiceBook svr = new ServiceBook();
        ModelBook book = new ModelBook();
        
        book.setBookname("mysql2");
        
        int rs = -1;
        rs = svr.deleteBook(book);
        assertTrue(rs >= 0);
    }
    
    @Test
    public void testTransCommit() {
        int result = -1;
        try {
            ServiceAuth serviceAuth = new ServiceAuth();
            // 추가. Auth 테이블에 inserted 된 authid 를
            // book 테이블에 insert 할 때 사용하도록 수정.
            book.setAuthid(result);
            DaoBook daoBook = new DaoBook(conn);
            result = daoBook.insert(book);
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            conn.rollback();
        }
        return result;
        
    }
    
    @Test
    public void testTransRollback() {
        fail("Not yet implemented");
    }
    
}
