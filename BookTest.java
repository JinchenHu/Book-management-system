
//import the Scanner package
import java.util.Scanner;
public class BookTest {
	// the reason for declaring those static variable is that they are not only used
	// in main method
	// create a Scanner object and assign it to sc
	static Scanner sc = new Scanner(System.in);
	// creates an integer variable choice, which represents the choice of owner in
	// the main menu (Fig.1)
	static int choice;
	// declare a static integer variable, which is the book number that the user
	// choose to update information in the second option in main menu (Fig.1)
	static int max;
	// create a book array to store the all the created book objects
	static Book[] inventory;
	public static void main(String[] args) {
		// calls the welcome method
		welcome();
		// read the input of the owner
		max = sc.nextInt();
		// initialize the length of inventory
		inventory = new Book[max];
		System.out.println();
		// declare an integer variable to count the number of times enterPassword()
		// method is called
		int count1 = 0;

		// do...while loop, the reason why the conditional is true is that ensures the
		// main menu will be redisplayed again
		// after ending each option in main menu(Fig.1)
		do {
			// call the menu method
			figure1();
			// uses switch to control the flow
			switch (choice) {
			// enter a new book
			case 1:
				// do...while loop to control the times the users enters password
				do {
					count1++;
					// if the user inputs the correct password, then the addBook() method will be
					// called
					if (enterPassword()) {
						addBook();
						break;// when creating a new book successfully, ends the second do...while loop and
								// redisplays the main menu(Fig.1)
					} else
						// if the enterPassword() return a false, which means 3 times invalid inputs,
						// ends the second do...while and redisplays the main menu(Fig.1)
						break;
				} while (count1 < 4);// while count1 is smaller than 4, executes the loop continuously;
										// otherwise,ends the loop

				// if the count1 is equals to 4, which means the total failed attempts is 12,
				// gives the user a prompt and ends the program
				if (count1 == 4) {
					System.out.println("Program detected suspicous activities and will terminate immediately!");
					System.exit(0);
				}
				break;

			// change the information of a book
			case 2:
				// if the method enterPassword() returns true, then executes method update()
				//
				if (enterPassword()) {
					update();
				}
				break;

			// display all books by a specified author
			case 3:
				findBooksBy();
				break;

			// display all books under a specified price
			case 4:
				findCheaperThan();
				break;

			// display a closing message and end the program
			case 5:
				System.out.println("The program shuts down, thanks very much for your use");
				System.exit(0);
				break;
			}
		} while (true);
	}// end of main

	/**
	 * method that displays the welcome banner
	 */
	public static void welcome() {
		System.out.println("		----------------------------------");
		System.out.println("		WELCOME TO BOOKS MANAGEMENT SYSTEM");
		System.out.println("		----------------------------------");
		System.out.println();
		System.out.print("Please enter the maximum number of books: ");
	}

	/**
	 * method that displays the main menu, and it will not end until the user enters
	 * a number between 1 and 5 inclusive
	 */
	public static void figure1() {
		// do...while loop to ensure the user enters a number between 1 and 5 inclusive
		do {
			System.out.println("**********************************************************");
			System.out.print(
					"What do you want to do?\r    1.  Enter new books (password required)\r    2.  Change information of a book (password required)\r    3.  Display all books by a specific author\r    4.  Display all books under a certain price\r    5.  Quit\rPlease enter your choice>");
			choice = sc.nextInt();
			if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5)
				System.out.println("Invalid choice! Please input again");
		} while (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5);
	}

	/**
	 * method that let the user enter the password (3 attempts at most)
	 * 
	 * @return return true if the user enters correct password no more than 3 times;
	 *         otherwise,return false
	 */
	public static boolean enterPassword() {
		int i;
		// for loop controls the number of entering password
		for (i = 1; i < 4; i++) {
			System.out.print("Please enter the Password: ");
			// if the user input the correct password, break the for loop and i minus 1 to
			// avoid that the boolean variable flag is true, when the user input correct
			// password in the third time
			if (sc.next().equals("password")) {
				i--;
				break;
			}
		}
		boolean flag = i < 3;
		return flag; // when i<2, return true; namely, the owner enter the correct password within
						// three times.
	}

	/**
	 * method that stores the information of the books until the user inputs an
	 * available number of books the program can store
	 */
	public static void addBook() {
		// do...while loop to ensure the user inputs an available number of books the
		// program can store
		do {
			System.out.print("Please enter the number of books you want to add: ");
			int addNumber = sc.nextInt();
			// if there is enough space to add the books, execute the statements below
			if (addNumber <= inventory.length - Book.findNumberOfCreatedBooks()) {
				// declare an integer variable bookNumber, which is the book number of the new
				// created book
				int bookNumber;
				// declare an integer variable total, which is the maximal number of books can
				// be stored in this step
				int total = addNumber + Book.findNumberOfCreatedBooks();
				// for loop to traverse the array and create new book objects
				for (bookNumber = Book.findNumberOfCreatedBooks(); bookNumber < total; bookNumber++) {
					System.out.println("Enter the information of the new book");
					System.out.println("------------------------------------------------");
					inventory[bookNumber] = new Book();
					System.out.print("Please enter the title of the book: ");
					sc.nextLine();
					String title = sc.nextLine();
					inventory[bookNumber].setTitle(title);
					System.out.print("Please enter the author of the book: ");
					String author = sc.nextLine();
					inventory[bookNumber].setAuthor(author);
					System.out.print("Please enter the ISBN of the book: ");
					long ISBN = sc.nextLong();
					inventory[bookNumber].setISBN(ISBN);
					System.out.print("Please enter the price of the book: ");
					double price = sc.nextDouble();
					inventory[bookNumber].setPrice(price);
					System.out.println();
				}
				break;// break the do...while loop
			} else {
				// if the number the user input is greater that the number of books the
				// bookstore can store, give the user a prompt
				System.out.println("Sorry! You can only store " + (inventory.length - Book.findNumberOfCreatedBooks())
						+ " books, please enter again.");
			}
		} while (true);
	}

	/**
	 * method that updates the information of a specified book
	 */
	public static void update() {

		// do...while loop to keep redisplay the update menu until the user inputs 5
		loop1: do {
			System.out.print("Please enther the book number you wish to update: ");
			// read an integer variable and assign it to changeNumber which is the book
			// number of the book the user plans to change information
			int changeNumber = sc.nextInt();
			// if the book number exists, execute the statements in the loop
			if (changeNumber < Book.findNumberOfCreatedBooks()) {
				System.out.println("Current information of the book");
				System.out.println("-------------------------------");
				// display the current information of the book
				System.out.println("Book #" + changeNumber + inventory[changeNumber].toString());
				// declares a integer variable which is the choice of the user in update
				// menu(Fig.2)
				int choice2;

				// executes the do....while loop until the user inputs 5 or wish to go back to
				// main menu when there is no specified book
				do {
					// executes the do...while loop until the user inputs correct number
					do {
						System.out.println("..........................................");
						System.out.print(
								"What information would you like to change?\r\t1. author\r\t2. title\r\t3. ISBN\r\t4. price\r\t5. Quit\rEnter your choice: ");
						// read an integer and assign it to choice2
						choice2 = sc.nextInt();
						if (choice2 != 1 && choice2 != 2 && choice2 != 3 && choice2 != 4 && choice2 != 5)
							System.out.println("Wrong number! Please enter again");
					} while (choice2 != 1 && choice2 != 2 && choice2 != 3 && choice2 != 4 && choice2 != 5);
					// switch to control the flow
					switch (choice2) {
					// change the information of author
					case 1:
						System.out.print("Please enter the new author of the book: ");
						sc.nextLine();
						String author = sc.nextLine();
						inventory[changeNumber].setAuthor(author);
						System.out.println("Congratualations! The new author has updated successfully");
						System.out.println("----------------------------------------------------");
						// display the new information of the book
						System.out.println("Book #" + changeNumber + inventory[changeNumber].toString());
						break;
					// change the information of title
					case 2:
						System.out.print("Please enter the new title of the book: ");
						sc.nextLine();
						String title = sc.nextLine();
						inventory[changeNumber].setTitle(title);
						System.out.println("Congratualations! The new title has updated successfully");
						System.out.println("----------------------------------------------------");
						System.out.println("Book #" + changeNumber + inventory[changeNumber].toString());
						break;
					// change the information of ISBN
					case 3:
						System.out.print("Please enter the new ISBN of the book: ");
						long ISBN = sc.nextLong();
						inventory[changeNumber].setISBN(ISBN);
						System.out.println("Congratualations! The new ISBN has updated successfully");
						System.out.println("----------------------------------------------------");
						System.out.println("Book #" + changeNumber + inventory[changeNumber].toString());
						break;
					// change the information of price
					case 4:
						System.out.print("Please enter the new price of the book: ");
						double price = sc.nextDouble();
						inventory[changeNumber].setPrice(price);
						System.out.println("Congratualations! The new price has updated successfully");
						System.out.println("----------------------------------------------------");
						System.out.println("Book #" + changeNumber + inventory[changeNumber].toString());
						break;

					// quit the method and go back to main menu(Fig.1)
					case 5:

						break loop1;
					}
				} while (true);
			} else {
				System.out.println(
						"The book number you inputed does not exist, do you wish to re-enter or go back to main menu");
				// declare an integer variable which is the user's choice
				int option;
				// do...while loop to ensure the users make a right choice
				do {
					System.out.print(
							"1 represents re-enter, 2 represents go back to main menu. Please enter your choice: ");
					// read an integer and assign it to option
					option = sc.nextInt();
					if (option == 1) {
						break;// end the do...while loop, and executed loop1 again
					} else if (option == 2) {
						break loop1;// end the loop1 and go back to main menu
					} else
						System.out.println("Invalid number! Please enter again");
				} while (option != 1 && option != 2);
			}
		} while (true);

	}

	/**
	 * method that displays all the books by a specified author
	 */
	public static void findBooksBy() {
		System.out.print("Please enther the name of author: ");
		sc.nextLine();
		String name = sc.nextLine();
		// traverse the array and get the author name of each book, if the name is equal
		// to the specified name, display all information of the book
		for (int i = 0; i < Book.findNumberOfCreatedBooks(); i++) {
			if (name.equals(inventory[i].getAuthor())) {
				System.out.println("Book #" + i + inventory[i].toString());
				System.out.println("-------------------");
			}
		}
	}

	/**
	 * method that displays all the books under a specified price
	 */
	public static void findCheaperThan() {
		System.out.print("Please enter the price: ");
		double price = sc.nextDouble();
		for (int i = 0; i < Book.findNumberOfCreatedBooks(); i++) {
			if (price > inventory[i].getPrice()) {
				System.out.println("Book #" + i + inventory[i].toString());
				System.out.println("-------------------");
			}
		}
	}
}
