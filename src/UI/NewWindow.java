package UI;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class NewWindow extends JFrame implements ActionListener {
    private JButton button, button2;
    private JPanel panelJaevel;
    private Graphics graphics;
    private BufferStrategy bufferStrategy;
    private Canvas canvas;
    private Image image;
    private final int WIDTH = 800;
    private final int HEIGTH = 600;
    private final Dimension windowSize = new Dimension(WIDTH, HEIGTH);



    public static void main(String[] args) {
        new NewWindow().setVisible(true);
    }

    private NewWindow() {
        super("Ett jävla test för att se om skiten funkar");



        setSize(800, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        panelJaevel = new Panel();
        panelJaevel.setBackground(Color.BLACK);
        panelJaevel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        panelJaevel.setVisible(true);
        //setLayout(new GridLayout(2, 1)); //ändra första siffran för att ändra antal grids (liggandes/horisontellt)
        //setLayout(new BorderLayout()); //lägger knapparna i utkanten av fönstret

        this.setContentPane(panelJaevel);

        button = new JButton("En ful jävla knapp");
        button.setActionCommand("click");
        button2 = new JButton("Fulare knapp finns inte");
        button2.setActionCommand("knappjaevel");

//        JMenuBar bar = new JMenuBar();
//        setJMenuBar(bar);

        button.addActionListener(this);
        button2.addActionListener(this);

        add(button);                    //(button, BorderLayout.WEST) för att placera knappen längst vänster ytterkant
        add(button2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = e.getActionCommand();

        if(name.equals("click")) {
            System.out.println("Knapp 1");
        } else if (name.equals("knappjaevel")) {
            System.out.println("Knapp 2");
        }
    }
}