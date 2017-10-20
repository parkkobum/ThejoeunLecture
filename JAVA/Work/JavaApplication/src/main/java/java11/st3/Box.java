package java11.st3;

public class Box {
    
    private int width;
    private int length;
    private int height;
    
    int getVolumn() {
        return width * length * height;
    }
    
    
    
    public int getWidth() {
        return width;
    }



    public void setWidth(int width) {
        this.width = width;
    }



    public int getLength() {
        return length;
    }



    public void setLength(int length) {
        this.length = length;
    }



    public int getHeight() {
        return height;
    }



    public void setHeight(int height) {
        this.height = height;
    }

    public Box() {
        super();
    }

    public Box(int width, int length, int height) {
        super();
        this.width = width;
        this.length = length;
        this.height = height;
    }



    @Override
    public String toString() {
        return "Box [width=" + width + ", length=" + length + ", height="
                + height + "]";
    }

    void printVolumn() {
        int volumn = getVolumn();
        System.out.println(volumn);
    }
}
