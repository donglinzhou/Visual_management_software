package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class SelectTeacherInfo implements DatabaseOperation{
	/**
	 * 教师ID、姓名、性别、民族、政治面貌、学历、出生日期、联系电话、邮箱
	 * */
	public static DatabaseModel database = new DatabaseModel();
	
	public void selectTeacherInfo(ArrayList<String> data) {
		database.connect();
		
		try {
			String sql = "SELECT * FROM 教师表  WHERE 教师ID = ?";
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
			selectTeacherInfo(data);
			break;
		default:
			System.out.println("ERROR!");
		}
	}
}


