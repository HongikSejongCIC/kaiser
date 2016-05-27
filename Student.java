package project_kwon;

import java.util.ArrayList;

class Student{		//	학생클래스 정의
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