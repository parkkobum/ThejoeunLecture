package java15.st2enum;

import java.util.Scanner;

public class PhoneHeaderTest {
    public static void main(String[] args) {
        
        Scanner Keyboard = new Scanner(System.in);
        
        String phone = Keyboard.next();
        
        String header = phone.substring(0, 3);
        
        if (header.equals(PhoneHeaderClass.P010)) {
            System.out.println("General");
        }
        else if (header.equals(PhoneHeaderClass.P011)) {
            System.out.println("sk");
        }
        else if (header.equals(PhoneHeaderClass.P016)) {
            System.out.println("kt");
        }
        else if (header.equals(PhoneHeaderClass.P019)) {
            System.out.println("lg");
        }
        
        System.out.println("Enum Start!");
        if (header.equals(PhoneHeaderEnum.P010)) {
            System.out.println("General");
        }
        else if (header.equals(PhoneHeaderEnum.P011)) {
            System.out.println("sk");
        }
        else if (header.equals(PhoneHeaderEnum.P016)) {
            System.out.println("kt");
        }
        else if (header.equals(PhoneHeaderEnum.P019)) {
            System.out.println("lg");
        }
            

        
        
        
    }
    
}
