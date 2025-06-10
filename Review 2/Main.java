import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n====== Library Management System ======");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book by Title");
            System.out.println("4. Register User");
            System.out.println("5. View Users");
            System.out.println("6. Issue Book");
            System.out.println("7. Return Book");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.print("🔁 Enter a number: ");
                scanner.next();
            }

            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("📘 Title: ");
                    String title = scanner.nextLine();
                    System.out.print("✍️ Author: ");
                    String author = scanner.nextLine();
                    System.out.print("🔢 ISBN: ");
                    String isbn = scanner.nextLine();
                    if (title.isBlank() || author.isBlank() || isbn.isBlank()) {
                        System.out.println("❌ All fields are required.");
                        break;
                    }
                    library.addBook(new Book(title, author, isbn));
                    break;

                case 2:
                    library.viewBooks();
                    break;

                case 3:
                    System.out.print("🔍 Enter book title: ");
                    library.searchBook(scanner.nextLine());
                    break;

                case 4:
                    System.out.print("👤 Name: ");
                    String name = scanner.nextLine();
                    System.out.print("🆔 User ID: ");
                    String userId = scanner.nextLine();
                    if (name.isBlank() || userId.isBlank()) {
                        System.out.println("❌ Both fields are required.");
                        break;
                    }
                    library.addUser(new User(name, userId));
                    break;

                case 5:
                    library.viewUsers();
                    break;

                case 6:
                    System.out.print("📘 Book ISBN: ");
                    String issueIsbn = scanner.nextLine();
                    System.out.print("🆔 User ID: ");
                    String issueUser = scanner.nextLine();
                    library.issueBook(issueIsbn, issueUser);
                    break;

                case 7:
                    System.out.print("📘 ISBN to return: ");
                    library.returnBook(scanner.nextLine());
                    break;

                case 0:
                    System.out.println("👋 Exiting system. Goodbye!");
                    break;

                default:
                    System.out.println("❗ Invalid choice.");
            }

        } while (choice != 0);

        scanner.close();
    }
}
