import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class UserDetailsApplet extends Applet implements ActionListener {
    Label nameLabel, addressLabel, phoneLabel;
    TextField nameField, addressField, phoneField;
    Button submitButton;
    String name, address, phone;

    public void init() {
        nameLabel = new Label("Name: ");
        add(nameLabel);

        nameField = new TextField(20);
        add(nameField);

        addressLabel = new Label("Address: ");
        add(addressLabel);

        addressField = new TextField(20);
        add(addressField);

        phoneLabel = new Label("Phone: ");
        add(phoneLabel);

        phoneField = new TextField(20);
        add(phoneField);

        submitButton = new Button("Submit");
        add(submitButton);
        submitButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        name = nameField.getText();
        address = addressField.getText();
        phone = phoneField.getText();
        repaint();
    }

    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Name: " + name, 20, 150);

        g.setColor(Color.blue);
        g.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        g.drawString("Address: " + address, 20, 180);

        g.setColor(Color.green);
        g.setFont(new Font("Courier New", Font.PLAIN, 20));
        g.drawString("Phone: " + phone, 20, 210);
    }
}