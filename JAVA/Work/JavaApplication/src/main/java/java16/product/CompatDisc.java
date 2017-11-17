package java16.product;

public class CompatDisc extends Product {
    
    private String 앨범제목;
    private String 가수이름;
    public String get앨범제목() {
        return 앨범제목;
    }
    public void set앨범제목(String 앨범제목) {
        this.앨범제목 = 앨범제목;
    }
    public String get가수이름() {
        return 가수이름;
    }
    public void set가수이름(String 가수이름) {
        this.가수이름 = 가수이름;
    }
    @Override
    public String toString() {
        return "CompatDisc [앨범제목=" + 앨범제목 + ", 가수이름=" + 가수이름 + ", toString()="
                + super.toString() + "]";
    }
    public CompatDisc() {
        super();
        // TODO Auto-generated constructor stub
    }
    public CompatDisc(int 고유식별자, String 상품설명, String 생산자, int 가격) {
        super(고유식별자, 상품설명, 생산자, 가격);
        // TODO Auto-generated constructor stub
    }
    public CompatDisc(int 고유식별자, String 상품설명, String 생산자, int 가격, String 앨범제목,
            String 가수이름) {
        super(고유식별자, 상품설명, 생산자, 가격);
        this.앨범제목 = 앨범제목;
        this.가수이름 = 가수이름;
    }
    
    public void print(int i) {
        System.out.println("상품ID>>" + i);
        System.out.println("상품 설명>>" + this.get상품설명());
        System.out.println("생산자>>" + this.get생산자());
        System.out.println("가격>>" + this.get가격());
        System.out.println("앨범 제목>>" + this.get앨범제목());
        System.out.println("가수>>" + this.get가수이름());
    }
    
    
}
