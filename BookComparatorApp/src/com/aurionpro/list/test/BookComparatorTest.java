package com.aurionpro.list.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import com.aurionpro.list.model.Book;
import com.aurionpro.list.model.BookComparator;
import com.aurionpro.list.model.BookComparator.BookTitleComparator;


public class BookComparatorTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Book> books = new ArrayList<Book>();
		int choice=-1;
		while(choice!=9) {
			System.out.println("\nWelcome to Books");
		    System.out.println("1 -> Add New Book ");
		    System.out.println("2 -> Load book preset");
		    System.out.println("3 -> Sort -> author,title,price");
		    System.out.println("4 -> Sort -> Publication year,price,author");
		    System.out.println("5 -> Sort -> titler");
		    System.out.println("6 -> Sort -> author");
		    System.out.println("7 -> Sort -> price");
		    System.out.println("8 -> Sort -> Publication Year");
		    System.out.println("9 -> Exit");			
		    System.out.print("Select: ");			
		    
		    choice = scanner.nextInt();
		    if(choice==1) {
		    	addBook(books,scanner);
		    }
		    else if(choice==2) {
		    	addPreLoadedBook(books);
		    }
		    else if(choice==3) {
		    	bookSortATP(books);
		    }
		    else if(choice==4) {
		    	bookSortPPA(books);
		    }
		    else if(choice==5) {
		    	bookByTitle(books);
		    }
		    else if(choice==6) {
		    	bookByAuthor(books);
		    }
		    else if(choice==7) {
		    	bookByPrice(books);
		    }
		    else if(choice==8) {
		    	bookByPublishingYear(books);
		    }
		}
	}

	private static void bookByPublishingYear(ArrayList<Book> books) {
		books.sort(new BookComparator.BookPublishicanYearComparator());
		for(Book book: books) {
			System.out.println(book);
		}
	}
	
	private static void bookByPrice(ArrayList<Book> books) {
		books.sort(new BookComparator.BookPriceComparator());
		for(Book book: books) {
			System.out.println(book);
		}
	}
	
	private static void bookByAuthor(ArrayList<Book> books) {
		books.sort(new BookComparator.BookAuthorComparator());
		for(Book book: books) {
			System.out.println(book);
		}
	}
	
	private static void bookByTitle(ArrayList<Book> books) {
		books.sort(new BookComparator.BookTitleComparator());
		for(Book book: books) {
			System.out.println(book);
		}
	}
	
	
	private static void bookSortPPA(ArrayList<Book> books) {
		books.sort(new BookComparator.BookPublishicanYearComparator()
				.thenComparing(new BookComparator.BookPriceComparator()
						.thenComparing(new BookComparator.BookAuthorComparator())));
		for(Book book: books) {
			System.out.println(book);
		}
	}

	private static void bookSortATP(ArrayList<Book> books) {
		books.sort(new BookComparator.BookAuthorComparator()
				.thenComparing(new BookComparator.BookTitleComparator()
						.thenComparing(new BookComparator.BookPriceComparator())));
		for(Book book: books) {
			System.out.println(book);
		}
	}
	
	private static void addPreLoadedBook(ArrayList<Book> books) {
		books.add(new Book("To Kill a Mockingbird", "Harper Lee", 19.99, 1960));
		books.add(new Book("Pride and Prejudice", "Jane Austen", 14.99, 1813));
		books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 12.99, 1925));
		books.add(new Book("1984", "George Orwell", 9.99, 1949));
		books.add(new Book("The Catcher in the Rye", "J.D. Salinger", 11.99, 1951));
		books.add(new Book("Brave New World", "Aldous Huxley", 10.99, 1932));
		books.add(new Book("The Hobbit", "J.R.R. Tolkien", 15.99, 1937));
		books.add(new Book("The Lord of the Rings", "J.R.R. Tolkien", 24.99, 1954));
		books.add(new Book("The Chronicles of Narnia", "C.S. Lewis", 18.99, 1950));
		books.add(new Book("The Book Thief", "Markus Zusak", 13.99, 2005));
		books.add(new Book("The Alchemist", "Paulo Coelho", 8.99, 1988));
		books.add(new Book("The Picture of Dorian Gray", "Oscar Wilde", 7.99, 1890));
		books.add(new Book("The Handmaid's Tale", "Margaret Atwood", 16.99, 1985));
		books.add(new Book("The Kite Runner", "Khaled Hosseini", 12.99, 2003));
		books.add(new Book("The Road", "Cormac McCarthy", 14.99, 2006));
		books.add(new Book("The Help", "Kathryn Stockett", 10.99, 2009));
		books.add(new Book("The Girl with the Dragon Tattoo", "Stieg Larsson", 11.99, 2005));
		books.add(new Book("The Hunger Games", "Suzanne Collins", 9.99, 2008));
		books.add(new Book("The Fault in Our Stars", "John Green", 13.99, 2012));
		books.add(new Book("The Da Vinci Code", "Dan Brown", 10.99, 2003));
	}

	private static void addBook(ArrayList<Book> books,Scanner scanner) {
		scanner.nextLine();
    	System.out.print("Enter title: ");
    	String title = scanner.nextLine();
    	System.out.print("Enter author: ");
    	String author = scanner.nextLine();
    	System.out.print("Enter price: ");
    	Double price = scanner.nextDouble();
    	System.out.print("Enter publication year: ");
    	Integer publicationYear = scanner.nextInt();
    	books.add(new Book(title,author,price,publicationYear));
	}

}
