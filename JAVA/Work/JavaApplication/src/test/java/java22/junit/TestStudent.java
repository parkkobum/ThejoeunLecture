package java22.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

public class TestStudent {
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }
    
    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void testGetGrade() {
        
        Student test = new Student(101);
        
        assertEquals("F", test.getgrade(101));

        
        assertEquals("A", test.getgrade(95));
                
        assertEquals("B", test.getgrade(85));
        
        assertEquals("C", test.getgrade(75));
        assertEquals("D", test.getgrade(65));
        
        assertEquals("F", test.getgrade(55));
        
    }
    
}
