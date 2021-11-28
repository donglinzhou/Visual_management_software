package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SelectStudentInfo implements DatabaseOperation{
	/**
	 * 学生ID、姓名、性别、民族、入学年份、出生日期、家庭住址、家庭类型、政治面貌、入学排名、宿舍号、是否退学
	 * */
	public static DatabaseModel database = new DatabaseModel();
	
	public ArrayList<ArrayList<String>> selectStudentInfo(ArrayList<String> data) {
		
		ArrayList<ArrayList<String>> selectStudentInfoList = new ArrayList<ArrayList<String>>();
		database.connect();
		
		try {
			String sql = "SELECT * FROM 学生表 WHERE 学生ID = ?";
			ResultSet rs=database.execResult(sql,data);
	
			
			
			Integer stuInt = null;//学生ID
			String name = null;//姓名
			String gender = null;//性别
			String people = null;//民族
			Integer enrollmentYear = null;//入学年份
			String birthday = null;//出生日期
			String home = null;//家庭住址
			String homeType = null;//家庭类型
			String politics = null;//政治面貌
			Integer entranceRanking = null;//入学排名
			Integer dormitoryNo = null;//宿舍号
			Integer dropOut = null;//是否退学
			
			
			
			
			while(rs.next()) {
				
				//写入Arraylist数组中
	        	ArrayList<String> onerow = new ArrayList<String>();	// 创建一维数组输入
				
	        	stuInt = rs.getInt("学生ID");//获取学生ID
	        	name = rs.getString("姓名");//获取姓名
	        	gender = rs.getString("性别");//获取性别
	        	people = rs.getString("民族");//获取民族
	        	enrollmentYear = rs.getInt("入学年份");//获取入学年份
	        	birthday = rs.getString("出生日期");//获取出生日期
	        	home = rs.getString("家庭住址");//获取家庭住址
	        	homeType = rs.getString("家庭类型");//获取家庭类型
	        	politics = rs.getString("政治面貌");//获取政治面貌
	        	entranceRanking = rs.getInt("入学排名");//入学排名
	        	dormitoryNo = rs.getInt("宿舍号");//宿舍号
	        	dropOut = rs.getInt("是否退学");//是否退学
				
				
        		
				//将数据类型进行转换
				String stu = Integer.toString(stuInt);
				String enrollmentYearstr = Integer.toString(enrollmentYear);
				String entranceRankingstr = Integer.toString(entranceRanking);
				String dormitoryNostr = Integer.toString(dormitoryNo);
				String dropOutstr = Integer.toString(dropOut);
				
				//写入数组
				onerow.add(stu);
        		onerow.add(name);
        		onerow.add(gender);
        		onerow.add(people);
        		onerow.add(enrollmentYearstr);
        		onerow.add(birthday);
        		onerow.add(home);
        		onerow.add(homeType);
        		onerow.add(politics);
        		onerow.add(entranceRankingstr);
        		onerow.add(dormitoryNostr);
        		onerow.add(dropOutstr);
				
        		selectStudentInfoList.add(onerow);
        		
        		
        	}
        	rs.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return selectStudentInfoList;
	}

	@Override
	public ArrayList<ArrayList<String>> databaseOperation(ArrayList<String> data, int choose) {
		// TODO Auto-generated method stub
		
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		
		
		switch(choose) {
		case 1:
			result = selectStudentInfo(data);
			break;
		default:
			System.out.println("ERROR!");
		}
		return result;
	}
}

