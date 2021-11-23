package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class SelectStudentGrade implements DatabaseOperation{
	/**
	 * 学生ID、考试开始时间、考试类型ID、学科ID、学期ID、考试成绩、Z-Score、T-Score、等第
	 * */
	public static DatabaseModel database = new DatabaseModel();
	
	public void selectStudentGrade1(ArrayList<String> data) {
		/**
		 * 查询单条成绩记录 某一学科
		 * */
		
		database.connect();
		
		try {
			String sql = "SELECT * FROM 学生成绩表  WHERE 学生ID = ?, 考试类型ID = ?，学科ID = ?, 学期ID = ?";
			database.exec(sql,data);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectStudentGrade2(ArrayList<String> data) {
		/**
		 * 查询单次成绩记录 某一次考试全部学科
		 * */
		
		database.connect();
		
		try {
			String sql = "SELECT * FROM 学生成绩表  WHERE 学生ID = ?, 考试类型ID = ?，学期ID = ?";
			database.exec(sql,data);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectStudentGrade3(ArrayList<String> data) {
		/**
		 * 查询某个学生全部成绩记录
		 * */
		database.connect();
		
		try {
			String sql = "SELECT * FROM 学生成绩表  WHERE 学生ID = ?";
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
			selectStudentGrade1(data); // 查询单条成绩记录 某一学科
			break;
		case 2:
			selectStudentGrade2(data); // 查询单次成绩记录 某一次考试全部学科
			break;
		case 3:
			selectStudentGrade3(data); //查询某个学生全部成绩记录
			break;
		default:
			System.out.println("ERROR!");
		}
	}

}
