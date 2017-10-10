package java07;

import java.util.Arrays;
import java.util.Scanner;

public class ex07_03_배열로최대최소구하기2 {
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);
        System.out.print("INPUT:");
        
        String input = keyboard.next();
        String[] inputArray = input.split(",");
        int[] studentScore = new int[inputArray.length];
        
        for (int i = 0; i < inputArray.length; i++) {
            studentScore[i] = Integer.valueOf(inputArray[i]);
        }
        
        System.out.print("배열 정렬 전:");
        printArray(studentScore);
        
        Arrays.sort(studentScore); // 배열 정렬 메서드.
        
        System.out.print("배열 정렬 후:");
        printArray(studentScore);
        
        System.out.println("최소값 : " + studentScore[0]);
        System.out.println("최대값 : " + studentScore[inputArray.length - 1]);
        
    }
    
    public static void printArray(int[] studentScore) {
        
        if (beforeAfter == 0) {
        } else {
            System.out.print("배열 정렬 후:");
            
        }
        for (int i = 0; i < studentScore.length; i++) {
            if (i == studentScore.length - 1) {
                System.out.println(studentScore[studentScore.length - 1]);
            } else {
                System.out.print(studentScore[i] + ",");
            }
        }
        
    }
}
