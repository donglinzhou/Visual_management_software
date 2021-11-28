package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class DeleteStudentSubject implements DatabaseOperation{
	/**
	 * 学生ID、主修学科ID、次修学科ID1、次修学科ID2
	 * */
	public static DatabaseModel database = new DatabaseModel();
	
	public void deleteStudentSubject1(ArrayList<String> data) {
		/**
		 * 根据学号ID 删除学生 选科 信息
		 * */
		
		database.connect();
		
		try {
			
			database.delete("学生六选三表", "学生ID", data);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteStudentSubject2(ArrayList<String> data) {
		/**
		 * 根据特定选科信息 删除所有学生 做出此种选科的信息
		 * */
		
		database.connect();
		
		try {
			String sql = "DELETE FROM 学生六选三表 WHERE 主修学科ID = ?, 次修学科ID1 = ?, 次修学科ID2 = ?";
			database.exec(sql, data);

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
			deleteStudentSubject1(data); // 根据学号ID 删除学生 选科 信息
			break;
		case 2:
			deleteStudentSubject2(data); // 根据特定选科信息 删除所有学生 做出此种选科的信息
			break;
		default:
			System.out.println("ERROR!");
		}
		return null;
	}
}
