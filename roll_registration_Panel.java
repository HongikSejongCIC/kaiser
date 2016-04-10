package project_kwon;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

class roll_registration_Panel extends JPanel{
	JLabel image_label;
	ImageIcon img;
	
	public roll_registration_Panel(){
		setLayout(new BorderLayout());
		
		img = new ImageIcon("img/nfc_img.jpg");
		image_label = new JLabel(img);
		add(image_label);
	}
}
