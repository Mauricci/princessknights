package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Window extends Canvas implements Runnable {

    JFrame frame;
    private final int WIDTH = 800;
    private final int HEIGHT = 500;
    private final Dimension windowSize = new Dimension(WIDTH, HEIGHT);
    private Canvas canvas;
    private Graphics graphics;
    private BufferStrategy buffStrat;
    private final String title = "Princess Knights";

    BufferedImage image;

    static boolean running = false;


    @Override
    public void run() {
        while(running) {
            render(new ArrayList<>());
            try {
                Thread.sleep(7);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public synchronized void start() {
        running = true;
//        new Thread(this).start();
    }

    public static synchronized void stop() {
        running = false;
    }

    public Window() {
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

        canvas = new Canvas();
        canvas.setMinimumSize(windowSize);
        canvas.setMaximumSize(windowSize);
        canvas.setPreferredSize(windowSize);

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(canvas, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setTitle(title);
        frame.setLocationRelativeTo(null);

        canvas.createBufferStrategy(2);
        buffStrat = canvas.getBufferStrategy();
        graphics = buffStrat.getDrawGraphics();

        //things (dialog/stuff) to render in window goes here
    }

    public void tick() {
        //update method, if needed
    }

    public void render(ArrayList<Drawable> drawingObjects) {

        if(buffStrat == null) {
            frame.createBufferStrategy(3);
            return;
        }
        graphics = buffStrat.getDrawGraphics();

        //background
        graphics.setColor(Color.BLACK);
        graphics.drawImage(image, 0, 0, 800, 500, null);

        //font goes here
        graphics.setColor(Color.WHITE);
        String string = "Hej hopp";
        graphics.drawString(string, 50, 50);

        String fontMessage = "Nya fonten";
        Font font = new Font("Consolas", Font.PLAIN, 36 );
        //Font font = null;
        try{
             font = Font.createFont(Font.TRUETYPE_FONT, new File("C:/Windows/Fonts/mytype.ttf"));
            //graphics.setFont(font);
        }catch(Exception e){

        }

        for(Drawable drawable : drawingObjects){

        }

        font = font.deriveFont(font.getSize()*50f);
        graphics.setFont(font);//new Font("mvboli", Font.BOLD, 10)
        //frame.setFont(font);
        //graphics.setFont(font);
        graphics.drawString(fontMessage, 100, 100);


        graphics.dispose();
        buffStrat.show();
    }
    public Canvas getCanvas(){
        return canvas;
    }
    public Graphics getGraphics(){
        return graphics;
    }

    public BufferStrategy getBuffStrat(){
        return buffStrat;
    }
    public static void main(String[] args) {
        Graphics graphics;
        Window wind = new Window();
        wind.render(new ArrayList<>());

        CustomFont cust = new CustomFont();
        cust.render(wind);
    }
}


