package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CheckClassHistoryGradeListClass implements CheckClassHistoryGradeListBehavior {

	@Override
	public ArrayList<ArrayList<String>> checkclasshistorygradeList(String teacherid, String examtime, String examtype) {
		// TODO 自动生成的方法存根
		//需要传入教师ID（实际上是班主任ID）,考试时间（是指数据库中的那串时间，我觉得很麻烦）,考试类型
		//查看班级某一时期历史总成绩排名表
		ArrayList<ArrayList<String>> checkclasshistorygradeList = new ArrayList<ArrayList<String>>();
		Connection conn = null;
		String driver = "com.mysql.cj.jdbc.Driver";		
		//String url = "jdbc:mysql://172.16.107.100:3306/软工小组项目";		
		String url = "jdbc:mysql://10.22.27.7:3306/软工小组项目";		
        String user = "林鑫灿";       
        String password = "1234";
        
        try {
			Class.forName(driver);
        	//连接数据库
        	conn = DriverManager.getConnection(url,user,password);
        	if(!conn.isClosed())
        		System.out.println("数据库连接成功!");
        	Statement statement = conn.createStatement();
        	String phrase = "学生班级表.班主任ID=" + teacherid;
        	
        	String sql = "SELECT 学生ID,考试成绩 FROM 软工小组项目.学生成绩表 WHERE 学生ID IN (SELECT 学生ID FROM 软工小组项目.学生班级表 WHERE 班主任ID = 49 ) ORDER BY 学科ID,考试成绩 DESC;\r\n"
        			+ "SELECT 学生姓名 FROM 学生表 WHERE 学生ID IN (SELECT 学生ID FROM 软工小组项目.学生成绩表 WHERE 学生ID IN (SELECT 学生ID FROM 软工小组项目.学生班级表 WHERE 班主任ID = 49 ) ORDER BY 学科ID,考试成绩 DESC);\r\n"
        			+ "\r\n"
        			+ "SELECT 学科名 FROM 学科表 WHERE 学科ID IN (SELECT 学科ID FROM 软工小组项目.学生成绩表 WHERE 学生ID IN (SELECT 学生ID FROM 软工小组项目.学生班级表 WHERE 班主任ID = 49 ) ORDER BY 学科ID,考试成绩 DESC) ;";
        	ResultSet rs = statement.executeQuery(sql);
        	
        	Integer id = null;
        	String name = null;
        	
        	while(rs.next()) {
        		name = rs.getString("学生姓名");
        		
        	}
        	rs.close();
        	conn.close();
		}
		catch (ClassNotFoundException e) {
			// TODO: handle exception
			//数据库驱动类异常处理
       		System.out.println("数据库驱动加载失败!");  
        	e.printStackTrace();  
        } catch(SQLException e) {
        	//数据库连接失败异常处理
        	e.printStackTrace(); 
        }catch (Exception e) {
        	// TODO: handle exception
        	e.printStackTrace();
        }finally {
			System.out.println("数据库数据成功获取！");
		}
        
		return checkclasshistorygradeList;
	}

}
