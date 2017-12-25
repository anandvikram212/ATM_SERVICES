package operation;
import dbcom.*;
import java.sql.*;
import java.util.Scanner;

public class delrec {

	public static void main(String[] args) {

		try{
			Scanner s=new Scanner(System.in);
			Connection cn=getdb.getCn();//GetCn
			String sql="update mytable set sid='2' where sname='ufxgh'";//   "?" is parameter index
			PreparedStatement ps=cn.prepareStatement(sql);
			String sql1="update mytable set sname='anand' where sid='2'";//   "?" is parameter index
			PreparedStatement ps1=cn.prepareStatement(sql1);
			ps.executeUpdate();
			ps1.executeUpdate();
			System.out.println("record updated");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
