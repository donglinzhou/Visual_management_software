package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CheckStudentConsumptionInfoClass implements CheckStudentConsumptionInfoBehavior {//查询学生消费记录

//	static String ID="15888";//传入的学生ID
//	static int n=5;
	//static ArrayList<Double>studentInfo= new ArrayList<Double>();
	//static ArrayList<Double>studentInfo3= new ArrayList<Double>();
	//static ArrayList<ArrayList<String>> studentInfo2 = new ArrayList<ArrayList<String>>();//类的全局变量，用来存储返回学生消费记录
	//static ArrayList<ArrayList<String>> studentInfo1 = new ArrayList<ArrayList<String>>();//类的全局变量，用来存储返回学生无用消费记录

	@Override
	public  ArrayList<Double> checkStudentConsumptionInfo(String ID,int n) {//返回的学生消费记录
		 ArrayList<Double>studentInfo= new ArrayList<Double>();
		 ArrayList<Double>studentInfo3= new ArrayList<Double>();
		 ArrayList<ArrayList<String>> studentInfo2 = new ArrayList<ArrayList<String>>();//类的全局变量，用来存储返回学生消费记录
		 ArrayList<ArrayList<String>> studentInfo1 = new ArrayList<ArrayList<String>>();//类的全局变量，用来存储返回学生无用消费记录

		//System.out.println("查看学生个人信息");
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
		       DriverManager.getConnection("jdbc:mysql://172.16.107.100:3306/软工小组项目","邹振庭","1234");
		       //此处软工项目小组为mysql提前建立的数据库，邹振庭为用户名，最后为密码：1234

		   System.out.println("连接成功");

		   //一下测试输出数据库内数据，提前在数据库内建立user表，添加num和name
		   
		  // ps = conn.prepareStatement("select 学生ID,学生姓名 from 软工小组项目.学生表;");
		   ps = conn.prepareStatement(""
			   		+ "select 学生表.学生姓名,学生表.学生ID,消费时间,消费金额\r\n" + 
			   		"from 软工小组项目.学生表,软工小组项目.消费表\r\n" + 
			   		"where 学生表.学生ID=消费表.学生ID\r\n" + 
			   		"      and 学生表.学生ID=" +ID);
		   rs = ps.executeQuery();
		   while(rs.next()) {
			   ArrayList<String> people =new ArrayList<String>();//存储一条学生消费记录的元组
			   //学生ID，学生姓名，消费时间，消费金额
			   int num = rs.getInt("学生ID");
			   String name = rs.getString("学生姓名");
			   String consumptionTimeYear = rs.getString("消费时间").substring(0, 4);
			   String consumptionTimeMonth = rs.getString("消费时间").substring(5,6);
			   double consumptionAmount = rs.getInt("消费金额");
			   System.out.print(num+"\t"+name+"\t"+consumptionTimeYear+"\t"+consumptionTimeMonth+"\t"+consumptionAmount);
			   System.out.println("");
			   
			  
			   
			 //将学生ID，学生姓名，消费时间，消费金额插入people
			   people.add(name);
			   people.add(Integer.toString(num));
			   people.add(consumptionTimeYear);
			   people.add(consumptionTimeMonth);
			   people.add(String.valueOf(consumptionAmount));
			   //将people插入studentInfo
			   studentInfo2.add(people);
			   
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
		String FLAG=studentInfo2.get(0).get(3);
		double sum=0.0;
		for(int i=0;i<studentInfo2.size();i++) {
			if (studentInfo2.get(i).get(3).equals(FLAG)) {
				
				sum += Double.parseDouble(studentInfo2.get(i).get(4));
				if(i==studentInfo2.size()-1) studentInfo3.add(sum);
				}
			
			else 
			{
				FLAG=studentInfo2.get(i).get(3);
				studentInfo3.add(sum);
				sum=0;
				sum += Double.parseDouble(studentInfo2.get(i).get(4));
				
			
		}
		
		
	}
		if(studentInfo3.size()<n) 
			n=studentInfo3.size();
		
		for (int c=0;c<n;c++) {
			studentInfo.add(studentInfo3.get(c));
			
		}
		//System.out.println(studentInfo3);//检查是否正确传入
	
		return studentInfo;
		
	}


}

