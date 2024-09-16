package library;

import java.util.Scanner;

public class AddBook implements IOOperation{

	
	
	@Override
	public void oper(DataBase database, User user) {
		
		Scanner input = new Scanner(System.in);
		Book book = new Book();
		System.out.println("\nEnter book name: ");
		
		String name = input.next();
		if(database.getBook(name) > -1) {
			System.out.println("There is already a book with this name! \n");
			user.menu(database, user);
			return;
		}else {
			book.setName(name);

			System.out.println("Enter book author: ");
			book.setAuthor(input.next());

			System.out.println("Enter book publisher: ");
			book.setPublisher(input.next());

			System.out.println("Enter Collection Adress: ");
			book.setAdress(input.next());

			System.out.println("Enter Copies available for sale: ");
			book.setQty(input.nextInt());
			
			System.out.println("Enter price: ");
			book.setPrice(input.nextDouble());
			
			System.out.println("Enter borrowing copies: ");
			book.setBrwcopies(input.nextInt());
			
			database.AddBook(book);		
			System.out.println("Book added succesfully!\n");
			
			user.menu(database, user);
			input.close();

		}
	}

}
