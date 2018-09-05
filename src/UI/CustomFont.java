package UI;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.File;

public class CustomFont {
    //    JLabel label = new JLabel("This is the font of DOOOOOOOOOOOM!");
    BufferStrategy buffStrat;

    public void render(Window window) {


        window.frame.createBufferStrategy(3);
        buffStrat = window.getBuffStrat();
                String message = "This is the font of DOOOOOOOOOOOM!";
        Font font;

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        try {
            //font = Font.createFont(Font.TRUETYPE_FONT, new File("C:/Windows/Fonts/mytype.ttf"));
            //ge.registerFont(font);
        } catch (Exception e) {
          //  e.printStackTrace();
            System.out.println(e.getMessage());
        }
        try{
            //font = new Font("consolas", Font.PLAIN, 24 );
           // g.setFont(Font.createFont(Font.TRUETYPE_FONT, new File("C:/Windows/Fonts/mytype.ttf")));
        }catch(Exception e){
            System.out.println("font error");
        }
        font = new Font("Consolas", Font.PLAIN, 24 );
        window.frame.setFont(font);
        Graphics g = window.getGraphics();
        g.setFont(font);



        //g = buffStrat.getDrawGraphics();
        g.setColor(Color.WHITE);
        g.drawString(message, 100, 100);
        g.dispose();
        buffStrat.show();

    }
}
