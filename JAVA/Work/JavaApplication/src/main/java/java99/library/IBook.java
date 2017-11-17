package java99.library;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IBook {
    
    int getCount(ModelBook book) throws SQLException;    
    int getMaxBookid() throws SQLException;
    
    ResultSet selectAll() throws SQLException;    
    ResultSet selectLike(String bookname) throws SQLException;    
    ResultSet selectEqual(ModelBook book) throws SQLException;    
    ResultSet selectDynamic(ModelBook book) throws SQLException;
    
    int insertBook(ModelBook book) throws SQLException;    
    int updateBook(ModelBook wherebook, ModelBook setbook) throws SQLException;    
    int deleteBook(ModelBook book) throws SQLException;
    
}
