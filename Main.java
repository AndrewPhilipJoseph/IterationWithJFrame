import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;


public class Main extends JFrame {
    static public JTextField TBar = new JTextField();
    public static int xCord = 0;
    private int yCord = 0;
    private int width = 5;
  private   int height = 5;

    public Main() {


        int domain1, domain2, range1, range2;
        domain1 = -500;
        domain2 = 500;
        range1 = -250;
        range2 = 250;

        //getContentPane().setBackground(new Color(175, 238, 238));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setResizable(false);
        //setBounds(500, 500, domain2 - domain1, range2 - range1);
        setSize(1000, 360);
        getContentPane().setLayout(null);
/*
        TBar.setText("");
        TBar.setForeground(Color.BLACK);
        TBar.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
        TBar.setHorizontalAlignment(SwingConstants.RIGHT);
        TBar.setBounds(100, 100, 100, 100);
        getContentPane().add(TBar);
*/


    }

@Override
    public void paint (Graphics g) {
        g.fillRect(xCord, 40, 10, 10);

       // Graphics2D g2d = (Graphics2D) g.create();

       // g2d.drawRect(10, 15, 90, 60);
       // g2d.setColor(new Color(212, 212, 212));



        //g2d.setColor(new Color(31, 21, 1));
       // g2d.fillRect(250, 195, 90, 60);

    }

    public static void main(String[] args) throws InterruptedException {
                Main frame = new Main();
        frame.setVisible(true);


            for (int i = 0; i < 200; i++) {

                Thread.sleep(10); //allows computer time to update xCord
                //without this the program will "skip" some of the rectangles
                //assisted by code two lines under this one

                xCord = 10 * i; //updates position of x

                TBar.setText(String.valueOf(xCord)); //invisible text bar is updated, slightly lagging the generation and helping to avoid errors
                //this is much faster than the minimum sleep time needed to avoid errors
                //I don't fully understand why this happens, but I think it's because the JFrame has an inital lag
                //Indeed, if removed the first "chunk" of rectangles don't generate, but all others do, suggesting this initial lag fixes the problem
                //I don't understand why this is too, because adding a momentary sleep function that occurs before iteration doesn't solve the problem.
                //regardless, this is a simple solution to this problem, only needing 2 basic lines of code

                frame.add(new rectangle());

                frame.repaint();


            }

    }

}

class rectangle extends JPanel {

    public rectangle() {
        this.repaint();
    }
@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

    g.fillRect(Main.xCord, 40, 10, 10);
    }

}


