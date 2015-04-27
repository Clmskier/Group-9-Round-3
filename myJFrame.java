
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class myJFrame extends JFrame {

    myJPanel mjp;

    public myJFrame() {


        super("Flappy Squirrel");
//------------------------------------------------------
// Create components
        mjp = new myJPanel();
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(mjp, "Center");
//------------------------------------------------------
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450, 680);
        setVisible(true);
    }
}
