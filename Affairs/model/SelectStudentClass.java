package model;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;

public class SelectStudentClass implements DatabaseOperation{
	/**
	 * 学生ID、学期ID、班级ID、班主任ID
	 * */
	public static DatabaseModel database = new DatabaseModel();
	
	public ArrayList<ArrayList<String>> selectSingleStudentClassInfo(ArrayList<String> data) {
		/**
		 * 查询某个学生的所有班级信息
		 * */
		ArrayList<ArrayList<String>> selectSingleStudentClassInfoList = new ArrayList<ArrayList<String>>();
		database.connect();
		
		try {
			String sql = "SELECT * FROM 学生班级表  WHERE 学生ID = ?";
			ResultSet rs=database.execResult(sql,data);
			
			Integer stuIdint = null;
			Integer semesterIdint = null;
			Integer classIdint = null;
			Integer teacherIdint = null;
        	
        	while(rs.next()) {
        		
        		
        		//写入Arraylist数组中
	        	ArrayList<String> onerow = new ArrayList<String>();	// 创建一维数组输入
        		
        		stuIdint = rs.getInt("学生ID");
        		semesterIdint = rs.getInt("学期ID");
        		classIdint = rs.getInt("班级ID");
        		teacherIdint = rs.getInt("班主任ID");
 
        		//将数据类型进行转换
        		String stuId = Integer.toString(stuIdint);
        		String semesterId = Integer.toString(semesterIdint);
        		String classId = Integer.toString(semesterIdint);
        		String teacherId = Integer.toString(teacherIdint);
        		
        		//写入数组
        		onerow.add(stuId);
        		onerow.add(semesterId);
        		onerow.add(classId);
        		onerow.add(teacherId);
				
        		selectSingleStudentClassInfoList.add(onerow);
        		
        	}
        	rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return selectSingleStudentClassInfoList;
	}
	
	public ArrayList<ArrayList<String>> selectSingleStudentSingleSemesterClassInfo(ArrayList<String> data) {
		/**
		 * 查询某个学生在某个学期的班级信息
		 * */
		
		
		
		ArrayList<ArrayList<String>> selectSingleStudentSingleSemesterClassInfoList = new ArrayList<ArrayList<String>>();
		database.connect();
		
		try {
			String sql = "SELECT * FROM 学生班级表  WHERE 学生ID = ?, 学期ID = ?";
			ResultSet rs=database.execResult(sql,data);
			
			Integer stuIdint = null;
			Integer semesterIdint = null;
			Integer classIdint = null;
			Integer teacherIdint = null;
        	
        	while(rs.next()) {
        		
        		
        		//写入Arraylist数组中
	        	ArrayList<String> onerow = new ArrayList<String>();	// 创建一维数组输入
        		
        		stuIdint = rs.getInt("学生ID");
        		semesterIdint = rs.getInt("学期ID");
        		classIdint = rs.getInt("班级ID");
        		teacherIdint = rs.getInt("班主任ID");
 
        		//将数据类型进行转换
        		String stuId = Integer.toString(stuIdint);
        		String semesterId = Integer.toString(semesterIdint);
        		String classId = Integer.toString(classIdint);
        		String teacherId = Integer.toString(teacherIdint);
        		
        		//写入数组
        		onerow.add(stuId);
        		onerow.add(semesterId);
        		onerow.add(classId);
        		onerow.add(teacherId);
				
        		selectSingleStudentSingleSemesterClassInfoList.add(onerow);
        		
        	}
        	rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return selectSingleStudentSingleSemesterClassInfoList;
	}
	
	public ArrayList<ArrayList<String>> selectSingleTeacherClassInfo(ArrayList<String> data) {
		/**
		 * 查询某个班主任管理过的所有班级信息
		 * */
		
		ArrayList<ArrayList<String>>  selectSingleTeacherClassInfoList = new ArrayList<ArrayList<String>>();
		database.connect();
		
		try {
			String sql = "SELECT * FROM 学生班级表  WHERE 班主任ID = ?";
			ResultSet rs=database.execResult(sql,data);
			
			Integer stuIdint = null;
			Integer semesterIdint = null;
			Integer classIdint = null;
			Integer teacherIdint = null;
        	
        	while(rs.next()) {
        		
        		
        		//写入Arraylist数组中
	        	ArrayList<String> onerow = new ArrayList<String>();	// 创建一维数组输入
        		
        		stuIdint = rs.getInt("学生ID");
        		semesterIdint = rs.getInt("学期ID");
        		classIdint = rs.getInt("班级ID");
        		teacherIdint = rs.getInt("班主任ID");
 
        		//将数据类型进行转换
        		String stuId = Integer.toString(stuIdint);
        		String semesterId = Integer.toString(semesterIdint);
        		String classId = Integer.toString(classIdint);
        		String teacherId = Integer.toString(teacherIdint);
        		
        		//写入数组
        		onerow.add(stuId);
        		onerow.add(semesterId);
        		onerow.add(classId);
        		onerow.add(teacherId);
				
        		 selectSingleTeacherClassInfoList.add(onerow);
        		
        	}
        	rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return  selectSingleTeacherClassInfoList;
	}
	
	public ArrayList<ArrayList<String>>  selectSingleTeacherSingleSemesterClassInfo(ArrayList<String> data) {
		/**
		 * 查询某个班主任在某个学期所管理的班级信息
		 * */
		ArrayList<ArrayList<String>> selectSingleTeacherSingleSemesterClassInfoList = new ArrayList<ArrayList<String>>();
		database.connect();
		
		try {
			String sql = "SELECT * FROM 学生班级表  WHERE 班主任ID = ?, 学期ID = ?";
			ResultSet rs=database.execResult(sql,data);
			
			Integer stuIdint = null;
			Integer semesterIdint = null;
			Integer classIdint = null;
			Integer teacherIdint = null;
        	
        	while(rs.next()) {
        		
        		
        		//写入Arraylist数组中
	        	ArrayList<String> onerow = new ArrayList<String>();	// 创建一维数组输入
        		
        		stuIdint = rs.getInt("学生ID");
        		semesterIdint = rs.getInt("学期ID");
        		classIdint = rs.getInt("班级ID");
        		teacherIdint = rs.getInt("班主任ID");
 
        		//将数据类型进行转换
        		String stuId = Integer.toString(stuIdint);
        		String semesterId = Integer.toString(semesterIdint);
        		String classId = Integer.toString(classIdint);
        		String teacherId = Integer.toString(teacherIdint);
        		
        		//写入数组
        		onerow.add(stuId);
        		onerow.add(semesterId);
        		onerow.add(classId);
        		onerow.add(teacherId);
				
        		selectSingleTeacherSingleSemesterClassInfoList.add(onerow);
        		
        	}
        	rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return selectSingleTeacherSingleSemesterClassInfoList;
	}
	
	public ArrayList<ArrayList<String>> selectSingleClassInfo(ArrayList<String> data) {
		/**
		 * 查询某个班级信息
		 * */
		ArrayList<ArrayList<String>> selectSingleClassInfoList = new ArrayList<ArrayList<String>>();
		database.connect();
		
		try {
			String sql = "SELECT * FROM 学生班级表  WHERE 班级ID = ?";
			ResultSet rs=database.execResult(sql,data);
			
			Integer stuIdint = null;
			Integer semesterIdint = null;
			Integer classIdint = null;
			Integer teacherIdint = null;
        	
        	while(rs.next()) {
        		
        		
        		//写入Arraylist数组中
	        	ArrayList<String> onerow = new ArrayList<String>();	// 创建一维数组输入
        		
        		stuIdint = rs.getInt("学生ID");
        		semesterIdint = rs.getInt("学期ID");
        		classIdint = rs.getInt("班级ID");
        		teacherIdint = rs.getInt("班主任ID");
 
        		//将数据类型进行转换
        		String stuId = Integer.toString(stuIdint);
        		String semesterId = Integer.toString(semesterIdint);
        		String classId = Integer.toString(classIdint);
        		String teacherId = Integer.toString(teacherIdint);
        		
        		//写入数组
        		onerow.add(stuId);
        		onerow.add(semesterId);
        		onerow.add(classId);
        		onerow.add(teacherId);
				
        		selectSingleClassInfoList.add(onerow);
        		
        	}
        	rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return selectSingleClassInfoList;
	}

	@Override
	public ArrayList<ArrayList<String>> databaseOperation(ArrayList<String> data, int choose) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		
		switch(choose) {
		case 1:
			result = selectSingleStudentClassInfo(data); // 查询某个学生的所有班级信息(历年来)
			
			break;
		case 2:
			result = selectSingleStudentSingleSemesterClassInfo(data); // 查询某个学生在某个学期的班级信息
			break;
		case 3:
			result = selectSingleTeacherClassInfo(data); // 查询某个班主任管理过的所有班级信息(历年来)
			break;
		case 4:
			result = selectSingleTeacherSingleSemesterClassInfo(data); // 查询某个班主任在某个学期所管理的班级信息
			break;
		case 5:
			result = selectSingleClassInfo(data); // 查询某个班级信息
			break;
		default:
			System.out.println("ERROR!");
		}
		return result;
	}
}
