package ATMCARD;

import java.util.*;

public class Password {
    public int password(String pin,int balance){
    	System.out.println("[[ ENTER YOUR PIN NUMBER ]]");
    	Scanner s=new Scanner(System.in);
    	String pn=s.next();
    	if(pn.equals(pin)){
    		System.out.println("1. [[  BALANCE ENQUIRY ]]                   2. [[   CASH  WITHDRAWAL  ]]");
    		System.out.println("3. [[    PIN CHANGE    ]]                   4. [[   FUND   TRANSFER   ]]");
    		int choose =s.nextInt();
    		if(choose==1||choose==2||choose==3||choose==4){
    		   return choose;
    		   
    		}
    		else{
    			System.out.println("  invalid option !!");
    			return 0;
    		}
    	    	}
    	else {
    		System.out.println("[[  WRONG ATM-PIN ]]   TRY AGAIN LATER!!!");
    		return 0;
    	}
    }
}
