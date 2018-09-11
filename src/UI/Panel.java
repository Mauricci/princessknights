package UI;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    Image background = Toolkit.getDefaultToolkit().createImage("/res/images/princess.jpg");
    Panel() {
        setPreferredSize(new Dimension(800,600));
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        graphics.drawString("Sessan gör KAOS med ALLA!", 30, 30);
        graphics.drawRect(100, 100, 100, 100);
        graphics.drawImage(background, 0, 0, null);
    }
}
