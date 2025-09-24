package model;

import security.Autenticable;
import java.util.regex.Pattern;

public abstract class User implements Autenticable{
    private String email;
    private String password;
    private boolean blocked;

    public User(String email, String password, boolean blocked) {
        setEmail(email);
        setPassword(password);
        setBlocked(blocked);
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty() ||
                !Pattern.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,3}$", email)) {
            throw new IllegalArgumentException("Email format incorrect");
        }
        this.email = email;
    }

    public void setPassword(String password) {
        if (password == null || password.trim().isEmpty() || password.length() < 6) {
            throw new IllegalArgumentException("Password format incorrect");
        }
        this.password = password;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public abstract void showProfile();

    @Override
    public boolean Authenticated(String email, String password) {
        return !blocked && this.email.equals(email) && this.getPassword().equals(password);
    }

    // En Usuario.java (la clase abstracta)
    public void block() {
        setBlocked(true);
    }

    public void unblock() {
        setBlocked(false);
    }


}