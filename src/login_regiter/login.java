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
			  if(rs.getInt(1)==0 {
					System.out.println("username exist");
			  }else {
				  String sql1 = "insert into user(username,password)values(?,?)";
				  PreparedStatement pstmt1  = con.conn.prepareStatement(sql1);
				  pstmt1.setString(1,username);
				  pstmt1.setString(2,password);
				  pstmt1.executeUpdate();
				  System.out.print("user crée");
			  }
		}
	}

}
