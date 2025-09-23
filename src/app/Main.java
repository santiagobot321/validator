package app;

import model.Admin;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Admin admin1 = new Admin("coco@coco.com", "pepe123", false);

        String emailInput = JOptionPane.showInputDialog("Enter email:");
        String passwordInput = JOptionPane.showInputDialog("Enter password:");

        if (admin1.Authenticated(emailInput, passwordInput)) {
            JOptionPane.showMessageDialog(null, "Login successful");
            admin1.showProfile();
        } else {
            JOptionPane.showMessageDialog(null, "Login failed");
        }
    }
}
