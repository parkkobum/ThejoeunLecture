package java04;

public class ex04_14_for {
    
    public static void main(String[] args) {
        
        for (int j = 2; j <= 9; j = j + 1) {
            
            for (int i = 1; i <= 9; i = i + 1) {
                if (i != 9) {
                    System.out.print(j + " * " + i + " = " + i * j + ", ");
                } else {
                    System.out.print(j + " * " + i + " = " + i * j + ".\n");
                }
            }
        }
        
    }
}
