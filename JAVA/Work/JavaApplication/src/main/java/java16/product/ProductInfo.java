package java16.product;

import java.util.Scanner;

public class ProductInfo {
    
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);
        
        Product[] p = new Product[10];
        int addPrint = 0;
        int type = 0;
        Product.고유식별자 = 0;
        String 설명 = "";
        String 생산자 = "";
        int 가격 = 0;
        String 언어 = "";
        String isbn = "";
        String 저자 = "";
        String 책제목 = "";
        String 앨범제목 = "";
        String 가수 = "";
        
        for (;;) {
            System.out.print("상품 추가<1>, 모든 상품 조회<2>, 끝내기<3>>>");
            addPrint = keyboard.nextInt();
            
            if (addPrint == 1) {
                
                System.out.print("상품 종류 책<1>, 음악CD<2>, 회화책<3>>>");
                type = keyboard.nextInt();
                if (type < 1 || type > 3) {
                    System.out.println("다시 입력하세요.");
                    continue;
                }
                if (Product.고유식별자 >= 9) {
                    System.out.println("더이상 입력할 수 없습니다.");
                    continue;
                }
                System.out.print("상품 설명>>");
                설명 = keyboard.next();
                System.out.print("생산자>>");
                생산자 = keyboard.next();
                System.out.print("가격>>");
                가격 = keyboard.nextInt();
                if (type == 1 || type == 3) {
                    System.out.print("책 제목>>");
                    책제목 = keyboard.next();
                    System.out.print("저자>>");
                    저자 = keyboard.next();
                    System.out.print("ISBN>>");
                    isbn = keyboard.next();
                    if (type == 1) {
                        p[Product.고유식별자] = new Book(Product.고유식별자, 설명, 생산자, 가격,
                                isbn, 저자, 책제목);
                    } else {
                        System.out.print("언어>>");
                        언어 = keyboard.next();
                        p[Product.고유식별자] = new ConversationBook(Product.고유식별자,
                                설명, 생산자, 가격, isbn, 저자, 책제목, 언어);
                    }
                    
                } else if (type == 2) {
                    System.out.print("앨범제목>>");
                    앨범제목 = keyboard.next();
                    System.out.print("가수>>");
                    가수 = keyboard.next();
                    p[Product.고유식별자] = new CompatDisc(Product.고유식별자, 설명, 생산자,
                            가격, 앨범제목, 가수);
                }
                Product.고유식별자++;
            } else if (addPrint == 2) {
                System.out.println("고유식별자:" + Product.고유식별자);
                for (int i = 0; i < Product.고유식별자; i++) {
                    p[i].print(i);
                }
            } else {
                break;
            }
            
        }
    }
    
}
