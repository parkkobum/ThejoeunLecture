package java14.st8animal;

public class AnimalTest {
    
    public static void main(String[] args) {
        
        Animal animal = new Animal();
        Dog    doggy = new Dog();
        Cat    catty = new Cat();
        
        animal.sleep();
        animal.eat();
        
        doggy.bark();
        doggy.eat();
        doggy.sleep();
        
        catty.eat();
        catty.sleep();
        catty.play();
        
    }
    
}
