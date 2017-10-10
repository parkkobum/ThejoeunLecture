package java07;

import java.util.Scanner;

public class ex07_07_자리예약1차원 {
    public static void main(String[] args) {
        int n1 = 0, n2 = 0;
        Scanner keyboard = new Scanner(System.in);
        int[] seats = new int [10];
        
        for (;;) {
            display(seats);
            System.out.print("원하시는 좌석번호를 입력하세요(종료는 -1) :");
            n1 = keyboard.nextInt() - 1;
            
            if (n1 == -2 || n1 ==  -1) {
                System.out.println("시스템을 종료합니다.");
                break;
            }
            
            if (seats[n1] == 0) {
                seats[n1] =1;
                System.out.println("예약되었습니다.");
            }
            else {
                System.out.println("이미 예약된 자리입니다.");
            }
        }
    }
    
    public static void display(int[] seats) {
        System.out.println("-------------------------------");
        System.out.println("  1  2  3  4  5  6  7  8  9  10");
        System.out.println("-------------------------------");
        for(int i= 0 ; i< seats.length;i++) {
            System.out.format("%3d", seats[i]);
        }
        System.out.println();
        
    }
    
}
