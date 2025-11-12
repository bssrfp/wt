import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdatbleEx {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","admin");
			Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=st.executeQuery("select * from students");
			System.out.println("First record");
			rs.first();
			System.out.println("ID:"+rs.getInt("id"));
			System.out.println("Last record");
			rs.last();
			System.out.println("ID:"+rs.getInt("id"));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
