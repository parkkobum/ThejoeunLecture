package java14.st2hasa;

public class CircleTest {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        Point p1 = new Point(25, 78);
        
        c1.setRadius(12);
        // c.setCenter(new Point(25,78));
        c1.setCenter(p1);
        System.out.println(c1);
        System.out.println(p1);
        
        Circle c2 = new Circle();
        c2.setRadius(10);
        p1 = new Point(25, 78);
        c2.setCenter(p1);
        
        Circle c3 = new Circle(10, new Point(25, 78));
        
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(c3.toString());

        
    }
    
}
