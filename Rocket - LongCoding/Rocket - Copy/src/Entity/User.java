package Entity;

import Service.App;

abstract class User {
	protected int id;
	protected String name;
	protected String pass;
 public User(int id, String name, String pass) {
		this.id = id;
		this.name = name;
		this.pass = pass;
	}
 abstract void dashboard(App app);
}
