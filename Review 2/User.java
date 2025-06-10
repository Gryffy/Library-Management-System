import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String userId;

    public User(String name, String userId) {
        this.name = name.trim();
        this.userId = userId.trim();
    }

    public String getName() { return name; }
    public String getUserId() { return userId; }

    public void displayUserInfo() {
        System.out.println("👤 Name: " + name);
        System.out.println("🆔 User ID: " + userId);
    }
}
