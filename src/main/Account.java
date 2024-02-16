package main;

public class Account {
    private String email;
    private String password;

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
        // this.password = Util.hash(password);
    }

    protected String getEmail() {
        return email;
    }

    protected String getPassword() {
        return password;
    }
}
