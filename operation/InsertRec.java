package operation;

import dbcom.*;
import java.sql.*;
import java.util.*;
public class InsertRec {

	public static void main(String[] args) {
		
		try{
			Scanner s=new Scanner(System.in);
			Connection cn=getdb.getCn();//GetCn
			System.out.println("Enter NEW address");
			 String newaddr=s.next();
			String sql1="update mytable set saddr= ? where sid= ?";
			PreparedStatement ps1=cn.prepareStatement(sql1);
			ps1.setString(1, newaddr);
			ps1.setString(2,"1");
			System.out.print("password update complete");
			ps1.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
