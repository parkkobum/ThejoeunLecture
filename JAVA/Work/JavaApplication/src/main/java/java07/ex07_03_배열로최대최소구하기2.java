package java07;

import java.util.Scanner;

public class ex07_03_배열로최대최소구하기2 {
    public static void main(String[] args) {
        int sum = 0;
        double avg = 0.0;
        
        Scanner keyboard = new Scanner(System.in);
        System.out.print("학생수를 입력하시오");
        int studentNum = keyboard.nextInt();
        
        int[] studentScore = new int[studentNum];
        
        for (int i = 0; i < studentNum; i++) {
            System.out.print("성적을 입력하시오:");
            studentScore[i] = keyboard.nextInt();
            sum = sum + studentScore[i];
        }
        
        System.out.println("합계는:" + sum);
        System.out.println("평균은:" + sum / studentNum);
        
    }
    
}
