package controller;
import View.DeptView;


import model.DatabaseOperation;
import model.Dept;

public class DeptController {
	private Dept dept;
	private DeptView deptview;
	
	public DeptController() {
		
	}
	
	public void setDeptModel(Dept dept) {
		this.dept = dept;
	}
	
	public void setDeptView(DeptView deptview) {
		this.deptview = deptview;
	}
	
	public void setDatabaseOperation(DatabaseOperation databaseOperation) {
		dept.setDatabaseOperation(databaseOperation);
	}
	
	public void getInfoView() {
		//¥Ú”°
		deptview.printInfo(dept.performDatabaseOperation());
	}
	
	
	

}
