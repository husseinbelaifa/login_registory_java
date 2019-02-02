package login_regiter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class connect {
	 Connection conn;
	 Statement stmt;
	 
	 public connect() {
		 conn = null;
		 stmt=null;
	 }
	
	public void  connexion() throws ClassNotFoundException {
		
		try {
			Class.forName("org.sqlite.JDBC");
			   String url = "jdbc:sqlite:login_register.db";
	            // create a connection to the database
	            conn = DriverManager.getConnection(url);
	            
	            System.out.println("Connection to SQLite has been established.");
		}catch(SQLException e) {
			System.out.print("Connexion error"+e);
		}
	}
	
	public void create_table() throws ClassNotFoundException {
		
		try {
			
		this.connexion();
		 stmt = this.conn.createStatement();
		  String sql = "CREATE TABLE user " +
                  "(id INTEGER NOT NULL primary key AUTOINCREMENT," +
                  " username        varchar(50) NOT NULL, " + 
                  " password varchar(50)     NOT NULL)" ;
                
		  stmt.executeUpdate(sql);
	     stmt.close();
	     System.out.print("table crée");
		}catch(SQLException e) {
			System.out.print("Error in creation of user table"+e);
		}
	         
		
	}

}
