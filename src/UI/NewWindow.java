package UI;

import Story.Dialog;
import Story.Scenario;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.util.ArrayList;

public class NewWindow extends JFrame implements ActionListener {
    private JButton button, button2, button3;
    private Panel panel;
    private BufferStrategy bufferStrategy;
    private Canvas canvas;
    private Image image;
    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    private final Dimension windowSize = new Dimension(WIDTH, HEIGHT);
    private boolean alternative1;
    private boolean alternative2;
    private boolean alternative3;
    private boolean drawingScenarios = false;


    public static void main(String[] args) {
        new NewWindow().setVisible(true);
    }

    public NewWindow() {
        super("Princess Knights");

        setSize(800, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        panel = new Panel();
        panel.setBackground(Color.BLACK);
        int gap = 85;
        panel.setBorder(BorderFactory.createEmptyBorder(gap,gap,gap,gap));//createBevelBorder(BevelBorder.RAISED)
        panel.setVisible(true);
        //panel.setLayout(new GridLayout(2, 1)); //ändra första siffran för att ändra antal grids (liggandes/horisontellt)
        panel.setLayout(new BorderLayout()); //lägger knapparna i utkanten av fönstret

        this.setContentPane(panel);

        button = new JButton("Alt 1");
        button.setActionCommand("click");
        button2 = new JButton("Alt 2");
        button2.setActionCommand("click2");
        button3 = new JButton();
        button3.setActionCommand("click3");

        //insert button image here...image should be max 32x32
        try {
            System.out.println("fin knapp");
            Image image = ImageIO.read(new File("res/images/arrow.png"));
            button3.setIcon(new ImageIcon(image));
            System.out.println(image);
        }catch (Exception ex) {
            ex.printStackTrace();
        }

        //Test to check file existence
        File imageCheck = new File("res/images/buttongreen.png");
        if (imageCheck.exists()) {
            System.out.println("File found");
        } else
            System.out.println("File not found");

        panel.setText("Test");

        JPanel jpanel = new JPanel();
        jpanel.setOpaque(false);
//        JMenuBar bar = new JMenuBar();
//        setJMenuBar(bar);

        button.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);

        /*add(button);                    //(button, BorderLayout.WEST) för att placera knappen längst vänster ytterkant
        add(button2);
        add(button3);*/
        jpanel.add(button);
        jpanel.add(button2);
        jpanel.add(button3);
        //add(jpanel);
        //jpanel.setLocation(200,450);
        panel.add(jpanel,BorderLayout.SOUTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = e.getActionCommand();

        if(name.equals("click")) {
            alternative1 = true;
            if(drawingScenarios){
                panel.decrementChoice();
            }
            System.out.println("Knapp 1 funkar");
        } else if (name.equals("click2")) {
            if(drawingScenarios){
                panel.incrementChoice();
            }
            alternative2 = true;
            System.out.println("Knapp 2 funkar");
        }else if(name.equals("click3")){
            alternative3 = true;
        }
    }

    public void render(ArrayList<Drawable> drawingObjects) {
        panel.setDrawable(drawingObjects);
        if (drawingObjects.size() > 0) {
            Drawable drawable = drawingObjects.get(0);
            if(drawable instanceof Story.Dialog){
                panel.setText(((Dialog) drawable).getText());
                drawingScenarios = false;
            }else if(drawable instanceof Story.Scenario){
                drawingScenarios = true;
            }
        }
        panel.render(drawingObjects);
    }
    public void resetAlternatives() {
        alternative1 = false;
        alternative2 = false;
        alternative3 = false;
    }

    public boolean isAlternative1() {
        //System.out.println(alternative1);
        return alternative1;
    }

    public boolean isAlternative2() {
        //System.out.println(alternative2);
        return alternative2;
    }
    public boolean isAlternative3(){
        return alternative3;
    }

    public int getSelectedChoide(){
        return panel.getSelectedChoice();
    }

}