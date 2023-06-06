import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Library perpus = new Library();

        home:
        while (true) {
            System.out.println("\n-- Library --");
            System.out.println("1. Add Book");
            System.out.println("2. Book List");
            System.out.println("3. Find Book");
            System.out.println("4. Remove Book");
            System.out.println("5. Update Book");
            System.out.println("6. Out");
            System.out.print("Choice: ");

            try{
                int Choice = input.nextInt();
                input.nextLine();
                switch (Choice) {
                    case 1 -> {
                        System.out.println("\n==Please fill in the book information ==");
                        System.out.print("Title\t\t: ");
                        String Tittle = input.nextLine();
                        System.out.print("Author\t\t: ");
                        String Author = input.nextLine();
                        //Year
                        System.out.print("Year\t\t: ");
                        int Year = 0;
                        try {
                            Year = Integer.parseInt(input.nextLine());
                        } catch (Exception e) {
                            System.err.println("Invalid input for Year. Please enter an integer.\n");
                            System.err.flush();
                            continue;
                        }
                        //Page Count
                        System.out.print("Page Count\t: ");
                        int PageCount = 0;
                        try {
                            PageCount = Integer.parseInt(input.nextLine());
                        } catch (Exception e) {
                            System.err.println("Invalid input for Page Count. Please enter an integer.\n");
                            System.err.flush();
                            continue;
                        }
                        System.out.print("Publisher\t: ");
                        String Publisher = input.nextLine();

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
                                        Book textbooks = new TextBooks(Tittle, Author, Year, PageCount, Publisher, Lesson, BookType );
                                        perpus.addBook(textbooks);
                                        break bookType;
                                    }
                                    case 2 -> {
                                        System.out.print("Genre\t: ");
                                        String GenreNovel = input.nextLine();
                                        BookType = "Novel";
                                        Book novel = new Novel(Tittle, Author, Year, PageCount, Publisher, GenreNovel, BookType );
                                        perpus.addBook(novel);
                                        break bookType;
                                    }
                                    case 3 -> {
                                        System.out.print("Genre\t: ");
                                        String GenreComic = input.nextLine();
                                        BookType = "Comic";
                                        Book comic = new Comic(Tittle, Author, Year, PageCount, Publisher, GenreComic, BookType);
                                        perpus.addBook(comic);
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
                    case 2 -> perpus.ListBook();
                    case 3 -> {
                        if(Library.isBookListEmpty()) break;
                        try {
                            System.out.print("\nBook ID: ");
                            int BookID = input.nextInt();
                            input.nextLine();
                            perpus.FindBook(BookID);
                        } catch (Exception e) {
                            System.err.println("Invalid input. Please enter a valid book ID.\n");
                            System.err.flush();
                            input.nextLine();
                        }
                    }
                    case 4 -> {
                        if(Library.isBookListEmpty()) break;
                        try {
                            System.out.print("\nBook ID: ");
                            int BookID = input.nextInt();
                            input.nextLine();
                            perpus.removeBook(BookID);
                        } catch (Exception e) {
                            System.err.println("Invalid input. Please enter a valid book ID.\n");
                            System.err.flush();
//                            input.nextLine();
                        }
                    }
                    case 5 -> {
                        if(Library.isBookListEmpty()) break;
                        System.out.print("\nUpdate Book ID: ");
                        int bookId = input.nextInt();
                        input.nextLine();
                        if(bookId > Library.getTotalBooks()){
                            System.err.println("Book No " + bookId + " is not found in the library.\n");
                            System.err.flush();
                            break;
                        }

                        System.out.println("\nWhat part do you want to update, from Book No " + bookId);
                        System.out.println("1. Title");
                        System.out.println("2. Author");
                        System.out.println("3. Year");
                        System.out.println("4. PageCount");
                        System.out.println("5. Publisher");
                        System.out.println("6. Book Type");
                        System.out.println("7. out");
                        System.out.print("Choice : ");
                        String part = input.nextLine();
                        perpus.updateBook(bookId,part);
                    }
                    case 6 -> {
                        break home;
                    }
                    default -> {
                        System.err.println("Invalid input. Please enter a Valid Number\n");
                        System.err.flush();
                    }
                }
            }catch (Exception e){
                System.err.println("Invalid input. Please enter a Valid Number\n");
                System.err.flush();
                input.nextLine();
            }
        }
    }
}