package library;

import java.util.Scanner;

public class CalculateFine implements IOOperation{

	@Override
	public void oper(DataBase database, User user) {
		
		System.out.println("Enter book name");
		Scanner input = new Scanner(System.in);
		String bookname = input.next();
		
		boolean g = true;
		
		for(Borrowing b : database.getBrws()) {
			if(b.getBook().getName().matches(bookname) &&
					b.getUser().getName().matches(user.getName())) {
				
				if(b.getDaysLeft() > 0) {
					System.out.println("You are late!!\n"+
				"You must pay: $"+b.getDaysLeft()*50+" as fine.");
				}else {
					System.out.println("You dont have any fines due to pay.\n");
				}
				g = false;
				break;
			}
		}
		if(g) {
			System.out.println("You did not borrow this specific book. ");
		}
		user.menu(database, user);
	}

}
