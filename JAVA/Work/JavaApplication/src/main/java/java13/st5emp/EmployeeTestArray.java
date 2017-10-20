package java13.st5emp;

import java.util.Scanner;

public class EmployeeTestArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        Employee[] emp = new Employee[3];
        
        System.out.println("직원 3명의 정보를 입력하세요");
        
        for (int i = 0; i < emp.length; i++) {
            emp[i] = new Employee();
            System.out.print("직원" + (i + 1) + "의 이름 : ");
            emp[i].setName(scan.next());
            System.out.print("직원" + i + 1 + "의 주소 : ");
            emp[i].setAddress(scan.next());
            System.out.print("직원" + i + 1 + "의 월급 : ");
            emp[i].setSalary(scan.nextInt());
            System.out.print("직원" + i + 1 + "의 민번 : ");
            emp[i].setRrn(scan.next());
        }
        
        for (int i = 0; i < emp.length; i++) {
            System.out.println(emp[i].toString());
        }
        
    }
    
}
