package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class AddStudentInfoClass implements AddStudentInfoBehavior {
	/**
	 * ID、姓名、性别、民族、入学年份、出生日期、家庭住址、家庭类型、政治面貌、入学排名、宿舍号、是否退学
	 * */
	public static DatabaseModel database = new DatabaseModel();
	
	@Override
	public ArrayList<String> addStudentInfo(ArrayList<String> data) {
		// TODO 自动生成的方法存根
		// TODO Auto-generated method stub
		database.connect();
		ArrayList<String> result = new ArrayList<String>();
		try {
			database.insert("学生表",data);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result.add("成功录入以下数据");
		for (String dataset : data) {
			result.add(dataset);
		}
		
		return result;
	}

}
