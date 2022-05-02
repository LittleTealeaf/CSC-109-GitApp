import javax.swing.*;
import java.awt.*;

public class TextBox extends JPanel {
    private JLabel label;
    private JTextField textField;

    public TextBox(String text) {
        this.setLayout(new BorderLayout());

        this.label = new JLabel(text);
        this.textField = new JTextField(200);

        this.add(this.label, BorderLayout.WEST);
        this.add(this.textField, BorderLayout.CENTER);
    }

    public String getInput() {
        return this.textField.getText();
    }
}