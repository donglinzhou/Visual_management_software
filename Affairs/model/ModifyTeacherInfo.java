package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class ModifyTeacherInfo implements DatabaseOperation{
	/**
	 * 教师ID、姓名、性别、民族、政治面貌、学历、出生日期、联系电话、邮箱
	 * */
	public static DatabaseModel database = new DatabaseModel();
	
	public void modifyTeacherInfo(ArrayList<String> data) {
		database.connect();
		
		try {
			String sql = "UPDATE 教师表 SET 姓名=?, 性别=?, 民族?, 政治面貌=?, 学历=?, 出生日期=?, 联系电话=?, 邮箱=?"
					+ "WHERE 教师ID=?";
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
			modifyTeacherInfo(data);
			break;
		default:
			System.out.println("ERROR!");
		}
		return null;
	}
}
