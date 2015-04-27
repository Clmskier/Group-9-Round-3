
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MenuComponent;
import java.awt.Panel;
import java.awt.PopupMenu;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class myJPanel2 extends JPanel implements KeyListener, ActionListener {

    Timer gameButton;
    Timer gameLoop;
    JLabel Score;
    Rectangle r1;
    Rectangle r2;
    Rectangle r3;
    int x = 100;
    int y = 200;
    int s = 0;
    Random random = new Random();
    int background1_x = 0;
    int background2_x = 884;
    ImageIcon background1 = new ImageIcon(this.getClass().getResource("flap.jpg"));
    ImageIcon background2 = new ImageIcon(this.getClass().getResource("flap.jpg"));
    GameOverPanel gameOver;

    public myJPanel2() {
        super();
        setLayout(null);

        r1 = new Rectangle();
        r2 = new Rectangle();
        r3 = new Rectangle();
        gameOver = new GameOverPanel();
        add(gameOver);
        Score = new JLabel("" + s);
        Score.setOpaque(true);
        Score.setBounds(200, 100, 100, 100);
        Score.setBackground(new Color(0, 0, 0, 0));
        Score.setFont(new Font("Serif", Font.PLAIN, 80));
        add(Score);


        addKeyListener(this);
        setFocusable(true);
        int delay = 50;
        gameButton = new Timer(delay, this);
        int delay2 = 50;
        gameLoop = new Timer(delay2, this);
        setRectangleLocation();


    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background1.getImage(), background1_x, 0, null);
        g.drawImage(background2.getImage(), background2_x, 0, null);

        Graphics2D g2d = (Graphics2D) g;

        //g2d.draw(rectangle);
        requestFocusInWindow();
        g2d.setColor(Color.green);
        g2d.fill(r1);
        g2d.fill(r2);
        g2d.fill(r3);

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


    }

    public void setRectangleLocation() {

        int obstacle_x = 434;
        int obstacle_y = 0;
        int min_y = 100;
        int max_y = 400;
        int height = random.nextInt(max_y - min_y) + min_y;
        int gap = 150;
        int obstacle_x2 = obstacle_x;
        int obstacle_y2 = height + gap;
        int height2 = 550 - obstacle_y2;
        int width = 70;
        System.out.println("r1 x set: " + obstacle_x);
        r1.setBounds(obstacle_x, obstacle_y, width, height);
        r2.setBounds(obstacle_x2, obstacle_y2, width, height2);
        System.out.println("gjjghg");

    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        y += 8;

        Object obj = ae.getSource();


        if (obj == gameLoop) {

            int obstacle_y = r1.y;
            int obstacle_y2 = r2.y;
            int obstacle_x = r1.x - 11;
            System.out.println("rectangle 1 x in game loop: " + r1.x);
            int obstacle_x2 = r2.x - 11;
            int width = r1.width;
            int height = r1.height;
            int height2 = r2.height;

            if (obstacle_x <= 0) {
                setRectangleLocation();
                s++;
                Score.setText("" + s);

            } else {
                r1.setBounds(obstacle_x, obstacle_y, width, height);
                r2.setBounds(obstacle_x2, obstacle_y2, width, height2);
                r3.setBounds(x, y, 30, 30);
            }

            background1_x = background1_x - 11;
            background2_x = background2_x - 11;
            if (background1_x + background1.getIconWidth() < 0) {
                background1_x = this.getWidth() - 10;
                System.out.println("reset1");
            }
            if (background2_x + background2.getIconWidth() < 0) {
                background2_x = this.getWidth() - 10;
                System.out.println("reset2");
            }
            repaint();

            if (r1.intersects(r3) || r2.intersects(r3) || r3.y > 650) {
                gameLoop.stop();
                gameButton.stop();
//                int dialogResult = JOptionPane.showConfirmDialog(null, "Restart?", "Game Over", dialogButton);
//                if (dialogResult == JOptionPane.YES_OPTION) {
            }
        }
    }
}
