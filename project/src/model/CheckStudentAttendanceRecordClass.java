package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CheckStudentAttendanceRecordClass implements CheckStudentAttendanceRecordBehavior {

	@Override
	public ArrayList<ArrayList<String>> checkStudentAttendanceRecord(int studentID) {
		// TODO 自动生成的方法存根
		System.out.println("查看学生考勤记录");
		
		//-------DL--------//
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		//--驱动程序名
		String driver = "com.mysql.cj.jdbc.Driver";
        //--URL指向要访问的数据库名mydata
        String url = "jdbc:mysql://172.16.107.100:3306/软工小组项目";  //地址线路1
//        String url = "jdbc:mysql://10.22.27.7:3306/软工小组项目";   //地址线路2
        //--MySQL配置时的用户名
        String user = "朱大霖";
        //--MySQL配置时的密码
        String password = "1234"; 
		
		
		try { 
	            Class.forName(driver);   //加载驱动
	            System.out.println("加载成功");
	        } catch (Exception ex) {
	        	System.out.println("加载失败");
	            // handle the error
	        }
		
		try {
			conn =
		       DriverManager.getConnection(url+"?useSSL=false&serverTimezone=UTC",user,password);
//		       DriverManager.getConnection("jdbc:mysql://10.22.27.7:3306/软工小组项目?useSSL=false&serverTimezone=UTC","朱大霖","1234");
		       //此处软工项目小组为mysql提前建立的数据库，朱大霖为用户名，最后为密码：1234
               //其中有两条线路地址为172.16.107.100和10.22.27.7
		   System.out.println("连接成功");

		   //一下测试输出数据库内数据，提前在数据库内建立user表，添加num和name  and 学生姓名="+studentName+"
		   ps = conn.prepareStatement("select 学生表.学生ID,学生表.学生姓名,考勤类型表.考勤名称,学生考勤表.时间\n" + 
		   		"from  软工小组项目.学生表,软工小组项目.考勤类型表,软工小组项目.学生考勤表\n" + 
		   		"where 学生表.学生ID=学生考勤表.学生ID  and 考勤类型表.考勤类型ID=学生考勤表.考勤类型ID \n" + 
		   		"	   and 学生表.学生ID= "+studentID);
		   rs = ps.executeQuery();
		   
		   int temp=0;  //确定打印时刻，并记录信息条数
		   ArrayList<ArrayList<String>> attendanceRecord = new ArrayList<ArrayList<String>>();
		   while(rs.next()) {
			   //-------查询信息赋值------//
			   int num = rs.getInt("学生ID");
			   String name = rs.getString("学生姓名");
			   String attendance = rs.getString("考勤名称");
			   String timeRecord = rs.getString("时间");
			   
			   temp++;
			   //----打印查询信息-----//
			   if(temp==1)System.out.print("学生ID"+"\t"+"姓名"+"\t"+"考勤名称"+"\t\t"+"时间"+"\n");
			   System.out.print(num+"\t"+name+"\t"+attendance+"\t"+timeRecord);
			   System.out.println("");  //换行功能
			   
			   //记录：学生ID，姓名，考勤名称，时间
			   ArrayList<String> ss=new ArrayList<String>();
			   ss.add("" + num);  //强制类型转换"" + num,将数值转换为String类型
			   ss.add(name);
			   ss.add(attendance);
			   ss.add(timeRecord);
			   attendanceRecord.add(ss);
			   
		   }
		   System.out.println("共计条数："+temp);
		   System.out.println("\n返回学生考勤记录信息");
		   return attendanceRecord;
		   
		   
		} catch (SQLException ex) {//------处理任何错误,错误提示------//
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		    System.out.println("连接失败");
		}
		//--------DL--------//
		
		//需要查看：学生ID，姓名，考勤名称，时间
		System.out.println("返回学生考勤记录信息");

		ArrayList<ArrayList<String>> attendanceRecord = new ArrayList<ArrayList<String>>();
		ArrayList<String> ss1=new ArrayList<String>();
		ss1.add("没有该学生的考勤记录");
		attendanceRecord.add(ss1);
		return attendanceRecord;  //返回二维数组数据

	}
	

}
