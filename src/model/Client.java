package model;

import javax.swing.*;

public class Client extends User{

    public Client(String email, String password, boolean blocked){
        super(email, password, blocked);
    }

    @Override
    public void showProfile() {
        JOptionPane.showMessageDialog(null,"Client information: " + getEmail());
    }
}
