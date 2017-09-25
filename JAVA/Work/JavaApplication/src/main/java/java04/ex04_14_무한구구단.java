package java04;

import java.util.Scanner;

public class ex04_14_무한구구단 {
    public static void main(String[] args) {
        int n1 = 0, n2 = 0;
        int sum = 0, temp = 0;
        Scanner keyboard = new Scanner(System.in);
        
        for (;;) {
            System.out.print("시작단과 종료단을 입력하세요.");
            
            n1 = keyboard.nextInt();
            n2 = keyboard.nextInt();
            
            if (n1 == 0 || n2 == 0) {
                System.out.println("종료합니다");
                break;
            }
            
            if (n1 > n2) {
                temp = n2;
                n2 = n1;
                n1 = temp;
            }
            for (int i = n1; i <= n2; i = i + 1) {
                for (int j = 1; j <= 9; j = j + 1) {
                    System.out.println(i + " * " + j + " = " + i * j);
                }
            }
        }
    }
}
