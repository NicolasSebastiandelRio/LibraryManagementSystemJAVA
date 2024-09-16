package library;

import java.util.Scanner;

public class BorrowBook implements IOOperation{

	@Override
	public void oper(DataBase database, User user) {
		
		Scanner input = new Scanner (System.in);
		System.out.println("Enter book name: ");
		String bookname = input.next();
		
		int i = database.getBook(bookname);
		if (i >-1) {
			Book book = database.getBook(i);
			
			boolean n = true;
			for(Borrowing b : database.getBrws()) {
				if(b.getBook().getName().matches(bookname) &&
						b.getUser().getName().matches(user.getName())) {
					n = false;
					System.out.println("You have borrowed this book before!\n");
				}
			}
			if(n) {
				if(book.getBrwcopies() > 1) {
					Borrowing borrowing = new Borrowing(book,user);
					book.setBrwcopies(book.getBrwcopies()-1);
					database.borrowBook(borrowing,book,i);
					System.out.println("You must return the book before 14 days from now\n"+
					"Expiry date: "+borrowing.getFinish()+"\nEnjoy your lecture!");
				}else {
					System.out.println("This book is not available for borrowing\n");
				}	
			}
		}else {
			System.out.println("Book does not exist.\n");
		}
		user.menu(database, user);
		
	}

}
