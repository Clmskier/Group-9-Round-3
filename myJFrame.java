/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Jeff
 */
public class myJFrame extends JFrame
{
	myJPanel mjp;
	public myJFrame ()
	{
		super ("Flappy Bird");
//------------------------------------------------------
// Create components
    	mjp = new myJPanel();   	
		//getContentPane().setLayout(new BorderLayout());
		getContentPane().add(mjp,"Center");
//------------------------------------------------------
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize (900, 680);
		setVisible(true);
	}
}
