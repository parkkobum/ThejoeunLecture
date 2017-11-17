package java99.library;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ICustomer {
    
    int getCount(ModelCustomer customer) throws SQLException;    
    int getMaxCustomerid() throws SQLException;
    
    ResultSet selectAll() throws SQLException;    
    ResultSet selectLike(String customername) throws SQLException;    
    ResultSet selectEqual(ModelCustomer customer) throws SQLException;    
    ResultSet selectDynamic(ModelCustomer customer) throws SQLException;
    
    int insertCustomer(ModelCustomer customer) throws SQLException;    
    int updateCustomer(ModelCustomer whereCustomer, ModelCustomer setCustomer) throws SQLException;    
    int deleteCustomer(ModelCustomer customer) throws SQLException;
    
}
