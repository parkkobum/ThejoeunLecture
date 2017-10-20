package java16.product;

public class CoversationBook extends Book {
    
    private String 언어;

    public String get언어() {
        return 언어;
    }

    public void set언어(String 언어) {
        this.언어 = 언어;
    }

    public CoversationBook() {
        super();
        // TODO Auto-generated constructor stub
    }

    public CoversationBook(int 고유식별자, String 상품설명, String 생산자, int 가격,
            int iSBN번호, String 저자, String 책제목, String 언어) {
        super(고유식별자, 상품설명, 생산자, 가격, iSBN번호, 저자, 책제목);
        this.언어 = 언어;
    }
    
    
    
    
}
