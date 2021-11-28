package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SelectTermTeacherSubjectClass implements DatabaseOperation{
	/**
	 * 学期ID、教师ID、学科ID、班级ID
	 * */
	public static DatabaseModel database = new DatabaseModel();
	
	public ArrayList<ArrayList<String>> selectTeacherTeachingInfo(ArrayList<String> data) {
		/**
		 * 查询某个教师 所教的所有班级、学科、学期
		 * */
		
		ArrayList<ArrayList<String>> selectTeacherTeachingInfoList = new ArrayList<ArrayList<String>>();
		database.connect();
		
		try {
			String sql = "SELECT * FROM 学期-教师-学科-班级表  WHERE 教师ID = ?";
			ResultSet rs=database.execResult(sql,data);
	
			
			
			Integer teacherInt = null;
			Integer semesterInt = null;
			Integer subjectInt = null;
			Integer classInt = null;
			
			
			
			
			while(rs.next()) {
				
				//写入Arraylist数组中
	        	ArrayList<String> onerow = new ArrayList<String>();	// 创建一维数组输入
				
	        	teacherInt = rs.getInt("教师ID");//获取教师ID
	        	semesterInt = rs.getInt("学期ID");//获取学期ID
	        	subjectInt = rs.getInt("学科ID");//获取学科ID
	        	classInt = rs.getInt("班级ID");//获取班级ID
				
				
				
        		
				//将数据类型进行转换
				String teacher = Integer.toString(teacherInt);
				String semester = Integer.toString(semesterInt);
				String subject = Integer.toString(subjectInt);
				String classstr = Integer.toString(classInt);
				
				//写入数组
				onerow.add(teacher);
        		onerow.add(semester);
        		onerow.add(subject);
        		onerow.add(classstr);
				
        		selectTeacherTeachingInfoList.add(onerow);
        		
        		
        	}
        	rs.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return selectTeacherTeachingInfoList;
	}

	public ArrayList<ArrayList<String>> selectTeacherSingleSemesterTeachingInfo(ArrayList<String> data) {
		/**
		 * 查询某个教师在某个学期 所教的班级、学科、学期
		 * */
		
		ArrayList<ArrayList<String>> selectTeacherSingleSemesterTeachingInfoList = new ArrayList<ArrayList<String>>();
		database.connect();
		
		try {
			String sql = "SELECT * FROM 学期-教师-学科-班级表  WHERE 教师ID = ?, 学期ID = ?";
			ResultSet rs=database.execResult(sql,data);
	
			
			
			Integer teacherInt = null;
			Integer semesterInt = null;
			Integer subjectInt = null;
			Integer classInt = null;
			
			
			
			
			while(rs.next()) {
				
				//写入Arraylist数组中
	        	ArrayList<String> onerow = new ArrayList<String>();	// 创建一维数组输入
				
	        	teacherInt = rs.getInt("教师ID");//获取教师ID
	        	semesterInt = rs.getInt("学期ID");//获取学期ID
	        	subjectInt = rs.getInt("学科ID");//获取学科ID
	        	classInt = rs.getInt("班级ID");//获取班级ID
				
				
				
        		
				//将数据类型进行转换
				String teacher = Integer.toString(teacherInt);
				String semester = Integer.toString(semesterInt);
				String subject = Integer.toString(subjectInt);
				String classstr = Integer.toString(classInt);
				
				//写入数组
				onerow.add(teacher);
        		onerow.add(semester);
        		onerow.add(subject);
        		onerow.add(classstr);
				
        		selectTeacherSingleSemesterTeachingInfoList.add(onerow);
        		
        		
        	}
        	rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return selectTeacherSingleSemesterTeachingInfoList;
	}

	@Override
	public ArrayList<ArrayList<String>> databaseOperation(ArrayList<String> data, int choose) {
		// TODO Auto-generated method stub
		
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		
		
		switch(choose) {
		case 1:
			result = selectTeacherTeachingInfo(data); // 查询某个教师 所教的所有班级、学科、学期(历年来)
			break;
		case 2:
			result = selectTeacherSingleSemesterTeachingInfo(data); //查询某个教师在某个学期 所教的班级、学科、学期
			break;
		default:
			System.out.println("ERROR!");
		}
		return result;
	}

}
