package project_kwon;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

class roll_confirm_Panel extends JPanel {		// ��ȣȮ���ϱ� �г�
	JPanel roll_confirm_panel;
	GridBagConstraints c;		// ǥ�� ��Ÿ�������� ���
	ArrayList<Student> student_list;
	Manager manager_information;

	public roll_confirm_Panel(ArrayList<Student> student_list,
			Manager manager_infomation) {		// �����Լ��� ���� �л�����Ʈ�� ������ ��ü�� �޾ƿ´�.
		this.student_list = student_list;
		this.manager_information = manager_information;

		setSize(300, 300);
		GridBagLayout gridbag = new GridBagLayout();
		roll_confirm_panel = new JPanel();
		setLayout(gridbag);
		c = new GridBagConstraints();
		c.weightx = 2.0;
		c.weighty = 2.0;
		c.fill = GridBagConstraints.BOTH;

		ImageIcon ok_img = new ImageIcon("img/Ok_icon.jpg");
		ImageIcon wrong_img = new ImageIcon("img/Wrong_icon.jpg");

		JPanel panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(100, 300));
		panel1.setBorder(new LineBorder(Color.black));
		panel1.setLayout(null);
		JPanel panel2 = new JPanel();
		panel2.setPreferredSize(new Dimension(50, 150));
		panel2.setBorder(new LineBorder(Color.black));
		panel2.setLayout(null);
		JPanel panel3 = new JPanel();
		panel3.setPreferredSize(new Dimension(50, 150));
		panel3.setBorder(new LineBorder(Color.black));
		panel3.setLayout(null);
		JPanel panel4 = new JPanel();
		panel4.setPreferredSize(new Dimension(150, 150));
		panel4.setBorder(new LineBorder(Color.black));
		JPanel panel5 = new JPanel();
		panel5.setPreferredSize(new Dimension(150, 150));
		panel5.setBorder(new LineBorder(Color.black));
		JPanel panel6 = new JPanel();
		panel6.setPreferredSize(new Dimension(150, 150));
		panel6.setBorder(new LineBorder(Color.black));
		JPanel panel7 = new JPanel();
		panel7.setPreferredSize(new Dimension(150, 150));
		panel7.setBorder(new LineBorder(Color.black, 2, true));

		JLabel l1_1 = new JLabel("���ڱ����");
		JLabel l1_2 = new JLabel("���ڱ����");
		JLabel l2 = new JLabel("1��");
		l2.setBounds(15, 50, 40, 40);
		JLabel l3 = new JLabel("2��");
		l3.setBounds(15, 50, 40, 40);

		if (manager_infomation.Sex.equals("male")) {
			panel1.add(l1_1);
			l1_1.setBounds(20, 130, 80, 40);
		} else if (manager_infomation.Sex.equals("female")) {
			panel1.add(l1_2);
			l1_2.setBounds(20, 130, 80, 40);
		}

		panel2.add(l2);
		panel3.add(l3);
		
		if (manager_infomation.Sex.equals("male"))		// �Ŵ����� ���ڶ�� ���л��� ��Ÿ����.
			for (int i = 0; i < student_list.size(); i++) {
				JLabel temp_label = new JLabel("");
				// �л��� �����϶�
				if (student_list.get(i).Sex.equals("male")) {
					// ȣ����
					if (student_list.get(i).room_number == 101) {
						// ��ȣȮ�ο���
						if (student_list.get(i).Rollcall_Confirm == true) {
							temp_label = new JLabel(student_list.get(i).Name
									+ "(" + student_list.get(i).room_number
									+ ")", ok_img, SwingConstants.CENTER);
							panel4.add(temp_label);
						} else if (student_list.get(i).Rollcall_Confirm == false) {
							temp_label = new JLabel(student_list.get(i).Name
									+ "(" + student_list.get(i).room_number
									+ ")", wrong_img, SwingConstants.CENTER);
							panel4.add(temp_label);
						}

					} else if (student_list.get(i).room_number == 102) {
						if (student_list.get(i).Rollcall_Confirm == true) {
							temp_label = new JLabel(student_list.get(i).Name
									+ "(" + student_list.get(i).room_number
									+ ")", ok_img, SwingConstants.CENTER);
							panel6.add(temp_label);
						} else if (student_list.get(i).Rollcall_Confirm == false) {
							temp_label = new JLabel(student_list.get(i).Name
									+ "(" + student_list.get(i).room_number
									+ ")", wrong_img, SwingConstants.CENTER);
							panel6.add(temp_label);
						}

					} else if (student_list.get(i).room_number == 201) {
						if (student_list.get(i).Rollcall_Confirm == true) {
							temp_label = new JLabel(student_list.get(i).Name
									+ "(" + student_list.get(i).room_number
									+ ")", ok_img, SwingConstants.CENTER);
							panel5.add(temp_label);
						} else if (student_list.get(i).Rollcall_Confirm == false) {
							temp_label = new JLabel(student_list.get(i).Name
									+ "(" + student_list.get(i).room_number
									+ ")", wrong_img, SwingConstants.CENTER);
							panel5.add(temp_label);
						}

					} else if (student_list.get(i).room_number == 202) {
						if (student_list.get(i).Rollcall_Confirm == true) {
							temp_label = new JLabel(student_list.get(i).Name
									+ "(" + student_list.get(i).room_number
									+ ")", ok_img, SwingConstants.CENTER);
							panel7.add(temp_label);
						} else if (student_list.get(i).Rollcall_Confirm == false) {
							temp_label = new JLabel(student_list.get(i).Name
									+ "(" + student_list.get(i).room_number
									+ ")", wrong_img, SwingConstants.CENTER);
							panel7.add(temp_label);
						}
					}
				}
			}
		// �����ڰ� ���ڶ�� ���л��� ��Ÿ����.
		else if (manager_infomation.Sex.equals("female"))
			for (int i = 0; i < student_list.size(); i++) {
				JLabel temp_labels = new JLabel("");
				if (student_list.get(i).Sex.equals("female")) {
					// ȣ����
					if (student_list.get(i).room_number == 101) {
						// ��ȣȮ�ο���
						if (student_list.get(i).Rollcall_Confirm == true) {
							temp_labels = new JLabel(student_list.get(i).Name
									+ "(" + student_list.get(i).room_number
									+ ")", ok_img, SwingConstants.CENTER);
							panel4.add(temp_labels);
						} else if (student_list.get(i).Rollcall_Confirm == false) {
							temp_labels = new JLabel(student_list.get(i).Name
									+ "(" + student_list.get(i).room_number
									+ ")", wrong_img, SwingConstants.CENTER);
							panel4.add(temp_labels);
						}

					} else if (student_list.get(i).room_number == 102) {
						if (student_list.get(i).Rollcall_Confirm == true) {
							temp_labels = new JLabel(student_list.get(i).Name
									+ "(" + student_list.get(i).room_number
									+ ")", ok_img, SwingConstants.CENTER);
							panel6.add(temp_labels);
						} else if (student_list.get(i).Rollcall_Confirm == false) {
							temp_labels = new JLabel(student_list.get(i).Name
									+ "(" + student_list.get(i).room_number
									+ ")", wrong_img, SwingConstants.CENTER);
							panel6.add(temp_labels);
						}

					} else if (student_list.get(i).room_number == 201) {
						if (student_list.get(i).Rollcall_Confirm == true) {
							temp_labels = new JLabel(student_list.get(i).Name
									+ "(" + student_list.get(i).room_number
									+ ")", ok_img, SwingConstants.CENTER);
							panel5.add(temp_labels);
						} else if (student_list.get(i).Rollcall_Confirm == false) {
							temp_labels = new JLabel(student_list.get(i).Name
									+ "(" + student_list.get(i).room_number
									+ ")", wrong_img, SwingConstants.CENTER);
							panel5.add(temp_labels);
						}

					} else if (student_list.get(i).room_number == 202) {
						if (student_list.get(i).Rollcall_Confirm == true) {
							temp_labels = new JLabel(student_list.get(i).Name
									+ "(" + student_list.get(i).room_number
									+ ")", ok_img, SwingConstants.CENTER);
							panel7.add(temp_labels);
						} else if (student_list.get(i).Rollcall_Confirm == false) {
							temp_labels = new JLabel(student_list.get(i).Name
									+ "(" + student_list.get(i).room_number
									+ ")", wrong_img, SwingConstants.CENTER);
							panel7.add(temp_labels);
						}
					}
				}
			}

		layout(panel1, 0, 0, 1, 2); // ������ġx, ������ġ y , �ʺ�, ����
		layout(panel2, 1, 0, 1, 1);
		layout(panel3, 1, 1, 1, 1);
		layout(panel4, 2, 0, 1, 1);
		layout(panel5, 2, 1, 1, 1);
		layout(panel6, 3, 0, 1, 1);
		layout(panel7, 3, 1, 1, 1);
	}

	void layout(Component obj, int x, int y, int width, int height) {
		c.gridx = x; // ������ġ x
		c.gridy = y; // ������ġ y
		c.gridwidth = width; // �����̳� �ʺ�
		c.gridheight = height; // �����̳� ����
		add(obj, c);
	}

}
