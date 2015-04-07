
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chelsea Martin
 */
public class GameOverPanel extends myJPanel {
    JLabel loser = new JLabel("You lose");
    JButton playagain= new JButton("Play again");
   JButton exit = new JButton("Exit Game");
   ImageIcon exitflappybird = new ImageIcon(this.getClass().getResource("GameOverFlappy.jpg"));
        GameOverPanel()
    {
        add(loser);
        add(playagain);
        add(exit);
    }
    @Override
   public void paintComponent(Graphics g)
   {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g; 
        g.drawImage(exitflappybird.getImage(), 0, 0, this);
       
   }

    
}
