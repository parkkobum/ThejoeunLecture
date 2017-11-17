package java99.library;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IServiceRent extends IRent {
    
    //추가되는 메서드. Service 레이어에서만 사용되는 메서드.
    
    public int transCommit(ModelRent b1, ModelRent b2);
    public int TransRollback(ModelRent b1, ModelRent b2);
    ResultSet selectLike(ModelRent rent) throws SQLException;
    
}
