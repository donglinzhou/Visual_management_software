package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class SelectStudentSubject implements DatabaseOperation{
	/**
	 * 学生ID、主修学科ID、次修学科ID1、次修学科ID2
	 * */
	public static DatabaseModel database = new DatabaseModel();

	public void selectStudentSubject(ArrayList<String> data) {
		database.connect();
		
		try {
			String sql = "SELECT * FROM 学生六选三表  WHERE 学生ID = ?";
			database.exec(sql,data);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void databaseOperation(ArrayList<String> data, int choose) {
		// TODO Auto-generated method stub
		switch(choose) {
		case 1:
			selectStudentSubject(data);
			break;
		default:
			System.out.println("ERROR!");
		}
	}

}
