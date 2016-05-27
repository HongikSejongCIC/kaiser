package project_kwon;

abstract class Human {
	String ID;
	String PassWord;
	String Name;
	String Sex;
	
	abstract void make(String ID, String PassWord, String Name, String Sex);
}

interface mail_relative{
	public void about_mail(Student a);
}