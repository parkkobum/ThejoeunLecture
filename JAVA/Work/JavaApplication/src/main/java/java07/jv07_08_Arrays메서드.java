package java07;

import java.util.Arrays;

public class jv07_08_Arrays메서드 {
    
    public static void main(String[] args) {
        
        int arraySize = 5;
        int[] array = new int[arraySize];
        
        for (int i = 0; i <= array.length - 1; i++) {
            array[i] = array.length - i;
        }
        printArray(array);
      
        
        System.out.println("최대값은 : "+max(array));
        printArray(array);

        
        int val = Arrays.binarySearch(array, 4);
        System.out.println("4값의 위치는 " + val);
        
        Arrays.fill(array, -1);
        printArray(array);
       
        
        
        
    }
    
    public static void printArray(int[] x) {
        
        for (int i = 0; i <= x.length - 1; i++) {
            System.out.print(x[i]);
        }
        System.out.println();
        
    }
    
    public static int max(int[] x) {
        
        Arrays.sort(x);
        if (x.length == 0) {
            return -1;
        } else {
            return x[x.length - 1];
        }
    }
    
}
