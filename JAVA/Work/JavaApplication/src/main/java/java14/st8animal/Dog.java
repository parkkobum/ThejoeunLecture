package java14.st8animal;

public class Dog extends Animal{
    
    public void bark() {
        System.out.println("Bow!!");

    }
    
    @Override
    public void eat() {
        System.out.println("코로 먹는다.");
    }
    
    
    public void eat(String food) {
        System.out.println("코로 먹는다.");
    }
    
    public int eat() {
        System.out.println("Yammy!!");
        return 0;

    }
    
}
