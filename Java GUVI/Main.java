import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookDAO dao = new BookDAOImpl();

        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. View Book by ID");
            System.out.println("3. View All Books");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    System.out.print("Year: ");
                    int year = sc.nextInt();
                    dao.addBook(new Book(0, title, author, year));
                    break;
                case 2:
                    System.out.print("Book ID: ");
                    Book b = dao.getBookById(sc.nextInt());
                    System.out.println(b != null ? b.getTitle() + " by " + b.getAuthor() : "Book not found");
                    break;
                case 3:
                    List<Book> books = dao.getAllBooks();
                    books.forEach(book -> System.out.println(book.getId() + " - " + book.getTitle()));
                    break;
                case 4:
                    System.out.print("Book ID to update: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("New Title: ");
                    String newTitle = sc.nextLine();
                    System.out.print("New Author: ");
                    String newAuthor = sc.nextLine();
                    System.out.print("New Year: ");
                    int newYear = sc.nextInt();
                    dao.updateBook(new Book(id, newTitle, newAuthor, newYear));
                    break;
                case 5:
                    System.out.print("Book ID to delete: ");
                    dao.deleteBook(sc.nextInt());
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }
}
