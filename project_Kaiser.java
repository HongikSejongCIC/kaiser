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

// 메인화면 프레임

class MainFrame extends JFrame {
	ArrayList<Student> student_list = new ArrayList<Student>();
	ArrayList<Manager> manager_list = new ArrayList<Manager>();
	Student student1 = new Student();
	Student student2 = new Student();
	Student student3 = new Student();
	Student student4 = new Student();
	Student student5 = new Student();
	Student student6 = new Student();
	Student student7 = new Student();
	Student student8 = new Student();
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
	
	int remember_index = 0;
	int remember_room = 101;
	public MainFrame() {
		setSize(500, 550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("기숙사점호시스템");
		setBackground(Color.white);
		getContentPane().setLayout(cards);

		getContentPane().add("Main", new Main_Page(this));
		getContentPane().add("User", new User_Panel(this));
		getContentPane().add("Manager", new Manager_Panel(this));

		student1.Member_Join("aaaa", "1234", "피카츄", "male", 21, "computer",
				101, 1000);
		student2.Member_Join("bbbb", "1234", "라이츄", "male", 22, "computer",
				102, 1001);
		student3.Member_Join("cccc", "1234", "파이리", "male", 23, "computer",
				201, 2002);
		student4.Member_Join("dddd", "1234", "꼬북이", "male", 24, "computer",
				202, 2003);
		student5.Member_Join("eeee", "1234", "버터플", "female", 25, "computer",
				101, 1004);
		student6.Member_Join("fffff", "1234", "야도란", "female", 26, "computer",
				102, 1005);
		student7.Member_Join("gggg", "1234", "피존투", "female", 27, "computer",
				201, 2006);
		student8.Member_Join("hhh", "1234", "또가스", "female", 28, "computer",
				202, 2007);
		student_list.add(student1);
		student_list.add(student2);
		student_list.add(student3);
		student_list.add(student4);
		student_list.add(student5);
		student_list.add(student6);
		student_list.add(student7);
		student_list.add(student8);

		manager1.Manager_Join("kwon", "1234", "kwon", "male");
		manager2.Manager_Join("1234", "1234", "jun", "female");
		manager_list.add(manager1);
		manager_list.add(manager2);

		setVisible(true);
	}

	public void change_User_Panel() {
		cards.show(getContentPane(), "User");
	}

	public void change_Manager_Panel() {
		cards.show(getContentPane(), "Manager");
	}

	public void change_Main_Panel() {
		cards.show(getContentPane(), "Main");
	}

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
			// panel.setLayout(new FlowLayout(FlowLayout.CENTER,10,20));
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

			JLabel label = new JLabel("☆ 기숙사 점호 시스템 ☆");
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

			login = new JButton("로그인");
			member_join = new JButton("회원가입");
			member_delete = new JButton("회원탈퇴");
			
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

	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == login) {
				char[] temp = pw.getPassword();
				String passwd = new String(temp, 0, temp.length);
				for (int i = 0; i < student_list.size(); i++) {
					if (id.getText().equals(student_list.get(i).ID)
							&& passwd.equals(student_list.get(i).PassWord)) {
						JOptionPane.showMessageDialog(null, "유저 로그인에 성공하였습니다.");
						remember_index = i;
						change_User_Panel();
						return;
					}
				}
				for (int i = 0; i < manager_list.size(); i++) {
					if (id.getText().equals(manager_list.get(i).ID) && passwd.equals(manager_list.get(i).PassWord)) {
						JOptionPane.showMessageDialog(null, "관리자 로그인에 성공하였습니다.");
						remember_index = i;
						change_Manager_Panel();
						return;
					}
				}
				JOptionPane.showMessageDialog(null, "로그인에 실패하였습니다.", "로그인 실패",
						JOptionPane.WARNING_MESSAGE);
			} else if(e.getSource() == member_join){
				MemberInsert_Frame frame = new MemberInsert_Frame(student_list);
			}
			else if(e.getSource() == member_delete){
				int confirm_temp=0;
				char[] temp = pw.getPassword();
				String passwd = new String(temp, 0, temp.length);
				for (int i = 0; i < student_list.size(); i++) {
					if (id.getText().equals(student_list.get(i).ID) && passwd.equals(student_list.get(i).PassWord)) {
						int result_Option = JOptionPane.showConfirmDialog(null, "정말 삭제하시겠습니까?","삭제확인",JOptionPane.YES_NO_OPTION);
						if(result_Option == JOptionPane.CLOSED_OPTION){
							return;
						}
						else if(result_Option == JOptionPane.YES_OPTION){
							student_list.remove(i);
							confirm_temp++;
						}
						else{
							return;
						}
					}
				}
				if(confirm_temp==0)
				JOptionPane.showMessageDialog(null, "일치하는 아이디나 비밀번호가 없습니다.", "삭제 실패",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	class User_ButtonListener implements ActionListener {
		int user_mail_count;
		int user_parcel_count;

		public void actionPerformed(ActionEvent e) {
			user_mail_count = student_list.get(remember_index).Post;
			user_parcel_count = student_list.get(remember_index).ParcelService;
			if (e.getSource() == rollcall_registration_button) {
				middle_panel_user.removeAll();
				roll_registration_Panel roll_panels = new roll_registration_Panel(student_list,remember_index,remember_room);
				middle_panel_user.add(roll_panels.roll_registration_Panel_return());
				
			}  else if (e.getSource() == mail_confirm_button) {
				JOptionPane.showMessageDialog(null, "우편은 " + user_mail_count + "통, 소포는 " + user_parcel_count
						+ "통이 있으니 찾아가시기 바랍니다.");
			} else if (e.getSource() == user_back) {
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

	class Manager_ButtonListener implements ActionListener {
		int a = 0, b = 123;

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == rollcall_confirm_button) {
				JOptionPane.showMessageDialog(null, "점호확인하였습니다.");
			}  else if (e.getSource() == mail_registration_button) {
				
				middle_panel_manager.removeAll();
				manager_mail_regist manager_mail_regists = new manager_mail_regist(student_list);
				middle_panel_manager.add(manager_mail_regists.manager_mail_regist_Panel_return());
				
			} else if (e.getSource() == manager_back) {
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
			user_back = new JButton("로그아웃");
			rollcall_registration_button = new JButton("점호등록");
			mail_confirm_button = new JButton("우편 및 소포 확인");

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

			rollcall_confirm_button = new JButton("점호확인");
			mail_registration_button = new JButton("우편 및 소포 등록");
			manager_back = new JButton("로그아웃");
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
