import java.util.*;

class Student {
	String ID;
	String PassWord;
	String Name;
	String Sex;
	int Age;
	String Department;
	int NFC;
	int Post;
	int ParcelService;
	int Rank;
	int RoomNumber;
	
	
	boolean ID_Check(ArrayList<Student> receive, String id){
		int num = receive.size();
		for(int i=0;i<num;i++){
			if(receive.get(i).ID.equals(id))
					return true;
				else
					return false;
		}
		return false;
	}
	
	
	public void Member_Join(String ID, String PassWord, String Name, String Sex, int Age, String Department, int NFC){
		this.ID=ID; this.PassWord=PassWord; this.Name=Name; this.Sex=Sex; this.Age=Age; this.Department=Department; this.NFC=NFC;
	
	}
	
	boolean Rogin(ArrayList<Student> receive, String id, String pw){
		int num = receive.size();
		for(int i=0;i<num;i++){
			if(receive.get(i).ID.equals(id))
				if(receive.get(i).PassWord.equals(pw))
					return true;
				else
					return false;
		}
		return false;
	}
	
	public boolean Rogout(){
		
		return true;
		
	}
	
	public boolean RollCall(){
		
		return true;
		
	}
	
	public boolean Notice_Check(){
		
		return true;
		
	}
	
	public boolean PostAndParcelService_Check(){
		
		return true;
		
	}
	

	
}

class Manager {
	String ID;
	String PassWord;
	String Name;
	String Sex;
	int Rank;
	
	public Manager(String ID, String PassWord, String Name, String Sex, int Rank){
		this.ID=ID; this.PassWord=PassWord; this.Name=Name; this.Sex=Sex; this.Rank=Rank;
	}
	
	public void RollCall_State(){
		
	}
	
	public void Notice_Registration(){
		
	}
	
	public void PostAndParcelService_Registration(){
		
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
		
		st1.Member_Join("qwer","123","Sam","male",25,"coumputer",100);
		st2.Member_Join("asdf","123","Emily","female",21,"design",55);
		st3.Member_Join("zxcv","123","Peter","male",20,"graphic",83);
		a.add(st1);
		a.add(st2);
		a.add(st3);
		st1.ID_Check(a, "qwer");
		st2.ID_Check(a, "1234");
		for(int i=0; i<a.size(); i++){
			System.out.println(a.get(i).ID + " " + a.get(i).PassWord + " " + a.get(i).Name + " " + a.get(i).Sex + " " + a.get(i).Age + " " + a.get(i).Department + " " + a.get(i).NFC);
		}
		
	    
	    
	    
	    
	}

}
