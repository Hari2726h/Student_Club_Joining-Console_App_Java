package Entity;

public class Event {
private int id;
private String eventName;
private Club club;
public Event(int id, String eventName, Club club) {
	super();
	this.id = id;
	this.eventName = eventName;
	this.club = club;
}
public String toString() {
	return id+" "+eventName+" "+club.toString();
}

}
