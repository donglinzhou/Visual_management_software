package model;

public abstract class Person {
	protected String name=" ";
	protected int id=49;
	private String password=" ";
	protected int identity=0;
	
	protected boolean register(int id, String password) {
		/*登录功能*/
		boolean status=true;
		return status;
	}
	
	protected boolean changePassword(int id, String password) {
		/*登录密码修改*/
		boolean status=true;
		return status;
	}
	
	public int getId() {
		/*返回登陆者的ID*/
		return this.id;
	}
	
	protected void setIdentity() {
		/*设置状态：1表示已经登录，0表示未登录*/
		this.identity = 0;
	}
	
}
