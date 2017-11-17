package java23.jdbc;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestDaoAuth {
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
        
        DaoAuth dao = new DaoAuth(conn);
        ModelAuth model = new ModelAuth();
        int result = dao.getCount(model);
        
        assertEquals(3, result);
        
    }
    
    @Test
    public void testGetMaxAuthid() {
        DaoAuth dao = new DaoAuth(conn);
        int result = dao.getMaxAuthid();
        
        assertEquals(7, result);
    }
    
    @Test
    public void testSelectAll() throws SQLException {
        DaoAuth dao = new DaoAuth(conn);
        ResultSet rs = dao.selectAll();
        rs.next();
        int authid = rs.getInt("authid");
        String authname = rs.getString("name");
        assertEquals(1, authid);
        assertEquals("bob", authname);
    }
    
    @Test
    public void testSelectLike() throws SQLException {
        DaoAuth dao = new DaoAuth(conn);
        ResultSet rs = dao.selectLike("bo");
        rs.next();
        int rowNum = rs.getRow();
        assertNotNull(rs);
        assertTrue(rs.getRow() >= 1);
        String authname = rs.getString("name");
        assertEquals("bob", authname);
        assertTrue(authname.contains("bo"));
    }
    
    @Test
    public void testSelectEqual() throws SQLException {
        DaoAuth dao = new DaoAuth(conn);
        ModelAuth auth = new ModelAuth();
        auth.setName("bob");
        ResultSet rs = dao.selectEqual(auth);
        rs.next();
        assertNotNull(rs);
        String authname = rs.getString("name");
        assertEquals("bob", authname);
        assertTrue(authname.contains("bob"));
    }
    
    @Test
    public void testInsertAuth() {
        DaoAuth dao = new DaoAuth(conn);
        ModelAuth auth = new ModelAuth();
        
        auth.setName("Myname");
        auth.setBirth("20171113");
        auth.setAuthid(4);
        
        int rs = -1;
        try {
            rs = dao.insertAuth(auth);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        assertTrue(rs == 1);
    }
    
    @Test
    public void testUpdateAuth() {
        DaoAuth dao = new DaoAuth(conn);
        ModelAuth whereauth = new ModelAuth();
        ModelAuth setauth = new ModelAuth();
        
        whereauth.setName("Myname");
        setauth.setBirth("20171101");
        
        int rs = -1;
        rs = dao.updateAuth(whereauth, setauth);
        assertTrue(rs >= 0);
    }
    
    @Test
    public void testDeleteAuth() throws SQLException {
        DaoAuth dao = new DaoAuth(conn);
        ModelAuth auth = new ModelAuth();
        
        auth.setName("Myname");
        
        int rs = -1;
        rs = dao.deleteAuth(auth);
        assertTrue(rs >= 0);
    }
    
    @Test
    public void testSelectDynamic() throws SQLException {
        DaoAuth dao = new DaoAuth(conn);
        ModelAuth auth = new ModelAuth();
        ResultSet rs = dao.selectDynamic(auth);
        assertNotNull(rs);
    
        auth.setName("bob");
        rs = dao.selectDynamic(auth);
        assertNotNull(rs);
        
        rs.next();
        int authid = rs.getInt("authid");
        String name = rs.getString("name");
        
        assertEquals(1, authid);
        assertEquals("bob", name);
        
        auth.setAuthid(2);
        auth.setName("kim");
       
        rs = dao.selectDynamic(auth);
        rs.next();
        authid = rs.getInt("authid");
        name = rs.getString("name");
        
        assertEquals(2, authid);
        assertEquals("kim", name);

        
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
