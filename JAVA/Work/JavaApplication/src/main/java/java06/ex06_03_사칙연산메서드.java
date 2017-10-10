package java06;

import java.util.Scanner;

public class ex06_03_사칙연산메서드 {
    
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);
        
        /* Input */
        System.out.print("First  num:");
        int x = keyboard.nextInt();
        System.out.print("Second num:");
        int y = keyboard.nextInt();
        
        /* Calculate */
        int add = Add(x, y);
        int minus = Minus(x, y);
        int mul = Mul(x, y);
        double div = Div(x, y);
        
        /* Print */
        System.out.println("Add :" + add);
        System.out.println("Minus :" + minus);
        System.out.println("Mul :" + mul);
        System.out.format("Div : %.6f\n", div);
        
    }
    
    private static double Div(int x, int y) {
        double div = 0;
        try {
            div = (double) x / y;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return div;
    }
    
    private static int Minus(int x, int y) {
        return x - y;
    }
    
    private static int Mul(int x, int y) {
        return x * y;
    }
    
    private static int Add(int x, int y) {
        return x + y;
    }
    
}
