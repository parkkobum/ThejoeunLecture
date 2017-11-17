package 박고범;

import java.util.Scanner;

public class ex5 {
    public static void main(String[] args) {
        
        int arraySize = 3;
        Scanner scan = new Scanner(System.in);
        
        Employee[] emp = new Employee[arraySize];
        
        for (int i = 0;i<emp.length; i++ ) {
            System.out.println((i+1) +" 번째 직원");
            emp[i] = new Employee();
            System.out.print("이    름 :"); emp[i].setName(scan.next()); 
            System.out.print("주    소 :"); emp[i].setAddr(scan.next()); 
            System.out.print("주민번호 :"); emp[i].setRrn(scan.next());
            System.out.print("월    급 :"); emp[i].setSalary(scan.nextInt());
        }
        
        for (int i=0; i<emp.length;i++) {
            System.out.println((i+1) +" 번째 직원");
            System.out.println(emp[i].toString());
        }
    }
    
}
