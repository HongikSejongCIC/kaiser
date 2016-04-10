package project_kwon;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


class MemberInsert_Frame extends JFrame{
	JPanel p;
	MemberInsert_Page page = new MemberInsert_Page();
	public MemberInsert_Frame(){
		setSize(500,450);
		setTitle("회원가입");
		p = page.return_panel();
		add(p);
		setVisible(true);
	}
}

class MemberInsert_Page extends JPanel{
	JPanel panels = new JPanel();
	public MemberInsert_Page(){
		panels = new JPanel(); 
		panels.setLayout(null);
		panels.setBackground(Color.WHITE);
		JPanel panel1 = new JPanel();JPanel panel2 = new JPanel();JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();JPanel panel5 = new JPanel();JPanel panel6 = new JPanel();JPanel panel7 = new JPanel();
		JPanel panel8 = new JPanel();JPanel panel9 = new JPanel();
		panel1.setBackground(null);panel2.setBackground(null);panel3.setBackground(null);panel4.setBackground(null);
		panel5.setBackground(null);panel6.setBackground(null);panel7.setBackground(null);panel8.setBackground(null);
		panel9.setBackground(null);
		JLabel intro = new JLabel("회원가입 메뉴");
		intro.setFont(new Font("Serif",Font.BOLD,20));
		String[] major_list={"컴퓨터정보통신","바이오화학","전자전기","광고홍보","기계공학"};
		JComboBox major = new JComboBox(major_list);
		JLabel ID = new JLabel("ID");JLabel PW = new JLabel("비밀번호");JLabel NAME = new JLabel("이름");
		JLabel AGE = new JLabel("나이");JLabel SEX = new JLabel("성별");JLabel MAJOR = new JLabel("학과");
		JLabel ROOM_NUMBER = new JLabel("호실");
		JTextField id = new JTextField(10);
		JTextField pw = new JTextField(10);
		JTextField name = new JTextField(10);
		JTextField age = new JTextField(10);
		JTextField room_number = new JTextField(10);
		JButton id_confirm = new JButton("아이디 확인");
		ButtonGroup g = new ButtonGroup();
		JRadioButton male = new JRadioButton("남자");
		JRadioButton female = new JRadioButton("여자");
		g.add(male);g.add(female);male.setBackground(null);female.setBackground(null);
		JButton NFC = new JButton("NFC를 대주세요");
		NFC.setSize(50, 50);
		
		panel1.setBounds(0,10,500,40);
		panel2.setBounds(0,60,500,40);
		panel3.setBounds(0,100,500,40);
		panel4.setBounds(0,140,500,40);
		panel5.setBounds(0,180,500,40);
		panel6.setBounds(0,220,500,40);
		panel7.setBounds(0,260,500,40);
		panel8.setBounds(0,310,500,40);
		panel9.setBounds(0,350,500,40);
		
		panel1.add(intro);
		panel2.add(ID);panel2.add(id);panel2.add(id_confirm);panel3.add(PW);panel3.add(pw);panel4.add(NAME);panel4.add(name);
		panel5.add(AGE);panel5.add(age);panel6.add(SEX);panel6.add(male);panel6.add(female);panel7.add(ROOM_NUMBER);panel7.add(room_number);
		panel8.add(MAJOR);panel8.add(major);panel9.add(NFC);
		panels.add(panel1);panels.add(panel2);panels.add(panel3);panels.add(panel4);panels.add(panel5);panels.add(panel6);
		panels.add(panel7);panels.add(panel8);panels.add(panel9);
	}
	public JPanel return_panel(){
		return panels;
	}
}