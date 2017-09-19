package java03;

import java.util.Scanner;

public class ex03_02_Maxnumber {
    public static void main(String[] args) {
        int x = 0, y = 0, z = 0;
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("첫번째수를입력하세요:");
        x = keyboard.nextInt();
        System.out.print("두번째수를입력하세요:");
        y = keyboard.nextInt();
        System.out.print("세번째수를입력하세요:");
        z = keyboard.nextInt();
/*        
        if (x >= y) {
            if (x > z) {
                System.out.format("입력 받은 수중 가장 큰 수는 %d입니다.\n", x);
            } else {
                System.out.format("입력 받은 수중 가장 큰 수는 %d입니다.\n", z);
            }
        } 
        else {    
            if (y > z) {
                System.out.format("입력 받은 수중 가장 큰 수는 %d입니다.\n", y);
            } else {
                System.out.format("입력 받은 수중 가장 큰 수는 %d입니다.\n", z);
            }
        }
        
    }
  */
        if (x >= y && x >= z) {
            System.out.format("입력 받은 수중 가장 큰 수는 %d입니다.\n", x);
        } else if (y >= z) {
            System.out.format("입력 받은 수중 가장 큰 수는 %d입니다.\n", y);
        } else {
            System.out.format("입력 받은 수중 가장 큰 수는 %d입니다.\n", z);
        }
    }
}        
