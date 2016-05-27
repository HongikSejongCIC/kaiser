package project_kwon;

import java.util.ArrayList;

class Manager{		//	관리자클래스 정의
	String ID;
	String PassWord;
	String Name;
	String Sex;

	void Manager_Join(String ID, String PassWord, String Name, String Sex) {		//관리자가입 함수
		this.ID = ID;
		this.PassWord = PassWord;
		this.Name = Name;
		this.Sex = Sex;
	}

}