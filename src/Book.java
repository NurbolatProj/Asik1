public class Book {

    private int id;
    private static int idGen = 1;
    private String title;
    private String author;
    private int year;
    private boolean available;

    public Book() {
        this.id = idGen++;
        this.available = true;
    }

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
        if (title == null || title.isEmpty())
            throw new IllegalArgumentException("Title is empty");
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author == null || author.isEmpty())
            throw new IllegalArgumentException("Author is empty");
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year < 1500 || year > 2025)
            throw new IllegalArgumentException("Wrong year");
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
        return id + ": " + title + " by " + author +
                " (" + year + "), available=" + available;
    }
}
