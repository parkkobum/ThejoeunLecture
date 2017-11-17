package 박고범;

public class Oper {
    private int firstNum;
    private int secondNum;
    
    public int getFirstNum() {
        return firstNum;
    }
    
    public void setFirstNum(int firstNum) {
        this.firstNum = firstNum;
    }
    
    public int getSecondNum() {
        return secondNum;
    }
    
    public void setSecondNum(int secondNum) {
        this.secondNum = secondNum;
    }
    
    @Override
    public String toString() {
        return "Oper [firstNum=" + firstNum + ", secondNum=" + secondNum + "]";
    }
    
    public Oper(int firstNum, int secondNum) {
        super();
        this.firstNum = firstNum;
        this.secondNum = secondNum;
    }
    
    public Oper() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public int add() {
        return firstNum + secondNum;
    }
    
    public int minus() {
        return firstNum - secondNum;
    }
    
    public int mul() {
        return firstNum * secondNum;
    }
    
    public double div() {
        return (double)firstNum / secondNum;
    }
    
}
