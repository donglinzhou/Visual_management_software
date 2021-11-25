package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class DeleteTeacherInfo implements DatabaseOperation{
	/**
	 * 教师ID、姓名、性别、民族、政治面貌、学历、出生日期、联系电话、邮箱
	 * */
	public static DatabaseModel database = new DatabaseModel();
	
	public void deleteStudentSubject(ArrayList<String> data) {
		/**
		 * 根据教师ID 删除教师信息
		 * */
		
		database.connect();
		
		try {
			
			database.delete("教师表", "教师ID", data);

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
			deleteStudentSubject(data);
			break;
		default:
			System.out.println("ERROR!");
		}
	}
}
