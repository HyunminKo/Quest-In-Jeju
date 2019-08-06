import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class Test01 {
	public static void main(String[] args) throws Exception {
		
	    try{
            Class.forName("com.mysql.jdbc.Driver");
            
        }catch (ClassNotFoundException e) {e.printStackTrace();}
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://35.237.65.93:3306/test","HR","HR12345678");
			System.out.println(conn);
			Statement stmt = conn.createStatement();
			
			String sql = "select * from study_t";
			ResultSet rs = stmt.executeQuery(sql);
			
			rs.next();
			System.out.println(rs.getInt("no"));
			System.out.println(rs.getString("text"));
			stmt.close();
			conn.close();
		
	}
}
