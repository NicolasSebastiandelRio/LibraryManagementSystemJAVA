package library;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewOrders implements IOOperation{

	@Override
	public void oper(DataBase database, User user) {
		System.out.println("\n Enter book name");
		Scanner input = new Scanner (System.in);
		String bookname = input.next();
		
		int i = database.getBook(bookname);
		if (i >-1) {
			System.out.println("Book\t\tUser\t\tPrice\t\tQty");
			for(Order order : database.getAllOrders()) {
				if(order.getBook().getName().matches(bookname)) {
					System.out.println(order.getBook().getName()+"\t\t"+
				order.getUser().getName()+"\t\t"+order.getQty()+"\t"+order.getPrice());
				}
			}
			System.out.println();

		}else {
			System.out.println("Book suggested does not exist! ");
		}
		user.menu(database, user);
	}

}
