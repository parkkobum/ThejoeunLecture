package java14.st11pattern;

public class PatternTest {
    
    public static void main(String[] args) {
        
        Point pt = new Point(2, 4);
        
        Rectangle p1 = new Rectangle("blue", pt, 10, 10);
        Circle p2 = new Circle(10);
        
        System.out.println(p1);
        System.out.println(p2);
        
        String prov="abc defg ijklm nop qrs wx yz";
        
        int len = prov.length();

        System.out.println(prov.substring(4, 8));

        String nums="74 874 9883 73 9 73646 774";
        
        
        
    }
    
}
