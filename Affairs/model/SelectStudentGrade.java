package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SelectStudentGrade implements DatabaseOperation{
	/**
	 * 学生ID、考试开始时间、考试类型ID、学科ID、学期ID、考试成绩、Z-Score、T-Score、等第
	 * */
	public static DatabaseModel database = new DatabaseModel();
	
	public ArrayList<ArrayList<String>> selectSingleSubjectGrade(ArrayList<String> data) {
		/**
		 * 查询单条成绩记录 某一学科
		 * */
		
		ArrayList<ArrayList<String>> selectSingleSubjectGradeList = new ArrayList<ArrayList<String>>();
		
		database.connect();
		
		try {
			
			String sql = "SELECT * FROM 学生成绩表  WHERE 学生ID = ?, 考试类型ID = ?，学科ID = ?, 学期ID = ?";
			ResultSet rs=database.execResult(sql,data);
	
			
			
			Integer stuint = null;
			Integer examtypeint = null;
			Integer subjectint = null;
			Integer semesterint = null;
			Integer gradeint = null;
			String ZScore = null;
			String TScore = null;
			String ranking = null;
			String timestart = null;
			
			
			
			
			
			while(rs.next()) {
				
				//写入Arraylist数组中
	        	ArrayList<String> onerow = new ArrayList<String>();	// 创建一维数组输入
				
				stuint = rs.getInt("学生ID");//获取学生ID
				examtypeint = rs.getInt("考试类型ID");//获取考试类型ID
				subjectint = rs.getInt("学科ID");//获取学科ID
				semesterint = rs.getInt("学期ID");//获取学期ID
				gradeint = rs.getInt("考试成绩");//获取考试成绩
				ZScore = rs.getString("Z-Score");//获取Z-Score
				TScore = rs.getString("T-Score");//获取T-Score
				ranking = rs.getString("等第");//获取等第
				timestart = rs.getString("考试开始时间");//获取考试开始时间
				
				
        		
				//将数据类型进行转换
				String stu = Integer.toString(stuint);
				String examtype = Integer.toString(examtypeint);
				String subject = Integer.toString(subjectint);
				String semester = Integer.toString(semesterint);
				String grade = Integer.toString(gradeint);
				
				//写入数组
				onerow.add(stu);
        		onerow.add(examtype);
        		onerow.add(subject);
        		onerow.add(semester);
        		onerow.add(grade);
        		onerow.add(ZScore);
        		onerow.add(TScore);
        		onerow.add(ranking);
        		onerow.add(timestart);
				
        		selectSingleSubjectGradeList.add(onerow);
        		
        		
        	}
        	rs.close();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return selectSingleSubjectGradeList;
	}
	
	public ArrayList<ArrayList<String>> selectSingleExamGrade(ArrayList<String> data) {
		/**
		 * 查询单次成绩记录 某一次考试全部学科
		 * */
		
		ArrayList<ArrayList<String>> selectSingleExamGradeList = new ArrayList<ArrayList<String>>();
		database.connect();
		
		try {
			
			String sql = "SELECT * FROM 学生成绩表  WHERE 学生ID = ?, 考试类型ID = ?，学期ID = ?";
			ResultSet rs=database.execResult(sql,data);
	
			
			
			Integer stuint = null;
			Integer examtypeint = null;
			Integer subjectint = null;
			Integer semesterint = null;
			Integer gradeint = null;
			String ZScore = null;
			String TScore = null;
			String ranking = null;
			String timestart = null;
			
			
			
			
			
			while(rs.next()) {
				
				//写入Arraylist数组中
	        	ArrayList<String> onerow = new ArrayList<String>();	// 创建一维数组输入
				
				stuint = rs.getInt("学生ID");//获取学生ID
				examtypeint = rs.getInt("考试类型ID");//获取考试类型ID
				subjectint = rs.getInt("学科ID");//获取学科ID
				semesterint = rs.getInt("学期ID");//获取学期ID
				gradeint = rs.getInt("考试成绩");//获取考试成绩
				ZScore = rs.getString("Z-Score");//获取Z-Score
				TScore = rs.getString("T-Score");//获取T-Score
				ranking = rs.getString("等第");//获取等第
				timestart = rs.getString("考试开始时间");//获取考试开始时间
				
				
        		
				//将数据类型进行转换
				String stu = Integer.toString(stuint);
				String examtype = Integer.toString(examtypeint);
				String subject = Integer.toString(subjectint);
				String semester = Integer.toString(semesterint);
				String grade = Integer.toString(gradeint);
				
				//写入数组
				onerow.add(stu);
        		onerow.add(examtype);
        		onerow.add(subject);
        		onerow.add(semester);
        		onerow.add(grade);
        		onerow.add(ZScore);
        		onerow.add(TScore);
        		onerow.add(ranking);
        		onerow.add(timestart);
				
        		selectSingleExamGradeList.add(onerow);
        		
        		
        	}
        	rs.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return selectSingleExamGradeList;
	}
	
	public ArrayList<ArrayList<String>> selectSingleStudentGrade(ArrayList<String> data) {
		/**
		 * 查询某个学生全部成绩记录
		 * */
		
		ArrayList<ArrayList<String>> selectSingleStudentGradeList = new ArrayList<ArrayList<String>>();
		database.connect();
		
		try {
			String sql = "SELECT * FROM 学生成绩表  WHERE 学生ID = ?";			
			ResultSet rs=database.execResult(sql,data);
	
			
			
			Integer stuint = null;
			Integer examtypeint = null;
			Integer subjectint = null;
			Integer semesterint = null;
			Integer gradeint = null;
			String ZScore = null;
			String TScore = null;
			String ranking = null;
			String timestart = null;
			
			
			
			
			
			while(rs.next()) {
				
				//写入Arraylist数组中
	        	ArrayList<String> onerow = new ArrayList<String>();	// 创建一维数组输入
				
				stuint = rs.getInt("学生ID");//获取学生ID
				examtypeint = rs.getInt("考试类型ID");//获取考试类型ID
				subjectint = rs.getInt("学科ID");//获取学科ID
				semesterint = rs.getInt("学期ID");//获取学期ID
				gradeint = rs.getInt("考试成绩");//获取考试成绩
				ZScore = rs.getString("Z-Score");//获取Z-Score
				TScore = rs.getString("T-Score");//获取T-Score
				ranking = rs.getString("等第");//获取等第
				timestart = rs.getString("考试开始时间");//获取考试开始时间
				
				
        		
				//将数据类型进行转换
				String stu = Integer.toString(stuint);
				String examtype = Integer.toString(examtypeint);
				String subject = Integer.toString(subjectint);
				String semester = Integer.toString(semesterint);
				String grade = Integer.toString(gradeint);
				
				//写入数组
				onerow.add(stu);
        		onerow.add(examtype);
        		onerow.add(subject);
        		onerow.add(semester);
        		onerow.add(grade);
        		onerow.add(ZScore);
        		onerow.add(TScore);
        		onerow.add(ranking);
        		onerow.add(timestart);
				
        		selectSingleStudentGradeList.add(onerow);
        		
        		
        	}
        	rs.close();
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return selectSingleStudentGradeList;
	}

	@Override
	public ArrayList<ArrayList<String>> databaseOperation(ArrayList<String> data, int choose) {
		// TODO Auto-generated method stub
		
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		
		switch(choose) {
		case 1:
			result = selectSingleSubjectGrade(data); // 查询单条成绩记录 某一学科
			break;
		case 2:
			result = selectSingleExamGrade(data); // 查询单次成绩记录 某一次考试全部学科
			break;
		case 3:
			result = selectSingleStudentGrade(data); //查询某个学生全部成绩记录
			break;
		default:
			System.out.println("ERROR!");
		}
		return result;
	}

}
