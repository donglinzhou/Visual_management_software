package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import com.sun.java_cup.internal.runtime.Scanner;

public class CheckStudentInfoClass implements CheckStudentInfoBehavior {//查看学生画像

	
//	//static int ID=13012;//传入的学生ID
//	static String ID="13012";
//	static 
//	
//	 public void setStudentInfo(String ID) {
//			this.ID=ID;
//		}
//	 
	@Override
	public ArrayList<String> checkStudentInfo(String ID) {//返回学生信息的元组
		ArrayList<String> studentInfo = new ArrayList<String>();//类的全局变量，用来存储返回学生信息的元组
		//需要查看：姓名，年龄，性别，入学年份、政治面貌、班主任姓名
		//System.out.println("查看学生个人信息");
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		 try {// 检查是否能连接数据库
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            System.out.println("加载成功");
	        } catch (Exception ex) {
	        	System.out.println("加载失败");
	            // 处理错误
	        }
		
		try {
		    conn =DriverManager.getConnection("jdbc:mysql://10.22.27.7:3306/软工小组项目","邹振庭","1234");
		       //此处软工项目小组为mysql提前建立的数据库，邹振庭为用户名，最后为密码：1234
		       System.out.println("连接成功");
		      //一下测试输出数据库内数据，提前在数据库内建立user表，添加num和name
		      // ps = conn.prepareStatement("select 学生ID,学生姓名 from 软工小组项目.学生表;");
		   ps = conn.prepareStatement(""
		   		+ "select distinct 学生表.学生ID,学生表.学生姓名,学生表.出生日期, 学生表.性别,学生表.入学年份,学生表.政治面貌,(教师表.教师名)as 班主任\r\n" + 
		   		"from 软工小组项目.学生表,软工小组项目.学生班级表,软工小组项目.教师表,软工小组项目.`学期-教师-学科-班级表`\r\n" + 
		   		"where 学生表.学生ID=学生班级表.学生ID and 学生表.学生ID="+ID+" and 学生班级表.班主任ID=教师表.教师ID" );
		   rs = ps.executeQuery();
		   while(rs.next()) {
			   //以下变量对应：姓名，年龄，性别，入学年份、政治面貌、班主任姓名
			   int num = rs.getInt("学生ID");
			   String name = rs.getString("学生姓名");
			   String birthDay  = rs.getString("出生日期").substring(0, 4);
			   String gender = rs.getString("性别");
			   int enrollmentYear = rs.getInt("入学年份");
			   String politicsStatus = rs.getString("政治面貌");
			   String teacherName = rs.getString("班主任");
			   int age = 2021- Integer.parseInt(birthDay);
			   System.out.print(num+"\t"+name+"\t"+age+"\t"+gender+"\t"+enrollmentYear+"\t"+politicsStatus+"\t"+teacherName);
			   System.out.println("");
			   
			   //将姓名，年龄，性别，入学年份、政治面貌、班主任姓名加入studentInfo的list中
			   studentInfo.add(name);
			   studentInfo.add(Integer.toString(num));
			   studentInfo.add(Integer.toString(age));
			   studentInfo.add(gender);
			   studentInfo.add(Integer.toString(enrollmentYear));
			   studentInfo.add(politicsStatus);
			   studentInfo.add(teacherName);
			   //System.out.println(studentInfo);
		   }

		} catch (SQLException ex) { // 处理错误
		   
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		    System.out.println("连接失败");
		}
		//System.out.println(studentInfo);//检查是否正确传入
		
		return studentInfo;
	}
	


	
		
		


}




