package java99.library;

public class ModelBook {
    private Integer bookid    = null; // bookid int not null auto_increment primary key
    private String  bookname  = "";   // bookname varchar(50)
    private String  publisher = "";   // publisher varchar(40)
    private String  type      = "";   // type varchar(10)
    private String  writer    = "";   // writer varchar(20)
    private Integer price     = null; // price int
    private Boolean use_yn    = null; // use_yn bit
    
    public Integer getBookid() {
        return bookid;
    }
    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }
    public String getBookname() {
        return bookname;
    }
    public void setBookname(String bookname) {
        this.bookname = bookname;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getWriter() {
        return writer;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public Boolean getUse_yn() {
        return use_yn;
    }
    public void setUse_yn(Boolean use_yn) {
        this.use_yn = use_yn;
    }
    
    
    
    @Override
    public String toString() {
        return "ModelBook [bookid=" + bookid + ", bookname=" + bookname
                + ", publisher=" + publisher + ", type=" + type + ", writer="
                + writer + ", price=" + price + ", use_yn=" + use_yn + "]";
    }
    public ModelBook(Integer bookid, String bookname, String publisher, String type,
            String writer, Integer price, Boolean use_yn) {
        super();
        this.bookid = bookid;
        this.bookname = bookname;
        this.publisher = publisher;
        this.type = type;
        this.writer = writer;
        this.price = price;
        this.use_yn = use_yn;
    }
    public ModelBook() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    
    
}
