package bridge;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppGUI {

    public static void main(String[] args) {
        // Create main frame
        JFrame frame = new JFrame("Simple Swing bridge.App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        // Top Panel
        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.LIGHT_GRAY);
        JLabel titleLabel = new JLabel("Welcome to the bridge.App");
        topPanel.add(titleLabel);

        // Center Panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2, 2, 10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();
        centerPanel.add(nameLabel);
        centerPanel.add(nameField);
        centerPanel.add(emailLabel);
        centerPanel.add(emailField);

        // Bottom Panel
        JPanel bottomPanel = new JPanel();
        JButton submitButton = new JButton("Submit");
        JButton clearButton = new JButton("Clear");

        bottomPanel.add(submitButton);
        bottomPanel.add(clearButton);

        // Action Listeners
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                JOptionPane.showMessageDialog(frame, "Submitted:\nName: " + name + "\nEmail: " + email);
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nameField.setText("");
                emailField.setText("");
            }
        });

        // Add panels to frame
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Make it visible
        frame.setVisible(true);
    }
}