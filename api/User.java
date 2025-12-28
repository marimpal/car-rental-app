package api;

public class User {

    private String name;
    private String surname;
    private String email;
    private String username;
    private String password;

    public User(String name,String surname,String username, String email, String password) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.surname = surname;
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
    public String getSurname() {return surname;}
}
