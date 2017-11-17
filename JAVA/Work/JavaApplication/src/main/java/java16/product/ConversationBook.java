package java16.product;

public class ConversationBook extends Book {
    
    private String 언어;

    public String get언어() {
        return 언어;
    }

    public void set언어(String 언어) {
        this.언어 = 언어;
    }

    public ConversationBook() {
        super();
        // TODO Auto-generated constructor stub
    }

    public ConversationBook(int 고유식별자, String 상품설명, String 생산자, int 가격,
            String iSBN번호, String 저자, String 책제목, String 언어) {
        super(고유식별자, 상품설명, 생산자, 가격, iSBN번호, 저자, 책제목);
        this.언어 = 언어;
    }
    
    public void print(int i) {
        System.out.println("상품ID>>" + i);
        System.out.println("상품 설명>>" + this.get상품설명());
        System.out.println("생산자>>" + this.get생산자());
        System.out.println("가격>>" + this.get가격());
        System.out.println("ISBN>>" + this.getISBN번호());
        System.out.println("책 제목>>" + this.get책제목());
        System.out.println("저자>>" + this.get저자());
        System.out.println("언어>>" + this.get언어());
    }
    
    
    
}
