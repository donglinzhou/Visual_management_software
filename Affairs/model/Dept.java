package model;

import java.util.ArrayList;

public class Dept extends Person{
	DatabaseOperation DatabaseOperation;
	
	public void setDatabaseOperation(DatabaseOperation DatabaseOperation) {
		this.DatabaseOperation = DatabaseOperation;
	}
	
	
	public ArrayList<ArrayList<String>> performDatabaseOperation(){
    	return DatabaseOperation.databaseOperation(null, (Integer) null);
    }
	
}
