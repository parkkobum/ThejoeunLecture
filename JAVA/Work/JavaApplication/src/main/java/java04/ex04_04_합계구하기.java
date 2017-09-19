package java04;

import java.util.Scanner;

public class ex04_04_합계구하기 {
    public static void main(String[] args) {
        
        int a = 0, b = 0, temp = 0, sum = 0;
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("시작값을 입력하세요.");
        a = keyboard.nextInt();
        System.out.print("종료값을 입력하세요.");
        b = keyboard.nextInt();
        
        if (a > b) {
            temp = b;
            b = a;
            a = temp;
        }
        
        for (int i = a; i <= b; i = i + 1) {
            sum = sum + i;
        }
        System.out.println(a + "부터 " + b + "까지의 합계는 " + sum + "입니다.");
        
    }
    
}
