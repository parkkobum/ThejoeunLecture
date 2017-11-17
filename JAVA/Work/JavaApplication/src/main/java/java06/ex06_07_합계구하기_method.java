package java06;

import java.util.Scanner;

public class ex06_07_합계구하기_method {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("시작값을 입력하세요.   ");
        int a = input.nextInt();
        System.out.print("종료값을 입력하세요.   ");
        int b = input.nextInt();
        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        int sum = getSum(a, b);
        
        printSum(a, b, sum);
        
        
    }
    
    public static int getSum(int a, int b) {
        int sum = 0;
        
        for (int i = a; i <= b; i++) {
            sum = sum + i;
        }
        return sum;
        
    }
    
    public static void printSum(int a, int b, int sum) {
        System.out.println(a + "부터 " + b + "까지의 합계는 " + sum + "입니다.");
    }
    
}
