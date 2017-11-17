package test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Random random = new Random();
        Date   date = new Date();
        //1.
        System.out.println(random.nextInt(100));
        //2.
        String phoneNum = "082-2-777-5566";
        String[] arr = phoneNum.split("-");
        for(int i=0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }
        //3.
        System.out.println(date.toLocaleString());
        //4.
        for(int i= 0; i<=90; i=i+5) {
            System.out.println(Math.sin(i));
        }
        //5.
        System.out.println(random.nextInt(9)+1);
        //6.
        String sentense = "By doubting we come at the truth";
        String[] word = sentense.split(" ");
        for(int i=0; i<word.length; i++) {
            System.out.println(word[i]);
        }
        //7.
        Calendar cal = Calendar.getInstance();
        cal.set(2017, 10, 22);
        //8.
        double[] darray = {2.1, 4.5, 3.2};
        Arrays.sort(darray);
        
        
    }
    
}
