import java.util.*;

class System{
	boolean Student_ID_Check(ArrayList<Student> receive, String id){
		int num = receive.size();
		for(int i=0; i<num; i++){
			if(receive.get(i).ID.equals(id))
					return true;
				else
					return false;
		}
		return false;
	}
	
	Student Login(Student s, ArrayList<Student> receive, String input_id, String input_pw){
		int num = receive.size(); // 3개있을떄 3개
		for(int i=0;i<num;i++){
			if(receive.get(i).ID.equals(input_id))
				if(receive.get(i).PassWord.equals(input_pw)){
					s = receive.get(i);
					return s;
				}
				else{
					s=null;
					return s;
				}
		}
		s=null;
		return s;
	}
	
    int Logout(){
		
		return 1000;
		
	}
    
    
    
	
}

class Student extends System{
	String ID;
	String PassWord;
	String Name;
    String Sex;
	int Age;
	String Department;
	int NFC;
	int Post;
	int ParcelService;
	boolean Rollcall_Confirm;

	public void Member_Join(String ID, String PassWord, String Name, String Sex, int Age, String Department, int NFC){
		this.ID=ID; 
		this.PassWord=PassWord; 
		this.Name=Name; 
		this.Sex=Sex; 
		this.Age=Age; 
		this.Department=Department; 
		this.NFC=NFC;
		this.Rollcall_Confirm = false;
	
	}
	
	
	
	Student Login(Student s, ArrayList<Student> receive, String input_id, String input_pw){
		int num = receive.size(); // 3개있을떄 3개
		for(int i=0;i<num;i++){
			if(receive.get(i).ID.equals(input_id))
				if(receive.get(i).PassWord.equals(input_pw)){
					s = receive.get(i);
					return s;
				}
				else{
					s=null;
					return s;
				}
		}
		s=null;
		return s;
	}
	
	int Logout(){
		
		return 1000;
		
	}
	
	boolean RollCall(ArrayList<Student> receive, int NFC){
		
		
		return true;
		
	}
	
	boolean Notice_Check(){
		
		return true;
		
	}
	
	boolean PostAndParcelService_Check(ArrayList<Student> receive, int post, int parcelservice){
		
		return true;
		
	}
	

	
}

class Manager extends System{
	String ID;
	String PassWord;
	String Name;
	String Sex;
	String Notice_Title;
	String Notice_Content;
	String Notice_Writer;
	int Room_Number;
	int Floor;
	int Post;
	int ParcelService;
	
	public void Manager_Information(String ID, String PassWord, String Name, String Sex){
		this.ID=ID; 
		this.PassWord=PassWord; 
		this.Name=Name; 
		this.Sex=Sex;
	}
	
	boolean Login(String input_id, String input_pw){
		
		if(ID.equals(input_id))
			if(PassWord.equals(input_pw)){
				return true;
			}
			else{
				return false;
			}
		return false;
	}
	
	boolean Logout(){
		
		return true;
	}
	
	boolean RollCall_State(ArrayList<Student> receive, int room_number, int floor){
		
		return true;
	}
	
	boolean Notice_Registration(ArrayList<Student> receive, String notice_title, String notie_content, String notice_writer){
		
		return true;
	}
	
	boolean PostAndParcelService_Registration(ArrayList<Student> receive, int post, int parcelservice){
		
		return true;
	}
	
	
}

public class RollCallSystem {
	public static void main(String[] args) {
		
		/*
		Manager man = new Manager(     );
		man.Notice_Registration();
		man.PostAndParcelService_Registration();
		
		Manager woman = new Manager(     );
		woman.Notice_Registration();
		woman.PostAndParcelService_Registration();
		*/
		
		ArrayList<Student> a = new ArrayList<Student>();
		Student st1 = new Student();
		Student st2 = new Student();
		Student st3 = new Student();
		Student s = null;
		
		st1.Member_Join("qwer","123","Sam","male",25,"coumputer",100);
		st2.Member_Join("asdf","123","Emily","female",21,"design",55);
		st3.Member_Join("zxcv","123","Peter","male",20,"graphic",83);
		a.add(st1);
		a.add(st2);
		a.add(st3);
		st1.Student_ID_Check(a, "qwer");
		st2.Student_ID_Check(a, "1234");
		for(int i=0; i<a.size(); i++){
			System.out.println(a.get(i).ID + " " + a.get(i).PassWord + " " + a.get(i).Name + " " + a.get(i).Sex + " " + a.get(i).Age + " " + a.get(i).Department + " " + a.get(i).NFC);
		}
		s = st1.Login(s,a,"qwer","123");
		s = st1.Login(s,a,"asdf","123");
		s = st1.Login(s,a,"zxcv","123");
		s = st1.Login(s,a,"1234","123");
		s = st1.Login(s,a,"12345","123");
		
		Manager man = new Manager();
		man.Manager_Information("ManManager2016", "m_domitory1234", "철수", "남");
		Manager woman = new Manager();
		woman.Manager_Information("WomanManager2016", "w_domitory1234", "영희", "여");
		
		man.Login("ManManager2016", "m_domitory1234");
		woman.Login("WomanManager2016", "m_domitory");
		
	    
	    
	}

}
