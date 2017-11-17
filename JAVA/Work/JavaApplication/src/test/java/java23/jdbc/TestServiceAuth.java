package java23.jdbc;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestServiceAuth {
    
    private ServiceAuth svr = new ServiceAuth();
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }
    
    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void testServiceAuth() {

    }
    
    @Test
    public void testGetCount() throws SQLException {
        ModelAuth model = new ModelAuth();
        int result = svr.getCount(model);
        
        assertEquals(3, result);
    }
    
    @Test
    public void testGetMaxAuthid() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testSelectAll() throws SQLException {
        ResultSet rs = svr.selectAll();
        
        
        assertNotNull(rs);
        
        //값 검증
        //1.갯수 검증
        ModelAuth auth = null;
        int rscount = svr.getCount(auth);
        
        rs.last();
        int lastnum = rs.getRow();
        
        assertEquals(rscount, lastnum);
        
        //3.row 값으로 검증
        rs.first();
        int authid = rs.getInt("authid");
        assertEquals(1, authid);
        
    }
    
    @Test
    public void testSelectLikeModelAuth() throws SQLException {
        ModelAuth auth = new ModelAuth();
        auth.setName("b");
        
        ResultSet rs = svr.selectLike(auth);
        
        assertNotNull(rs);
        
        rs.next();
        String name = rs.getString("name");
        assertTrue(name.contains(auth.getName()));
        
    }
    
    @Test
    public void testSelectEqual() throws SQLException {
        ModelAuth auth = new ModelAuth();
        auth.setName("bob");
        
        ResultSet rs = svr.selectEqual(auth);
        
        assertNotNull(rs);
        
        rs.next();
        String name = rs.getString("name");
        assertTrue(name.contains(auth.getName()));
        
    }
    
    @Test
    public void testSelectDynamic() throws SQLException {
        ModelAuth auth = new ModelAuth();
        
        ResultSet rs = svr.selectDynamic(auth);
        
        rs.last();
        int last = rs.getRow();
        int count = svr.getCount(auth);
        assertEquals(last, count);
        
        auth.setName("kim");
        rs = svr.selectDynamic(auth);
        
        assertNotNull(rs);
        rs.next();
        assertEquals("kim", rs.getString("name"));
        assertEquals("1980.05.01", rs.getString("birth"));
        
        auth.setName("park");
        auth.setBirth("2000.05.01");
        rs = svr.selectDynamic(auth);
        
        assertNotNull(rs);
        rs.next();
        assertEquals("park", rs.getString("name"));
        assertEquals("2000.05.01", rs.getString("birth"));
    }
    
    @Test
    public void testInsertAuth() throws SQLException {
        ModelAuth auth = new ModelAuth(8, "kang", "2014.03.12");

        int rs = -1;
        
        rs = svr.insertAuth(auth);
        
        assertTrue(rs >= 1);
        
    }
    
    @Test
    public void testUpdateAuth() {
        ModelAuth setauth = new ModelAuth(6, "kang", "2014.03.12");
        ModelAuth whereauth   = new ModelAuth(null, "kang", null);
        
        
        
        int rs = -1;
        
        rs = svr.updateAuth(whereauth, setauth);
        
        assertTrue(rs >= 0);

    }
    
    @Test
    public void testDeleteAuth() throws SQLException {
        ModelAuth auth = new ModelAuth(8, "kang", "2014.03.12");

        int rs = -1;
        
        rs = svr.deleteAuth(auth);
        
        assertTrue(rs >= 1);
    }
    
    @Test
    public void testTransCommit() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testTransRollback() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testSelectLikeString() {
        fail("Not yet implemented");
    }
    
}
