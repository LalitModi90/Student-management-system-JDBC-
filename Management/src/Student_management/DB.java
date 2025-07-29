package Student_management;

import java.sql.Connection;
import java.sql.DriverManager; 


public class DB {
  static Connection con = null;
  public static Connection  connect(){
	   
	  try {
		  String url = "jdbc:mysql://localhost:3306/mydatabase";
		  String username = "root";
		  String pass = "12345";
		  
		  con = DriverManager.getConnection(url,username,pass);
		  
	  }catch(Exception e){
		  e.printStackTrace();
		  
	  }
	return con;
	  
  }
}
