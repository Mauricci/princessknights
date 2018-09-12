package UI;

import Story.Dialog;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Panel extends JPanel {
    Image background = Toolkit.getDefaultToolkit().createImage("/res/images/princess.jpg");
    String stringText;
    ArrayList<Drawable> drawingObjects = new ArrayList<>();
    private Graphics graphics;


    public Panel() {
        setPreferredSize(new Dimension(800, 600));

    }

    public void setDrawable(ArrayList<Drawable> drawable) {
        this.drawingObjects = drawable;
    }


    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        graphics.drawString(stringText, 30, 30);
//        graphics.drawRect(100, 100, 100, 100);
        graphics.drawImage(background, 0, 0, null);

        for (Drawable drawable : drawingObjects) {
            if(drawable instanceof Dialog){
                Dialog dialog = (Dialog)(drawable);
                graphics.drawString(dialog.getText(), 100, 100);
                System.out.println("hej hopp");
//                drawDialog((Dialog)drawable);
            }
        }
    }

    public void setText(String string) {
        stringText = string;
    }
    public void render(ArrayList<Drawable> drawingObjects) {
        if (drawingObjects.size() > 0) {
            Drawable drawable = drawingObjects.get(0);
            if(drawable instanceof Story.Dialog){
                setText(((Dialog) drawable).getText());
            }
        }
    }


    private void drawDialog(Dialog dialog) {
        graphics.setColor(Color.gray);
        int rectX = WIDTH/2-(int)(WIDTH*0.4);
        int rectY = HEIGHT/2+40;
        graphics.fillRoundRect(rectX,rectY, (int)(WIDTH*0.8),(int)(HEIGHT*0.35),30,30);
        drawText(dialog.getText(),rectX+20,rectY+40, 20);
    }
    private void drawText(String text, int x, int y, int size) {
        Font font = new Font("Consolas", Font.PLAIN, size);
        System.out.println("ritar ut " +text);
        graphics.setFont(font);
        graphics.setColor(Color.WHITE);
        graphics.drawString(text, x, y);
    }
}



