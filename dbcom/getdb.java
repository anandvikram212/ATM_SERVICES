package dbcom;
import java.sql.*;
public class getdb {

	static String driver="com.ibm.db2.jcc.DB2Driver";
	static Connection cn=null;
	static String url="jdbc:db2://localhost:50000/mydata";
	static String user="vikram123";
	static String pass="windows10";
	public static Connection getCn(){
		try{
			Class.forName(driver);
			cn=DriverManager.getConnection(url,user,pass);
		}catch(Exception e){
			e.printStackTrace();
		}
		return cn;
	}
}
