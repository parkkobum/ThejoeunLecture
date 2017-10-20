package Java17.st1shape;

public class Triangle extends Shape {
    
    private int base;
    private int height;
    
    @Override
    public Shape getShape() {
        return null;
        
    }
    
    @Override
    public void draw() {
        System.out.println("Triangle.Draw()");
        
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Triangle [base=" + base + ", height=" + height + ", toString()="
                + super.toString() + "]";
    }

    public Triangle(String color, int x, int y, int base, int height) {
        super(color, x, y);
        this.base = base;
        this.height = height;
    }

    public Triangle() {
        super();
        System.out.println("Triangle.Draw()");
    }

    public Triangle(String color, int x, int y) {
        super(color, x, y);
        // TODO Auto-generated constructor stub
    }
    
    
    
    
}
