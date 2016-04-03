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
	
	
	public void ID_Check(){
		
		
	}
	
	public void PW_Check(){
		
		
	}
	
	public void Member_Join(String ID, String PassWord, String Name, String Sex, int Age, String Department, int NFC){
		this.ID=ID; this.PassWord=PassWord; this.Name=Name; this.Sex=Sex; this.Age=Age; this.Department=Department; this.NFC=NFC;
	}
	
	public void Rogin(){
		
	}
	
	public boolean Rogout(){
		return true;
	}
	
	public void RollCall(){
		
	}
	
	public void Notice_Check(){
		
	}
	
	public void PostAndParcelService_Check(){
		
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
		
		Student s = new Student();
	
		/*
		Manager man = new Manager(     );
		man.Notice_Registration();
		man.PostAndParcelService_Registration();
		
		Manager woman = new Manager(     );
		woman.Notice_Registration();
		woman.PostAndParcelService_Registration();
		*/
		
		ArrayList<Student> a = new ArrayList<Student>();
		Student st = new Student();
		st.Member_Join("qwe","123","Sam","male",21,"coumputer",100);
		a.add(st);
		System.out.println(a.size());
		for(int i=0; i<a.size(); i++){
			System.out.print(a.get(i).Name + " ");
		}
		
		
	}

}
