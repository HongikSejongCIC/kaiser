package project_kwon;

import java.util.ArrayList;

import javax.swing.JOptionPane;

class Student extends Human implements mail_relative{		//	�л�Ŭ���� ����
	String ID;
	String PassWord;
	String Name;
	String Sex;
	int Age;
	String Department;
	int room_number;
	int NFC;
	int Post;	// ����
	int ParcelService;	//�ù�
	boolean Rollcall_Confirm;
	
	void Member_Join(String ID, String PassWord, String Name,
			String Sex, int Age, String Department, int room_number, int NFC) {		//ȸ������ �Լ�
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
		user_mail_count = a.Post;		// ������ ������ ����
		user_parcel_count = a.ParcelService;	// �ù��� ������ ����
		JOptionPane.showMessageDialog(null, "������ " + user_mail_count + "��, ������ " + user_parcel_count
				+ "���� ������ ã�ư��ñ� �ٶ��ϴ�.");
	}

}