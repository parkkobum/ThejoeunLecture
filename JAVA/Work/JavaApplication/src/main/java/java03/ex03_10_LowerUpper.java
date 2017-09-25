package java03;

import java.util.Scanner;

public class ex03_10_LowerUpper {
    public static void main(String[] args) {
        char c = 0;
        
        Scanner keyboard = new Scanner(System.in);
        System.out.printf("ch: ");
        c = keyboard.next().charAt(0);
        
        if ('a' <= c && c <= 'z') {
            System.out.format("ch to upperCase: %c", (c - 32));
        } else if ('A' <= c && c <= 'A') {
            System.out.format("ch to lowerCase: %c", (c + 32));
        } else {
            System.out.println("대소문자를 입력하세요.");
        }
    }
    
}
