package project_kwon;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	CardLayout cards = new CardLayout();
	ImageIcon img;
	JLabel image_label;
	JButton login;
	JButton member_join;
	JButton rollcall_registration_button;
	JButton noticeboard_confirm_button;
	JButton mail_confirm_button;
	JButton user_back;
	JButton manager_back;
	JButton rollcall_confirm_button;
	JButton noticeboard_registration_button;
	JButton mail_registration_button;
	
	JPanel system_panel, top_panel, middle_panel;
	
	JTextField id = new JTextField(15);
	JPasswordField pw = new JPasswordField(15);

	Hongik_Thread th = new Hongik_Thread();
	ButtonListener b_listener = new ButtonListener();
	MemberInsert_Page member_page = new MemberInsert_Page();

	public MainFrame() {
		setSize(500, 550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("기숙사점호시스템");
		setBackground(Color.white);
		getContentPane().setLayout(cards);

		getContentPane().add("Main", new Main_Page(this));
		getContentPane().add("User", new User_Panel(this));
		getContentPane().add("Manager", new Manager_Panel(this));

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
			login.addActionListener(b_listener);
			member_join.addActionListener(b_listener);
			panel5.add(login);
			panel5.add(member_join);

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
				// System.out.println(passwd);
				// System.out.println(id.getText());
				if (id.getText().equals("whhwhh") && passwd.equals("1234")) {
					JOptionPane.showMessageDialog(null, "유저 로그인에 성공하였습니다.");
					change_User_Panel();
				} else if (id.getText().equals("momo") && passwd.equals("1234")) {
					JOptionPane.showMessageDialog(null, "관리자 로그인에 성공하였습니다.");
					change_Manager_Panel();
				} else
					JOptionPane.showMessageDialog(null, "로그인에 실패하였습니다.",
							"로그인 실패", JOptionPane.WARNING_MESSAGE);
			}

			else {
				MemberInsert_Frame frame = new MemberInsert_Frame();
			}
		}
	}

	class User_ButtonListener implements ActionListener {
		int a = 10, b = 20;

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == rollcall_registration_button) {
				JOptionPane.showMessageDialog(null, "점호등록완료하였습니다.");
			} else if (e.getSource() == noticeboard_confirm_button) {
				JOptionPane.showMessageDialog(null, "공지사항이 없습니다.");
			} else if (e.getSource() == mail_confirm_button) {
				JOptionPane.showMessageDialog(null, "우편은 " + a + "통, 소포는 " + b
						+ "통이 있으니 찾아가시기 바랍니다.");
			} else if (e.getSource() == user_back) {
				id.setText(null);
				pw.setText(null);
				change_Main_Panel();
			}
		}
	}
	class Manager_ButtonListener implements ActionListener {
		int a = 0, b = 123;
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == rollcall_confirm_button) {
				JOptionPane.showMessageDialog(null, "점호확인하였습니다.");
			} else if (e.getSource() == noticeboard_registration_button) {
				JOptionPane.showMessageDialog(null, "공지사항이 없습니다.");
			} else if (e.getSource() == mail_registration_button) {
				JOptionPane.showMessageDialog(null, "우편은 " + a + "통, 소포는 " + b
						+ "통이 있으니 찾아가시기 바랍니다.");
				middle_panel.removeAll();
				// 요부분부터 수정하면 됨
				//middle_panel = new roll_registration_Panel();
				//add(middle_panel);
			} else if (e.getSource() == manager_back) {
				id.setText(null);
				pw.setText(null);
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

			system_panel = new JPanel();
			top_panel = new JPanel();
			middle_panel = new JPanel();
			system_panel.setBackground(Color.WHITE);
			top_panel.setBackground(Color.WHITE);
			top_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
			middle_panel.setBackground(Color.WHITE);

			img = new ImageIcon("img/campus_img.jpg");
			image_label = new JLabel(img);
			user_back = new JButton("로그아웃");
			rollcall_registration_button = new JButton("점호등록");
			noticeboard_confirm_button = new JButton("공지사항 확인");
			mail_confirm_button = new JButton("우편 및 소포 확인");

			rollcall_registration_button.addActionListener(user_listener);
			noticeboard_confirm_button.addActionListener(user_listener);
			mail_confirm_button.addActionListener(user_listener);
			user_back.addActionListener(user_listener);

			top_panel.add(rollcall_registration_button);
			top_panel.add(noticeboard_confirm_button);
			top_panel.add(mail_confirm_button);
			top_panel.add(user_back);

			middle_panel.add(image_label);

			system_panel.add(top_panel, BorderLayout.NORTH);
			system_panel.add(middle_panel, BorderLayout.CENTER);
			add(system_panel);

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

			system_panel = new JPanel();
			top_panel = new JPanel();
			middle_panel = new JPanel();
			system_panel.setBackground(Color.WHITE);
			top_panel.setBackground(Color.WHITE);
			top_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
			middle_panel.setBackground(Color.WHITE);

			img = new ImageIcon("img/campus_img.jpg");
			image_label = new JLabel(img);

			rollcall_confirm_button = new JButton("점호확인");
			noticeboard_registration_button = new JButton("공지사항 등록");
			mail_registration_button = new JButton("우편 및 소포 등록");
			manager_back = new JButton("로그아웃");
			rollcall_confirm_button.addActionListener(manager_listener);
			noticeboard_registration_button.addActionListener(manager_listener);
			mail_registration_button.addActionListener(manager_listener);
			manager_back.addActionListener(manager_listener);

			top_panel.add(rollcall_confirm_button);
			top_panel.add(noticeboard_registration_button);
			top_panel.add(mail_registration_button);
			top_panel.add(manager_back);

			middle_panel.add(image_label);

			system_panel.add(top_panel, BorderLayout.NORTH);
			system_panel.add(middle_panel, BorderLayout.CENTER);
			add(system_panel);

			setVisible(true);
		}
	}

	
	
	
	
}

public class project_Kaiser {
	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
	}

}
