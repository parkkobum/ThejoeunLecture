package java07;

import java.util.Scanner;

public class jv07_03_반평균구하기2 {
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);
        System.out.print("배열의 크기를 입력하시오");
        int studentNum = keyboard.nextInt();
        
        int[] studentScore = new int[studentNum];
        
        for (int i = 0; i < studentNum; i++) {
            System.out.print("성적을 입력하시오:");
            studentScore[i] = keyboard.nextInt();
        }

        System.out.print("배열의 값은:");
        
        
        for (int i = 0; i < studentNum; i++) {
            if (i == studentNum-1){
                System.out.println(studentScore[i]);
            }
            else{
                System.out.print(studentScore[i]+",");    
            }
            
        }

        
    }
    
}
