package Entity;

import java.util.List;

public class Club {
	private int clubid;
	private String name;
	private int size;
	
	public int getClubid() {
		return clubid;
	}

	public void setClubid(int clubid) {
		this.clubid = clubid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

 public Club(int clubid, String name,int size) {
		this.clubid = clubid;
		this.name = name;
		this.size = size;
	}
 public String toString() {
	 return clubid+" "+name+" "+size;
 }
}
