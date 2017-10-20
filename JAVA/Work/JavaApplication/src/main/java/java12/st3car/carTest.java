package java12.st3car;

public class carTest {
    
    public static void main(String[] args) {
        
        car myCar = new car();
        myCar.speedUp(100);
        myCar.speedPrint();
        System.out.println(myCar.toString());
        System.out.println("numberofCars : " + myCar.getNumberofCars());
        
        // car yourCar = new car("blue", 60,3);
        car yourCar = new car();
        yourCar.setColor("blue");
        yourCar.setGear(3);
        yourCar.setSpeed(60);
        System.out.println(yourCar.toString());
        System.out.println("numberofCars : " + yourCar.getNumberofCars());
        
        car otherCar = new car("blue", 60, 3);
        System.out.println(otherCar.toString());
        System.out.println("numberofCars : " + otherCar.getNumberofCars());
        

        System.out.println("------------------------------");
        System.out.println("numberofCars : " + myCar.getNumberofCars());

        System.out.println("numberofCars : " + yourCar.getNumberofCars());

        System.out.println("numberofCars : " + otherCar.getNumberofCars());

        System.out.println("------------------------------");
        System.out.println(car.getNumberofCars());
        
    }
    
}
