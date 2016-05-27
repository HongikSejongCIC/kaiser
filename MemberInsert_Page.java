package project_kwon;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class MemberInsert_Frame extends JFrame {		// ȸ������ ������
	JPanel p;
	JPanel panels = new JPanel();
	JButton id_confirm;
	JButton member_joins;
	JButton NFC;
	JLabel ID;
	JTextField id_input; JTextField pw_inputs;
	JTextField name; JTextField age; JTextField room_numbers;
	ButtonGroup g; JRadioButton male; JRadioButton female;
	JComboBox major;
	
	ArrayList<Student> student_list;
	ArrayList<Manager> manager_list;
	boolean id_check=false;
	Member_ButtonListener member_listener = new Member_ButtonListener();
	// �����Լ��κ��� �л�����Ʈ,�Ŵ�������Ʈ�� �Ű������� �޴´�
	public MemberInsert_Frame(ArrayList<Student> student_list, ArrayList<Manager> manager_list) {
		setSize(500, 500);
		setTitle("ȸ������");
		
		this.student_list = student_list;
		this.manager_list = manager_list;
		panels = new JPanel();
		panels.setLayout(null);
		panels.setBackground(Color.WHITE);

		JPanel panel1 = new JPanel();	JPanel panel2 = new JPanel();	JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();	JPanel panel5 = new JPanel();	JPanel panel6 = new JPanel();
		JPanel panel7 = new JPanel();	JPanel panel8 = new JPanel();	JPanel panel9 = new JPanel();
		JPanel panel10 = new JPanel();
		panel1.setBackground(null);	panel2.setBackground(null);	panel3.setBackground(null);
		panel4.setBackground(null);	panel5.setBackground(null);	panel6.setBackground(null);	
		panel7.setBackground(null);	panel8.setBackground(null);	panel9.setBackground(null);
		panel10.setBackground(null);

		JLabel intro = new JLabel("ȸ������ �޴�");
		intro.setFont(new Font("Serif", Font.BOLD, 20));
		String[] major_list = { "��ǻ��", "���̿�", "��������", "��ȫ", "���" };
		major = new JComboBox(major_list);

		ID = new JLabel("ID");	JLabel PW = new JLabel("��й�ȣ");	JLabel NAME = new JLabel("�̸�");
		JLabel AGE = new JLabel("����");	JLabel SEX = new JLabel("����");	JLabel MAJOR = new JLabel("�а�");
		JLabel ROOM_NUMBER = new JLabel("ȣ��");

		id_input = new JTextField(10);	pw_inputs = new JTextField(10);	
		name = new JTextField(10);
		age = new JTextField(10);	room_numbers = new JTextField(10);
		
		id_confirm = new JButton("���̵� Ȯ��");
		id_confirm.addActionListener(member_listener);
		member_joins = new JButton("ȸ������");
		member_joins.addActionListener(member_listener);

		g = new ButtonGroup();
		male = new JRadioButton("����");
		male.setSelected(true);
		female = new JRadioButton("����");
		g.add(male);	g.add(female);
		male.setBackground(null);	female.setBackground(null);
		NFC = new JButton("NFC�� ���ּ���");

		panel1.setBounds(0, 10, 500, 40);	panel2.setBounds(0, 60, 500, 40);	panel3.setBounds(0, 100, 500, 40);
		panel4.setBounds(0, 140, 500, 40);panel5.setBounds(0, 180, 500, 40);panel6.setBounds(0, 220, 500, 40);
		panel7.setBounds(0, 260, 500, 40);panel8.setBounds(0, 310, 500, 40);panel9.setBounds(0, 350, 500, 40);
		panel10.setBounds(0, 400, 500, 40);

		panel1.add(intro);panel2.add(ID);panel2.add(id_input);panel2.add(id_confirm);panel3.add(PW);
		panel3.add(pw_inputs);panel4.add(NAME);panel4.add(name);panel5.add(AGE);	panel5.add(age);
		panel6.add(SEX);panel6.add(male);panel6.add(female);	panel7.add(ROOM_NUMBER);
		panel7.add(room_numbers);panel8.add(MAJOR);panel8.add(major);panel9.add(NFC);
		panel10.add(member_joins);
		
		panels.add(panel1);panels.add(panel2);panels.add(panel3);panels.add(panel4);panels.add(panel5);
		panels.add(panel6);panels.add(panel7);panels.add(panel8);panels.add(panel9);panels.add(panel10);
		
		add(panels);
		setVisible(true);
	}
	
	class Member_ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
				if(e.getSource() == id_confirm){			// ���̵� Ȯ��
					int temp=0;
					for(int i=0; i<student_list.size();i++){
						if (id_input.getText().equals(student_list.get(i).ID)){		// ���̵� �̹� �ִٸ�
							JOptionPane.showMessageDialog(null, "�ߺ��� ���̵� �Դϴ�. �ٸ� ���̵� �Է����ּ���", 
									"���̵� �ߺ�",	JOptionPane.WARNING_MESSAGE);
							temp++;
							return;
						}
					}
					for(int i=0; i<manager_list.size();i++){
						if (id_input.getText().equals(manager_list.get(i).ID)){		// ���̵� �̹� �ִٸ�
							JOptionPane.showMessageDialog(null, "�ߺ��� ���̵� �Դϴ�. �ٸ� ���̵� �Է����ּ���", 
									"���̵� �ߺ�",	JOptionPane.WARNING_MESSAGE);
							temp++;
							return;
						}
					}
					if(temp==0){		// ���̵� ���ٸ�
						JOptionPane.showMessageDialog(null, "��밡���� ���̵��Դϴ�.");
						id_check = true;
					}
				}
				else if(e.getSource() == member_joins){		// ȸ������ ��ư�� ������ ��
					if(id_check == true && !pw_inputs.getText().equals("") && !name.getText().equals("") && 
							!age.getText().equals("") && !room_numbers.getText().equals("")){	// ���̵�üũ�� �ϰ� ����� üũ�Ѵ�.
						Student temp_student = new Student();
						String temp_sex; String temp_major;
						int temp_NFC;
						
						if(male.isSelected())
							temp_sex = "male";
						else
							temp_sex = "female";
						
						temp_major = (String)major.getSelectedItem();
						
						temp_NFC = (int)(Math.random()*10000);
						
						temp_student.Member_Join(id_input.getText(), pw_inputs.getText(), name.getText(), temp_sex, 
								Integer.parseInt(age.getText()), temp_major, Integer.parseInt(room_numbers.getText()), temp_NFC);
						
						student_list.add(temp_student);
						JOptionPane.showMessageDialog(null, "�Է��� �Ϸ�Ǿ����ϴ�.");
						dispose();
					}
						
					else if(id_check == false){		// ���̵� üũ�� ���� �ʾ��� ��
						JOptionPane.showMessageDialog(null, "IDüũ�� ���ּ���!",	"IDüũȮ��",	JOptionPane.WARNING_MESSAGE);
						return;
					}
					else		// ��ĭ�� ���� ��
						JOptionPane.showMessageDialog(null, "�Է½���! ��ĭ�� ä���ּ���",	"�Է½���",	JOptionPane.WARNING_MESSAGE);
				}
		}
	}
}