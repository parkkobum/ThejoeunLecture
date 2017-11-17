package java22.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestRect {
        
    @Test
    public void testPerimeter() {
        Rect rect = new Rect(5, 10);
        int rs = rect.prerimeter();
        assertEquals(30, rs);
    }
    
    
    @Test
    public void testArea() {
        Rect rect = new Rect(5, 10);
        int rs = rect.area();
        assertEquals(50, rs);
    }
    
    @Test
    public void test_type() {
        Rect r = new Rect(2, 5);
        Object r1 = r.type();
        assertNull(r1);
    }
    
}
