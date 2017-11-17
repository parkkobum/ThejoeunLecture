package 박고범;

import java.util.Arrays;

public class ex2 {
    public static void main(String[] args) {
        int arr[] = {23, 96,35,42,81,19,8,77,50};
        
        printArray("정렬전:", arr);
        Arrays.sort(arr);
        printArray("정렬후:", arr);        
        
    }

    public static void printArray(String str, int[] arr) {
        System.out.print(str);
        for (int i=0; i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
}
