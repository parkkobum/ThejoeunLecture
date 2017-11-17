package java22.junit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestMyUnit {
    private static MyUnit myUnit = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        myUnit = new MyUnit();
    }
    
    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void testConcate() {
        String result;
        result = myUnit.concate("ab", "cd");
        assertEquals("abcd", result);
    }
    
    @Test
    public void testGetBoolean() {
        boolean rs = myUnit.getBoolean();
        assertFalse(rs);
    }
    
    @Test
    public void testGetSameObject() {
        Object rs = myUnit.getSameObject();
        assertSame(null, rs);
    }
    
    @Test
    public void testGetObject() {
        Object rs = myUnit.getObject();
        assertNull(rs);
    }
    
    @Test
    public void testGetStringArray() {
        String[] result = myUnit.getStringArray();
        String[] expecteds = { "one", "two", "three" };
        assertArrayEquals(expecteds, result);
    }
    
    @Test(expected = ArithmeticException.class)
    public void test_getException() {
        double result = myUnit.getException();
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void test_getEmptyList() {
        ArrayList<String> list = myUnit.getEmptyList();
        list.get(0);
        
    }
    
}
