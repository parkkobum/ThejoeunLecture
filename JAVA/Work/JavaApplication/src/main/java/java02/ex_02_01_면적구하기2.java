package java02;

import java.util.Scanner;

public class ex_02_01_면적구하기2 {
    
    public static void main(String[] args) {
        
        int w = 0;
        int h = 0;
        int area = 0, perimeter = 0;
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("사각형의 가로 길이를 입력하시오:");
        w = keyboard.nextInt(); 
        
        System.out.print("사각형의 세로 길이를 입력하시오:");
        h = keyboard.nextInt(); 
        
        area = w * h;
        perimeter = 2 * ( w + h );
        
        System.out.println("사각형의 넓이: " + area);
        System.out.println("사각형의 둘레: " + perimeter);
        
        keyboard.close();
        
        
    }
    
}
