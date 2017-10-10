package java06;

import java.util.Scanner;

public class ex06_03_isNumber {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in); 
        
        System.out.print("문자열을 입력하시오:");
        String s = keyboard.next();
        
        if (isNumber(s)) {
            System.out.println("숫자");
        } else {
            System.out.println("문자");
        }
        
    }
    
    private static boolean isNumber(String s) {
        
        char c;
        int count = 0;
        
        if (s == "" || s == null) {
            return false;
        }
        
        for (int j = 0; j < s.length(); j = j + 1) {
            c = s.charAt(j);
            if (!(c >= '0' && c <= '9')) {
                count++;
            }
            
        }
        if (count > 0) {
            return false;
        } else {
            return true;
        }
        
    }
    
}
