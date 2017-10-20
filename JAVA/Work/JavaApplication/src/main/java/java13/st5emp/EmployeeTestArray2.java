package java13.st5emp;

import java.util.Scanner;

public class EmployeeTestArray2 {
    public static void main(String[] args) {
        int salary;
        String name, address, rrn;
        Scanner scan = new Scanner(System.in);
        
        Employee[] emp = new Employee[3];
        
        System.out.println("직원 3명의 정보를 입력하세요");
        
        for (int i = 0; i < emp.length; i++) {
            System.out.print("직원" + (i + 1) + "의 이름 : ");
            name = scan.next();
            System.out.print("직원" + i + 1 + "의 주소 : ");
            address = scan.next();
            System.out.print("직원" + i + 1 + "의 월급 : ");
            salary = scan.nextInt();
            System.out.print("직원" + i + 1 + "의 민번 : ");
            rrn = scan.next();
            
            emp[i] = new Employee(name, address, salary, rrn);

        }
        
        for (int i = 0; i < emp.length; i++) {
            System.out.println(emp[i].toString());
        }
        
    }
    
}
