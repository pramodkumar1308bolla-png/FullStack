package Constructor;

class Book{
	String title;
	String author;
	int year=0;
	
	public Book() {
		System.out.println("the book with default information");
	}

	public Book(String title) {
		this.title = title;
	}

	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}

	public Book(String title, String author, int year) {
		this.title = title;
		this.author = author;
		this.year = year;
	}
	void displayDetails() {
		System.out.println("title of the book : "+title);
		System.out.println("author of the book : "+author);
		System.out.println("year of publication"+year);
		System.out.println("-----------------------------");
	}
}

public class library {

	public static void main(String[] args) {
		Book b1=new Book();
		b1.displayDetails();
		Book b2=new Book("xyz");
		b2.displayDetails();
		Book b3=new Book("xyz","pramod");
		b3.displayDetails();
		Book b4=new Book("xyz","Pramod",1997);
		b4.displayDetails();

	}

}
