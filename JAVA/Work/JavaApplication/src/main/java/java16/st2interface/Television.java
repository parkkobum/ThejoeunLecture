package java16.st2interface;

public class Television implements RemoteControl, SerialCommunication {

    @Override
    public void turnOn() {
        System.out.println(this.getClass().getName());
        System.out.println("Television turn on!");
    }

    @Override
    public void turnOff() {
        System.out.println(this.getClass().getEnclosingMethod().getName());
        System.out.println("Television turn off!");
    }

    @Override
    public void moveLeft() {
        
    }

    @Override
    public void moveRight() {
        
    }

    @Override
    public void send() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void receive() {
        // TODO Auto-generated method stub
        
    }
    
    
    
    
}
