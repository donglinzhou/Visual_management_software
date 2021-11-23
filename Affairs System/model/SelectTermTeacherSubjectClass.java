package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class SelectTermTeacherSubjectClass implements DatabaseOperation{
	/**
	 * 学期ID、教师ID、学科ID、班级ID
	 * */
	public static DatabaseModel database = new DatabaseModel();
	
	public void selectTermTeacherSubjectClass1(ArrayList<String> data) {
		/**
		 * 查询某个教师 所教的所有班级、学科、学期
		 * */
		database.connect();
		
		try {
			String sql = "SELECT * FROM 学期-教师-学科-班级表  WHERE 教师ID = ?";
			database.exec(sql,data);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void selectTermTeacherSubjectClass2(ArrayList<String> data) {
		/**
		 * 查询某个教师在某个学期 所教的班级、学科、学期
		 * */
		database.connect();
		
		try {
			String sql = "SELECT * FROM 学期-教师-学科-班级表  WHERE 教师ID = ?, 学期ID = ?";
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
			selectTermTeacherSubjectClass1(data); // 查询某个教师 所教的所有班级、学科、学期(历年来)
			break;
		case 2:
			selectTermTeacherSubjectClass2(data); //查询某个教师在某个学期 所教的班级、学科、学期
			break;
		default:
			System.out.println("ERROR!");
		}
	}

}
