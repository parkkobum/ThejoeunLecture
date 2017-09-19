package test;

import java.util.Scanner;

public class tw02_01 {
    public static void main(String[] args) {
        int w = 0, h = 0, area = 0, perimeter = 0;
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("사각형의 가로를 입력하시오.>");
        w = keyboard.nextInt();

        System.out.print("사각형의 세로를 입력하시오.>");
        h = keyboard.nextInt();
        
        area = w*h;
        perimeter = 2*(w+h);
        
        System.out.printf("사각형의 넓이: %d\n", area);
        
        System.out.printf("사각형의 둘레: %d\n", perimeter);
    }
    
}
