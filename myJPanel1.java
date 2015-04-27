
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class myJPanel1 extends JPanel {
    JButton playButton;
    ImageIcon ip = new ImageIcon(this.getClass().getResource("flappy_bird.jpg"));
    public myJPanel1()
	{
            super();
            setLayout(new GridLayout(6,1));
            JLabel jlabel1 = new JLabel("Flappy Squirrel");
            jlabel1.setFont(new Font("Stencil",5,30));
            jlabel1.setForeground(Color.green);
            jlabel1.setHorizontalAlignment(SwingConstants.CENTER);
            add(jlabel1);
          
   	    playButton = new JButton("Play!");	 
            playButton.setBounds(10, 30, 10, 10);
            add(playButton);
            
	}
        public void paintComponent (Graphics g){
            g.drawImage(ip.getImage(),0,0,null);
        }

        public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

