package operation;
import dbcom.*;
import java.sql.*;
import java.util.*;

public class Update_rec_id {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String sql="select sname,sid from mytable where sid=?";
		String sql1="update mytable set saddr=?,sph=? where sid=?";
		String sid=null;
		String saddr=null;
		String sph=null;
		System.out.println("enter id");
		sid=s.next();
		try{
			Connection cn=getdb.getCn();
			PreparedStatement ps=cn.prepareStatement(sql);
			ps.setString(1, sid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
			 String name=rs.getString(1);
			 String id=rs.getString(2);
			 System.out.println("Hello "+name);
			 System.out.println("old record ");
			 System.out.println("======");
			 PreparedStatement ps3 = cn.prepareStatement("select saddr,sph from mytable where  sid=?" );
				ps3.setString(1, id);
		ResultSet rs2=ps3.executeQuery();
		if(rs2.next()){
			System.out.println(rs2.getString(1)+" "+rs2.getString(2));
		}
			 System.out.println("Enter new Address");
			 saddr=s.next();
			 System.out.println("Enter new Phone number");
			 sph=s.next();
			 PreparedStatement ps1=cn.prepareStatement(sql1);
				ps1.setString(1, saddr);
				ps1.setString(2, sph);
				ps1.setString(3, id);
				ps1.execute();
				System.out.println("Updated....");
				PreparedStatement ps2 = cn.prepareStatement("select * from mytable where  sid=?" );
				ps2.setString(1, id);
		ResultSet rs1=ps2.executeQuery();
				System.out.println("udated record");
				System.out.println("======");
				if(rs1.next()){
					System.out.println(rs1.getString(1)+" "+rs1.getString(2)+" "+rs1.getString(3)+" "+rs1.getString(4));	
				}
			}
			else{
				System.out.println("no id found");
			
		}
		}catch(Exception e){
			System.out.println("not working....");
		}
	
		}
	}

