package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class SelectStudentInfo implements DatabaseOperation{
	/**
	 * 学生ID、姓名、性别、民族、入学年份、出生日期、家庭住址、家庭类型、政治面貌、入学排名、宿舍号、是否退学
	 * */
	public static DatabaseModel database = new DatabaseModel();
	
	public void selectStudentInfo(ArrayList<String> data) {
		database.connect();
		
		try {
			String sql = "SELECT * FROM 学生表 WHERE 学生ID = ?";
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
			selectStudentInfo(data);
			break;
		default:
			System.out.println("ERROR!");
		}
	}
}

