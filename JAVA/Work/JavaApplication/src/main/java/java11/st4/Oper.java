package java11.st4;

public class Oper {
    
    public Oper() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    double Div(int x, int y) {
        double div = 0;
        try {
            div = (double) x / y;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return div;
    }
    
    int Minus(int x, int y) {
        return x - y;
    }
    
    int Mul(int x, int y) {
        return x * y;
    }
    
    int Add(int x, int y) {
        return x + y;
    }
    
}
