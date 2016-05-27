package project_kwon;

import java.util.ArrayList;

import javax.swing.JOptionPane;

class Student extends Human implements mail_relative{		//	학생클래스 정의
	String ID;
	String PassWord;
	String Name;
	String Sex;
	int Age;
	String Department;
	int room_number;
	int NFC;
	int Post;	// 우편
	int ParcelService;	//택배
	boolean Rollcall_Confirm;
	
	void Member_Join(String ID, String PassWord, String Name,
			String Sex, int Age, String Department, int room_number, int NFC) {		//회원가입 함수
		make(ID, PassWord, Name, Sex);
		this.Age = Age;
		this.Department = Department;
		this.room_number = room_number;
		this.NFC = NFC;
		this.Rollcall_Confirm = false;
		this.Post =0;
		this.ParcelService = 0;
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
		int user_mail_count;
		int user_parcel_count;
		user_mail_count = a.Post;		// 메일의 갯수를 저장
		user_parcel_count = a.ParcelService;	// 택배의 갯수를 저장
		JOptionPane.showMessageDialog(null, "우편은 " + user_mail_count + "통, 소포는 " + user_parcel_count
				+ "통이 있으니 찾아가시기 바랍니다.");
	}

}