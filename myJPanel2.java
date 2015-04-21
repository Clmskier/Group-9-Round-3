
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jeff
 */
public class myJPanel2 extends JPanel implements KeyListener, ActionListener {

    JButton squirrel;
    JButton obstacle;
    JButton obstacle2;
    Timer gameButton;
    Timer gameLoop;
    int x = 200;
    int y =200;
    int background1_x = 0;
    int background2_x = 884;
    int obstacle_x = 250;
    int obstacle_x2 = 250;
    ImageIcon background1 = new ImageIcon(this.getClass().getResource("flap.jpg"));
    ImageIcon background2 = new ImageIcon(this.getClass().getResource("flap.jpg"));

    public myJPanel2() {
        super();
        setLayout(null);

   
        squirrel = new JButton("");
        squirrel.setBounds(x, y, 30, 30);
        Rectangle r1 = squirrel.getBounds();
        add(squirrel);
        
        obstacle = new JButton("");
        obstacle.setBounds(obstacle_x, y, 30, 30);
        Rectangle r2 = obstacle.getBounds();
        add(obstacle);
        
        obstacle2 = new JButton("");
        obstacle2.setBounds(obstacle_x2, y, 30, 30);
        Rectangle r3 = obstacle2.getBounds();
        add(obstacle2);
        
        addKeyListener(this);
        setFocusable(true);
        int delay = 50;
        gameButton = new Timer(delay, this);
        int delay2 = 50;
        gameLoop = new Timer(delay2, this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background1.getImage(), background1_x, 0, null);
        g.drawImage(background2.getImage(), background2_x, 0, null);
        
        Graphics2D g2d = (Graphics2D) g;
        
        //g2d.draw(rectangle);
        requestFocusInWindow();
        System.out.println(this.getWidth() + " | " + this.getHeight());

    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int kk = ke.getKeyCode();
        if (kk == ke.VK_SPACE) {
            gameButton.start();
            y -= 100;
            gameLoop.start();


            System.out.println("key pressed");
        }

        squirrel.setBounds(new Rectangle(100, y, 30, 30));
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        y += 8;
        squirrel.setLocation(100, y);
        Object obj = ae.getSource();
        double r;
         //r = Math.random();
         //obstacle_x = (int) (r * 500);
         //obstacle_x2 = (int) (r * 500);
        if (obj == gameLoop) {
            obstacle_x =obstacle_x-11;
            obstacle_x2 =obstacle_x2-11;
            if(obstacle_x == 0 && obstacle_x2 == 0 ){
               obstacle.setBounds(obstacle_x, 3, 30, 200);
               obstacle2.setBounds(obstacle_x2,  300, 30, 250);

            }
            obstacle.setBounds(obstacle_x, 3, 30, 200);
            obstacle2.setBounds(obstacle_x2,  300 , 30, 250);
            background1_x = background1_x - 11;
            background2_x = background2_x - 11;
            if (background1_x + background1.getIconWidth() < 0) {
                background1_x = this.getWidth()-10;
                System.out.println("reset1");
            }
            if (background2_x + background2.getIconWidth() < 0) {
                background2_x = this.getWidth()-10;
                System.out.println("reset2");
            }

            repaint();
        }
    }
}
