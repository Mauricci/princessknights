package UI;

import Story.Dialog;
import Story.Scenario;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Panel extends JPanel {
    Image background = Toolkit.getDefaultToolkit().createImage("/res/images/princess.jpg");
    String stringText;
    ArrayList<Drawable> drawingObjects = new ArrayList<>();
    private Graphics graphics;
    private int scenarioLap = 0;
    private boolean drawingScenarios = false;
    private int selectedChoice;
    private boolean currentScenarioDone = false;


    public Panel() {
        setPreferredSize(new Dimension(800, 600));

    }

    public void setDrawable(ArrayList<Drawable> drawable) {
        this.drawingObjects = drawable;
    }


    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        graphics.drawString("Princess Knights", 30, 30);
//        graphics.drawRect(100, 100, 100, 100);
        graphics.drawImage(background, 0, 0, null);

        for (Drawable drawable : drawingObjects) {
            if(drawable instanceof Dialog){
                Dialog dialog = (Dialog)(drawable);
//                graphics.drawString(dialog.getText(), 100, 100);
//                drawText(graphics, dialog.getText(), 100, 100, 24);
                System.out.println("hej hopp");
                drawDialog(dialog, graphics);
            }else if(drawable instanceof Scenario){
                currentScenarioDone = false;
                drawingScenarios = true;
                Scenario scenario = (Scenario)(drawable);
                if(scenario.getScenarioDone()){
                    currentScenarioDone = true;
                    selectedChoice++;
                }
                drawScenario(scenario, graphics);
            }
        }
        scenarioLap=0;
        drawingScenarios = false;
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
        repaint();
    }


    private void drawDialog(Dialog dialog, Graphics graphics) {
        graphics.setColor(Color.gray);
        int rectX = WIDTH/2-(int)(WIDTH*0.4);
        int rectY = HEIGHT/2+40;
        graphics.fillRoundRect(rectX,rectY, (int)(WIDTH*0.8),(int)(HEIGHT*0.35),30,30);
        drawText(graphics, dialog.getText(),rectX+20,rectY+40, 20);
    }
    private void drawText(Graphics graphics, String text, int x, int y, int size) {
        int length = 66;
        int lineLength = length;
        graphics.setColor(Color.WHITE);
        Font font = new Font("Consolas", Font.PLAIN, size);
        graphics.setFont(font);
        while (text.length() > length) {
            for(int i = length; i > 0; i--){
                if(text.charAt(i) == ' '){
                    lineLength = i;
                    break;
                }
            }
            String viewLine = text.substring(0, lineLength);
            text = text.substring(lineLength, text.length());
            System.out.println("ritar ut " + text);

            graphics.drawString(viewLine, x, y);
            y = y + 25;
        }

        if(drawingScenarios && currentScenarioDone){
            graphics.setColor(Color.RED);
        }else if(drawingScenarios && scenarioLap == selectedChoice){
            graphics.setColor(Color.YELLOW);
        }
        System.out.println("ritar ut " + text);
        graphics.drawString(text, x, y);
    }

    public void drawScenario(Scenario scenario, Graphics graphics) {
        //setText();
        int rectX = WIDTH/2-(int)(WIDTH*0.4);
        int rectY = HEIGHT/2+40;
        drawText(graphics,scenario.getText(), rectX+20,(rectY+40)+(scenarioLap*25),20);
        scenarioLap++;
    }
    
    public int getSelectedChoice(){
        return selectedChoice;
    }

    public void decrementChoice() {
    }

    public void incrementChoice() {
    }
}



