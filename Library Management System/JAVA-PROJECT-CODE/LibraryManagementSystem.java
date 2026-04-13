import java.util.Scanner;

// Book Class
class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    // Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Setter
    public void setAvailable(boolean status) {
        isAvailable = status;
    }
}

// Library Class
class Library {
    private Book[] books;

    // Constructor
    public Library() {
        books = new Book[5];

        books[0] = new Book("Java Basics", "James Gosling");
        books[1] = new Book("Data Structures", "Mark Allen");
        books[2] = new Book("Operating Systems", "Galvin");
        books[3] = new Book("Computer Networks", "Tanenbaum");
        books[4] = new Book("DBMS", "Korth");
    }

    // Display Books
    public void displayBooks() {
        System.out.println("\n--- Book List ---");
        for (int i = 0; i < books.length; i++) {
            System.out.println((i + 1) + ". " + books[i].getTitle()
                    + " - " + (books[i].isAvailable() ? "Available" : "Issued"));
        }
    }

    // Search Book
    public void searchBook(String title) {
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("\nBook Found:");
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Status: " +
                        (book.isAvailable() ? "Available" : "Issued"));
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("\nBook not found!");
        }
    }

    // Issue Book
    public void issueBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    System.out.println("\nBook issued successfully");
                } else {
                    System.out.println("\nBook is already issued");
                }
                return;
            }
        }
        System.out.println("\nBook not found!");
    }

    // Return Book
    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (!book.isAvailable()) {
                    book.setAvailable(true);
                    System.out.println("\nBook returned successfully");
                } else {
                    System.out.println("\nBook was not issued");
                }
                return;
            }
        }
        System.out.println("\nBook not found!");
    }
}

// Main Class
public class LibraryManagementSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library lib = new Library();

        int choice;
        String title;

        do {
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Display Books");
            System.out.println("2. Search Book");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    lib.displayBooks();
                    break;

                case 2:
                    System.out.print("Enter book title: ");
                    title = sc.nextLine();
                    lib.searchBook(title);
                    break;

                case 3:
                    System.out.print("Enter book title to issue: ");
                    title = sc.nextLine();
                    lib.issueBook(title);
                    break;

                case 4:
                    System.out.print("Enter book title to return: ");
                    title = sc.nextLine();
                    lib.returnBook(title);
                    break;

                case 5:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}