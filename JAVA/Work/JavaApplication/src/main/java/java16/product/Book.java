package java16.product;

public class Book extends Product {
    
    private String ISBN번호;
    private String 저자;
    private String 책제목;
    public String getISBN번호() {
        return ISBN번호;
    }
    public void setISBN번호(String iSBN번호) {
        ISBN번호 = iSBN번호;
    }
    public String get저자() {
        return 저자;
    }
    public void set저자(String 저자) {
        this.저자 = 저자;
    }
    public String get책제목() {
        return 책제목;
    }
    public void set책제목(String 책제목) {
        this.책제목 = 책제목;
    }
    @Override
    public String toString() {
        return "Book [ISBN번호=" + ISBN번호 + ", 저자=" + 저자 + ", 책제목=" + 책제목
                + ", toString()=" + super.toString() + "]";
    }
    public Book(int 고유식별자, String 상품설명, String 생산자, int 가격, String iSBN번호,
            String 저자, String 책제목) {
        super(고유식별자, 상품설명, 생산자, 가격);
        ISBN번호 = iSBN번호;
        this.저자 = 저자;
        this.책제목 = 책제목;
    }
    public Book() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Book(int 고유식별자, String 상품설명, String 생산자, int 가격) {
        super(고유식별자, 상품설명, 생산자, 가격);
        // TODO Auto-generated constructor stub
    }
    
    public void print(int i) {
        System.out.println("상품ID>>" + i);
        System.out.println("상품 설명>>" + this.get상품설명());
        System.out.println("생산자>>" + this.get생산자());
        System.out.println("가격>>" + this.get가격());
        System.out.println("ISBN>>" + this.getISBN번호());
        System.out.println("책 제목>>" + this.get책제목());
        System.out.println("저자>>" + this.get저자());
    }
    
    
    
}
