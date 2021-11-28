package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class ModifyStudentSubject implements DatabaseOperation{
	/**
	 * 学生ID、主修学科ID、次修学科ID1、次修学科ID2
	 * */
	public static DatabaseModel database = new DatabaseModel();
	
	public void modifyStudentSubject(ArrayList<String> data) {
		database.connect();
		
		try {
			String sql = "UPDATE 学生六选三表 SET 主修学科ID=?, 次修学科ID1=?, 次修学科ID2=? WHERE 学生ID=?";
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
			modifyStudentSubject(data);
			break;
		default:
			System.out.println("ERROR!");
		}
		return null;
	}

}
