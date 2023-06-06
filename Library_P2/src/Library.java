import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private static ArrayList<Book> BookList;

    // contructor
    public Library() {
        BookList = new ArrayList<Book>();
    }

    // getter
    public static int getTotalBooks(){ // dipake di main
        return BookList.size();
    }
    //getter boolean
    public static boolean isBookListEmpty(){
        if(BookList.isEmpty()){
            System.err.println("There is no book in library\n");
            System.err.flush();
            return BookList.isEmpty();
        }
        return false;
    }

    public void addBook(Book book) {
        BookList.add(book);
        System.out.println("Book added successfully.");
    }

    public void ListBook() {
        if(isBookListEmpty()) return;
        System.out.println("\nBook List : ");
        for (Book book : BookList) {
            System.out.println((BookList.indexOf(book) + 1) + ". " + book.getTittle() + " - " + book.getAuthor() + " (" + book.getBookType() + ")");
        }
    }

    public void FindBook(int BookID) {
        if (BookID >= 1 && BookID <= BookList.size()) {
            System.out.println("\nLooking for Book No " + BookID + " : ");
            BookList.get(BookID - 1).display();
        }else{
            System.err.println("Invalid input. Please enter a valid book ID\n");
            System.err.flush();
        }
    }

    public void removeBook(int BookID) {
        if (BookList.get(BookID - 1) != null) {
            BookList.remove(BookID - 1);
            System.out.println("Book No " +  BookID + " successfully removed from library.");
        } else {
            System.err.println("Invalid input. Please enter a valid book ID.\n");
            System.err.flush();
        }
    }

    public void updateBook(int BookID, String part){
        Scanner input = new Scanner(System.in);
        int index = BookID - 1;
        if(BookList.get(index) != null){
            switch (part) {
                case "1" -> {
                    System.out.println("\nChange Title");
                    System.out.println("Before \t: " + BookList.get(index).getTittle());
                    System.out.print("After \t: ");
                    String sChange = input.nextLine();
                    BookList.get(index).setTittle(sChange);
                }
                case "2" -> {
                    System.out.println("\nChange Author");
                    System.out.println("Before \t: " + BookList.get(index).getAuthor());
                    System.out.print("After \t: ");
                    String sChange = input.nextLine();
                    BookList.get(index).setAuthor(sChange);
                }
                case "3" -> {
                    try{
                        System.out.println("\nChange Year");
                        System.out.println("Before \t: " + BookList.get(index).getYear());
                        System.out.print("After \t: ");
                        int sChange = input.nextInt();
                        BookList.get(index).setYear(sChange);
                    } catch (Exception e){
                        System.err.println("Invalid input for Year. Please enter an integer.\n");
                        System.err.flush();
                    }
                }
                case "4" -> {
                    try {
                        System.out.println("\nChange PageCount");
                        System.out.println("Before \t: " + BookList.get(index).getPageCount());
                        System.out.print("After \t: ");
                        int sChange = input.nextInt();
                        BookList.get(index).setPageCount(sChange);
                    }catch (Exception e){
                        System.err.println("Invalid input for Page Count. Please enter an Interger.\n");
                        System.err.flush();
                    }
                }
                case "5" -> {
                    System.out.println("\nChange Publisher");
                    System.out.println("Before \t: " + BookList.get(index).getPublisher());
                    System.out.print("After \t: ");
                    String sChange = input.nextLine();
                    BookList.get(index).setPublisher(sChange);
                }
                case "6" -> {
                    String Tittle = BookList.get(index).getTittle();
                    String Author = BookList.get(index).getAuthor();
                    int Year = BookList.get(index).getYear();
                    int PageCount = BookList.get(index).getPageCount();
                    String Publisher = BookList.get(index).getPublisher();

                    String BookType = "";
                    bookType:
                    while(true){
                        System.out.println("\n-= Book Type =-");
                        System.out.println("1. Textbooks");
                        System.out.println("2. Novel");
                        System.out.println("3. Comic");
                        System.out.print("Choice\t: ");
                        try{
                            int bookType = input.nextInt();
                            input.nextLine();
                            switch (bookType) {
                                case 1 -> {
                                    System.out.print("Lesson\t: ");
                                    String Lesson = input.nextLine();
                                    BookType = "Textbooks";
                                    TextBooks textbooks = new TextBooks(Tittle, Author, Year, PageCount, Publisher, Lesson, BookType );
                                    BookList.set(index,textbooks);
                                    break bookType;
                                }
                                case 2 -> {
                                    System.out.print("Genre\t: ");
                                    String GenreNovel = input.nextLine();
                                    BookType = "Novel";
                                    Novel novel = new Novel(Tittle, Author, Year, PageCount, Publisher, GenreNovel, BookType );
                                    BookList.set(index,novel);
                                    break bookType;
                                }
                                case 3 -> {
                                    System.out.print("Genre\t: ");
                                    String GenreComic = input.nextLine();
                                    BookType = "Comic";
                                    Comic comic = new Comic(Tittle, Author, Year, PageCount, Publisher, GenreComic, BookType);
                                    BookList.set(index,comic);
                                    break bookType;
                                }
                                default -> {
                                    System.err.println("Invalid input. Please enter a valid number for book type.\n");
                                    System.err.flush();
                                }
                            }
                        } catch (Exception e) {
                            System.err.println("Invalid input. Please enter a valid number for book type.\n");
                            System.err.flush();
                            input.nextLine();
                        }
                    }
                }
                case "7" -> {} // if user input "7", will return to home
                default -> {
                    System.err.println("Invalid choice.\n");
                    System.err.flush();
                }
            }
        }
    }
}