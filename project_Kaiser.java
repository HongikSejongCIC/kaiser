package project_kwon;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

// ����ȭ�� ������

class MainFrame extends JFrame {
	ArrayList<Student> student_list = new ArrayList<Student>();
	ArrayList<Manager> manager_list = new ArrayList<Manager>();
	Student student1 = new Student();	Student student2 = new Student();	Student student3 = new Student();
	Student student4 = new Student();	Student student5 = new Student();	Student student6 = new Student();
	Student student7 = new Student();	Student student8 = new Student();  Student student9 = new Student();
	Student student10 = new Student();	Student student11 = new Student();  Student student12 = new Student();
	Student student13 = new Student();	Student student14 = new Student();  Student student15 = new Student();
	Student student16 = new Student();	Student student17 = new Student();  Student student18 = new Student();
	Student student19 = new Student();	Student student20 = new Student();
	Manager manager1 = new Manager();
	Manager manager2 = new Manager();

	CardLayout cards = new CardLayout();
	ImageIcon img;
	JLabel image_label;
	JButton login;
	JButton member_join;
	JButton member_delete;
	JButton rollcall_registration_button;
	JButton mail_confirm_button;
	JButton user_back;
	JButton manager_back;
	JButton rollcall_confirm_button;
	JButton mail_registration_button;

	JPanel system_panel, top_panel, middle_panel;
	JPanel system_panel_user, top_panel_user, middle_panel_user;
	JPanel system_panel_manager, top_panel_manager, middle_panel_manager;

	JTextField id = new JTextField(15);
	JPasswordField pw = new JPasswordField(15);

	Hongik_Thread th = new Hongik_Thread();
	ButtonListener b_listener = new ButtonListener();
	//MemberInsert_Page member_page = new MemberInsert_Page();
	
	int remember_index = 0;			// ���̵�Ȯ��
	int remember_room = 101;			// �� �ý����� ���ڱ���� 101ȣ�̴�.
	public MainFrame() {
		setSize(500, 550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("�������ȣ�ý���");
		setBackground(Color.white);
		getContentPane().setLayout(cards);

		getContentPane().add("Main", new Main_Page(this));
		getContentPane().add("User", new User_Panel(this));
		getContentPane().add("Manager", new Manager_Panel(this));
		
		//	���л� ���� ����
		student1.Member_Join("aaaa", "1234", "��ī��", "male", 21, "��ǻ��", 101, 1000);
		student2.Member_Join("bbbb", "1234", "�̻��ؾ�", "male", 22, "���̿�", 102, 1001);
		student3.Member_Join("cccc", "1234", "���̸�", "male", 23, "��������", 201, 1003);
		student4.Member_Join("dddd", "1234", "������", "male", 24, "��ȫ", 202, 1004);
		student5.Member_Join("eeee", "1234", "ĳ����", "male", 23, "���", 101, 1005);
		student6.Member_Join("fffff", "1234", "������", "male", 22, "��ǻ��", 102, 1006);
		student7.Member_Join("gggg", "1234", "����", "male", 21, "���̿�", 201, 1007);
		student8.Member_Join("hhhh", "1234", "����", "male", 22, "��������", 202, 1008);
		student9.Member_Join("iiii", "1234", "�ƺ�", "male", 23, "��ȫ", 101, 1009);
		student10.Member_Join("jjjj", "1234", "����", "male", 24, "���",	102, 1010);
		
		//	���л� ���� ����
		student11.Member_Join("AAAA", "1234", "������", "female", 25, "��ǻ��",	101, 2000);
		student12.Member_Join("BBBB", "1234", "�̻��ز�", "female", 26, "���̿�", 102, 2001);
		student13.Member_Join("CCCC", "1234", "���ڸ�", "female", 27, "��������",	201, 2002);
		student14.Member_Join("DDDD", "1234", "�źϿ�", "female", 28, "��ȫ", 202, 2003);
		student15.Member_Join("EEEE", "1234", "������", "female", 27, "���", 101, 2004);
		student16.Member_Join("FFFF", "1234", "��ħ��", "female", 26, "��ǻ��", 102, 2005);
		student17.Member_Join("GGGG", "1234", "����", "female", 25, "���̿�", 201, 2006);
		student18.Member_Join("HHHH", "1234", "��Ʈ��", "female", 24, "��������", 202, 2007);
		student19.Member_Join("IIII", "1234", "�ƺ�ũ", "female", 23, "��ȫ", 101, 2008);
		student20.Member_Join("JJJJ", "1234", "����", "female", 22, "���", 102, 2009);
		
		// �л� ����Ʈ�� �л����� �߰�
		student_list.add(student1);	student_list.add(student2);	student_list.add(student3);	student_list.add(student4);
		student_list.add(student5);	student_list.add(student6);	student_list.add(student7);	student_list.add(student8);
		student_list.add(student9);	student_list.add(student10);	student_list.add(student11);	student_list.add(student12);
		student_list.add(student13);	student_list.add(student14);	student_list.add(student15);	student_list.add(student16);
		student_list.add(student17);	student_list.add(student18);	student_list.add(student19);	student_list.add(student20);

		// �Ŵ��� ���� ����
		manager1.Manager_Join("kaiser", "1234", "kwon", "male"); manager2.Manager_Join("joint", "5678", "jun", "female");
		// �Ŵ��� �����Ϳ� �Ŵ��� ���� �߰�
		manager_list.add(manager1);	manager_list.add(manager2);

		setVisible(true);
	}

	// �л��� �α��� ���� �� �������� ȭ��
	public void change_User_Panel() {
		cards.show(getContentPane(), "User");
	}

	// �����ڰ� �α��� ���� �� �������� ȭ��
	public void change_Manager_Panel() {
		cards.show(getContentPane(), "Manager");
	}

	// �α׾ƿ��� ���� �� �������� ȭ��(����ȭ��)
	public void change_Main_Panel() {
		cards.show(getContentPane(), "Main");
	}
	
	// ����ȭ�� ����
	class Main_Page extends JPanel {
		private JFrame F;
		JPanel panel;

		public Main_Page(JFrame f) {
			setSize(500, 500);
			setLayout(null);
			F = f;

			panel = new JPanel();
			panel.setBackground(Color.white);
			panel.setBounds(0, 0, 700, 700);
			;

			panel.setLayout(null);
			JPanel panel1 = new JPanel();
			panel1.setBackground(Color.white);
			panel1.setBounds(0, 10, 500, 50);
			JPanel panel2 = new JPanel();
			panel2.setBackground(Color.white);
			panel2.setBounds(0, 60, 500, 300);
			JPanel panel3 = new JPanel();
			panel3.setBackground(Color.white);
			panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
			panel3.setBounds(0, 360, 500, 40);
			JPanel panel4 = new JPanel();
			panel4.setBackground(Color.white);
			panel4.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
			panel4.setBounds(0, 410, 500, 40);
			JPanel panel5 = new JPanel();
			panel5.setBackground(Color.white);
			panel5.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0));
			panel5.setBounds(0, 460, 500, 40);

			JLabel label = new JLabel("�� ����� ��ȣ �ý��� ��");
			label.setFont(new Font("Serif", Font.BOLD, 20));
			panel1.add(label);

			img = new ImageIcon("img/hongik_logo1.jpg");
			image_label = new JLabel(img);
			panel2.add(image_label);

			JLabel label1 = new JLabel("I D");
			JLabel label2 = new JLabel("P W");
			label1.setFont(new Font("Serif", Font.BOLD, 15));
			label2.setFont(new Font("Serif", Font.BOLD, 15));
			panel3.add(label1);
			panel3.add(id);
			panel4.add(label2);
			panel4.add(pw);

			login = new JButton("�α���");
			member_join = new JButton("ȸ������");
			member_delete = new JButton("ȸ��Ż��");
			
			login.addActionListener(b_listener);
			member_join.addActionListener(b_listener);
			member_delete.addActionListener(b_listener);
			panel5.add(login);
			panel5.add(member_join);
			panel5.add(member_delete);
			

			panel.add(panel1);
			panel.add(panel2);
			panel.add(panel3);
			panel.add(panel4);
			panel.add(panel5);
			th.start();
			add(panel);
			setVisible(true);
		}
	}
	
	// ȫ�ʹ� �ΰ� ȸ���Ѵ�.
	class Hongik_Thread extends Thread {
		public void run() {
			for (int i = 1; i < 21; i++) {
				try {
					img = new ImageIcon("img/hongik_logo" + i + ".jpg");
					image_label.setIcon(img);
					Thread.sleep(250);
					if (i == 20)
						i = 1;
				} catch (InterruptedException e) {
					return;
				}
			}
		}
	}
	
	// ����ȭ���� ��ư�� ������ �� ����
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//�α����� �õ��Ͽ�����
			if (e.getSource() == login) {
				char[] temp = pw.getPassword();
				String passwd = new String(temp, 0, temp.length);
				for (int i = 0; i < student_list.size(); i++) {
					if (id.getText().equals(student_list.get(i).ID)			// �л��� ���̵�� ��й�ȣ�� ��ġ�ϴ��� Ȯ���Ѵ�.
							&& passwd.equals(student_list.get(i).PassWord)) {
						JOptionPane.showMessageDialog(null, "���� �α��ο� �����Ͽ����ϴ�.");
						remember_index = i;		// ����Ʈ�� �л� ������ ��� ���� ����Ѵ�.
						change_User_Panel();		// ����ȭ������ ��ȯ�Ѵ�.
						return;
					}
				}
				for (int i = 0; i < manager_list.size(); i++) {		// �������� ���̴ٿ� ��й�ȣ�� ��ġ�ϴ��� Ȯ���Ѵ�.
					if (id.getText().equals(manager_list.get(i).ID) && passwd.equals(manager_list.get(i).PassWord)) {
						JOptionPane.showMessageDialog(null, "������ �α��ο� �����Ͽ����ϴ�.");
						remember_index = i;		// ����Ʈ�� ������ ������ ��� ���� ����Ѵ�.
						change_Manager_Panel();	//������ȭ������ ��ȯ�Ѵ�.
						return;
					}
				}
				// ��ġ�ϴ� �׸��� ���� �� �����ش�.
				JOptionPane.showMessageDialog(null, "�α��ο� �����Ͽ����ϴ�.", "�α��� ����",
						JOptionPane.WARNING_MESSAGE);
			} else if(e.getSource() == member_join){		// ȸ�������� ������ ȸ������ �������� �����Ѵ�.
				MemberInsert_Frame frame = new MemberInsert_Frame(student_list,manager_list);
			}
			else if(e.getSource() == member_delete){		// ȸ�������� ��������
				int confirm_temp=0;
				char[] temp = pw.getPassword();
				String passwd = new String(temp, 0, temp.length);
				for (int i = 0; i < student_list.size(); i++) {		// ȸ�������� �ִ��� Ȯ���� �Ѵ�
					if (id.getText().equals(student_list.get(i).ID) && passwd.equals(student_list.get(i).PassWord)) {
						int result_Option = JOptionPane.showConfirmDialog(null, "���� �����Ͻðڽ��ϱ�?","����Ȯ��",JOptionPane.YES_NO_OPTION);
						if(result_Option == JOptionPane.CLOSED_OPTION){		// ������ ��Ҹ� ������ Ȯ�ιٰ� �������.
							return;
						}
						else if(result_Option == JOptionPane.YES_OPTION){		// ������ Ȯ���� ������ �����Ѵ�.
							student_list.remove(i);
							confirm_temp++;
						}
						else{
							return;
						}
					}
				}
				if(confirm_temp==0)		// ���̵�� ��й�ȣ�� ��ġ���� ���� ��� ������ �˾�
				JOptionPane.showMessageDialog(null, "��ġ�ϴ� ���̵� ��й�ȣ�� �����ϴ�.", "���� ����",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	
	// ����ȭ�鿡�� ������ ��ư�鿡 ���� �ൿ ����
	class User_ButtonListener implements ActionListener {
		//int user_mail_count;
		//int user_parcel_count;

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == rollcall_registration_button) {		// ��ȣȮ���� ��������
				middle_panel_user.removeAll();
				// �Ʒ� ȭ���� ��ȣ �гη� �ٲ��.
				roll_registration_Panel roll_panels = new roll_registration_Panel(student_list, remember_index, remember_room);
				middle_panel_user.add(roll_panels.roll_registration_Panel_return());
				
			}  else if (e.getSource() == mail_confirm_button) {		// ����Ȯ�ι�ư�� ������ ��
				Student s = new Student();
				s.about_mail(student_list.get(remember_index));
			} else if (e.getSource() == user_back) {		// �α׾ƿ���ư�� ������ ��
				id.setText(null);
				pw.setText(null);
				remember_index = 0;
				middle_panel_user.removeAll();
				ImageIcon user_temp_img = new ImageIcon("img/campus_img.jpg");
				JLabel user_temp_image_label = new JLabel(user_temp_img);
				middle_panel_user.add(user_temp_image_label);
				change_Main_Panel();
			}
		}
	}
	
	// �Ŵ���ȭ�鿡�� ������ ��ư�鿡 ���� �ൿ ����
	class Manager_ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == rollcall_confirm_button) {		// ��ȣȮ�ι�ư�� ������ ��
				middle_panel_manager.removeAll();
				// �Ʒ� ȭ���� ��ȣȮ�� �гη� �ٲ��.
				middle_panel_manager.add(new roll_confirm_Panel(student_list, manager_list.get(remember_index)));
			}  else if (e.getSource() == mail_registration_button) {	// ���� �� ���� ��� ��ư�� ������ ��
				
				middle_panel_manager.removeAll();
				// ���� �� ���� ��� ȭ������ �ٲ��.
				manager_mail_regist manager_mail_regists = new manager_mail_regist(student_list);
				middle_panel_manager.add(manager_mail_regists.manager_mail_regist_Panel_return());
				
			} else if (e.getSource() == manager_back) {		// �α׾ƿ� ��ư�� ������ ��
				id.setText(null);
				pw.setText(null);
				remember_index = 0;
				
				middle_panel_manager.removeAll();
				ImageIcon manager_temp_img = new ImageIcon("img/campus_img.jpg");
				JLabel manager_temp_image_label = new JLabel(manager_temp_img);
				middle_panel_manager.add(manager_temp_image_label);
				
				change_Main_Panel();
			}
		}

	}
	
	// ����ȭ�� ����
	class User_Panel extends JPanel {
		private JFrame F;

		User_ButtonListener user_listener = new User_ButtonListener();
		ImageIcon img;
		JLabel image_label;

		public User_Panel(JFrame f) {
			setSize(700, 700);
			F = f;
			setLayout(new BorderLayout());

			system_panel_user = new JPanel();
			top_panel_user = new JPanel();
			middle_panel_user = new JPanel();
			system_panel_user.setBackground(Color.WHITE);
			top_panel_user.setBackground(Color.WHITE);
			top_panel_user.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
			middle_panel_user.setBackground(Color.WHITE);

			img = new ImageIcon("img/campus_img.jpg");
			image_label = new JLabel(img);
			user_back = new JButton("�α׾ƿ�");
			rollcall_registration_button = new JButton("��ȣ���");
			mail_confirm_button = new JButton("���� �� ���� Ȯ��");

			rollcall_registration_button.addActionListener(user_listener);
			mail_confirm_button.addActionListener(user_listener);
			user_back.addActionListener(user_listener);

			top_panel_user.add(rollcall_registration_button);
			top_panel_user.add(mail_confirm_button);
			top_panel_user.add(user_back);

			middle_panel_user.add(image_label);

			system_panel_user.add(top_panel_user, BorderLayout.NORTH);
			system_panel_user.add(middle_panel_user, BorderLayout.CENTER);
			add(system_panel_user);

			setVisible(true);
		}
	}
	
	
	//������ ȭ�� ����
	class Manager_Panel extends JPanel {
		private JFrame F;

		Manager_ButtonListener manager_listener = new Manager_ButtonListener();
		ImageIcon img;
		JLabel image_label;

		public Manager_Panel(JFrame f) {
			setSize(700, 700);
			F = f;
			setLayout(new BorderLayout());

			system_panel_manager = new JPanel();
			top_panel_manager = new JPanel();
			middle_panel_manager = new JPanel();
			system_panel_manager.setBackground(Color.WHITE);
			top_panel_manager.setBackground(Color.WHITE);
			top_panel_manager.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
			middle_panel_manager.setBackground(Color.WHITE);

			img = new ImageIcon("img/campus_img.jpg");
			image_label = new JLabel(img);

			rollcall_confirm_button = new JButton("��ȣȮ��");
			mail_registration_button = new JButton("���� �� ���� ���");
			manager_back = new JButton("�α׾ƿ�");
			rollcall_confirm_button.addActionListener(manager_listener);
			mail_registration_button.addActionListener(manager_listener);
			manager_back.addActionListener(manager_listener);

			top_panel_manager.add(rollcall_confirm_button);
			top_panel_manager.add(mail_registration_button);
			top_panel_manager.add(manager_back);

			middle_panel_manager.add(image_label);

			system_panel_manager.add(top_panel_manager, BorderLayout.NORTH);
			system_panel_manager.add(middle_panel_manager, BorderLayout.CENTER);
			add(system_panel_manager);

			setVisible(true);
		}
	}

}

public class project_Kaiser {
	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
	}

}
