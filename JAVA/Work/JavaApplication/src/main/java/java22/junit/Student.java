package java22.junit;

import java.util.Scanner;

public class Student {
    
    private static int grade;
    
    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    
    public Student(int grade) {
        super();
        this.grade = grade;
    }

    public static String getgrade(int grade) {      
        
        
        String result = "";
        if (grade > 100) {
            result = "F";
        } 
        else if (grade >= 90) {
            result = "A";
        } else if (grade >= 80) {
            result = "B";
        } else if (grade >= 70) {
            result = "C";
        } else if (grade >= 60) {
            result = "D";
        } else {
            result = "F";
        }
        
        return result;
    }
}
