package java14.st3car;

public class Car {
    private int    speed;
    private int    gear;
    private String color;
    
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
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    @Override
    public String toString() {
        return "Car [speed=" + speed + ", gear=" + gear + ", color=" + color
                + "]";
    }
    
    public Car() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public Car(int speed, int gear, String color) {
        super();
        this.speed = speed;
        this.gear = gear;
        this.color = color;
    }
    
    public void speedUp(int s) {
        this.speed = this.speed + s;
    }
    
    public void speedDown(int s) {
        this.speed = this.speed - s;
    }

    public Car(String color) {
        super();
        this.color = color;
    }
    
    
    
}
