package java13.st5emp;

public class Employee {
    String name;
    String Address;
    int salary;
    String rrn;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public String getRrn() {
        return rrn;
    }
    public void setRrn(String rrn) {
        this.rrn = rrn;
    }
    
    @Override
    public String toString() {
        return "Employee [name=" + name + ", Address=" + Address + ", salary="
                + salary + ", rrn=" + rrn + "]";
    }
    
    public Employee() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Employee(String name, String address, int salary, String rrn) {
        super();
        this.name = name;
        Address = address;
        this.salary = salary;
        this.rrn = rrn;
    }
    
    
}
