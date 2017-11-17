package java14.st4shape;

public class Shape {
    
    private int x = 0;
    private int y = 0;
    private String color = "";
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    @Override
    public String toString() {
        return "Shape [x=" + x + ", y=" + y + ", color=" + color + "]";
    }
    public Shape() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public Shape(int x, int y, String color) {
        super();
        this.x = x;
        this.y = y;
        this.color = color;
    }
    
    
    
}