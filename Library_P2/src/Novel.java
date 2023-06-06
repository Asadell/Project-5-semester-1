public class Novel extends Book {
    private String Genre;

    public Novel( String Tittle, String Author, int Year, int PageCount, String Publisher, String Genre , String BookType){
        super(Tittle, Author, Year, PageCount, Publisher, BookType);
        this.Genre = Genre;
    }

    public String getGenre(){
        return Genre;
    }

    public void display(){
        System.out.println("Title\t\t:\t" + getTittle());
        System.out.println("Author\t\t:\t" + getAuthor());
        System.out.println("Genre\t\t:\t" + getGenre());
        System.out.println("Year\t\t:\t" + getYear());
        System.out.println("Page Count\t:\t" + getPageCount());
        System.out.println("Publisher\t:\t" + getPublisher());
        System.out.println("BookType\t:\t" + getBookType());
    }
}
