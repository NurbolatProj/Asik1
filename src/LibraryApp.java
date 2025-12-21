import java.util.ArrayList;
import java.util.Scanner;

public class LibraryApp {

    private ArrayList<Book> books = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("""
                    1. Print books
                    2. Add book
                    3. Borrow book
                    4. Return book
                    5. Delete book
                    6. Quit
                    """);

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> printBooks();
                case 2 -> addBook();
                case 3 -> borrowBook();
                case 4 -> returnBook();
                case 5 -> deleteBook();
                case 6 -> {
                    System.out.println("Bye!");
                    return;
                }
            }
        }
    }

    private void printBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in library");
            return;
        }
        for (Book b : books) {
            System.out.println(b);
        }
    }

    private void addBook() {
        System.out.print("Title: ");
        String title = sc.nextLine();
        System.out.print("Author: ");
        String author = sc.nextLine();
        System.out.print("Year: ");
        int year = sc.nextInt();

        books.add(new Book(title, author, year));
    }

    private void borrowBook() {
        System.out.print("Book id: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.getId() == id) {
                if (b.isAvailable()) {
                    b.markAsBorrowed();
                    System.out.println("Book borrowed");
                } else {
                    System.out.println("Already borrowed");
                }
                return;
            }
        }
        System.out.println("Book not found");
    }

    private void returnBook() {
        System.out.print("Book id: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.getId() == id) {
                b.markAsReturned();
                System.out.println("Book returned");
                return;
            }
        }
        System.out.println("Book not found");
    }

    private void deleteBook() {
        System.out.print("Book id: ");
        int id = sc.nextInt();

        books.removeIf(b -> b.getId() == id);
    }

    public static void main(String[] args) {
        new LibraryApp().run();
    }
}
