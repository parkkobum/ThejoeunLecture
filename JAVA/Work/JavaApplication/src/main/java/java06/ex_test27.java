package java06;

import java.util.Arrays;
import java.util.Collections;

public class ex_test27 {
    public static void main(String[] args) {
        Integer[] a = {5,7,1,2};
        System.out.println(max(a));
    }
    
    public static int max(Integer[] array) {        
        int max = (int)Collections.max(Arrays.asList(array));
        return max;
    }
    
}
