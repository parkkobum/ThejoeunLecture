package java22.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestOper2 {
    
    private static Oper op = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        op = new Oper(2, 4);
    }
    
    @Test
    public void test_add() {
        int rs = op.add();
        assertEquals(6, rs);
    }
    @Test
    public void test_minus() {
        int rs = op.minus();
        assertEquals(-2, rs);
    }
    @Test
    public void test_mul() {
        int rs = op.mul();
        assertEquals(8, rs);
    }
    @Test
    public void test_div() {
        double rs = op.div();
        assertEquals(0.5, rs, 0.1);
    }
    
    
}
