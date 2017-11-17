package java23.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IServiceAuth extends IAuth {
    
    //추가되는 메서드. Service 레이어에서만 사용되는 메서드.
    
    public int transCommit(ModelAuth a1, ModelAuth a2);
    public int TransRollback(ModelAuth a1, ModelAuth a2);
    ResultSet selectLike(ModelAuth auth) throws SQLException;
    
}
