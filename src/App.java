import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class App extends JFrame {
    protected Config config = new Config();
    private ConfigPanel configPanel;
    private JButton submitButton;
    private InfoPanel infoPanel;

    public App() {
        super();

        setLayout(new BorderLayout());
        setSize(1000,1000);

        this.add(this.configPanel = new ConfigPanel(this), BorderLayout.NORTH);
        this.add(this.submitButton = new JButton("Submit"), BorderLayout.SOUTH);
        this.add(this.infoPanel = new InfoPanel(), BorderLayout.WEST);

        this.submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submit();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new App();
    }

    public void submit() {
        this.configPanel.updateConfig();
        config.process();
    }
}
