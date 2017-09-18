package java02;

public class ex_02_01_면적구하기 {
    
    public static void main(String[] args) {
        
        double w = 10.0;
        double h = 5.0;
        double area = 0, perimeter = 0;
        
        area = w * h;
        perimeter = 2 * ( w + h );
        
        System.out.println("사각형의 넓이: " + area);
        System.out.println("사각형의 둘레: " + perimeter);
        
    }
    
}
