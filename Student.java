package project_kwon;

import java.util.ArrayList;

class Student{		//	�л�Ŭ���� ����
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
		this.ID = ID;
		this.PassWord = PassWord;
		this.Name = Name;
		this.Sex = Sex;
		this.Age = Age;
		this.Department = Department;
		this.room_number = room_number;
		this.NFC = NFC;
		this.Rollcall_Confirm = false;
		this.Post =0;
		this.ParcelService = 0;
	}

}