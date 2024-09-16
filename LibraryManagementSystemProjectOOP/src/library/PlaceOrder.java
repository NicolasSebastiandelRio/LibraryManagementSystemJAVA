package library;

import java.util.Scanner;

public class PlaceOrder implements IOOperation{

	@Override
	public void oper(DataBase database, User user) {
		
		Order order = new Order();
		System.out.println("\nEnter book name:");
		Scanner input = new Scanner (System.in);
		String bookname = input.next();
		int i = database.getBook(bookname);
		
		if (i<=-1) {
			System.out.println("Book suggested does not exist! ");
		}else {
			Book book = database.getBook(i);
			order.setBook(book);
			order.setUser(user);
			System.out.println("Enter qty:");
			int qty = input.nextInt();
			order.setQty(qty);
			order.setPrice(book.getPrice()*qty);
			int bookindex = database.getBook(book.getName());
			book.setQty(book.getQty()-qty);
			database.addOrder(order,book, bookindex);
			System.out.println("Order placed succesfully!\n ");
		}
		user.menu(database, user);
		
	}

}
