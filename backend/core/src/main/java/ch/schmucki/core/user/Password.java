package ch.schmucki.core.user;

public class Password {
    private String password;

    public Password(String password) {
        if (!isValid(password)) {
            throw new IllegalArgumentException("Invalid password");
        }
        this.password = password;
    }

    public boolean isValid(String password) {
        if (!password.matches("^[A-Za-z0-9]*$")) {
            return false;
        }
        if (password.length() < 8) {
            return false;
        }
        return true;
    }

    public String getPassword() {
        return password;
    }
}
