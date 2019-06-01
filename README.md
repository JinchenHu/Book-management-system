# Book-management-system
1st assignment in comp249
Part I)
A book object has four attributes, a title (String), an author (String), an ISBN (long), and a price (double). For this part, you are required to design and implement the Book class according to the following specifications:
  -Upon the creation of a book object, the object must immediately be initialized with valid values; that is title, author, ISBN and          price.
  -The design should allow enough flexibility so that the value of any of these attributes can be modified later on. For example, it        should be possible to create a book object with a given price then change its price later on. The design should also allow the user      to obtain the value of any of the attributes.
  -The design should allow all information of an object to be displayed at once through the utilization of  System.out.print() method.
  -It is required to know how many Book objects have been created. For that, you need to add a method, called  findNumberOfCreatedBooks(),    to the class. This method must return the number of created Book objects prior to the time this method is called. The method would          simply return 0 if no books has been created by the time the method is called.
  -It is required to compare two Book objects for equality. Two Book objects are considered
   equal if they have the same ISBN and price.
  -It is required to display any Book object (all info of that object) using System.out.println() method. 
  
Part II)
You are hired by a bookstore to write a software that helps the store owner in keeping track of the books at the store. Write a driver program that will contain, at least, the following methods. Note:  You can have the main function in a separate driver file, or in the same file if you prefer.
  a. Display a welcome message
  b. Prompt the bookstore owner for the maximum number of books (maxBooks) his/her bookstore can contain. Create an empty array, called      inventory, that will have the potential of keeping track of the created Book objects.
  c. Display a main menu (fig 1) with the following choices and keep prompting the user until they enter a number between 1 and 5            inclusive:
  d. When option 1 is entered:
    i. Prompt the bookstore owner for his/her password. (Make sure you have a constant variable containing the password “password” – do        not use any other password as it will be easier for the marker to check your assignments). The bookstore owner has a maximum of 3        attempts to enter the correct password. After the 3 rd illegal entry, the main menu in figure 1 is re-displayed again.                  Additionally after this process is repeated 4 times (i.e. total failed attemopts is 12 by now), the program must displays the            following messages: “Program detected suspicous activities and will terminate immediately!”, then the program must exits.
    ii. If the correct password is entered, ask the owner how many books s/he wants to enter. Check that there is enough space in the           bookstore (array of Book) to add these many books. If so, add them; otherwise inform the owner of the maximum remaining places           in the array. (How the book information is input/entered by the user, is up to you).
  e. When option 2 is entered :
    i. Prompt the bookstore owner for his/her password. (Make sure you have a constant containing the password “password” as a constant–        do not use another password). Again the bookstore owner has 3 attempts to enter the correct password. However, after the 3 rd            illegal entry, the main menu in figure 1 is simply re-displayed again (notice the different behaviour in that case from the              previous one above).
    ii. Ask the user which book number s/he wishes to update. The book number is the index in the array inventory. If there is no Book object at the specified index location, display a message asking the user if he/she wishes to re-enter another book, or quit this operation and go back to the main menu. If the entered index has a valid book, display the current information of that book in the following format:
                                Book # X 
                                Author: name of author
                                Title: title of book
                                ISBN: isbn #
                                Price: $price
        Then ask the user which attribute they wish to change by displaying the following menu. Once the user has entered a correct             choice, make the changes to the attribute then display again all of the attributes on the screen to show that the attribute has         been changed. Keep prompting the user for additional changes until the user enters 5. Each time the user is prompted for a               choice make sure that a number from 1 to 5 is entered, otherwise keep prompting until a valid number is entered.
  f. When option 3 (in the main menu shown in Fig. 1) is entered, prompt the user to enter an author name. You then need to display the      information of all books by that requested author. (Hint: You may use a static method, for instance called findBooksBy , which          accepts a string for an author name then performs the needed search).
  g. When option 4 (in the main menu shown in Fig. 1) is entered, promtp the user to enter a value (representing a price). You them need      to display all books that have a vlaue smaller than that entered value. (Hint: You may use a static method, for instance called
     findCheaperThan, which accepts a double value, for a price, then performs the needed search).
  h. When option 5 (in the main menu shown in Fig. 1) is entered, display a closing message
     and end the driver
