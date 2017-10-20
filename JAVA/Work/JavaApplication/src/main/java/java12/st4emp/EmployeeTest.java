package java12.st4emp;

public class EmployeeTest {
    
    public static void main(String[] args) {
        
        Employee emp1 = new Employee("Mike", 3000);
        System.out.println(emp1.toString()+"count:"+emp1.getCount());
        Employee emp2 = new Employee("Sandy", 2800);
        System.out.println(emp2.toString()+"count:"+emp2.getCount());
        Employee emp3 = new Employee("Sarah", 2600);
        System.out.println(emp3.toString()+"count:"+emp3.getCount());
        
        System.out.println("emp1.getCount() :" +emp1.getCount());
        System.out.println("emp2.getCount() :" +emp2.getCount());
        System.out.println("emp3.getCount() :" +emp3.getCount());
        System.out.println("Employee.getCount() :" +Employee.getCount());

    }
    
}
