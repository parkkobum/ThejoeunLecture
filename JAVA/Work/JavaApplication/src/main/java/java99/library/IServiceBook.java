package java99.library;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IServiceBook extends IBook {
    
    //추가되는 메서드. Service 레이어에서만 사용되는 메서드.
    
    public int transCommit(ModelBook b1, ModelBook b2);
    public int TransRollback(ModelBook b1, ModelBook b2);
    ResultSet selectLike(ModelBook book) throws SQLException;
    
}
