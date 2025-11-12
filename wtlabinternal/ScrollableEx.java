import java.sql.*;

public class ScrollableEx {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","admin");
			Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=st.executeQuery("select * from students");
			while(rs.next()) {
				System.out.println("Name:"+rs.getString("name"));
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
