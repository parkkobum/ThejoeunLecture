package java12;

import java.util.Scanner;

public class RectTest {
    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        int w = 0, h = 0;
        Rect rect;
        
        System.out.print("사각형의 가로 길이를 입력하시오:");
        w = keyboard.nextInt();
        
        System.out.print("사각형의 세로 길이를 입력하시오:");
        h = keyboard.nextInt();
        
        if (true) {
            rect = new Rect(w, h);
        } else {
            rect = new Rect();
            rect.setH(h);
            rect.setW(w);
        }
        
        System.out.println(rect.toString());
        System.out.println("사각형의 넓이: " + rect.area());
        System.out.println("사각형의 둘레: " + rect.prerimeter());
        
        keyboard.close();
        
    }
    
}
