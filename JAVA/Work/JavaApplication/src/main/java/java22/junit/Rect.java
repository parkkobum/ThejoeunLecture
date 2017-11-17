package java22.junit;

public class Rect {
    
    private int w = 0;
    private int h = 0;
    
    int area() {
        return w * h;
    }
    
    int prerimeter() {
        return 2 * (w + h);
    }

    @Override
    public String toString() {
        return "Rect [w=" + w + ", h=" + h + "]";
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }


    public Rect() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Rect(int w, int h) {
        super();
        this.w = w;
        this.h = h;
    }
    
    public Object type() {
        return null;
    }
    
}
