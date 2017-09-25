package java04;

public class jv04_03_삼각형출력 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i = i + 1) {
            System.out.println("**********");
        }
        System.out.println("---------------------------------");
        System.out.println("**********");
        System.out.println("**********");
        System.out.println("**********");
        System.out.println("**********");
        System.out.println("**********");
        System.out.println("-------중첩for문으로 변경 -------");
        for (int i = 1; i <= 10; i = i + 1) {
            for (int j = 1; j <= i; j = j + 1) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 1; i <= 10; i = i + 1) {
            for (int j = 1; j < i; j = j + 1) {
                System.out.print(" ");
            }
            for (int k = 11 - i; k >= 1; k = k - 1) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 1; i <= 10; i = i + 1) {
            for (int j = 11 - i; j > 1; j = j - 1) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
