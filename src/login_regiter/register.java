package login_regiter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class register {
	
	private String username;
	private String password;
	
	public register(String username,String password) {
		
		this.username=username;
		this.password=password;
		
	}
	
	public boolean validate() {
		
		if(username.trim().equals("") || password.trim().equals(""))
			return false;
		else return true;
		
	}
	
	public void register() throws SQLException, ClassNotFoundException {
		if(!validate()) {
			System.out.println("username and apssword must no be blank");
		}else {
			   connect con=new connect();
			   con.connexion();
			  String sql = "SELECT count(*) from user where username=?";
			  PreparedStatement pstmt  = con.conn.prepareStatement(sql);
			  pstmt.setString(1,username);
			  ResultSet rs  = pstmt.executeQuery();
			  if(rs.getInt(1)>=1) {
					System.out.println("username exist");
			  }else {
				
				  String sql1 = "insert into user(username,password)values(?,?)";
				 pstmt  = con.conn.prepareStatement(sql1);
				pstmt.setString(1,username);
				  
				
				  
				  pstmt.setString(2,password);
				  pstmt.execute();
				  System.out.println("user cr�e");
				  System.out.println("redirect to home ");
			  }
		}
	}

}
