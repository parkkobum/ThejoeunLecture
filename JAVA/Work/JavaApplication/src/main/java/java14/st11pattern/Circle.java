package java14.st11pattern;

public class Circle extends Shape {
    
    private int radius;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle [radius=" + radius + ", color=" + color + ", pt=" + pt
                + ", toString()=" + super.toString() + "]";
    }

    public Circle(int radius) {
        super();
        this.radius = radius;
        System.out.println("Circle()");
    }

    public Circle(String color, Point pt) {
        super(color, pt);
        System.out.println("Circle()");    }

    public Circle() {
        super();
        System.out.println("Circle()");    }

    public Circle(String color, Point pt, int radius) {
        super(color, pt);
        this.radius = radius;
        
        System.out.println("Circle()");
        
    }
    
    
    
    
}
