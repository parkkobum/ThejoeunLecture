package java12.st3car;

public class car {
    
    private String     color        = "빨강";
    private int        speed        = 100;
    private int        gear         = 4;
    
    private int        carid        = 0;
    
    private static int numberofCars = 0;
    
    public void speedUp(int s) {
        this.speed = speed + s;
    }
    
    void speedDown(int s) {
        speed = speed - s;
    }
    
    public void speedPrint() {
        System.out.println("속도" + speed + "km");
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public int getSpeed() {
        return speed;
    }
    
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    public int getGear() {
        return gear;
    }
    
    public void setGear(int gear) {
        this.gear = gear;
    }
    
    public static int getNumberofCars() {
        return numberofCars;
    }
    
    public car() {
        super();
        carid = ++numberofCars;
    }
    
    public car(String color, int speed, int gear) {
        super();
        this.color = color;
        this.speed = speed;
        this.gear = gear;
        carid = ++numberofCars;
    }
    
    @Override
    public String toString() {
        return "car [color=" + color + ", speed=" + speed + ", gear=" + gear
                + "]";
    }
    
    // getter & setter
    
    // constructor(생성자)
    
    // toString()
    
}
