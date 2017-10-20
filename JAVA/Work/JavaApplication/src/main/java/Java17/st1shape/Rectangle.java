package Java17.st1shape;

public class Rectangle extends Shape {
    
    protected int width;
    protected int height;
    
    public Shape getShape() {
        return null;
        
    }
    
    public void draw() {
        System.out.println("Rectangle.Draw()");
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle [width=" + width + ", height=" + height
                + ", toString()=" + super.toString() + "]";
    }

    public Rectangle() {
        super();
        System.out.println("Rectangle()");
    }

    public Rectangle(String color, int x, int y) {
        super(color, x, y);
        // TODO Auto-generated constructor stub
    }

    public Rectangle(String color, int x, int y, int width, int height) {
        super(color, x, y);
        this.width = width;
        this.height = height;
    }
    
    
    
}
