
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class myJPanel extends JPanel implements ActionListener {

    myJPanel1 p1;
    myJPanel2 p2;
    GameOverPanel p3;
    myJPanel3 p4;

    public myJPanel() {
        setLayout(new BorderLayout());
        p1 = new myJPanel1();
        p1.playButton.addActionListener(this);
        add(p1, "Center");
    }

    public void actionPerformed(ActionEvent event) {
        Object obj = event.getSource();
        if (obj == p1.playButton) {
            p2 = new myJPanel2(this);
            remove(p1);
            add(p2, "Center");
            validate();
            repaint();

        }
    }
}
