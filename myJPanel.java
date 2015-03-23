/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author Jeff
 */
public class myJPanel extends JPanel implements ActionListener
{
        
	myJPanel1 p1;
	myJPanel1 p2;
        
	public myJPanel()
	{
		setBackground(Color.green);
		setLayout(new BorderLayout());

		p1 = new myJPanel1();
                p1.playButton.addActionListener(this);
		add(p1,"Center");
}
        
    public void actionPerformed(ActionEvent event) 
    {   
            Object obj = event.getSource();   
                 if (obj == p1.playButton)
     	 {
     	 	remove(p1);
		add(p2,"Center");
     	 	validate();
                repaint();
     	 }       
    }
}
 