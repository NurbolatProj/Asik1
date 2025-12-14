import java.time.Year;

public class Book {

    private int id;
    private static int idGen = 1;
    private String title;
    private String author;
    private int year;
    private boolean available;

    // Default constructor
    public Book() {
        this.id = idGen++;
        this.available = true;
    }

    // Constructor with parameters
    public Book(String title, String author, int year) {
        this();
        setTitle(title);
        setAuthor(author);
        setYear(year);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author cannot be null or empty");
        }
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        int currentYear = Year.now().getValue();
        if (year < 1500 || year > currentYear) {
            throw new IllegalArgumentException("Invalid year");
        }
        this.year = year;
    }

    public boolean isAvailable() {
        return available;
    }

    public void markAsBorrowed() {
        available = false;
    }

    public void markAsReturned() {
        available = true;
    }

    @Override
    public String toString() {
        return "Book{id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", available=" + available + "}";
    }
}
