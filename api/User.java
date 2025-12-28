package api;

public class User {

    private String name;
    private String email;
    private String username;
    private String password;

    public User(String name, String email, String username, String password, String trim) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    // Getters
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
}
