package java04;

import java.util.Scanner;

public class ex04_09_무한입력 {
    public static void main(String[] args) {
        int n1 = 0, n2 = 0;
        Scanner keyboard = new Scanner(System.in);
        
        for (;;) {
            System.out.print("정수를 입력하세요 :");
            n1 = keyboard.nextInt();
            
            if (n1 < 0) {
                System.out.println("정상 종료합니다.");
                break;
            }
            
            System.out.printf("입력한 값은 %d입니다.\n", n1);
            
        }
    }
}
