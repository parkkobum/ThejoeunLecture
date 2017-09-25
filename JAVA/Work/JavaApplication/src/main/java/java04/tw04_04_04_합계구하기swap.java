package java04;

import java.util.Scanner;

public class tw04_04_04_합계구하기swap {
    public static void main(String[] args) {
        
        int begin = 0, end = 0, temp = 0, sum = 0;
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("시작값을 입력하세요.");
        begin = keyboard.nextInt();
        System.out.print("종료값을 입력하세요.");
        end = keyboard.nextInt();
        
        if (begin > end) {
            temp = end;
            end = begin;
            begin = temp;
        }
        for (int i = begin; i <= end; i = i + 1) {
            sum = sum + i;
        }
        System.out.println(begin + "부터 " + end + "까지의 합계는 " + sum + "입니다.");
    }
    
}
