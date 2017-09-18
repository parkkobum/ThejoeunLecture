package java03;

import java.util.Scanner;

public class ex03_01_LargeSmall {
    public static void main(String[] args) {
        int n = 0;
        
        Scanner keyboard = new Scanner(System.in);
        System.out.printf("n값을 입력하시오>");
        n = keyboard.nextInt();
        
        if ( n >= 100) {
            System.out.println("Large");
        }
        else {
            System.out.println("small");
        }
    }
    
}
