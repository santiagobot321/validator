package service;

import model.Client;

import javax.swing.*;
import java.util.HashMap;

public class UserService {

    private HashMap<String, Client> clientStored = new HashMap<>();

    public void addClient(Client client) {
        clientStored.put(client.getEmail(), client);
    }

    // Actualizar solo email
    public void updatingEmail() {
        String actEmail = JOptionPane.showInputDialog(null, "Type your current email");
        Client client = clientStored.get(actEmail);

        if (client == null) {
            JOptionPane.showMessageDialog(null, "User not found");
            return;
        }

        String uptEmail = JOptionPane.showInputDialog(null, "Type the new email");
        boolean success = client.updateEmail(uptEmail);

        if (!success) {
            JOptionPane.showMessageDialog(null, "Invalid email. Update failed.");
            return;
        }

        // Si el email cambió, actualizar la clave del HashMap
        if (!actEmail.equals(uptEmail)) {
            clientStored.remove(actEmail);
            clientStored.put(uptEmail, client);
        }

        JOptionPane.showMessageDialog(null, "Email updated successfully!");
    }

    // Actualizar solo dirección
    public void updatingAddress() {
        String actEmail = JOptionPane.showInputDialog(null, "Type your email");
        Client client = clientStored.get(actEmail);

        if (client == null) {
            JOptionPane.showMessageDialog(null, "User not found");
            return;
        }

        String uptAddress = JOptionPane.showInputDialog(null, "Type the new address");
        boolean success = client.updateAddress(uptAddress);

        if (!success) {
            JOptionPane.showMessageDialog(null, "Invalid address. Update failed.");
            return;
        }

        JOptionPane.showMessageDialog(null, "Address updated successfully!");
    }

    // Mostrar todos los clientes
    public void showClients() {
        StringBuilder sb = new StringBuilder();
        for (Client c : clientStored.values()) {
            sb.append("Email: ").append(c.getEmail())
                    .append(" | Address: ").append(c.getAddress())
                    .append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
