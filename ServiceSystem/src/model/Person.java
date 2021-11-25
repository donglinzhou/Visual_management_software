package model;
/*  鐧诲綍鎿嶄綔绫�     */
public abstract class Person {
	protected String name=" ";
	protected int id=0;
	private String password=" ";
	protected int identity=0;
	
	protected boolean register(int id, String password) {
		/*鐧诲綍鍔熻兘*/
		boolean status=true;
		return status;
	}
	
	protected boolean changePassword(int id, String password) {
		/*鐧诲綍瀵嗙爜淇敼*/
		boolean status=true;
		return status;
	}
	
	public int getId() {
		/*杩斿洖鐧婚檰鑰呯殑ID*/
		return this.id;
	}
	
	protected void setIdentity() {
		/*璁剧疆鐘舵�侊細1琛ㄧず宸茬粡鐧诲綍锛�0琛ㄧず鏈櫥褰�*/
		this.identity = 0;
	}
	
}
