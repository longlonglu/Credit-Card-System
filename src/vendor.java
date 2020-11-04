import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class vendor {
	public static void main(String[]args) throws SQLException, ClassNotFoundException {
	
	}
  public int charge(String cardNumber,double amount,String shopName,Calendar x) throws SQLException, ClassNotFoundException {
	  Calendar today = Calendar.getInstance();
	  String month;
	  String date;
	  String year = ""+today.get(today.YEAR);
	  if(today.get(today.MONTH)+1<=10)
		  month="0"+(today.get(today.MONTH)+1);
	  else
		  month=""+(today.get(today.MONTH)+1); 
	  
	  if(today.get(today.DATE)+Math.abs(today.get(today.MINUTE)-x.get(x.MINUTE))+1<=10)
		  date="0"+(today.get(today.DATE)+Math.abs(today.get(today.MINUTE)-x.get(x.MINUTE))/+1);
	  else {
		  System.out.println(1);
		  date=""+(today.get(today.DATE)+Math.abs(today.get(today.MINUTE)-x.get(x.MINUTE))/+1);
	  }
	  String inputDate=year+"-"+month+"-"+date+" 00:00:00";

	  String  edate;
	  Calendar exdate =  Calendar.getInstance();
	  double availableBalance;
	  double newBalance;
	 try { 
		 Class.forName("com.mysql.cj.jdbc.Driver");
	  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/credit_card_system?userTimezone=true&serverTimezone=UTC","root","wang87067835");
	  Statement statement =con.createStatement();
	  ResultSet data = statement.executeQuery("SELECT expireDate,remainCredit FROM credit_cards WHERE cardNumber='"+cardNumber+"'");
	  Statement s2=con.createStatement();

	  data.next();
	 
	  edate=data.getString("expireDate");
	 
	 exdate.set(Integer.parseInt(edate.substring(0,4)),Integer.parseInt(edate.substring(5, 7))-1
			 ,Integer.parseInt(edate.substring(8,10)));
	 if(today.before(exdate)) {
	  availableBalance=Double.parseDouble(data.getString("remainCredit"));
		  if(availableBalance<amount) {
			  return -1;
		  }
		
		  else {
			  newBalance=availableBalance-amount;
			  statement.executeUpdate("UPDATE credit_cards set remainCredit = '"+ newBalance+"' WHERE cardNumber='"+cardNumber+"'");
			  statement.executeUpdate("INSERT INTO transactions (`cost`,`DATE`,`cardNumber`,`paidTo`) Values( '" +amount+  "' , ' "+inputDate+"' , '"+cardNumber+"' , '"+shopName+"' )");
			  return  1;
		  }
	  }
	 else {
		 return -2;
	 }
	 }
  catch(Exception e) {
	  e.printStackTrace();;
  	}
	return 0;
}
  public int check(String cardNumber,String lastName,String firstName,String security, String password) throws SQLException, ClassNotFoundException {
	 try { 
		 String id;
		 Class.forName("com.mysql.cj.jdbc.Driver");
	  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/credit_card_system?userTimezone=true&serverTimezone=UTC","root","wang87067835");
	  Statement statement =con.createStatement();
	  
	  ResultSet data = statement.executeQuery("SELECT id, password from users WHERE firstName= '"+firstName+"' AND lastName='"+lastName+"'");
	  if(!data.next())
		  return -1;
	  else if ( !data.getString("password").equals(getMd5(password))) {
		  return -2;
	  }
	  else {
		  id=data.getString("id");
		  data=	statement.executeQuery("SELECT cardNumber,securityCode FROM credit_cards WHERE cardHolder='"+id+"'");
	      while(data.next()) {
	    	  if(data.getString("cardNumber").equals(cardNumber)&&data.getString("securityCode").equals(security))
	    		  return 1;
	  	}
	      return -1;
	 }
	 }
  catch(Exception e) {
	  e.printStackTrace();;
	  return -1;
  	}
  }
  
  public String getMd5(String input) 
  { 
      try { 

          // Static getInstance method is called with hashing MD5 
          MessageDigest md = MessageDigest.getInstance("MD5"); 

          // digest() method is called to calculate message digest 
          //  of an input digest() return array of byte 
          byte[] messageDigest = md.digest(input.getBytes()); 

          // Convert byte array into signum representation 
          BigInteger no = new BigInteger(1, messageDigest); 

          // Convert message digest into hex value 
          String hashtext = no.toString(16); 
          while (hashtext.length() < 32) { 
              hashtext = "0" + hashtext; 
          } 
          return hashtext; 
      }  

      // For specifying wrong message digest algorithms 
      catch (NoSuchAlgorithmException e) { 
          throw new RuntimeException(e); 
      } 
  } 
}
