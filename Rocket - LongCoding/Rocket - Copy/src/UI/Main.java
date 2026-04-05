package UI;

import java.util.Scanner;

import Service.App;

public class Main {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	App app=new App();
	app.addClub();
	while(true) {
		System.out.println("1.Register/n2.Login");
		int ch=sc.nextInt();
		if(ch==1) {
			app.register();
		}else if(ch==2) {
			app.login();
		}
		
		else {
			return;
		}
	}
}
}