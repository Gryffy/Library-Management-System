import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class LibrarySystem {
    private ArrayList<Book> books;
    private ArrayList<User> users;
    private final String BOOK_FILE = "books.txt";
    private final String USER_FILE = "users.txt";

    public LibrarySystem() {
        books = loadBooks();
        users = loadUsers();
    }

    // Book & User Storage
    @SuppressWarnings("unchecked")
    private ArrayList<Book> loadBooks() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(BOOK_FILE))) {
            return (ArrayList<Book>) in.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @SuppressWarnings("unchecked")
    private ArrayList<User> loadUsers() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(USER_FILE))) {
            return (ArrayList<User>) in.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    private void saveData() {
        try (ObjectOutputStream outBooks = new ObjectOutputStream(new FileOutputStream(BOOK_FILE));
             ObjectOutputStream outUsers = new ObjectOutputStream(new FileOutputStream(USER_FILE))) {
            outBooks.writeObject(books);
            outUsers.writeObject(users);
        } catch (IOException e) {
            System.out.println("⚠️ Error saving data.");
        }
    }

    // Add Book with Duplicate Check
    public void addBook(Book book) {
        for (Book b : books) {
            if (b.getIsbn().equalsIgnoreCase(book.getIsbn())) {
                System.out.println("❌ Book with this ISBN already exists.");
                return;
            }
        }
        books.add(book);
        saveData();
        System.out.println("✅ Book added successfully.");
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("📭 No books available.");
            return;
        }
        books.forEach(b -> {
            b.displayBookInfo();
            System.out.println("---------------------------");
        });
    }

    public void searchBook(String title) {
        boolean found = false;
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title.trim())) {
                b.displayBookInfo();
                found = true;
            }
        }
        if (!found) System.out.println("🔍 No book found with that title.");
    }

    public void addUser(User user) {
        for (User u : users) {
            if (u.getUserId().equalsIgnoreCase(user.getUserId())) {
                System.out.println("❌ User ID already registered.");
                return;
            }
        }
        users.add(user);
        saveData();
        System.out.println("✅ User registered successfully.");
    }

    public void viewUsers() {
        if (users.isEmpty()) {
            System.out.println("👥 No users registered.");
            return;
        }
        users.forEach(u -> {
            u.displayUserInfo();
            System.out.println("---------------------------");
        });
    }

    public void issueBook(String isbn, String userId) {
        Book book = books.stream()
                .filter(b -> b.getIsbn().equalsIgnoreCase(isbn.trim()) && !b.isIssued())
                .findFirst().orElse(null);

        if (book == null) {
            System.out.println("❌ Book is unavailable or already issued.");
            return;
        }

        boolean userExists = users.stream().anyMatch(u -> u.getUserId().equalsIgnoreCase(userId.trim()));
        if (!userExists) {
            System.out.println("❌ User ID not found.");
            return;
        }

        book.setIssued(true);
        saveData();
        System.out.println("✅ Book issued to User ID: " + userId);
    }

    public void returnBook(String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equalsIgnoreCase(isbn.trim())) {
                if (!b.isIssued()) {
                    System.out.println("⚠️ Book was not issued.");
                    return;
                }
                // Calculate fine
                long now = System.currentTimeMillis();
                long duration = now - b.getIssueTimestamp();
                long days = TimeUnit.MILLISECONDS.toDays(duration);
                if (days > 14) {
                    long fine = (days - 14) * 5; // ₹5 per day late
                    System.out.println("💸 Book is " + (days - 14) + " days late. Fine: ₹" + fine);
                }

                b.setIssued(false);
                saveData();
                System.out.println("✅ Book returned successfully.");
                return;
            }
        }
        System.out.println("❌ Book not found.");
    }
}
