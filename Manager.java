package project_kwon;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

class Manager extends Human implements mail_relative{		//	������Ŭ���� ����
	void Manager_Join(String ID, String PassWord, String Name, String Sex) {		//�����ڰ��� �Լ�
		make(ID,PassWord,Name,Sex);
	}

	@Override
	void make(String ID, String PassWord, String Name, String Sex) {
		this.ID = ID;
		this.PassWord = PassWord;
		this.Name = Name;
		this.Sex = Sex;
	}

	@Override
	public void about_mail(Student a) {
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd, hh:mm:ss a");
		JOptionPane.showMessageDialog(null, a.Name+"�л��� ������ "+sdf.format(dt).toString()+"�� �����Ͽ����ϴ�.");
	}

}