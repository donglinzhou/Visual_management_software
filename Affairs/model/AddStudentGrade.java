package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class AddStudentGrade implements DatabaseOperation{
	/**
	 * 学生ID、考试开始时间、考试类型ID、学科ID、学期ID、考试成绩、Z-Score、T-Score、等第
	 * */
	public static DatabaseModel database = new DatabaseModel();
	
	public void addStudentGrade(ArrayList<String> data) {
		// TODO Auto-generated method stub
		database.connect();
		
		try {
			database.insert("学生成绩表",data);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<ArrayList<String>> databaseOperation(ArrayList<String> data, int choose) {
		// TODO Auto-generated method stub
		switch(choose){
		case 1:
			addStudentGrade(data);
			break;
		default:
			System.out.println("ERROR!");
		}
		return null;
	}
}
