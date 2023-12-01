package com.app;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.dao.BookDao;
import com.model.Book;


public class App {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println(
					"Select Option : \n 1 - Add Book \n 2 - Display Book \n 3 - Search Book \n 4 - Update Book \n 5 - Delete Book ");
			System.out.println("Enter Your Choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				int c;
				do {
					System.out.println("Enter the Book ID");
					int bokid = sc.nextInt();
					System.out.println("Enter the Book Name You Want to Add");
					String bokNam = sc.next();
					System.out.println("Enter the Book Price");
					double bokPric = sc.nextDouble();

					Book b = new Book(bokid, bokNam, bokPric);
					int i = 0;
					try {
						i = BookDao.addBook(b);
					} catch (Exception e) {
						System.out.println(e);
					}
					if (i > 0) {
						System.out.println("Book Inserted");
					} else {
						System.out.println("Book Not Inserted");
					}
					System.out.println("You Want to Enter more Press 1 otherWise Press 0");
					c = sc.nextInt();
				} while (c >= 1);
				break;

			case 2:
				System.out.println("***** Book Available in the Store: *****");
				List<Book> ls = null;
				try {
					ls = BookDao.DisplayBook();
				} catch (Exception e) {
					System.out.println(e);
				}
				System.out.println(" ID    NAME   PRICE");
				Iterator<Book> itr = ls.iterator();
				while (itr.hasNext()) {
					Book book = itr.next();
					System.out.print(" " + book.getId() + "  ");
					System.out.print(" " + " " + book.getBokName() + "   ");
					System.out.println(" " + " " + book.getBokPrice());
				}
				break;

			case 3:
				Book book = null;
				System.out.println("Enter the book id");
				int id = sc.nextInt();
				book = BookDao.getBookById(id);
				System.out.println(" ID   NAME  PRICE");
				System.out.print(" " + book.getId() + "  ");
				System.out.print(" " + " " + book.getBokName() + "   ");
				System.out.println(" " + " " + book.getBokPrice());
				break;

			case 4:
				double setpri;
				String setnam;
				System.out.println("Enter the book id");
				int Uid = sc.nextInt();
				Book bok = null;
				try {					
					bok = BookDao.getBookById(Uid);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				System.out.println(" ID   NAME  PRICE");
				System.out.print(" " + bok.getId() + "  ");
				System.out.print(" " + " " + bok.getBokName() + "   ");
				System.out.println(" " + " " + bok.getBokPrice());

				System.out.println("Enter the Book Name to Set");
				setnam = sc.next();

				System.out.println("Enter the Book price to Set");
				setpri = sc.nextInt();

				Book b1 = new Book(Uid, setnam, setpri);
				int i1 = 0;

				try {
					i1 = BookDao.updateBook(b1);
				} catch (Exception e) {
					System.out.println(e);
				}
				if (i1 > 0) {
					System.out.println("Book Price And Name Set SuccessFully!!");
				} else {
					System.out.println("Book not Updated!!");
				}
				break;
				
			case 5:
				System.out.println("Enter the id you want to delete");
				int did=sc.nextInt();
				
				int i2=0;
				try {
					i2=BookDao.deleteBook(did);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				if (i2 > 0) {
					System.out.println("Book Deleted SuccessFully!!");
				} else {
					System.out.println("Book not Deleted!!");
				}
				break;
			}
		} while (true);
	}
}
