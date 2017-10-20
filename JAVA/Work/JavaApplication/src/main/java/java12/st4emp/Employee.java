package java12.st4emp;

public class Employee {
    
    private String name;
    private double salary;
    private static int count = 0;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public static int getCount() {
        return count;
    }
    @Override
    public String toString() {
        return "Employee [name=" + name + ", salary=" + salary + "]";
    }
    public Employee(String name, double salary) {
        super();
        this.name = name;
        this.salary = salary;
        count++;
    }
    public Employee() {
        super();
        count++;
        // TODO Auto-generated constructor stub
    }
    
}
