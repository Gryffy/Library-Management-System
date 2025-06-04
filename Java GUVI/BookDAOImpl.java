import java.sql.*;
import java.util.*;

public class BookDAOImpl implements BookDAO {

    public void addBook(Book book) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO books (title, author, year) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setInt(3, book.getYear());
            stmt.executeUpdate();
            System.out.println("Book added successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Book getBookById(int id) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM books WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Book(rs.getInt("id"), rs.getString("title"),
                        rs.getString("author"), rs.getInt("year"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Book> getAllBooks() {
        List<Book> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM books";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                list.add(new Book(rs.getInt("id"), rs.getString("title"),
                        rs.getString("author"), rs.getInt("year")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateBook(Book book) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE books SET title=?, author=?, year=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setInt(3, book.getYear());
            stmt.setInt(4, book.getId());
            stmt.executeUpdate();
            System.out.println("Book updated.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteBook(int id) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM books WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Book deleted.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
