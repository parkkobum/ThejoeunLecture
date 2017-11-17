package 박고범;

import java.util.Scanner;

public class ex1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        for(;;) {
            System.out.print("시작값을 입력하세요.");
            int x = input.nextInt();
            System.out.print("종료값을 입력하세요.");
            int y = input.nextInt();
            
            if(x>y) {
                int tmp=x; x=y;y=tmp;
            }
            
            printSum(x, y);
            
        }
    }

    public static void printSum(int x, int y) {
        int sum=0;
        for (int i = x; i < y; i++) {
            System.out.print(i+" + ");
            sum= sum+i;
        }
        sum=sum+y;
        System.out.println(y+ " = " + sum);
    }
    
}
