package model;

import javax.swing.*;

public class Admin extends User{
    public Admin(String email, String password, boolean blocked) {
        super(email, password, blocked);
    }

    @Override
    public void showProfile() {
        JOptionPane.showMessageDialog(null,"Administrator profile: " + getEmail());
    }
}
