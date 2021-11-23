package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class SelectStudentClass implements DatabaseOperation{
	/**
	 * 学生ID、学期ID、班级ID、班主任ID
	 * */
	public static DatabaseModel database = new DatabaseModel();
	
	public void selectStudentClass1(ArrayList<String> data) {
		/**
		 * 查询某个学生的所有班级信息
		 * */
		database.connect();
		
		try {
			String sql = "SELECT * FROM 学生班级表  WHERE 学生ID = ?";
			database.exec(sql,data);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectStudentClass2(ArrayList<String> data) {
		/**
		 * 查询某个学生在某个学期的班级信息
		 * */
		database.connect();
		
		try {
			String sql = "SELECT * FROM 学生班级表  WHERE 学生ID = ?, 学期ID = ?";
			database.exec(sql,data);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectStudentClass3(ArrayList<String> data) {
		/**
		 * 查询某个班主任管理过的所有班级信息
		 * */
		database.connect();
		
		try {
			String sql = "SELECT * FROM 学生班级表  WHERE 班主任ID = ?";
			database.exec(sql,data);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectStudentClass4(ArrayList<String> data) {
		/**
		 * 查询某个班主任在某个学期所管理的班级信息
		 * */
		database.connect();
		
		try {
			String sql = "SELECT * FROM 学生班级表  WHERE 班主任ID = ?, 学期ID = ?";
			database.exec(sql,data);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectStudentClass5(ArrayList<String> data) {
		/**
		 * 查询某个班级信息
		 * */
		database.connect();
		
		try {
			String sql = "SELECT * FROM 学生班级表  WHERE 班级ID = ?";
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
			selectStudentClass1(data); // 查询某个学生的所有班级信息(历年来)
			break;
		case 2:
			selectStudentClass2(data); // 查询某个学生在某个学期的班级信息
			break;
		case 3:
			selectStudentClass3(data); // 查询某个班主任管理过的所有班级信息(历年来)
			break;
		case 4:
			selectStudentClass4(data); // 查询某个班主任在某个学期所管理的班级信息
			break;
		case 5:
			selectStudentClass5(data); // 查询某个班级信息
			break;
		default:
			System.out.println("ERROR!");
		}
	}
}
