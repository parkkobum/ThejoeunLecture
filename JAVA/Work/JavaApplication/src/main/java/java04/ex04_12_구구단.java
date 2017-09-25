package java04;

import java.util.Scanner;

public class ex04_12_구구단 {
    public static void main(String[] args) {
        int n1 = 0, n2 = 0;
        int sum = 0, temp = 0;
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("시작 단수를 입력하세요:");
        n1 = keyboard.nextInt();
        System.out.print("종료 단수를 입력하세요:");
        n2 = keyboard.nextInt();
        
        if (n1 > n2) {
            temp = n2;
            n2 = n1;
            n1 = temp;
        }
        for (int i = n1; i <= n2; i = i + 1) {
            for (int j = 1; j <= 9; j = j + 1) {
                if (j != 9) {
                    System.out.format("%3d*%d=%3d,", i, j, i * j);
                } else {
                    System.out.format("%3d*%d=%3d\n", i, j, i * j);
                }
            }
        }
        
    }
}
