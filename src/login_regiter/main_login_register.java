package login_regiter;

import java.sql.SQLException;
import java.util.Scanner;

public class main_login_register {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		/*connect conn=new connect();
		conn.create_table();*/
		/*register r=new register("","admin");
		r.register();
		*/
		while(true) {
			
			System.out.println("menu ");
			System.out.println("1:login");
			System.out.println("2:Register");
			System.out.println("3:exit");
			System.out.println("tap you choice");
			int choice=new Scanner(System.in).nextInt();
			switch(choice) {
			case 1:{
				System.out.println("Tap your Ussername and Password");
				String username=new Scanner(System.in).next();
				String password=new Scanner(System.in).next();
				login log=new login(username,password);
				log.login();
				break;
			}
			case 2:{
				System.out.println("Tap your Ussername and Password");
				String username=new Scanner(System.in).next();
				String password=new Scanner(System.in).next();
				register reg=new register(username,password);
				reg.register();
				break;
			}
			case 3:{
				System.exit(0);
				break;
			}
			}
			
			
		}
		
		
		
	}

}
