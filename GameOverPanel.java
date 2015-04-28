
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameOverPanel extends JPanel {
    
    JLabel loser = new JLabel("You lose");
    JButton playagain = new JButton("Play Again");
    JButton exit = new JButton("Exit");
    JPanel myJPanel2;
    ImageIcon gameover = new ImageIcon(this.getClass().getResource("gameover.jpg"));
    myJPanel mjp;
    
    public GameOverPanel(myJPanel imjp) {
        mjp = imjp;
        add(loser);
        loser.setBounds(50, 10, 130, 30);
        add(playagain);
        playagain.setBounds(150, 10, 130, 30);
        setLayout(null);
        add(exit);
        exit.setBounds(300, 10, 130, 30);
        playagain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Object obj = ae.getSource();
                if (obj == playagain) {
                    mjp.remove(mjp.p3);
                    mjp.p2 = new myJPanel2(mjp);
                    mjp.add(mjp.p2, "Center");
                    mjp.validate();
                    mjp.repaint();
                    System.out.println("restart");
                }
                
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Object obj = ae.getSource();
                if (obj == exit) {
                    System.exit(0);
                }
                
            }
        });
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g.drawImage(gameover.getImage(), 0, 100, null);
        //g.drawImage(exitflappy, 0, 0, this);
    }
}
