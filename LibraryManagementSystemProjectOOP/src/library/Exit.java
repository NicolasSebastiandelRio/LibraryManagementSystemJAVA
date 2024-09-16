package library;

import java.util.Scanner;

public class Exit implements IOOperation{

	Scanner input;
	DataBase database;
	User user;
	
	@Override
	public void oper(DataBase database, User user) {
		this.database = database;
		this.user = user; 
		System.out.println("\nAre you sure that you want to log out ?\n"+
				"1.Yes\n2.No");
				
				input = new Scanner(System.in);
				int i = input.nextInt();
				if(i==1) {
					System.out.println("0.Exit\n1.Login\n2.New User");
					input = new Scanner(System.in);
					int num = input.nextInt();
					
					switch(num) {
						case 1: login();break;
						case 2:newuser();break;
					}
				}else {
					user.menu(database, user);
				}
		
	}
	
	private void login() {
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
	
	private void newuser() {
		System.out.println("Enter your name: ");
		String name = input.next();
		System.out.println("Enter a phone number: ");
		String phoneNumber = input.next();
		System.out.println("Enter an email: ");
		String email = input.next();
		System.out.println("1. Admin\n2.Normal User");
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
