package library;

import java.util.Scanner;

public class DeleteAllData implements IOOperation{

	@Override
	public void oper(DataBase database, User user) {
		
		System.out.println("\nAll data is going to be deleted (Both USERS and BOOKS!!!)\nAre you sure?\n"+
		"1.Continue\n2.Main Menu");
		
		Scanner input = new Scanner(System.in);
		int i = input.nextInt();
		if(i==1) {
			database.deleteAllData();
		}else {
			user.menu(database, user);
		}
		
	}

}
