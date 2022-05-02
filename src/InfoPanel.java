import java.io.File;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoPanel extends JPanel {
    private JLabel microsoft;
    private JLabel quinnipiac;
    private JLabel disclaimer;

    public InfoPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        try {
            this.add(this.microsoft = this.loadImage("assets/microsoft.png"));
            this.add(this.quinnipiac = this.loadImage("assets/quinnipiac.png"));
            this.add(this.disclaimer = new JLabel("Disclaimer: this app is just a prototype!"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JLabel loadImage(String location) throws Exception {
        BufferedImage image = ImageIO.read(
            new File(location)
        );

        double scale = 400.0 / image.getWidth();

        JLabel logo = new JLabel(
            new ImageIcon(
                image.getScaledInstance(
                    (int) (image.getWidth() * scale),
                    (int) (image.getHeight() * scale),
                    Image.SCALE_SMOOTH
                )
            )
        );

        return logo;
    }
}
