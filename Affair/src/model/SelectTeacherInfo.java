package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SelectTeacherInfo implements DatabaseOperation{
	/**
	 * 教师ID、姓名、性别、民族、政治面貌、学历、出生日期、联系电话、邮箱
	 * */
	public static DatabaseModel database = new DatabaseModel();
	
	public ArrayList<ArrayList<String>> selectTeacherInfo(ArrayList<String> data) {
		
		
		ArrayList<ArrayList<String>> selectTeacherInfoList = new ArrayList<ArrayList<String>>();
		database.connect();
		
		try {
			String sql = "SELECT * FROM 教师表  WHERE 教师ID = ?";
			ResultSet rs=database.execResult(sql,data);
	
			
			
			Integer teacherInt = null;//教师ID
			String name = null;//姓名
			String gender = null;//性别
			String people = null;//民族
			String degree = null;//学历
			String birthday = null;//出生日期
			String politics = null;//政治面貌
			Integer phone = null;//联系电话
			String email = null;//邮箱
			
			
			
			
			while(rs.next()) {
				
				//写入Arraylist数组中
	        	ArrayList<String> onerow = new ArrayList<String>();	// 创建一维数组输入
				
	        	teacherInt = rs.getInt("教师ID");//获取教师ID
	        	name = rs.getString("姓名");//获取姓名
	        	gender = rs.getString("性别");//获取性别
	        	people = rs.getString("民族");//获取民族
	        	degree = rs.getString("学历");//获取学历
	        	birthday = rs.getString("出生日期");//获取出生日期
	        	politics = rs.getString("政治面貌");//获取政治面貌
	        	phone = rs.getInt("联系电话");//联系电话
	        	email = rs.getString("邮箱");//邮箱
				
				
        		
				//将数据类型进行转换
				String teacher = Integer.toString(teacherInt);
				String phonestr = Integer.toString(phone);
				
				
				//写入数组
				onerow.add(teacher);
        		onerow.add(name);
        		onerow.add(gender);
        		onerow.add(people);
        		onerow.add(degree);
        		onerow.add(birthday);
        		onerow.add(politics);
        		onerow.add(phonestr);
        		onerow.add(email);

        		selectTeacherInfoList.add(onerow);
        		
        		
        	}
        	rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return selectTeacherInfoList;
	}
	
	@Override
	public ArrayList<ArrayList<String>> databaseOperation(ArrayList<String> data, int choose) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		switch(choose) {
		case 1:
			result = selectTeacherInfo(data);
			break;
		default:
			System.out.println("ERROR!");
		}
		return result;
	}
}


