<<<<<<< HEAD
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CheckStudentGradeInfoClass implements CheckStudentGradeInfoBehavior {//查询学生学业画像
	//static String subject="语文";//传入的学生学科
	//static String ID="15888";//传入的学生学科
	//static int n=5;//传入需要查看的最近的考试次数
	

	@Override
	public ArrayList<ArrayList<Integer>> checkStudentGradeInfo(String ID,int n) {//返回学生学业画像
		 ArrayList<ArrayList<Integer>>studentInfo = new ArrayList<ArrayList<Integer>>();//存储需要查询的学生学业画像
		
		 ArrayList<ArrayList<String>> studentInfo1 = new ArrayList<ArrayList<String>>();//存储无用学生学业画像信息的集合，中转变量
		 ArrayList<ArrayList<String>> studentInfo2 = new ArrayList<ArrayList<String>>();//存储无用学生学业画像信息的集合，中转变量
		
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
			   		+ "select 学生表.学生姓名,学生表.学生ID,班级名,学科名,考试类型名称,考试开始时间,考试成绩,\r\n" + 
			   		"Rank()over (partition by 学生姓名,班级名,考试类型名称 order by 考试成绩 desc)as 班级排名\r\n" + 
			   		"from 软工小组项目.学生表,\r\n" + 
			   		"     软工小组项目.学生班级表,\r\n" + 
			   		"     软工小组项目.班级表,\r\n" + 
			   		"     软工小组项目.学科表,\r\n" + 
			   		"     软工小组项目.学生成绩表,\r\n" + 
			   		"     软工小组项目.考试类型表\r\n" + 
			   		"     \r\n" + 
			   		"where      \r\n" + 
			   		"           学生表.学生ID = 学生班级表.学生ID\r\n" + 
			   		"       and 学生班级表.班级ID=班级表.班级ID/*查询班级*/\r\n" + 
			   		"       and  学生成绩表.学科ID = 学科表.学科ID\r\n" + 
			   		"       and   学生表.学生ID=学生成绩表.学生ID /*查询学科*/\r\n" + 
			   		"       and   学生成绩表.考试类型ID=考试类型表.考试类型ID /*考试类型*/"
			   		);
		   rs = ps.executeQuery();
		   while(rs.next()) {
			   
			   int num = rs.getInt("学生ID");
			   String name = rs.getString("学生姓名");
			   String className = rs.getString("班级名");
			   String subjectName = rs.getString("学科名");
			   String examName= rs.getString("考试类型名称");
			   int grade = rs.getInt("考试成绩");
			   int rank =rs.getInt("班级排名");
			   
			   
			   
			   //System.out.print(num+"\t"+name+"\t"+className+"\t"+subjectName+"\t"+examName+"\t"+grade+"\t"+rank);
			   //System.out.println("");
			   
			   ArrayList<String> people =new ArrayList<String>();//存储一条学生学业画像的元组
			   //将名字，学生ID，班级名，学科名，考试名，考试成绩。考试排名 插入people
			   people.add(name);
			   people.add(Integer.toString(num));
			   people.add(className);
			   people.add(subjectName);
			   people.add(examName);
			   people.add(Integer.toString(grade));
			   people.add(Integer.toString(rank));
			   //将people插入studentInfo
			   studentInfo1.add(people);
               			   
		   }

		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		    System.out.println("连接失败");
		}
		//System.out.println(studentInfo1);//检查是否正确传入
		for(int i=0;i<studentInfo1.size();i++)//筛选需要查询学生ID 的学生学业画像元组
		{
			if(studentInfo1.get(i).get(1).equals(ID))
			{
				//System.out.println(ID);
				studentInfo2.add(studentInfo1.get(i));
			}
			
			
			
		}
		//System.out.println(studentInfo2);
		
		int j=0;
		int k=0;
		ArrayList<Integer> temp =new ArrayList<Integer>();
		
		
		//System.out.println(studentInfo2.size());
		//System.out.println(studentInfo);
		String FLAG=studentInfo2.get(j).get(4);
		ArrayList<Integer> temp0 =new ArrayList<Integer>();
		ArrayList<Integer> temp1 =new ArrayList<Integer>();
		ArrayList<Integer> temp2 =new ArrayList<Integer>();
		ArrayList<Integer> temp3 =new ArrayList<Integer>();
		ArrayList<Integer> temp4 =new ArrayList<Integer>();
		ArrayList<Integer> temp5 =new ArrayList<Integer>();
		ArrayList<Integer> temp6 =new ArrayList<Integer>();
		ArrayList<Integer> temp7 =new ArrayList<Integer>();
		ArrayList<Integer> temp8 =new ArrayList<Integer>();
		for (int c=0;c<n;c++) {
			temp0.add(0);
			temp1.add(0);
			temp2.add(0);
			temp3.add(0);
			temp4.add(0);
			temp5.add(0);
			temp6.add(0);
			temp7.add(0);
			temp8.add(0);
		}
		
		while (j<studentInfo2.size()&&k<n) {
			
			
				if(studentInfo2.get(j).get(3).equals("语文")) {
					if(!(studentInfo2.get(j).get(4).equals(FLAG))) {
						k++;
						FLAG=studentInfo2.get(j).get(4);
					}
					temp0.set(k,Integer.parseInt(studentInfo2.get(j).get(5)));
					//studentInfo.get(0).set(k, Integer.parseInt(studentInfo2.get(j).get(5)));
					//System.out.println(studentInfo);
					j++;
					
					
					continue;	
				}
				   
				
				if(studentInfo2.get(j).get(3).equals("数学")) {
					if(!(studentInfo2.get(j).get(4).equals(FLAG))) {
						k++;
						FLAG=studentInfo2.get(j).get(4);
					}
					//studentInfo.get(1).set(k, Integer.parseInt(studentInfo2.get(j).get(5)));
					temp1.set(k,Integer.parseInt(studentInfo2.get(j).get(5)));
					
					j++;
					continue;
				}
				
				if(studentInfo2.get(j).get(3).equals("英语")) {
					if(!(studentInfo2.get(j).get(4).equals(FLAG))) {
						k++;
						FLAG=studentInfo2.get(j).get(4);
					}
					//studentInfo.get(2).set(k, Integer.parseInt(studentInfo2.get(j).get(5)));
					temp2.set(k,Integer.parseInt(studentInfo2.get(j).get(5)));
					j++;
					continue;
				}
				
				
				if(studentInfo2.get(j).get(3).equals("物理")) {
					if(!(studentInfo2.get(j).get(4).equals(FLAG))) {
						k++;
						FLAG=studentInfo2.get(j).get(4);
					}
					//studentInfo.get(3).set(k, Integer.parseInt(studentInfo2.get(j).get(5)));
					temp3.set(k,Integer.parseInt(studentInfo2.get(j).get(5)));
					j++;
					continue;
				}
				
				if(studentInfo2.get(j).get(3).equals("化学")) {
					if(!(studentInfo2.get(j).get(4).equals(FLAG))) {
						k++;
						FLAG=studentInfo2.get(j).get(4);
					}
					//studentInfo.get(4).set(k, Integer.parseInt(studentInfo2.get(j).get(5)));
					temp4.set(k,Integer.parseInt(studentInfo2.get(j).get(5)));
					j++;
					continue;
				}
				
				if(studentInfo2.get(j).get(3).equals("生物")) {
					if(!(studentInfo2.get(j).get(4).equals(FLAG))) {
						k++;
						FLAG=studentInfo2.get(j).get(4);
					}
					//studentInfo.get(5).set(k, Integer.parseInt(studentInfo2.get(j).get(5)));
					temp5.set(k,Integer.parseInt(studentInfo2.get(j).get(5)));
					j++;
					continue;
				}
				
				if(studentInfo2.get(j).get(3).equals("历史")) {
					if(!(studentInfo2.get(j).get(4).equals(FLAG))) {
						k++;
						FLAG=studentInfo2.get(j).get(4);
					}
					//studentInfo.get(6).set(k, Integer.parseInt(studentInfo2.get(j).get(5)));
					temp6.set(k,Integer.parseInt(studentInfo2.get(j).get(5)));
					j++;
					continue;
				}
				
				if(studentInfo2.get(j).get(3).equals("地理")) {
					if(!(studentInfo2.get(j).get(4).equals(FLAG))) {
						k++;
						FLAG=studentInfo2.get(j).get(4);
					}
					//studentInfo.get(7).set(k, Integer.parseInt(studentInfo2.get(j).get(5)));
					temp7.set(k,Integer.parseInt(studentInfo2.get(j).get(5)));
					j++;
					continue;
				}
				
				if(studentInfo2.get(j).get(3).equals("政治")) {
					if(!(studentInfo2.get(j).get(4).equals(FLAG))) {
						k++;
						FLAG=studentInfo2.get(j).get(4);
					}
					//studentInfo.get(8).set(k, Integer.parseInt(studentInfo2.get(j).get(5)));
					temp8.set(k,Integer.parseInt(studentInfo2.get(j).get(5)));
					j++;
					continue;
				}
				
				else {
					if(!(studentInfo2.get(j).get(4).equals(FLAG))) {
						k++;
						FLAG=studentInfo2.get(j).get(4);
					}
					j++;
					continue;
			         }
		
		    }
		studentInfo.add(temp0);
		studentInfo.add(temp1);
		studentInfo.add(temp2);
		studentInfo.add(temp3);
		studentInfo.add(temp4);
		studentInfo.add(temp5);
		studentInfo.add(temp6);
		studentInfo.add(temp7);
		studentInfo.add(temp8);
		//System.out.println(studentInfo);

		return studentInfo;
	}
	
 

}

=======
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CheckStudentGradeInfoClass implements CheckStudentGradeInfoBehavior {//查询学生学业画像
	//static String subject="语文";//传入的学生学科
	//static String ID="15888";//传入的学生学科
	//static int n=5;//传入需要查看的最近的考试次数
	

	@Override
	public ArrayList<ArrayList<Integer>> checkStudentGradeInfo(String ID,int n) {//返回学生学业画像
//		ID="15888";
//		n=1;
		 ArrayList<ArrayList<Integer>>studentInfo = new ArrayList<ArrayList<Integer>>();//存储需要查询的学生学业画像
		
		 ArrayList<ArrayList<String>> studentInfo1 = new ArrayList<ArrayList<String>>();//存储无用学生学业画像信息的集合，中转变量
		 ArrayList<ArrayList<String>> studentInfo2 = new ArrayList<ArrayList<String>>();//存储无用学生学业画像信息的集合，中转变量
		
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
			String url = "jdbc:mysql://172.16.107.100:3306/软工小组项目";  //地址线路1
	        //String url = "jdbc:mysql://10.22.27.7:3306/软工小组项目";   //地址线路2
		    conn =
		       DriverManager.getConnection(url,"林鑫灿","1234");
		       //此处软工项目小组为mysql提前建立的数据库，邹振庭为用户名，最后为密码：1234

		   System.out.println("连接成功");

		   //一下测试输出数据库内数据，提前在数据库内建立user表，添加num和name
		   
		  // ps = conn.prepareStatement("select 学生ID,学生姓名 from 软工小组项目.学生表;");
		   ps = conn.prepareStatement(""
			   		+ "select 学生表.学生姓名,学生表.学生ID,班级名,学科名,考试类型名称,考试开始时间,考试成绩,\r\n" + 
			   		"Rank()over (partition by 学生姓名,班级名,考试类型名称 order by 考试成绩 desc)as 班级排名\r\n" + 
			   		"from 软工小组项目.学生表,\r\n" + 
			   		"     软工小组项目.学生班级表,\r\n" + 
			   		"     软工小组项目.班级表,\r\n" + 
			   		"     软工小组项目.学科表,\r\n" + 
			   		"     软工小组项目.学生成绩表,\r\n" + 
			   		"     软工小组项目.考试类型表\r\n" + 
			   		"     \r\n" + 
			   		"where      \r\n" + 
			   		"           学生表.学生ID = 学生班级表.学生ID\r\n" + 
			   		"       and 学生班级表.班级ID=班级表.班级ID/*查询班级*/\r\n" + 
			   		"       and  学生成绩表.学科ID = 学科表.学科ID\r\n" + 
			   		"       and   学生表.学生ID=学生成绩表.学生ID /*查询学科*/\r\n" + 
			   		"       and   学生成绩表.考试类型ID=考试类型表.考试类型ID /*考试类型*/"
			   		);
		   rs = ps.executeQuery();
		   while(rs.next()) {
			   
			   int num = rs.getInt("学生ID");
			   String name = rs.getString("学生姓名");
			   String className = rs.getString("班级名");
			   String subjectName = rs.getString("学科名");
			   String examName= rs.getString("考试类型名称");
			   int grade = rs.getInt("考试成绩");
			   int rank =rs.getInt("班级排名");
			   
			   
			   
			   //System.out.print(num+"\t"+name+"\t"+className+"\t"+subjectName+"\t"+examName+"\t"+grade+"\t"+rank);
			   //System.out.println("");
			   
			   ArrayList<String> people =new ArrayList<String>();//存储一条学生学业画像的元组
			   //将名字，学生ID，班级名，学科名，考试名，考试成绩。考试排名 插入people
			   people.add(name);
			   people.add(Integer.toString(num));
			   people.add(className);
			   people.add(subjectName);
			   people.add(examName);
			   people.add(Integer.toString(grade));
			   people.add(Integer.toString(rank));
			   //将people插入studentInfo
			   studentInfo1.add(people);
               			   
		   }

		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		    System.out.println("连接失败");
		}
		//System.out.println(studentInfo1);//检查是否正确传入
		for(int i=0;i<studentInfo1.size();i++)//筛选需要查询学生ID 的学生学业画像元组
		{
			if(studentInfo1.get(i).get(1).equals(ID))
			{
				//System.out.println(ID);
				studentInfo2.add(studentInfo1.get(i));
			}
			
			
			
		}
		//System.out.println(studentInfo2);
		
		int j=0;
		int k=0;
		ArrayList<Integer> temp =new ArrayList<Integer>();
		
		
		//System.out.println(studentInfo2.size());
		//System.out.println(studentInfo);
		String FLAG=studentInfo2.get(j).get(4);
		ArrayList<Integer> temp0 =new ArrayList<Integer>();
		ArrayList<Integer> temp1 =new ArrayList<Integer>();
		ArrayList<Integer> temp2 =new ArrayList<Integer>();
		ArrayList<Integer> temp3 =new ArrayList<Integer>();
		ArrayList<Integer> temp4 =new ArrayList<Integer>();
		ArrayList<Integer> temp5 =new ArrayList<Integer>();
		ArrayList<Integer> temp6 =new ArrayList<Integer>();
		ArrayList<Integer> temp7 =new ArrayList<Integer>();
		ArrayList<Integer> temp8 =new ArrayList<Integer>();
		for (int c=0;c<n;c++) {
			temp0.add(0);
			temp1.add(0);
			temp2.add(0);
			temp3.add(0);
			temp4.add(0);
			temp5.add(0);
			temp6.add(0);
			temp7.add(0);
			temp8.add(0);
		}
		
		
		
		while (j<studentInfo2.size()&&k<n) {
			
			
				if(studentInfo2.get(j).get(3).equals("语文")) {
					if(!(studentInfo2.get(j).get(4).equals(FLAG))) {
						k++;
						FLAG=studentInfo2.get(j).get(4);
						if (k==n) break;
					}
					temp0.set(k,Integer.parseInt(studentInfo2.get(j).get(5)));
					//studentInfo.get(0).set(k, Integer.parseInt(studentInfo2.get(j).get(5)));
					//System.out.println(studentInfo);
					j++;
					
					
					continue;	
				}
				   
				
				if(studentInfo2.get(j).get(3).equals("数学")) {
					if(!(studentInfo2.get(j).get(4).equals(FLAG))) {
						k++;
						FLAG=studentInfo2.get(j).get(4);
						if (k==n) break;
					}
					//studentInfo.get(1).set(k, Integer.parseInt(studentInfo2.get(j).get(5)));
					temp1.set(k,Integer.parseInt(studentInfo2.get(j).get(5)));
					
					j++;
					continue;
				}
				
				if(studentInfo2.get(j).get(3).equals("英语")) {
					if(!(studentInfo2.get(j).get(4).equals(FLAG))) {
						k++;
						FLAG=studentInfo2.get(j).get(4);
						if (k==n) break;
					}
					//studentInfo.get(2).set(k, Integer.parseInt(studentInfo2.get(j).get(5)));
					temp2.set(k,Integer.parseInt(studentInfo2.get(j).get(5)));
					j++;
					continue;
				}
				
				
				if(studentInfo2.get(j).get(3).equals("物理")) {
					if(!(studentInfo2.get(j).get(4).equals(FLAG))) {
						k++;
						FLAG=studentInfo2.get(j).get(4);
						if (k==n) break;
					}
					//studentInfo.get(3).set(k, Integer.parseInt(studentInfo2.get(j).get(5)));
					temp3.set(k,Integer.parseInt(studentInfo2.get(j).get(5)));
					j++;
					continue;
				}
				
				if(studentInfo2.get(j).get(3).equals("化学")) {
					if(!(studentInfo2.get(j).get(4).equals(FLAG))) {
						k++;
						FLAG=studentInfo2.get(j).get(4);
						if (k==n) break;
					}
					//studentInfo.get(4).set(k, Integer.parseInt(studentInfo2.get(j).get(5)));
					temp4.set(k,Integer.parseInt(studentInfo2.get(j).get(5)));
					j++;
					continue;
				}
				
				if(studentInfo2.get(j).get(3).equals("生物")) {
					if(!(studentInfo2.get(j).get(4).equals(FLAG))) {
						k++;
						FLAG=studentInfo2.get(j).get(4);
						if (k==n) break;
					}
					//studentInfo.get(5).set(k, Integer.parseInt(studentInfo2.get(j).get(5)));
					temp5.set(k,Integer.parseInt(studentInfo2.get(j).get(5)));
					j++;
					continue;
				}
				
				if(studentInfo2.get(j).get(3).equals("历史")) {
					if(!(studentInfo2.get(j).get(4).equals(FLAG))) {
						k++;
						FLAG=studentInfo2.get(j).get(4);
						if (k==n) break;
					}
					//studentInfo.get(6).set(k, Integer.parseInt(studentInfo2.get(j).get(5)));
					temp6.set(k,Integer.parseInt(studentInfo2.get(j).get(5)));
					j++;
					continue;
				}
				
				if(studentInfo2.get(j).get(3).equals("地理")) {
					if(!(studentInfo2.get(j).get(4).equals(FLAG))) {
						k++;
						FLAG=studentInfo2.get(j).get(4);
						if (k==n) break;
					}
					//studentInfo.get(7).set(k, Integer.parseInt(studentInfo2.get(j).get(5)));
					temp7.set(k,Integer.parseInt(studentInfo2.get(j).get(5)));
					j++;
					continue;
				}
				
				if(studentInfo2.get(j).get(3).equals("政治")) {
					if(!(studentInfo2.get(j).get(4).equals(FLAG))) {
						k++;
						FLAG=studentInfo2.get(j).get(4);
						if (k==n) break;
					}
					//studentInfo.get(8).set(k, Integer.parseInt(studentInfo2.get(j).get(5)));
					temp8.set(k,Integer.parseInt(studentInfo2.get(j).get(5)));
					j++;
					continue;
				}
				
				else {
					if(!(studentInfo2.get(j).get(4).equals(FLAG))) {
						k++;
						FLAG=studentInfo2.get(j).get(4);
						if (k==n) break;
					}
					j++;
					continue;
			         }
		
		    }
		studentInfo.add(temp0);
		studentInfo.add(temp1);
		studentInfo.add(temp2);
		studentInfo.add(temp3);
		studentInfo.add(temp4);
		studentInfo.add(temp5);
		studentInfo.add(temp6);
		studentInfo.add(temp7);
		studentInfo.add(temp8);
		//System.out.println(studentInfo);
		
		
		
		

		return studentInfo;
	}
	
 

}

>>>>>>> 408f01557a212803392a6fde5c7b35e7b8cd5c8b
