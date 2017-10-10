package java07;

public class jv07_01_배열의선언과생성 {
    
    public static void main(String[] args) {
        int [] numbers = new int[6];
        
        int size = 6;
        int [] numbers2 = new int[size];
        
        numbers2[0] = 0;
        numbers2[1] = 1;
        numbers2[2] = 2;
        numbers2[3] = 3;
        numbers2[4] = 4;
        numbers2[5] = 5;
        
        for (int j= 0; j < numbers.length; j++) {
            System.out.println(numbers2[j]);
        }
        
    }
    
}
