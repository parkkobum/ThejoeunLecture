package java22.junit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestArrayList {
    
    private static List<String> list = null;
    
    @BeforeClass
    public static void setUpClass() {
        list = new ArrayList<String>();
        list.add("0");
        list.add("2");
        list.add("1");
        list.add("3");
        list.add("4");
    }
    
    @Test
    public void test01() {
        assertNotNull(list);
    }
    
    @Test
    public void test02() {
        assertEquals(5, list.size());
    }
    
    @Test
    public void test03() {
        assertFalse(list.contains("10"));
    }
    
    @Test
    public void test04() {
        String names[] = {"y2kpooh", "hwang"};
        String names2[] = {"y2kpooh", "hwang"};
        assertEquals(names, names2);
    }
    
}
