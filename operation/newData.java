package operation;
import dbcom.*;
import java.sql.*;
public class newData {

	public static void main(String[] args) {
       try {
    	/*String sql="insert into mytable values(?,?,?,?)";
		PreparedStatement ps = getdb.getCn().prepareStatement(sql);
		ps.setString(1,"8");
		ps.setString(2,"aman");
		ps.setString(3,"dehri");
		ps.setString(4,"12345678");
		ps.execute();
		System.out.println("insertion successful");
	*/
    /*	String sql1="delete from mytable where sid=?";
   		PreparedStatement ps1 = getdb.getCn().prepareStatement(sql1);
   		ps1.setString(1,"11");
   		ps1.execute();
   		System.out.println("deletion successful");	
   		*/
   	/*
		String sql2="update mytable set sid=? where sname=?";
		PreparedStatement ps2 = getdb.getCn().prepareStatement(sql2);
		ps2.setString(1,"11");
		ps2.setString(2,"aman");
		ps2.execute();
		System.out.println("update successful");
		*/
    	/*String sql3="select * from mytable where sid=?";
   		PreparedStatement ps3 = getdb.getCn().prepareStatement(sql3);
   		ResultSet rs1=ps3.executeQuery();
   		ps3.setString(1,"1");
   		ps3.executeQuery();
   		if(rs1.next()){
   		   System.out.println(" "+rs1.getString(1)+" "+rs1.getString(2));
   		}
   		else{
   			System.out.println("name not found");
   		}*/
    	   String sql4="select * from mytable";//where id=?
     		PreparedStatement ps4 = getdb.getCn().prepareStatement(sql4);
     		//ps4.setString(1,id); //for individual execution add "where id=? in the sql  
     		ResultSet rs1 =ps4.executeQuery();
    	   while(rs1.next()){
    	     System.out.println(rs1.getString(1)+" "+rs1.getString(2)+" "+rs1.getString(3)+" "+rs1.getString(4));}   
	} catch (SQLException e) {
		e.printStackTrace();
	} 


	}

}
