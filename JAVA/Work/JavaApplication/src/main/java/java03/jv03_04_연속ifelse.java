package java03;

import java.util.Scanner;

public class jv03_04_연속ifelse {
    
    public static void main(String[] args) {
        
        int grade = 0;
        
        Scanner keyboard = new Scanner(System.in);
        System.out.printf("Grade:");
        grade = keyboard.nextInt();
        
        System.out.print("학점:");
        
        if (grade >= 90) {
            System.out.println("A");
        } else if (grade >= 80) {
            System.out.println("B");
        } else if (grade >= 70) {
            System.out.println("C");
        } else if (grade >= 60) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
    }
}
