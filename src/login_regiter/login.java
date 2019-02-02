package login_regiter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class login {
	private String username;
	private String password;
	
	public login(String username,String password) {
		
		this.username=username;
		this.password=password;
		
	}
	
    public boolean validate() {
		
		if(username.trim().equals("") || password.trim().equals(""))
			return false;
		else return true;
		
	}
    
    
    public void login() throws SQLException, ClassNotFoundException {
		if(!validate()) {
			System.out.println("username and password must no be blank");
		}else {
			   connect con=new connect();
			   con.connexion();
			  String sql = "SELECT count(*) from user where username=?";
			  PreparedStatement pstmt  = con.conn.prepareStatement(sql);
			  pstmt.setString(1,username);
			  ResultSet rs  = pstmt.executeQuery();
			  if(rs.getInt(1)==0) {
					System.out.println("username no exist");
			  }else {
				 
				  System.out.print("user connecter");
				  System.out.print("redirect to home ");
			  }
		}
	}

}
