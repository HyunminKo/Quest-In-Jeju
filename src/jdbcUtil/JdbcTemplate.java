package jdbcUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JdbcTemplate {
    static {
        try{
            Class.forName("oracle.jdbc.OracleDriver");
        }catch (ClassNotFoundException e) {e.printStackTrace();}
    }

    private Connection makeConn() throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","HR","HR");
        return conn;
    }
    public int update(String sql, Object ...args) throws Exception{
        int rc = 0;
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = makeConn();
            stmt = conn.prepareStatement(sql);

            for(int i = 0 ; i < args.length; i++){
                if(args[i] == null){
                    stmt.setObject(i+1,null);
                }else if (args[i] instanceof Integer){
                    stmt.setInt(i+1,((Integer)args[i]).intValue());
                }else if (args[i] instanceof Double){
                    stmt.setDouble(i+1,((Double)args[i]).doubleValue());
                }else if (args[i] instanceof String){
                    stmt.setString(i+1, (String)args[i]);
                }
            }
        }catch(Exception e){
            throw e;
        }finally {
            if(stmt!=null) stmt.close();
            if(conn!=null) conn.close();
        }
        return rc;
    }
    public <T> T queryForObject(String sql, RowMapper<T> rowMapper, Object...args) throws Exception {
        T vo = null;

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = makeConn();
            stmt = conn.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                if(args[i] == null){
                    stmt.setObject(i+1,null);
                }else if (args[i] instanceof Integer){
                    stmt.setInt(i+1,((Integer)args[i]).intValue());
                }else if (args[i] instanceof Double){
                    stmt.setDouble(i+1,((Double)args[i]).doubleValue());
                }else if (args[i] instanceof String){
                    stmt.setString(i+1, (String)args[i]);
                }
            }
            rs = stmt.executeQuery();

            if(rs.next()){
                vo = rowMapper.mapRow(rs);
                if(rs.next()){
                    throw new Exception("many records");
                }
            }else {
                throw new Exception("no record");
            }
        } catch(Exception e){
            throw e;
        }finally {
            if( rs != null) rs.close();
            if( stmt != null) stmt.close();
            if( conn != null) conn.close();
        }
        return vo;
    }
    //select * from ? , bangmyung_t
    public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object ... args) throws Exception {
        List<T> rl = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = makeConn();
            stmt = conn.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                if(args[i] == null){
                    stmt.setObject(i+1,null);
                }else if (args[i] instanceof Integer){
                    stmt.setInt(i+1,((Integer)args[i]).intValue());
                }else if (args[i] instanceof Double){
                    stmt.setDouble(i+1,((Double)args[i]).doubleValue());
                }else if (args[i] instanceof String){
                    stmt.setString(i+1, (String)args[i]);
                }
            }
            //select * from bangmyung_t;
            rs = stmt.executeQuery();

            while(rs.next()){
                T vo = rowMapper.mapRow(rs);
                rl.add(vo);
            }
        }catch (Exception e){
            throw e;
        }finally {
            if( rs != null) rs.close();
            if( stmt != null) stmt.close();
            if( conn != null) conn.close();
        }
        return rl;
    }
}
