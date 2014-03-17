import java.sql.*;
public class jdbc
{
	public static void main(String args[])
	{
		
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String username="system";
		String password="ashish";
		try{
		Connection con=null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection(url,username,password);
		}catch(Exception e){System.out.println("exception");}
	}
}