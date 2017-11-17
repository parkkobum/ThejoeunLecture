package java99.library;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IServiceCustomer extends ICustomer {
    
    //추가되는 메서드. Service 레이어에서만 사용되는 메서드.
    
    public int transCommit(ModelCustomer c1, ModelCustomer c2);
    public int TransRollback(ModelCustomer c1, ModelCustomer c2);
    ResultSet selectLike(ModelCustomer customer) throws SQLException;
    
}
