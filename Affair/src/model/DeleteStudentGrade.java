package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class DeleteStudentGrade implements DatabaseOperation{
	/**
	 * 学生ID、考试开始时间、考试类型ID、学科ID、学期ID、考试成绩、Z-Score、T-Score、等第
	 * */
	public static DatabaseModel database = new DatabaseModel();
	
	public void deleteStudentGrade1(ArrayList<String> data) {
		/**
		 * 删除单条成绩记录 某一学科
		 * */
		
		database.connect();
		
		try {

			String sql = "DELETE FROM 学生成绩表 WHERE 学生ID = ?, 考试类型ID = ?，学科ID = ?, 学期ID = ?";
			database.exec(sql, data);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteStudentGrade2(ArrayList<String> data) {
		/**
		 * 删除单次成绩记录 某一次考试全部学科
		 * */
		
		database.connect();
		
		try {

			String sql = "DELETE FROM 学生成绩表 WHERE 学生ID = ?, 考试类型ID = ?，学期ID = ?";
			database.exec(sql, data);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteStudentGrade3(ArrayList<String> data) {
		/**
		 * 删除某个学生全部成绩记录
		 * */
		
		database.connect();
		
		try {
			
			database.delete("学生成绩表", "学生ID", data);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<ArrayList<String>> databaseOperation(ArrayList<String> data, int choose) {
		// TODO Auto-generated method stub
		switch(choose) {
		case 1:
			deleteStudentGrade1(data); // 删除单条成绩记录 某一学科
			break;
		case 2:
			deleteStudentGrade2(data); // 删除单次成绩记录 某一次考试全部学科
			break;
		case 3:
			deleteStudentGrade3(data); // 删除某个学生全部成绩记录
			break;
		default:
			System.out.println("ERROR!");
		}
		return null;
	}

}
