/*Author: Nathaniel Cobbinah
 *Email:  baby.hugo74@yahoo.com
 *Email:  fmg3ckali@gmail.com
 */


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class About  extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel imagepanel;
	private JPanel infopanel;
	private JPanel closepanel;
	private JButton closebutton;
	private JTextArea txtarea;
	
	private Font font;
	
	
	public About() {
		super("About  TANKS SMS APP");
		
		layoutdesign();
		
		//------------------------------------------------------------------------
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2 - this.getSize().width/2, dim.height/2 - this.getSize().height/2);
		//------------------------------------------------------------------------
		
		setSize(400,300);
		setResizable(false);
		setVisible(true);
	}
	
	private void layoutdesign() {
		setLayout(new BorderLayout());
		
		
		Border outerBorder= BorderFactory.createEtchedBorder();
		Border innerBorder= BorderFactory.createEmptyBorder(5, 5, 5, 5);
		
		Border compoundBorder = BorderFactory.createCompoundBorder(outerBorder, innerBorder);
		
		
		imagepanel = new JPanel();
		imagepanel.setBackground(Color.BLUE);
		imagepanel.setSize(100, 0);
		imagepanel.setLayout(new FlowLayout());
		imagepanel.setBorder(compoundBorder);
		
		txtarea = new JTextArea(15,1);
		txtarea.setBackground(Color.WHITE);
		String aboutmsg =     "Version 2.0" + "\n"
				            + "Author: Nathaniel Cobbinah" + "\n"
						    + "Email:fmg3ckali@gmail.com" + "\n"
					        + "Email2:baby.hugo74@yahoo.com" + "\n"
			            	+ "(c) Copyright Tank Contributors and Others 2017" + "\n"
						    + "All rights reserved. This product includes software" + "\n"
						    + "developed by other projects including synthetica libraries" + "\n"
						    + "From Jyloo Softwares(http://synthetica.com)" + "\n\n"
						    + "And BulkSMS API for making sending of messages possible\n";
		txtarea.setEditable(false);
		
		font = new Font("Monospace", Font.PLAIN, 11);
		
		txtarea.setFont(font);
		txtarea.setText(aboutmsg);
		
		infopanel = new JPanel();
		infopanel.add(txtarea);
	    infopanel.setBackground(Color.red);
	   
		
		closebutton = new JButton("Close");
		
		closebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		
		closepanel = new JPanel();
		closepanel.add(closebutton);
		closepanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		closepanel.setBorder(compoundBorder);
		
		
		add(imagepanel,BorderLayout.WEST);
		add(closepanel,BorderLayout.SOUTH);
		add(infopanel,BorderLayout.CENTER);
	}
}
