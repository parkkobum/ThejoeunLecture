package java14.st6manager;

public class Manager extends Employee {
    
    private int bunus = 0;
    
    public int getBunus() {
        return bunus;
    }
    
    public void setBunus(int bunus) {
        this.bunus = bunus;
    }
    
    @Override
    public String toString() {
        return "Manager [bunus=" + bunus + ", salary=" + salary
                + ", toString()=" + super.toString() + "]";
    }
    
    public Manager() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public Manager(String name, String address, int salary, String rrn) {
        super(name, address, salary, rrn);
        // TODO Auto-generated constructor stub
    }
    
    public void test() {
        String info = "name : " + super.getName();
        info = info + ", address " + super.getAddress();
        info = info + ", Salary : " + super.getSalary();
        info = info + ", RRN : " + super.getRrn();
        
        System.out.println(info);
    }
    
}
