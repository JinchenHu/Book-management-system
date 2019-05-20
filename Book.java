
public class Book {
	//declare the instance variable title
	private String title;
	//declare the instance variable author
	private String author;
	//declare the instance variable IBNS
	private long ISBN;
	//declare the instance variable price
	private double price;
	//declare a static variable title
	static int count = 0;
	/**
	 * no argument constructor
	 */
	public Book() {
		//once the constructor is called, the static variable count plus 1
		count ++;
	}
	
	/**
	 * arguments constructor which assign the values to object after receiving the arguments
	 * @param title a String value
	 * @param author a String value
	 * @param ISBN a long value
	 * @param price a double value
	 */
	public Book(String title, String author, long ISBN, double price) {
		this.title = title;
		this.author = author;
		this.ISBN = ISBN;
		this.price = price;
		//once the constructor is called, the static variable count plus 1
		count ++;
	}

	/**
	 * Mutator  to set the value of title
	 * @param title a String value the user inputs
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Accessor to get the value of title
	 * @return the value of title that is returned
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Mutator  to set the value of author
	 * @param author a String value the user inputs
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	/**
	 * Accessor to get the value of author
	 * @return the value of author that is returned
	 */
	public String getAuthor() {
		return author;
	}
	
	/**
	 * Mutator  to set the value of ISBN
	 * @param ISBN title a long value the user inputs
	 */
	public void setISBN(long ISBN) {
		this.ISBN = ISBN;
	}
	
	/**
	 * Accessor to get the value of ISBN
	 * @return the value of ISBN that is returned
	 */
	public long getISBN() {
		return ISBN;
	}
	
	/**
	 * Mutator  to set the value of price
	 * @param price a double value the user inputs
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * Accessor to get the value of price
	 * @return the value of price that is returned
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * method that display the information of a book
	 * @return the author, tile, ISBN, and price of the object
	 */
	public String toString() {
		return "\rAuthor: "+ author +"\rTitle: " + title + "\rISBN: " + ISBN + "#\rPrice: $" + price ;
	}
	
	/**
	 * static method that counts the number of existing books 
	 * @return the value of count which represents the number of created books
	 */
	public static int findNumberOfCreatedBooks() {
		return count;
	}
	
	/**
	 * method that compare the value of ISBN and price of two objects
	 * @param b a received book object
	 * @return if the values of both ISBN and price of two objects are equal, return turn; otherwise, return false
	 */
	public boolean equals(Book b) {
		return this.ISBN == b.ISBN && this.price == b.price;
	}
}
