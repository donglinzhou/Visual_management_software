package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class ModifyStudentGrade implements DatabaseOperation{
	/**
	 * 学生ID、考试开始时间、考试类型ID、学科ID、学期ID、考试成绩、Z-Score、T-Score、等第
	 * */
	public static DatabaseModel database = new DatabaseModel();
	
	public void modifyStudentGrade(ArrayList<String> data) {
		
		database.connect();
		
		try {
			String sql = "UPDATE 学生成绩表 SET 考试开始时间 = ?, 考试类型ID = ?, 学科ID = ?,"
					+ "学期ID = ?, 考试成绩 = ?, Z-Score = ?, T-Score = ?, 等第 = ?"
					+ "WHERE 学生ID = ?";
			database.update(sql, data);

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
			modifyStudentGrade(data);
			break;
		default:
			System.out.println("ERROR!");
		}
	}
}
