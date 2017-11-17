package java22.junit;

public class Oper {
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
        return "Oper [x=" + x + ", y=" + y + "]";
    }
    public Oper(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }
    public Oper() {
        super();
    }
    
    public int add() {
        return this.x + this.y;
    }
    public int minus() {
        return this.x - this.y;
    }
    public int mul() {
        return this.x * this.y;
    }
    public double div() {
        return (double)this.x / this.y;
    }
}
