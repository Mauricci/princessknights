package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.IOException;

public class CustomFont implements Drawable {
    //    JLabel label = new JLabel("This is the font of DOOOOOOOOOOOM!");
    BufferStrategy buffStrat;



    @Override
    public void render(Graphics g) {
        String message = "This is the font of DOOOOOOOOOOOM!";

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        try {
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("/fonts/mytype.ttf")));
        } catch (Exception e) {
            e.printStackTrace();
        }

        g = buffStrat.getDrawGraphics();
        g.setColor(Color.WHITE);
        g.drawString(message, 100, 100);
    }
}
