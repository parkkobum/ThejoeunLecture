package test;

import java.util.Scanner;

public class tw01_02 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("정수를입력하시오>");
        int     d = keyboard.nextInt();
        System.out.printf("입력된 정수는 %d\n", d);
        
        
        System.out.print("문자열을입력하시오>");
        String  s = keyboard.next();
        System.out.printf("입력된 문자열은 %s\n", s);
    }
    
}
