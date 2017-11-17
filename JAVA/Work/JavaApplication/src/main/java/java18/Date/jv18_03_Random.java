package java18.Date;

import java.util.Random;
import java.util.Scanner;

public class jv18_03_Random {
    
    public static void main(String[] args) {
        Random rand = new Random();
        double rand1 = rand.nextDouble();
        System.out.println(rand1);
        
        double rand3 = rand.nextDouble() * 2;
        System.out.println(rand3);
        
        // 문제1
        double rand4 = rand.nextDouble() * 2 + 1;
        System.out.println(rand4);
        
        // 문제2 0이상 10미만
        for (int i = 0; i < 5; i++) {
            double rand2 = rand.nextDouble() * 10;
            System.out.println(rand2);
        }
        
        // 문제3 A와 B사이 존재 난수 10개 생성 출력
        Scanner Input = new Scanner(System.in);
        
        System.out.print("최대 정수 A :");
        int maxA = Input.nextInt();
        System.out.print("최소 정수 B :");
        int minB = Input.nextInt();
        if (maxA-minB <= 0) {
            System.out.println("입력이 잘못되었습니다.");
            return;
        }
        System.out.println(minB +"~" + maxA +"사이의 난수 10개");
        for (int i = 0; i < 10; i++) {
            int rand5 = rand.nextInt(maxA-minB) + minB;
            System.out.print(rand5+ "    ");
        }
        
        
    }
    
}
