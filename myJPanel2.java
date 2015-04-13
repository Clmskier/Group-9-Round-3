
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
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

    JButton obstacle;
    JButton squirrel;
    Timer gameButton;
    Timer gameLoop;
    int x = 200;
    int y =200;
    int background1_x = 0;
    int background2_x = 884;
    ImageIcon background1 = new ImageIcon(this.getClass().getResource("flap.jpg"));
    ImageIcon background2 = new ImageIcon(this.getClass().getResource("flap.jpg"));

    public myJPanel2() {
        super();
        setLayout(null);

        obstacle = new JButton("");
        obstacle.setBounds(100, 10, 10, 100);
        add(obstacle);
        squirrel = new JButton("");
        squirrel.setBounds(x, y, 30, 30);
        Rectangle r1 = squirrel.getBounds();
        add(squirrel);
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
        if (obj == gameLoop) {

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
