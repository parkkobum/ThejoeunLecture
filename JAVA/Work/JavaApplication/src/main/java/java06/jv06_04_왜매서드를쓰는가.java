package java06;

public class jv06_04_왜매서드를쓰는가 {
    public static void main(String[] args) {
        int sum = getsum();
        System.out.println(sum);
        int sum2 = 0;
        for (int i=0; i<=100; i++) {
            sum2=sum2+i;
        }
        System.out.println(sum2);
        int sum3 = 0;
        for (int i=100; i<=sum2; i++) {
            sum3=sum3+i;
        }
        System.out.println(sum3);
        
        
    }

    public static int getsum() {
        int sum = 0;
        for (int i=0; i<=10; i++) {
            sum=sum+i;
        }
        return sum;
    }
    
    
}
