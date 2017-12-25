package ATMCARD;
import java.sql.*;
import java.util.Scanner;
import dbcom.getdb;
class cashwithdrawal{
	Scanner s=new Scanner(System.in);
	public int cash(int hbal) {
		System.out.println("[[ ENTER THE AMOUNT IN MULTIPLES OF 100 ]]");
		int opt=s.nextInt();
		return (hbal-opt);
	}
	public int transfer(int hbal,int amnt) {
		
		return (hbal-amnt);
	}
}
public class atm_withdrawal {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
        int i=0;
        String uid="",hname="",hpin="";
        int hbal=0;
        try{
			
			Connection cn=getdb.getCn();//GetCn
			System.out.println();
			System.out.println();
			System.out.println("[[   WELCOME TO SBI ATM-SERVICE  ]]");
			System.out.println();
			System.out.println("[[ PLEASE INSERT YOUR ATM-CARD-NUMBER ]]");//ATMCARDNUMBER IN CASE OF CARDNUMBER
		    uid =s.next();
		    PreparedStatement ps=cn.prepareStatement("select * from atmdata where id=?");
		    ps.setString(1, uid);
		    ResultSet rs=ps.executeQuery();
			if(rs.next()){
				 hname=rs.getString(2);
				 hpin=rs.getString(3);
				 hbal=rs.getInt(4);
				 System.out.println("[[  Hello MR."+hname+" ]]");
				 Password pss=new Password();
				 int option = pss.password(hpin,hbal);
				if(option==1){
				 System.out.println("[[  your current account balance is  "+hbal+"  ]]");
				 return;
				}
				if(option==2){
				 cashwithdrawal cw = new cashwithdrawal(); 
				 int balance= cw.cash(hbal);
				 System.out.println("[[ YOU HAVE WITHDRAWN RS."+(hbal-balance)+" FROM YOUR ACCOUNT ]]");
				 System.out.println(" [[ THANKYOU FOR USING CASH-WITHRADRAWAL SERVICE ]]");
				 System.out.println("[[ YOUR MAIN ACCOUNT BALANCE IS "+balance+" NOW ]]");
				 System.out.println(" ");
				 String sql2="update atmdata set balance=? where name=?";
					PreparedStatement ps2 = getdb.getCn().prepareStatement(sql2);
					ps2.setInt(1, balance);
					ps2.setString(2,hname);
					ps2.execute();
					System.out.println(" ");
					return;
				 }
				if(option==3){
					    System.out.println("ENTER OLD PASSWORD: ");
					    String pass1=s.next();
					    if(pass1.equals(hpin)){
					    	System.out.println("[ ENTER NEW PASSWORD ]");
					    	String newpin=s.next();
					    	 String sql3="update atmdata set pin=? where name=?";
								PreparedStatement ps2 = getdb.getCn().prepareStatement(sql3);
								ps2.setString(1, newpin);
								ps2.setString(2,hname);
								ps2.execute();
								System.out.println("[[  ATM-PIN CHANGED SUCCESSFULLY ]]");
								return;
					    }
					    else{
					    	System.out.println("[[   Incorrect ATM-PIN !!!! ]]");
					    	System.out.println();
					    	return;
					    	}
				}
				if(option==4){
				   System.out.println("[[ ENTER THE CARDNUMBER OF RECEIVER ]]");
				   String rname=s.next();
				   int  rbal=0;
				   PreparedStatement ps1=cn.prepareStatement("select * from atmdata where id=?");
				    ps1.setString(1, rname);
				    ResultSet rs2=ps1.executeQuery();
					if(rs2.next()){
						 rname=rs2.getString(2);
						 rbal=rs2.getInt(4);
						 System.out.println(" IS it MR."+rname+" ??");
						 System.out.println("  enter the amount to transfer ");
						 int amnt=s.nextInt();
						 cashwithdrawal cw = new cashwithdrawal(); 
						 int balan= cw.transfer(hbal,amnt);
						 String sql4="update atmdata set balance=? where name=?";
							PreparedStatement ps4 = getdb.getCn().prepareStatement(sql4);
							ps4.setInt(1, balan);
							ps4.setString(2,hname);
							ps4.execute();
							PreparedStatement ps5 = getdb.getCn().prepareStatement("update atmdata set balance=? where name=?");
							ps5.setInt(1, amnt+rbal);
							ps5.setString(2,rname);
							ps5.execute();
							System.out.println("[[YOU HAVE SUCCESSFULLY TRANSFERED AN AMOUNT OF RS. "+amnt+" INTO "+rname+"'s ACCOUNT  ]]");
				            return;
				            }
					else{
						System.out.println(" there is no such cardholder's account !!! please mention cardnumber carefully !!!");
					    return;
					    }
				}
			else{
				System.out.println("[ INVALID ATMCARD OR WRONG CARDNUMBER]");
				System.out.println("[[   try again aftersometime!!!! ]]]");
				return;
			}
			}
			else{
				System.out.println("[[ IDENTIFICATION FAILED!!!! PLEASE ENTER CORRECT CARDNUMBER ]]");
				return;
			}
		}catch(Exception e){
				e.printStackTrace();
			}
	}
}
