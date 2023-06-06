public class TextBooks extends Book{
    private String Lesson;

    public TextBooks( String Tittle, String Author, int Year, int PageCount, String Publisher, String Lesson, String BookType){
        super( Tittle, Author, Year, PageCount, Publisher, BookType);
        this.Lesson = Lesson;
    }

    public String getLesson(){
        return Lesson;
    }

    public void display() {
        System.out.println("Title\t\t:\t" + getTittle());
        System.out.println("Author\t\t:\t" + getAuthor());
        System.out.println("Lesson\t\t:\t" + getLesson());
        System.out.println("Year\t\t:\t" + getYear());
        System.out.println("Page Count\t:\t" + getPageCount());
        System.out.println("Publisher\t:\t" + getPublisher());
        System.out.println("BookType\t:\t" + getBookType());
    }
}