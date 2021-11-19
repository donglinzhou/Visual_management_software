package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CheckStudentGradeInfoClass implements CheckStudentGradeInfoBehavior {
	static String subject="语文";//传入的学生学科
	static ArrayList<ArrayList<String>> studentInfo = new ArrayList<ArrayList<String>>();
	@Override
	public ArrayList<ArrayList<String>> checkStudentGradeInfo() {
	
		System.out.println("查看学生个人信息");

	
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
		       DriverManager.getConnection("jdbc:mysql://172.16.107.100/软工小组项目","邹振庭","1234");
		       //此处软工项目小组为mysql提前建立的数据库，邹振庭为用户名，最后为密码：1234

		   System.out.println("连接成功");

		   //一下测试输出数据库内数据，提前在数据库内建立user表，添加num和name
		   
		  // ps = conn.prepareStatement("select 学生ID,学生姓名 from 软工小组项目.学生表;");
		   ps = conn.prepareStatement(""
			   		+ "select 学生表.学生姓名,学生表.学生ID,班级名,学科名,考试类型名称,学生成绩,\r\n" + 
			   		"Rank()over (partition by 班级名,学科名,考试类型名称 order by 学生成绩 desc)as 班级排名" + 
			   		"from 软工小组项目.学生表,软工小组项目.`班主任-学生表`,\r\n" + 
			   		"     软工小组项目.`学期-班级-班主任表`,\r\n" + 
			   		"     软工小组项目.`考试-学期-学科表`,软工小组项目.班级表,\r\n" + 
			   		"     软工小组项目.学科表,软工小组项目.学生成绩表,\r\n" + 
			   		"     软工小组项目.考试类型表" + 
			   		"where      \r\n" + 
			   		"           学生表.学生ID = `班主任-学生表`.学生ID\r\n" + 
			   		"       and `班主任-学生表`.`学期-班级-班主任ID`=`学期-班级-班主任表`.`学期-班级-班主任ID`/*查询班级*/\r\n" + 
			   		"       and   `学期-班级-班主任表`.班级ID=班级表.班级ID                                            /*查询班级*/\r\n" + 
			   		"       \r\n" + 
			   		"      \r\n" + 
			   		"       and  `考试-学期-学科表`.考试ID = 学生成绩表.考试ID\r\n" + 
			   		"       and  `考试-学期-学科表`.学科ID = 学科表.学科ID   /*查询学科*/\r\n" + 
			   		"       and   学生表.学生ID=学生成绩表.学生ID\r\n" + 
			   		"       \r\n" + 
			   		"       and   `考试-学期-学科表`.考试类型=考试类型表.考试类型ID /*考试类型*/\r\n" + 
			   		"       and 学科表.学科名='语文'" );
		   rs = ps.executeQuery();
		   while(rs.next()) {
			   
			   int num = rs.getInt("学生ID");
			   String name = rs.getString("学生姓名");
			   String className = rs.getString("班级名");
			   String subjectName = rs.getString("学科名");
			   String examName= rs.getString("考试类型名称");
			   int grade = rs.getInt("成绩");
			   int rank =rs.getInt("班级排名");
			   
			   
			   
			   System.out.print(num+"\t"+name+"\t"+className+"\t"+subjectName+"\t"+examName+"\t"+grade+"\t"+rank);
			   System.out.println("");
			   
			   ArrayList<String> people =new ArrayList<String>();
			   people.add(name);
			   people.add(Integer.toString(num));
			   people.add(className);
			   people.add(subjectName);
			   people.add(examName);
			   people.add(Integer.toString(grade));
			   people.add(Integer.toString(rank));
			   studentInfo.add(people);
			   
			   /*ArrayList<String> name1=new ArrayList<String>();
			   ArrayList<String> consumptionTime1=new ArrayList<String>();
			   ArrayList<String> consumptionAmount1=new ArrayList<String>();
			   ArrayList<String> num1=new ArrayList<String>();*/
			   
			   /*name1.add(name);
			   num1.add(Integer.toString(num));
			   consumptionTime1.add(consumptionTime);
			   consumptionAmount1.add(String.valueOf(consumptionAmount));*/
			   
			   /*studentInfo.add(name1);
			   studentInfo.add(num1);
			   studentInfo.add(consumptionTime1);
			   studentInfo.add(consumptionAmount1);*/
			   
			   
			   
			   
		   }

		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		    System.out.println("连接失败");
		}
		System.out.println(studentInfo);//检查是否正确传入
	}
}
