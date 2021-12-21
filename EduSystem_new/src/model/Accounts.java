package model;

public class Accounts {
	private int id;
	private String password;
	private int idnumber;
	
//	private String username;
//	private String mailbox;
//	private int phonenumber;

	public Accounts(int id, String password, int idnumber) {
		super();
		this.id = id;
		this.password = password;
		this.idnumber = idnumber;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getIdnumber() {
		return idnumber;
	}


	public void setIdnumber(int idnumber) {
		this.idnumber = idnumber;
	}
}
