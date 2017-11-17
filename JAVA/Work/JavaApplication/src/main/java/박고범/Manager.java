package 박고범;

public class Manager extends Employee {
    
    private int bonus;

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "Manager [bonus=" + bonus + ", toString()=" + super.toString()
                + "]";
    }

    public Manager(String name, String addr, int salary, String rrn,
            int bonus) {
        super(name, addr, salary, rrn);
        this.bonus = bonus;
    }

    public Manager() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Manager(String name, String addr, int salary, String rrn) {
        super(name, addr, salary, rrn);
        // TODO Auto-generated constructor stub
    }
    
    
    
}
