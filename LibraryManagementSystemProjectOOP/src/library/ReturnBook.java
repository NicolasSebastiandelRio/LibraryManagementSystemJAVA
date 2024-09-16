package library;

import java.util.Scanner;

public class ReturnBook implements IOOperation{

	@Override
	public void oper(DataBase database, User user) {
		System.out.println("Enter book name: ");
		Scanner input = new Scanner(System.in);
		String bookname = input.next();
		if(!database.getBrws().isEmpty()) {
			for(Borrowing b : database.getBrws()) {
				if(b.getBook().getName().matches(bookname) &&
						b.getUser().getName().matches(user.getName())) {
					Book book = b.getBook();
					int i = database.getAllBooks().indexOf(book);
					if (b.getDaysLeft() > 0) {
						System.out.println("You are late!!\n"+
								"You must pay: $"+b.getDaysLeft()*50+" as fine.\n");
					}
					book.setBrwcopies(book.getBrwcopies()+1);
					database.returnBook(b,book,i);
					System.out.println("Book succesfully returned!\nThank you!");
					break;
				}else {
					System.out.println("You did not borrow this book!\n");
				}
			}
			user.menu(database, user);

		}
	}

}
