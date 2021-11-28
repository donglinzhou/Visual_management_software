package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class ModifyStudentInfo implements DatabaseOperation{
	/**
	 * 学生ID、姓名、性别、民族、入学年份、出生日期、家庭住址、家庭类型、政治面貌、入学排名、宿舍号、是否退学
	 * */
	public static DatabaseModel database = new DatabaseModel();
	
	public void modifyStudentInfo(ArrayList<String> data) {
		database.connect();
		
		try {
			
			String sql = "UPDATE 学生表 SET 姓名=?, 性别=?, 民族=?, 入学年份=?,"
					+ "出生日期=?, 家庭住址=?, 家庭类型=?, 政治面貌=?, 入学排名=?, 宿舍号=?, 是否退学=?"
					+ "WHERE 学生ID = ?";
			database.update(sql, data);

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
			modifyStudentInfo(data);
			break;
		default:
			System.out.println("ERROR!");
		}
		return null;
	}
}
