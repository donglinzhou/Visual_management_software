package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class AddTeacherInfoClass implements AddTeacherInfoBehavior {
	/**
	 * 教师ID、姓名、性别、民族、政治面貌、学历、出生日期、联系电话、邮箱
	 * */
	public static DatabaseModel database = new DatabaseModel();
	@Override
	public ArrayList<String> addTeacherInfo(ArrayList<String> data) {
		// TODO 自动生成的方法存根
		// TODO Auto-generated method stub
		
		database.connect();
		ArrayList<String> result = new ArrayList<String>();		
				try {
					database.insert("教师表",data);
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
