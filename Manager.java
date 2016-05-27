package project_kwon;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

class Manager extends Human implements mail_relative{		//	관리자클래스 정의
	void Manager_Join(String ID, String PassWord, String Name, String Sex) {		//관리자가입 함수
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
		JOptionPane.showMessageDialog(null, a.Name+"학생의 정보를 "+sdf.format(dt).toString()+"에 수정하였습니다.");
	}

}