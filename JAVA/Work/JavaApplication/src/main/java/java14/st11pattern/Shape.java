package java14.st11pattern;

public class Shape {
    
    protected String color;
    protected Point  pt;
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public Point getPt() {
        return pt;
    }
    public void setPt(Point pt) {
        this.pt = pt;
    }
    @Override
    public String toString() {
        return "Shape [color=" + color + ", pt=" + pt + ", toString()="
                + super.toString() + "]";
    }
    public Shape(String color, Point pt) {
        super();
        this.color = color;
        this.pt = pt;
        System.out.println("Shape()");

    }
    public Shape() {
        super();
        System.out.println("Shape()");
    }
    
    
}
