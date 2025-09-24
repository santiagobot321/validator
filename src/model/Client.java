package model;

import javax.swing.*;
import java.util.regex.Pattern;

public class Client extends User {

    private String address;

    public Client(String email, String password, boolean blocked, String address) {
        super(email, password, blocked);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void showProfile() {
        JOptionPane.showMessageDialog(null,
                "Client information:\nEmail: " + getEmail() + "\nAddress: " + getAddress());
    }


    public boolean updateEmail(String newEmail) {
        if (newEmail == null || newEmail.trim().isEmpty() ||
                !Pattern.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,3}$", newEmail)) {
            return false;
        }
        setEmail(newEmail);
        return true;
    }


    public boolean updateAddress(String newAddress) {
        if (newAddress == null || newAddress.trim().isEmpty()) {
            return false;
        }
        setAddress(newAddress);
        return true;
    }

    public void blocking(){
        setBlocked(true);
    }


}
