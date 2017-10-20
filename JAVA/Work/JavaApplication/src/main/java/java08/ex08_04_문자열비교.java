package java08;

import java.util.Scanner;

public class ex08_04_문자열비교 {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        System.out.println("Please input first string : ");
        String x = input.next();
        System.out.println("Please input Second string : ");
        String y = input.next();
        
        if ( x.equals(y)) {
            System.out.println("Same");
        }
        else {
            System.out.println("Different");
        }
        
        if ( x==y) {
            System.out.println("Same");
        }
        else {
            System.out.println("Different");
        }
        
    }
    
}
