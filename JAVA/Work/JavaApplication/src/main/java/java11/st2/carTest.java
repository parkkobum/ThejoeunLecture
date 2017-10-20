package java11.st2;

public class carTest {
    
    public static void main(String[] args) {
        
        car myCar = new car();
        myCar.speedUp(100);
        myCar.speedPrint();
        System.out.println(myCar.toString());
        
        
//      car yourCar = new car("blue", 60,3);
        car yourCar = new car();
        yourCar.setColor("blue");
        yourCar.setGear(3);
        yourCar.setSpeed(60);
        System.out.println(yourCar.toString());
        
    }
    
}
