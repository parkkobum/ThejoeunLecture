package java99.library;

public class ModelCustomer {
    
    private Integer cid       = null; // manid int not null auto_increment primary key
    private String  name      = "";   // name     varchar(50)
    private String  minBun    = "";   // minBun    varchar(40)
    private String  phoneNum  = "";   // phoneNum varchar(10)
    private String  email     = "";   // email varchar(20)
    
    public Integer getCid() {
        return cid;
    }
    public void setCid(Integer cid) {
        this.cid = cid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMinBun() {
        return minBun;
    }
    public void setMinBun(String minBun) {
        this.minBun = minBun;
    }
    public String getPhoneNum() {
        return phoneNum;
    }
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString() {
        return "ModelCustomer [cid=" + cid + ", name=" + name + ", minBun="
                + minBun + ", phoneNum=" + phoneNum + ", email=" + email + "]";
    }
    
    public ModelCustomer(Integer cid, String name, String minBun, String phoneNum,
            String email) {
        super();
        this.cid = cid;
        this.name = name;
        this.minBun = minBun;
        this.phoneNum = phoneNum;
        this.email = email;
    }
    public ModelCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
 
    
    
}
