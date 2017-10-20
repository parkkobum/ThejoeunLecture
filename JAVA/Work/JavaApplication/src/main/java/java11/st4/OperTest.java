package java11.st4;

import java.util.Scanner;

public class OperTest {
    
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);
        Oper oper = new Oper();
        
        /* Input */
        System.out.print("First  num:");
        int x = keyboard.nextInt();
        System.out.print("Second num:");
        int y = keyboard.nextInt();
        
        /* Calculate */
        int add = oper.Add(x, y);
        int minus = oper.Minus(x, y);
        int mul = oper.Mul(x, y);
        double div = oper.Div(x, y);
        
        /* Print */
        System.out.println("Add :" + add);
        System.out.println("Minus :" + minus);
        System.out.println("Mul :" + mul);
        System.out.format("Div : %.6f\n", div);
        
    }
    
}
