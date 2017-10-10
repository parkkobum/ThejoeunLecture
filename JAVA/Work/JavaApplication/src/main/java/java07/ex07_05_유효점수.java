package java07;

import java.util.Arrays;
import java.util.Scanner;

public class ex07_05_유효점수 {
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);
        System.out.print("심사 위원의 수를 입력하시오");
        int scoreNum = keyboard.nextInt();
        
        int[] score = new int[scoreNum];
        
        System.out.print(scoreNum+"명 심사 위원의 점수 입력 :");
        for (int i = 0; i < scoreNum; i++) {
            score[i] = keyboard.nextInt();
        }
        
        Arrays.sort(score);
        
        System.out.print("유효점수 : ");
        
        int sum = 0;
        for (int i = 1; i < scoreNum-1; i++) {
                System.out.print(score[i]+" ");
                sum = sum + score[i];
        }
        System.out.println();
        System.out.println("합계 : " + sum);
        System.out.format("평균 : %.2f\n" ,((double)sum / (score.length-2)));

        
    }
    
}

