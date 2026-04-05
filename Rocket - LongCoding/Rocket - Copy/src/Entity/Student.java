package Entity;

import java.util.Scanner;

import Service.App;

public class Student extends User{
    private int cgpa;

	public Student(int id, String name, String pass,int cgpa) {
		super(id, name, pass);
		this.cgpa=cgpa;
	}

	@Override
	public	void dashboard(App app) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to the dashboard!");
		while(true) {
		System.out.println("1.View Clubs\n2.To Join Clubs\n3.cancelMembership\n4.Registered Clubs\n5.Apply for Event\n6.Logout");
		int ch=sc.nextInt();
		if(ch==1) {
			app.getClubs();
		}
		else if(ch==2) {
			System.out.println("Enter club id: ");
			int clubId=sc.nextInt();
			app.joinClub(clubId,this);	
		}else if(ch==3) {
			System.out.println("Enter club id: ");
			int clubId=sc.nextInt();
			app.cancelmembership(clubId,this);
		}
		else if(ch==4) {
			app.registeredClubs();
		}
		else if(ch==5) {
			app.applyForEvent();
		}
		else{
			return;
		}
		}
	}
	public int getCgpa() {
		return cgpa;
	}
	public int getid() {
		return id;
	}
	public String getPass() {
		return pass;
	}
	
	public void setCgpa(int cgpa) {
		this.cgpa = cgpa;
	}
	public String toString() {
		return id+" "+name+" ";
	}

}
