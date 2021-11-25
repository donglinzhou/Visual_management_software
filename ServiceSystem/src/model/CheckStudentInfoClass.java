package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CheckStudentInfoClass implements CheckStudentInfoBehavior {

	
	static int ID=13012;//传入的学生ID
	static ArrayList<String> studentInfo = new ArrayList<String>();
	@Override
	public ArrayList<String> checkStudentInfo() {
		// TODO 自动生成的方法存根
		//需要查看：姓名，年龄，性别，入学年份、政治面貌、班主任姓名
		System.out.println("查看学生个人信息");
//		Vector<String> info=new Vector<String>();
//		info.add("张三");
//		info.add("18");
//		info.add("2019");
//		info.add("团员");
//		info.add("王五");
//		return info;
//		public static void main(String []args) {
	
		return studentInfo;
		
	}

	public static void main(String []args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		 try {
	            // The newInstance() call is a work around for some
	            // broken Java implementations

	            Class.forName("com.mysql.cj.jdbc.Driver");
	            System.out.println("加载成功");
	        } catch (Exception ex) {
	        	System.out.println("加载失败");
	            // handle the error
	        }
		
		try {
		    conn =
		       DriverManager.getConnection("jdbc:mysql://10.22.27.7:3306/软工小组项目","邹振庭","1234");
		       //此处软工项目小组为mysql提前建立的数据库，邹振庭为用户名，最后为密码：1234

		   System.out.println("连接成功");

		   //一下测试输出数据库内数据，提前在数据库内建立user表，添加num和name
		   
		  // ps = conn.prepareStatement("select 学生ID,学生姓名 from 软工小组项目.学生表;");
		   ps = conn.prepareStatement(""
		   		+ "select 学生表.学生ID,学生表.学生姓名,学生表.出生日期, 学生表.性别,学生表.入学年份,学生表.政治面貌, 教师表.教师名\n" + 
		   		"from 软工小组项目.学生表,软工小组项目.`班主任-学生表`,软工小组项目.`学期-班级-班主任表`,软工小组项目.教师表\n" + 
		   		"where 学生表.学生ID=`班主任-学生表`.学生ID and `学期-班级-班主任表`.`学期-班级-班主任ID`=`班主任-学生表`.`学期-班级-班主任ID` \n" + 
		   		"and 学生表.学生ID="+ID+" and `学期-班级-班主任表`.教师ID=教师表.教师ID;");
		   rs = ps.executeQuery();
		   while(rs.next()) {
			   
			   int num = rs.getInt("学生ID");
			   String name = rs.getString("学生姓名");
			   String birthDay  = rs.getString("出生日期").substring(0, 4);
			   String gender = rs.getString("性别");
			   int enrollmentYear = rs.getInt("入学年份");
			   String politicsStatus = rs.getString("政治面貌");
			   String teacherName = rs.getString("教师名");
			   int age = 2021- Integer.parseInt(birthDay);
			   System.out.print(num+"\t"+name+"\t"+age+"\t"+gender+"\t"+enrollmentYear+"\t"+politicsStatus+"\t"+teacherName);
			   System.out.println("");
			   
			
			   studentInfo.add(name);
			   studentInfo.add(Integer.toString(num));
			   studentInfo.add(Integer.toString(age));
			   studentInfo.add(gender);
			   studentInfo.add(Integer.toString(enrollmentYear));
			   studentInfo.add(politicsStatus);
			   studentInfo.add(teacherName);
			   
			   
		   }

		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		    System.out.println("连接失败");
		}
		//System.out.println(studentInfo);检查是否正确传入
	}
	
}



