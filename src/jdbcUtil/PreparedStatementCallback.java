package jdbcUtil;

import java.sql.PreparedStatement;

public interface PreparedStatementCallback<T> {
    public T doInStatement(PreparedStatement stmt) throws Exception;
}
