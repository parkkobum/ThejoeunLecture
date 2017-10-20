package java12.st2date;

public class Date {
    
    private int year;
    private String month;
    private int day;
    
    public void setDate(int year, String month, int day) {
        
    }
    
    public void printDate() {
        
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "Date [year=" + year + ", month=" + month + ", day=" + day + "]";
    }

    public Date(int year, String month, int day) {
        super();
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public Date() {
        super();
        // TODO Auto-generated constructor stub
    }
    
}
