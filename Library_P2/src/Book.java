public abstract class Book {
    private String Tittle;
    private String Author;
    private int Year;
    private int PageCount;
    private String Publisher;
    private String BookType;

    public Book(String Tittle, String Author, int Year, int PageCount, String Publisher, String BookType){
        this.Tittle = Tittle;
        this.Author = Author;
        this.Year = Year;
        this.PageCount = PageCount;
        this.Publisher = Publisher;
        this.BookType = BookType;
    }


    public String getTittle() {
        return Tittle;
    }

    public void setTittle(String tittle) {
        Tittle = tittle;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public int getPageCount() {
        return PageCount;
    }

    public void setPageCount(int pageCount) {
        PageCount = pageCount;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }
    public String getBookType(){
        return BookType;
    }

    public abstract void display();
}
