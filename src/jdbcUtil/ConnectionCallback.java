package jdbcUtil;

import java.sql.Connection;

public interface ConnectionCallback<T> {
    public T doInConnection(Connection conn) throws Exception;
}
