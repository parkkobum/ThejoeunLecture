package java22.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestOper {
    
    @Test
    public void testAdd() {

        Oper op = new Oper(2, 4);
        
        int rs = op.add();
        
        assertEquals(6, rs);
        
    }
    
    @Test
    public void testMinus() {

        Oper op1 = new Oper(4, 2);
        
        int rs = op1.minus();
        
        assertEquals(2, rs);
        
    }
    @Test
    public void testMul() {

        Oper op = new Oper(2, 4);
        
        int rs = op.mul();
        
        assertEquals(8, rs);
        
    }
    
    @SuppressWarnings("deprecation")
    @Test
    public void testDiv() {

        Oper op = new Oper(6, 2);
        
        double rs = op.div();
        
        assertEquals(3, rs);
        
    }
}
