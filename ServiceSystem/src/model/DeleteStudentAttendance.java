package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class DeleteStudentAttendance implements DatabaseOperation{
	/**
	 * 考勤ID、考勤类型ID、学生ID、时间
	 * */
	public static DatabaseModel database = new DatabaseModel();
	
	public void deleteStudentAttendance1(ArrayList<String> data) {
	/**
	 * 删除单条考勤记录
	 * */
		
		database.connect();
		
		try {

			database.delete("学生考勤表", "考勤ID", data);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteStudentAttendance2(ArrayList<String> data) {
		/**
		 * 删除某个学生的所有考勤记录
		 * */
		
		database.connect();
		
		try {

			database.delete("学生考勤表", "学生ID", data);

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
			deleteStudentAttendance1(data); // 删除单条考勤记录
			break;
		case 2:
			deleteStudentAttendance2(data); // 删除某个学生的所有考勤记录
			break;
		default:
			System.out.println("ERROR!");
		}
	}
}
