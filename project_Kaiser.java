package project_kwon;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class Main_Frame extends JFrame{
	CardLayout cards = new CardLayout();
     
    public Main_Frame() {
        setSize(330, 100);
        getContentPane().setLayout(cards);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        getContentPane().add("One", new P_One(this));
        getContentPane().add("Two", new P_Two(this));
         
        setVisible(true);
    }
    
    public void changePanel() {
        cards.next(this.getContentPane());
    }
    
    class P_One extends JPanel {
    private JLabel lblNewLabel;
    private JButton btnNewButton;
    private JFrame F;
     
    public P_One(JFrame f) {
        setBackground(Color.LIGHT_GRAY);
        setSize(330, 80);
        setLayout(null);
         
        F = f;
         
        lblNewLabel = new JLabel("Panel One");
        lblNewLabel.setBounds(12, 10, 59, 15);
        add(lblNewLabel);
         
        btnNewButton = new JButton("Change Panel");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                changePanel();
            }
        });
        btnNewButton.setBounds(12, 35, 113, 23);
        add(btnNewButton);
 
        setVisible(true);
    }
    }
    
    
    class P_Two extends JPanel {
        private JLabel lblNewLabel;
        private JButton btnNewButton;
        private JFrame F;
         
        public P_Two(JFrame f) {
            setBackground(Color.GRAY);
            setSize(330, 80);
            setLayout(null);
             
            F = f;
             
            lblNewLabel = new JLabel("Panel Two");
            lblNewLabel.setBounds(12, 10, 61, 15);
            add(lblNewLabel);
             
            btnNewButton = new JButton("Change Panel");
            btnNewButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    changePanel();
                }
            });
            btnNewButton.setBounds(12, 35, 113, 23);
            add(btnNewButton);
     
            setVisible(true);
        }
    }
}


//////////////////////////////////////////////////////////////////////////

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





class MainFrame extends JFrame{	
	CardLayout cards = new CardLayout();
	ImageIcon img;
	JLabel image_label;
	JButton login;
	JButton member_join;
	JTextField id = new JTextField(15);
	JPasswordField pw = new JPasswordField(15);
	
	Hongik_Thread th = new Hongik_Thread();
	ButtonListener b_listener = new ButtonListener();
	MemberInsert_Page member_page = new MemberInsert_Page();
	
	public MainFrame(){
		setSize(500,550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("기숙사점호시스템");
		setBackground(Color.white);
		getContentPane().setLayout(cards);
		
		getContentPane().add("Main", new Main_Page(this));
        getContentPane().add("Temp", new Temp_Panel(this));
        
        setVisible(true);
	}
	
	public void changePanel() {
        cards.next(this.getContentPane());
    }
	
	
	class Main_Page extends JPanel{
		private JFrame F;
		JPanel panel;
        
        public Main_Page(JFrame f) {
            setSize(500, 500);
            setLayout(null);
            F = f;
             
            panel = new JPanel();
    		panel.setBackground(Color.white);
    		panel.setBounds(0, 0, 500, 500);;
    		//panel.setLayout(new FlowLayout(FlowLayout.CENTER,10,20));
    		panel.setLayout(null);
    		JPanel panel1 = new JPanel();
    		panel1.setBackground(Color.white);
    		panel1.setBounds(0, 10, 500, 50);
    		JPanel panel2 = new JPanel();
    		panel2.setBackground(Color.white);
    		panel2.setBounds(0, 60, 500, 300);
    		JPanel panel3 = new JPanel();
    		panel3.setBackground(Color.white);
    		panel3.setLayout(new FlowLayout(FlowLayout.CENTER,20,0));
    		panel3.setBounds(0, 360, 500, 40);
    		JPanel panel4 = new JPanel();
    		panel4.setBackground(Color.white);
    		panel4.setLayout(new FlowLayout(FlowLayout.CENTER,20,0));
    		panel4.setBounds(0, 410, 500, 40);
    		JPanel panel5 = new JPanel();
    		panel5.setBackground(Color.white);
    		panel5.setLayout(new FlowLayout(FlowLayout.CENTER,30,0));
    		panel5.setBounds(0, 460, 500, 40);
    		
    		JLabel label = new JLabel("☆ 기숙사 점호 시스템 ☆");
    		label.setFont(new Font("Serif",Font.BOLD,20));
    		panel1.add(label);
    		
    		img = new ImageIcon("img/hongik_logo1.jpg");
    		image_label = new JLabel(img);
    		panel2.add(image_label);
    		
    		JLabel label1 = new JLabel("I D");
    		JLabel label2 = new JLabel("P W");
    		label1.setFont(new Font("Serif",Font.BOLD,15));
    		label2.setFont(new Font("Serif",Font.BOLD,15));
    		panel3.add(label1);panel3.add(id);
    		panel4.add(label2);panel4.add(pw);
    		
    		login = new JButton("로그인");
    		member_join = new JButton("회원가입");
    		login.addActionListener(b_listener);member_join.addActionListener(b_listener);
    		panel5.add(login);panel5.add(member_join);
    		
    		panel.add(panel1);panel.add(panel2);panel.add(panel3);panel.add(panel4);panel.add(panel5);
    		th.start();
    		add(panel);
    		setVisible(true);
        }
	}
	
	class Temp_Panel extends JPanel{
		private JFrame F;
		public Temp_Panel(JFrame f){
			setBackground(Color.WHITE);
            setSize(500, 500);
            setLayout(null);
            F = f;
            JLabel post = new JLabel("성공");
            post.setBounds(10, 10, 100, 100);
            add(post);
            setVisible(true);
		}
	}
	
	class Hongik_Thread extends Thread{
		public void run(){
			for(int i=1; i<21;i++){
				try{
					img = new ImageIcon("img/hongik_logo"+i+".jpg");
					image_label.setIcon(img);
					Thread.sleep(250);
					if(i==20)
						i=1;
				}catch(InterruptedException e){
					return;
				}
			}
		}
	}
	
	class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()== login){
				char[] temp = pw.getPassword();
				String passwd = new String(temp,0,temp.length);
				//System.out.println(passwd);
				//System.out.println(id.getText());
				if(id.getText().equals("whhwhh")&&passwd.equals("1234")){
					JOptionPane.showMessageDialog(null, "로그인에 성공하였습니다.");
					changePanel();
				}
				else
					JOptionPane.showMessageDialog(null, "로그인에 실패하였습니다.", "로그인 실패", JOptionPane.WARNING_MESSAGE);
			}
			else{
				MemberInsert_Frame frame = new MemberInsert_Frame();
			}
		}
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

public class project_Kaiser {
	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		//Main_Frame f = new Main_Frame();
	}

}
