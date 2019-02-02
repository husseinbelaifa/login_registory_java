package login_regiter;

import java.sql.SQLException;

public class main_login_register {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		/*connect conn=new connect();
		conn.create_table();*/
		register r=new register("","admin");
		r.register();
	}

}
