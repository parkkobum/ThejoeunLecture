package test;

import java.util.Scanner;

public class tw01_03 {
    public static void main(String[] args) {
        
        int salary  = 0;
        int deposit = 0;
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("월급을 입력하시오:");
        salary = keyboard.nextInt();
        deposit = salary * 10 * 12;
        
        System.out.printf("10년 동안의 저축액: %d\n",deposit);
        
    }
    
}
