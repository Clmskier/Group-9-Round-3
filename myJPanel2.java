
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
    Timer gameLoop;
    int x = 100;
    int y = 100;
    ImageIcon f = new ImageIcon(this.getClass().getResource("flap.jpg"));

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
        gameLoop = new Timer(delay,this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(f.getImage(), 200, 0, null);
        requestFocusInWindow();

    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int kk = ke.getKeyCode();
        if (kk == ke.VK_SPACE) {
            gameLoop.start();
            y-=100;
            System.out.println("key pressed");
        }
        squirrel.setBounds(new Rectangle(x, y, 30, 30));
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        y+=8;
        squirrel.setLocation(x, y);
        System.out.println("action");           
    }
}