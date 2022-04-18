import javax.swing.*;
import java.awt.*;

import javax.swing.JFrame;

public class App extends JFrame {

    public App() {
        super();

        setLayout(new BorderLayout());
        setSize(1000,1000);


        setVisible(true);
    }

    public static void main(String[] args) {
        new App();
    }
}
