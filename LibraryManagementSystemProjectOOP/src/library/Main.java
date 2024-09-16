package library;
import java.util.Scanner;
public class Main {
	
	static DataBase database;
	static Scanner input;
	
	public static void main(String[] args) {
		
		database = new DataBase();
		System.out.println("--------------------------------------------------");
		System.out.println("Welcome to Buenos Aire´s library management System! ");
		System.out.println("--------------------------------------------------");
		int num;
		//do{
			System.out.println("\nPlease choose one of the following options: \n");
			System.out.println("0.Exit\n1.Login\n2.New User");
			input = new Scanner(System.in);
			num = input.nextInt();
			
			switch(num) {
				case 1: login();break;
				case 2:newuser();break;
			}
		//}while(num!=0); 
	}
		




	private static void login() {
		System.out.println("Enter a phone number: ");
		String phoneNumber = input.next();
		System.out.println("Enter an email: ");
		String email = input.next();
		int n = database.login(phoneNumber, email);
				
		if(n != -1) {
			User user = database.getUser(n);
			user.menu(database, user);
		}else {
			System.out.println("User does not exist.");
		}
	}
	
	private static void newuser() {
		System.out.println("Enter your name: ");
		String name = input.next();
		if(database.userExists(name)) {
			System.out.println("User exists!");
			newuser();
		}
		System.out.println("Enter a phone number: ");
		String phoneNumber = input.next();
		
		
		System.out.println("Enter an email: ");
		String email = input.next();
		System.out.println("\nWhat type of user are you?\n ");
		System.out.println("1.Admin\n2.Normal User");
		int n2 = input.nextInt();
		User user;
		if(n2 == 1) {
			user = new Admin(name, email, phoneNumber);
		}else {
			user = new NormalUser(name, email, phoneNumber);
		}
		database.AddUser(user);
		user.menu(database,user);
	}



}
