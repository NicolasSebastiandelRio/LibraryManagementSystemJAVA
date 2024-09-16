package library;

import java.util.Scanner;

public class DeleteBook implements IOOperation{

	@Override
	public void oper(DataBase database, User user) {
		Scanner input = new Scanner (System.in);
		System.out.println("Enter book name: ");
		String bookname = input.next();
		
		int i = database.getBook(bookname);
		if (i >-1) {
			database.deleteBook(i);
			System.out.println("Book deleted succesfully!\n");
		}else {
			System.out.println("Book does not exist!\n");
		}
		user.menu(database, user);
	}

}
