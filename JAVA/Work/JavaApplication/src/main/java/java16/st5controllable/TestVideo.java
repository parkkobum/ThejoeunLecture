package java16.st5controllable;

public class TestVideo implements controllable {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        controllable VideoPlayer = new controllable() {
            
            @Override
            public void stop() {
                System.out.println("VideoPlayer stop()");
                
            }
            
            @Override
            public void play() {
                System.out.println("VideoPlayer play()");
                
            }
        };
        
        VideoPlayer.play();
        VideoPlayer.stop();
        
        
    }

    @Override
    public void play() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void stop() {
        // TODO Auto-generated method stub
        
    }
    
}
