package 박고범;

import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        
        for(;;) {
            System.out.print("시작값을 입력하세요.");
            int x = input.nextInt();
            System.out.print("종료값을 입력하세요.");
            int y = input.nextInt();
            
            if (x==0 || y==0) {
                System.out.println("종료하겠습니다.");
                break;
            }
            
            if(x>y) {
                int tmp=x; x=y;y=tmp;
            }
            
            print99dan(x, y);
            
        }
    }
    
    public static void print99dan(int x, int y) {
        
        for(int i=x; i <=y; i++) {
            System.out.println(i + "단");
            for(int j=2; j<=9;j++) {
                System.out.println(i+" * "+j+" = "+ i*j);
            }
        }
    }
    
}
