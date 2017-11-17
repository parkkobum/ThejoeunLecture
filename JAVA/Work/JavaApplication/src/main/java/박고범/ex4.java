package 박고범;

import java.util.Scanner;

public class ex4 {
    public static void main(String[] args) {
        

        Scanner input = new Scanner(System.in);
        
            System.out.print("First num : ");
            int x = input.nextInt();
            System.out.print("\nSecond num : ");
            int y = input.nextInt();
            System.out.println();
            Oper op =  new Oper(x, y);

            System.out.println("Add : " + op.add()+"\n");
            System.out.println("Minus : " + op.minus()+"\n");
            System.out.println("Mul : " + op.mul()+"\n");
            System.out.format("Div : %.6f\n",op.div());
        
    }
    
}
