package Controller;

import View.DeptView;
import model.DatabaseOperation;
import model.Dept;

public class DeptController {
	private Dept dept;
	private DeptView deptView;
	
	public DeptController() {
		
	}
	
	public void setDeptModel(Dept dept) {
		this.dept = dept;
	}
	
	public void setDeptView(DeptView deptView) {
		this.deptView = deptView;
	}
	
	public void setDatabaseOperation(DatabaseOperation databaseOperation) {
		dept.setDatabaseOperation(databaseOperation);
	}
}
