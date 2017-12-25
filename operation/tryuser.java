package operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import dbcom.getdb;

class Password{
	Scanner s=new Scanner(System.in);
	String choose="";
	public void password(String pas,String emd,String pn){
	    
	    System.out.println("ENTER PASSWORD: ");
	    String pass1=s.next();
	    if(pass1.equals(pas)){
	    	System.out.println("[  YOU HAVE SUCCESSFULLY LOGGEDIN....... ]");
	    }
	    else{
	    	System.out.println("Incorrect UserName/password combination!!");
	    	System.out.println("FORGOT PASSWORD ??");
	    	System.out.println();
	    	System.out.println("Reset Password: ??[yes/no]");
	    	choose =s.next();
	    	if(choose.equals("yes")||choose.equals("YES")||choose.equals("Yes")||choose.equals("y")||choose.equals("Y")){
	    		System.out.println("Enter your Phone-Number OR Email-ID");
	    	  try {
				Proof(pn,emd);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    	}
	    	else if(choose.equals("no")||choose.equals("No")||choose.equals("NO")||choose.equals("n")||choose.equals("N")){
	    		System.out.println("[  PLEASE LOGIN AFTER SOMETIME!!!  ]");
	    	}
	    	
	    	
	    }
	}
	public void Proof(String pn,String emd) throws SQLException {
		String getproof ="";
		 getproof=s.next();
		if(getproof.equals(pn)||getproof.equals(emd)){
			
			Connection cn=getdb.getCn();
			
			String sql1="update LoginTable set Password= ? where Phonenumber= ?";
			PreparedStatement ps1=cn.prepareStatement(sql1);
			System.out.println("Enter NEW Password");
			String newpass=s.next();
			ps1.setString(1,newpass);
			ps1.setString(2, pn);
			ps1.execute();
			System.out.print("[ PASSWORD UPDATE COMPLETE ]");
		}
		else{
			System.out.println("PHONE-NUMBER/EMAIL-ID didnt match!!!     [ NOT ALLOWED ]");
		}
		
	}
	
}
public class tryuser {

	public static void main(String[] args) {
		
		int i=0;
		
		try{
			Scanner s=new Scanner(System.in);
			Connection cn=getdb.getCn();//GetCn
			System.out.println();
			System.out.println("[[   ALREADY A USER ?  ]]");
			System.out.println();
			System.out.println("[Yes/No]");
			String a=s.next();
			if(a.equals("no")||a.equals("NO")||a.equals("No")||a.equals("n")||a.equals("N")){
			System.out.println("Create New Account ");
			String sql="insert into LoginTable values(?,?,?,?)";//   "?" is parameter index
			System.out.println("ENTER UserName: ");
			String uid=s.next();
			System.out.println("ENTER password: ");
			String pass=s.next();
			System.out.println("ENTER Email-Id: ");
			String email=s.next();
			System.out.println("ENTER your Phone-Number: ");
			String phn=s.next();
			PreparedStatement ps=cn.prepareStatement(sql);
			ps.setString(1, uid);
			ps.setString(2, pass);
			ps.setString(3, email);
			ps.setString(4, phn);
			ps.execute();
			System.out.println("[ YOU HAVE SUCCESSFULLY CREATED A NEW ACCOUNT ]");
			}
			else{
				String us="",email="",phone="",user="",pass="";
				System.out.println("ENTER USERNAME: ");
				user=s.next();
				PreparedStatement ps= null;
				
				
				String sql="select UserName,Password,EmailId,PhoneNumber from LoginTable where UserName=?";
				ps =  cn.prepareStatement(sql);
				ps.setString(1, user);
				ResultSet rs=ps.executeQuery();
				if(rs.next()){
				     us=rs.getString(1);
					 pass=rs.getString(2);
					 email=rs.getString(3);
					 phone=rs.getString(4);
					Password pss=new Password();
					pss.password(pass,email,phone);
				}
				else{
					System.out.println("[ USERNAME DOES NOT EXIST ]");
				}
				
			}
		}catch(Exception e){
				e.printStackTrace();
			}
			
	}

}
