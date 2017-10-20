package java14.st7student;

public class GraduateStudentTest {
    
    public static void main(String[] args) {
        
        GraduateStudent s1 = new GraduateStudent(1, "KOBUM", "01024678304", "lab1");

        System.out.println(s1);
        
        System.out.println("number : "+s1.getNumber()+"\n name : "+
                           s1.getName()+"\n phone : "+s1.phone+"\n lab :"+s1.lab);

        GraduateStudent s2 = new GraduateStudent();
        s2.setLab("lab1");
        s2.setName("KB");
        s2.setNumber(2);
        s2.setPhone("01024777777");
        System.out.println(s2);
        
        System.out.println("number : "+s2.getNumber()+"\n name : "+
                           s2.getName()+"\n phone : "+s2.phone+"\n lab :"+s2.lab);
   
        GraduateStudent s3 = new GraduateStudent();
        s3.lab = "lab3";
        s3.name = "WOORI";
        s3.phone = "01099999876";
        s3.setNumber(3);
        
        System.out.println(s3);
        
        System.out.println("number : "+s3.getNumber()+"\n name : "+
                           s3.getName()+"\n phone : "+s3.phone+"\n lab :"+s3.lab);
 
        
        
        
    }
    

    
    
}
