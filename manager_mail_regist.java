package project_kwon;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class manager_mail_regist extends JPanel {
	JPanel manager_mail_regist_panel;
	int number=0;
	int count=0;
	JTextField name_information_field; JTextField room_student_field; JTextField mail_student_field;
	JTextField parcel_student_field;  JButton mail_student_confirm;  JButton mail_student_edit;
	ArrayList<Student> student_list;
	manager_mail_Listener mml = new manager_mail_Listener();
	
	
	public manager_mail_regist(ArrayList<Student> student_list){
		manager_mail_regist_panel = new JPanel();
		manager_mail_regist_panel.setLayout(new BorderLayout(0, 20));
		
		this.student_list = student_list;
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout(10, 10, 0));
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout(10, 10, 0));
		
		JLabel name_information = new JLabel("�л� �̸�");
		JLabel room_student = new JLabel("�л� ���ȣ");
		JLabel mail_student = new JLabel("������ ��");
		JLabel parcel_student = new JLabel("�ù��� ��");
		name_information_field = new JTextField(10);
		room_student_field = new JTextField(10);
		mail_student_field = new JTextField(10);
		parcel_student_field = new JTextField(10);
		
		mail_student_confirm = new JButton("�л�Ȯ��");
		mail_student_edit = new JButton("�����ϱ�");
		
		mail_student_confirm.addActionListener(mml);
		mail_student_edit.addActionListener(mml);
		
		panel1.add(name_information); panel1.add(name_information_field); panel1.add(room_student);
		panel1.add(room_student_field); panel1.add(mail_student_confirm);
		 
		panel2.add(mail_student); panel2.add(mail_student_field); panel2.add(parcel_student);
		panel2.add(parcel_student_field);panel2.add(mail_student_edit);
		
		manager_mail_regist_panel.add(panel1, BorderLayout.NORTH);
		manager_mail_regist_panel.add(panel2, BorderLayout.CENTER);
		
	}
	
	class manager_mail_Listener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == mail_student_confirm){
				for(int i=0;i<student_list.size();i++){
					if(student_list.get(i).Name.equals(name_information_field.getText() ) 
							&& student_list.get(i).room_number == Integer.parseInt(room_student_field.getText())){
						number = i;
						mail_student_field.setText(student_list.get(i).Post+"");
						parcel_student_field.setText(student_list.get(i).ParcelService+"");
						count++;
						JOptionPane.showMessageDialog(null, "Ȯ�οϷ��Ͽ����ϴ�.");
					}
				}
				if(count ==0 ){
					JOptionPane.showMessageDialog(null, "��ġ�ϴ� ���� �����ϴ�.", "��������ġ",
							JOptionPane.WARNING_MESSAGE);
				}
				count =0;
			}
			else if(e.getSource() == mail_student_edit){
				student_list.get(number).Post = Integer.parseInt(mail_student_field.getText());
				student_list.get(number).ParcelService = Integer.parseInt(parcel_student_field.getText());
				JOptionPane.showMessageDialog(null, "�����Ϸ��Ͽ����ϴ�.");
			}
		}
	}
	
	JPanel manager_mail_regist_Panel_return(){
		return manager_mail_regist_panel;
	}
}
