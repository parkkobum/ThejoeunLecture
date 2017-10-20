package Java17.st1shape;

public class Circle extends Shape {
    
    private int radius;
    
    @Override
    public Shape getShape() {
        return null;
        
    }
    @Override
    public void draw() {
        System.out.println("Circle.Draw()");
        
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle [radius=" + radius + ", toString()=" + super.toString()
                + "]";
    }

    public Circle(String color, int x, int y, int radius) {
        super(color, x, y);
        this.radius = radius;
    }

    public Circle() {
        super();
        System.out.println("Circle()");

    }

    public Circle(String color, int x, int y) {
        super(color, x, y);
        // TODO Auto-generated constructor stub
    }
    
    
    
}
