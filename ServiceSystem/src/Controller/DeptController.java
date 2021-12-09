package Controller;

import model.DatabaseOperation;

import model.Dept;

public class DeptController {
	private Dept dept;
	public DeptController() {
		
	}
	
	public void setDeptModel(Dept dept) {
		this.dept = dept;
	}
	
	public void setDatabaseOperation(DatabaseOperation databaseOperation) {
		dept.setDatabaseOperation(databaseOperation);
	}
}
