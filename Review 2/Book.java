import java.io.Serializable;

public class Book implements Serializable {
    private String title;
    private String author;
    private String isbn;
    private boolean isIssued;
    private long issueTimestamp;

    public Book(String title, String author, String isbn) {
        this.title = title.trim();
        this.author = author.trim();
        this.isbn = isbn.trim();
        this.isIssued = false;
        this.issueTimestamp = 0;
    }

    // Getters & Setters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public boolean isIssued() { return isIssued; }
    public long getIssueTimestamp() { return issueTimestamp; }

    public void setIssued(boolean issued) {
        isIssued = issued;
        issueTimestamp = issued ? System.currentTimeMillis() : 0;
    }

    public void displayBookInfo() {
        System.out.println("📘 Title: " + title);
        System.out.println("✍️ Author: " + author);
        System.out.println("🔢 ISBN: " + isbn);
        System.out.println("📦 Status: " + (isIssued ? "Issued" : "Available"));
    }
}
