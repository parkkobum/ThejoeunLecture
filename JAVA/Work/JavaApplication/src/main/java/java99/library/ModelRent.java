package java99.library;

public class ModelRent {
    private Integer rentid    = null; // bookid int not null auto_increment primary key
    private Integer cid       = null;
    private Integer bid       = null;
    private String  bookname  = "";   // bookname varchar(50)
    private String  name      = "";   // bookname varchar(50)
    private String  rentdate  = "";   // publisher varchar(40)
    public Integer getRentid() {
        return rentid;
    }
    public void setRentid(Integer rentid) {
        this.rentid = rentid;
    }
    public Integer getCid() {
        return cid;
    }
    public void setCid(Integer cid) {
        this.cid = cid;
    }
    public Integer getBid() {
        return bid;
    }
    public void setBid(Integer bid) {
        this.bid = bid;
    }
    public String getBookname() {
        return bookname;
    }
    public void setBookname(String bookname) {
        this.bookname = bookname;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRentdate() {
        return rentdate;
    }
    public void setRentdate(String rentdate) {
        this.rentdate = rentdate;
    }
    @Override
    public String toString() {
        return "ModelRent [rentid=" + rentid + ", cid=" + cid + ", bid=" + bid
                + ", bookname=" + bookname + ", name=" + name + ", rentdate="
                + rentdate + "]";
    }
    public ModelRent(Integer rentid, Integer cid, Integer bid, String bookname,
            String name, String rentdate) {
        super();
        this.rentid = rentid;
        this.cid = cid;
        this.bid = bid;
        this.bookname = bookname;
        this.name = name;
        this.rentdate = rentdate;
    }
    public ModelRent() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    

}
