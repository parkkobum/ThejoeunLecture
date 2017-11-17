package java18.Date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class jv18_05_Date {
    public static void main(String[] args) {
        Date date =null;
        date = new Date(114, 2, 18);
        System.out.println("Date( 114, 2, 18) >>" + date);
        
        date = new Date(114, 0, 18);
        System.out.println("Date( 114, 0, 18) >>" + date);
        
        date = new Date(114, 12, 18);
        System.out.println("Date( 114, 12, 18) >>" + date);
        
        Date from = new Date();
        
        SimpleDateFormat tf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fo2 = tf.format(from);
        System.out.println(fo2);
        
        tf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        fo2 = tf.format(from);
        System.out.println(fo2);
        
        tf = new SimpleDateFormat("dd HH");
        fo2 = tf.format(from);
        System.out.println(fo2);
        
        tf = new SimpleDateFormat("yyyy");
        fo2 = tf.format(from);
        System.out.println(fo2);
        
        tf = new SimpleDateFormat("MM");
        fo2 = tf.format(from);
        System.out.println(fo2);
        
        tf = new SimpleDateFormat("dd");
        fo2 = tf.format(from);
        System.out.println(fo2);
        
        tf = new SimpleDateFormat("HH");
        fo2 = tf.format(from);
        System.out.println(fo2);
        
        tf = new SimpleDateFormat("mm");
        fo2 = tf.format(from);
        System.out.println(fo2);
        
        tf = new SimpleDateFormat("ss");
        fo2 = tf.format(from);
        System.out.println(fo2);
        
        date = new Date();
        date.setYear(date.getYear()+3);
        date.setMonth(date.getMonth()-4);
        date.setDate(date.getDate()+2);
        tf = new SimpleDateFormat("yyyy-MM-dd");
        fo2 = tf.format(date);
        System.out.println(fo2);
        
        date.setHours(date.getHours()+4);
        date.setMinutes(date.getMinutes()-30);
        date.setSeconds(date.getSeconds()+10);
        tf = new SimpleDateFormat("HH:mm:ss");
        fo2 = tf.format(date);
        System.out.println(fo2);
        
    }
    
}
