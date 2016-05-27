package project_kwon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

class roll_registration_Panel extends JPanel{		// 점호등록패널
	JPanel panels;
	JLabel image_label;
	ImageIcon img;
	JButton user_roll_regist_button;
	JTextField user_roll_regist_field;
	JLabel user_roll_confirm;
	// 학생 리스트와 학생번호, 시스템 방번호를 가져온다
	public roll_registration_Panel(ArrayList<Student> student_list,int num, int room){
		panels = new JPanel();
		JPanel panel1 = new JPanel();JPanel panel2 = new JPanel(); JPanel panel3 = new JPanel();
		JLabel label = new JLabel("NFC를 대주세요");
		user_roll_regist_button = new JButton("점호하기");
		user_roll_regist_field = new JTextField(15);
		user_roll_regist_field.setText(student_list.get(num).NFC+"");
		user_roll_confirm = new JLabel(student_list.get(num).Name+"("+student_list.get(num).room_number+")");
		
		user_roll_regist_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//학생의 NFC, 방번호와 시스템 방번호, 성별여부를 확인한다
					if(student_list.get(num).NFC == Integer.parseInt(user_roll_regist_field.getText()) && 
							student_list.get(num).room_number == room && student_list.get(num).Sex.equals("male")){
							student_list.get(num).Rollcall_Confirm = true;
							JOptionPane.showMessageDialog(null, "점호등록완료하였습니다.");
					}
					// NFC와 성별은 같지만 방번호가 불일치 할때
					else if(student_list.get(num).NFC == Integer.parseInt(user_roll_regist_field.getText()) 
							&& student_list.get(num).room_number != room && student_list.get(num).Sex.equals("male"))
						JOptionPane.showMessageDialog(null, "자신의 방에서 등록하시기 바랍니다!!", "방번호 불일치",
								JOptionPane.WARNING_MESSAGE);
					// 방번호와 NFC는 같지만 여학생이 했을때
					else if(student_list.get(num).NFC == Integer.parseInt(user_roll_regist_field.getText()) 
							 && !student_list.get(num).Sex.equals("male"))
						JOptionPane.showMessageDialog(null, "여기는 남자기숙사 입니다", "성별 불일치",
								JOptionPane.WARNING_MESSAGE);
					else		// NFC가 불일치 할때
						JOptionPane.showMessageDialog(null, "NFC가 일치하지 않습니다.", "NFC불일치",
								JOptionPane.WARNING_MESSAGE);
			}
		});
		label.setFont(new Font("Serif", Font.BOLD, 20));
		panels.setLayout(new BorderLayout());
		panel1.setBackground(Color.white);
		panel2.setBackground(Color.white);
		panel3.setLayout(new FlowLayout(10, 10, 0));
		img = new ImageIcon("img/nfc_img.jpg");
		image_label = new JLabel(img);
		panel1.add(image_label);
		panel2.add(label);
		panel3.add(user_roll_confirm);panel3.add(user_roll_regist_field);panel3.add(user_roll_regist_button);
		
		panels.add(panel1,BorderLayout.NORTH);
		panels.add(panel2, BorderLayout.CENTER);
		panels.add(panel3, BorderLayout.SOUTH);
	}
	JPanel roll_registration_Panel_return(){
		return panels;
		
	}
}
