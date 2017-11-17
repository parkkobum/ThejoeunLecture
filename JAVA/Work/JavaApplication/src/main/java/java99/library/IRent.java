package java99.library;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IRent {
    
    int getCount(ModelRent rent) throws SQLException;    
    int getMaxRentid() throws SQLException;
    
    ResultSet selectAll() throws SQLException;    
    ResultSet selectLike(String rentname) throws SQLException;    
    ResultSet selectEqual(ModelRent rent) throws SQLException;    
    ResultSet selectDynamic(ModelRent rent) throws SQLException;
    ResultSet selectRent() throws SQLException;
    
    int insertRent(ModelRent rent) throws SQLException;    
    int updateRent(ModelRent whererent, ModelRent setrent) throws SQLException;    
    int deleteRent(ModelRent rent) throws SQLException;
    
}
