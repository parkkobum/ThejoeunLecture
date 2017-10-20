package java14.st11pattern;

public class Point {
    
    private int x;
    private int y;
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
    @Override
    public String toString() {
        return "Point [x=" + x + ", y=" + y + ", toString()=" + super.toString()
                + "]";
    }
    public Point(int x, int y) {
        super();
        this.x = x;
        this.y = y;
        System.out.println("Point()");

    }
    public Point() {
        super();
        System.out.println("Point()");
    }
    
    
    
}
