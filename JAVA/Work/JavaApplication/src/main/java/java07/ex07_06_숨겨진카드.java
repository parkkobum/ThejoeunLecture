package java07;

import java.util.Random;
import java.util.Scanner;

public class ex07_06_숨겨진카드 {
    public static void main(String[] args) {
        
        Random random = new Random();
        Scanner keyboard = new Scanner(System.in);

        
        for(;;) {
        
            int theNumber = random.nextInt(100);            
            System.out.println("숫자가 결정되었습니다. 맞추어보세요.");
            int max = 99, min = 0;
            int count =1 ;
            int n1=0;
            String retry = "";
            
            for (;;) {
                System.out.println(min+"-"+max);
                System.out.print(count+">>");
                n1 = keyboard.nextInt();
                
                if (n1==theNumber) {
                    System.out.println("맞았습니다.");
                    break;
                }
                else if (n1 < max && n1 > theNumber) {
                    System.out.println("더 낮게");
                    max = n1;
                    count++;
                }
                else if (n1 > min && n1 < theNumber) {
                    System.out.println("더 높게");
                    min = n1;
                    count++;
                }
                
            }
            System.out.print("다시하시겠습니까(y/n)>>");
            retry = keyboard.next();
            if (retry.equals("y")||retry.equals("Y")) {
                continue;
            }
            else {
                System.out.println("종료하겠습니다.");
                break;
            }            
            
        }
    }
}
