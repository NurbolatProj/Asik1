import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryApp {

    private List<Book> books = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new LibraryApp().run();
    }

    public void run() {
        boolean running = true;

        while (running) {
            System.out.println("\nWelcome to Library App!");
            System.out.println("1. Print all books");
            System.out.println("2. Add new book");
            System.out.println("3. Search books by title");
            System.out.println("4. Borrow a book");
            System.out.println("5. Return a book");
            System.out.println("6. Delete a book by id");
            System.out.println("7. Quit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> printAllBooks();
                case 2 -> addNewBook();
                case 3 -> searchByTitle();
                case 4 -> borrowBook();
                case 5 -> returnBook();
                case 6 -> deleteBook();
                case 7 -> running = false;
                default -> System.out.println("Invalid option");
            }
        }
    }

    private void printAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library");
            return;
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }

    private void addNewBook() {
        try {
            System.out.print("Title: ");
            String title = scanner.nextLine();
            System.out.print("Author: ");
            String author = scanner.nextLine();
            System.out.print("Year: ");
            int year = scanner.nextInt();
            scanner.nextLine();

            Book book = new Book(title, author, year);
            books.add(book);
            System.out.println("Book added successfully");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine();
        }
    }

    private void searchByTitle() {
        System.out.print("Enter part of title: ");
        String query = scanner.nextLine().toLowerCase();

        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(query)) {
                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found");
        }
    }

    private void borrowBook() {
        System.out.print("Enter book id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Book book : books) {
            if (book.getId() == id) {
                if (book.isAvailable()) {
                    book.markAsBorrowed();
                    System.out.println("Book borrowed");
                } else {
                    System.out.println("Book is already borrowed");
                }
                return;
            }
        }
        System.out.println("Book not found");
    }

    private void returnBook() {
        System.out.print("Enter book id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Book book : books) {
            if (book.getId() == id) {
                if (!book.isAvailable()) {
                    book.markAsReturned();
                    System.out.println("Book returned");
                } else {
                    System.out.println("Book was not borrowed");
                }
                return;
            }
        }
        System.out.println("Book not found");
    }

    private void deleteBook() {
        System.out.print("Enter book id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Book book : books) {
            if (book.getId() == id) {
                books.remove(book);
                System.out.println("Book deleted");
                return;
            }
        }
        System.out.println("Book not found");
    }
}
