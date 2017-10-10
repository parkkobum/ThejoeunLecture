package java07;

import java.util.Random;
import java.util.Scanner;

public class ex07_11_자리예약2차원 {
    public static void main(String[] args) {
        
        Random random = new Random();

        int x = 0, y = 0, r = 0;
        Scanner keyboard = new Scanner(System.in);
        int[][] seats = new int [6][4];
        seats[0][2] = -1;
        seats[0][3] = -1;
        seats[1][3] = -1;
        seats[2][3] = -1;
        
        for ( int i = 1; i <= 20; i++) {
            for(;;){
                r = random.nextInt(24);
                x = r % 6;
                y = r / 6;
                if (seats[x][y] == 0) {
                    seats[x][y] = i;
                    break;
                }                
            }
        }
        display(seats);
        
}
    
    public static void display(int[][] seats) {
        System.out.format("             |--------| \n" );
        System.out.format("             | 스크린 | \n" );
        System.out.format("             |--------| \n" );
        System.out.format("\n" );
        System.out.format("|----|----|----|  |----|----|----|\n");
        System.out.format("| %2d | %2d | %2d |  | %2d | %2d | %2d |\n", seats[0][0], seats[1][0], seats[2][0], seats[3][0], seats[4][0], seats[5][0] );
        System.out.format("|----|----|----|  |----|----|----|\n");
        System.out.format("| %2d | %2d | %2d |  | %2d | %2d | %2d |\n", seats[0][1], seats[1][1], seats[2][1], seats[3][1], seats[4][1], seats[5][1] );
        System.out.format("|----|----|----|  |----|----|----|\n");
        System.out.format("     | %2d | %2d |  | %2d | %2d | %2d |\n", seats[1][2], seats[2][2], seats[3][2], seats[4][2], seats[5][2] );
        System.out.format("     |----|----|  |----|----|----|\n");
        System.out.format("                  | %2d | %2d | %2d |\n", seats[3][3], seats[4][3], seats[5][3]);
        System.out.format("                  |----|----|----|\n" );
        
    }
    
}
