package Service;

import java.util.*;

import Entity.Club;
import Entity.Event;
import Entity.Student;

public class App {
Map<Integer,Student> users=new HashMap<>();
List<Club> clubs=new ArrayList<>();
Map<Student,Club> map=new HashMap<>();
Map<Student,Club> waitlist=new HashMap<>();
List<Event> events=new ArrayList<>();
Map<Club,Event> clubToevent=new HashMap<>();
Map<Student,Map<Club,Event>> studentTocToE=new HashMap<>();

int uid=1;
public void addClub() {
	clubs.add(new Club(1,"Music",2));
	clubs.add(new Club(2,"Dance",10));
}

public void addEvent() {
	events.add(new Event(1,"Singing Competition",clubs.get(0)));
	events.add(new Event(2,"Paatuku paatu",clubs.get(0)));
}

public void register() {
Scanner sc=new Scanner(System.in);
System.out.println("Enter your name: ");
String name=sc.nextLine();
System.out.println("Enter your password: ");
String pass=Hash(sc.nextLine());
System.out.println("Enter your password: ");
int cgpa=Integer.parseInt(sc.nextLine());
Student student=new Student(uid,name,pass,cgpa);
users.put(uid,student);
System.out.println("Your user id is: "+uid);
uid++;
}


private String Hash(String nextLine) {
	return new StringBuilder(nextLine).reverse().toString();
}


public void getClubs() {
	for(Club club:clubs) {
		System.out.println(club.getClubid()+" "+club.getName()+" "+club.getSize());
	}
}


public void joinClub(int clubId, Student student) {
	for(Club club:clubs) {
		if(club.getClubid()==clubId && club.getSize()>0) {
			club.setSize(club.getSize()-1);
			 map.put(student,club);
			 System.out.println("Registered Successfully");
			 return;
		}
	}
	System.out.println("No Seats Available You have been added to the waitlist");
	for(Club club:clubs) {
		if(club.getClubid()==clubId) {
			 waitlist.put(student,club);
			 return;
		}
	}
}

public void cancelmembership(int clubId, Student student) {
	int cgpa=1;
	int k=0;
	for(Student s:waitlist.keySet()) {
		 if(s.getCgpa()>cgpa) {
			 k=s.getid();
			 cgpa=s.getCgpa();
		 }
	 }
	for(Club club:clubs) {
		if(club.getClubid()==clubId) {
			club.setSize(club.getSize()+1);
			 map.remove(student);
			 System.out.println("Removed Successfully");
			 for(Student s:waitlist.keySet()) {
				 if(s.getid()==k) {
				 map.put(s, waitlist.get(s));
				 waitlist.remove(s);
				 return;
				 }
			 }
		}
	}
}


public void registeredClubs() {
	for(Student s:map.keySet()) {
		System.out.println(s.toString());
		System.out.println(map.get(s).toString());

	}
}


public void login() {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter your user id: ");
	int uid=sc.nextInt();
	sc.nextLine();
	System.out.println("Enter your password: ");
	String pass=sc.nextLine();
	for(int id:users.keySet()) {
		if(uid==id) {
		Student user=users.get(uid);
		if(user.getPass().equals(pass)) {
			user.dashboard(this);		
		}
		}
	}
}
public void RegisterForEvent(Event e,) {
	
}

public void applyForEvent() {
	for(Event event:events) {
		System.out.println(event.toString());
	}
	
}
}
