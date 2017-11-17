package java19.st3studentmap;

import java.util.HashMap;
import java.util.Map;

public class TestStudent {
    
    public static void main(String[] args) {
        // HashMap 인스턴스 생성
        
        // map에 추가
        // key  --> val
        // 
        Map<String, Student> map = null;
        
        map = new HashMap<String, Student>();
        map.put("170101", new Student(170101, "구준표"));
        map.put("170102", new Student(170102, "금잔디"));
        map.put("170103", new Student(170103, "윤지후"));
        
        System.out.println("for문으로 Map 출력하기");
        for( Map.Entry<String, Student> elem : map.entrySet() ){
            System.out.println( elem.getKey()+ ", " +elem.getValue().getNumber() +":"+elem.getValue().getName() );
        }
        System.out.println();
        
        map.remove("170102");
        
        System.out.println("for문으로 Map 출력하기 - 삭제후");
        for( Map.Entry<String, Student> elem : map.entrySet() ){
            System.out.println( elem.getKey()+ ", " +elem.getValue().getNumber() +":"+elem.getValue().getName() );
        }
        System.out.println();
        
        map.replace("170103", new Student(170103, "윤후"));
        
        System.out.println("for문으로 Map 출력하기 - 변경후");
        for( Map.Entry<String, Student> elem : map.entrySet() ){
            System.out.println( elem.getKey()+ ", " +elem.getValue().getNumber() +":"+elem.getValue().getName() );
        }
        System.out.println();
  
        
    }
    
}
