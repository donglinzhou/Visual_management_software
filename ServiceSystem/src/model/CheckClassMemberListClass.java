package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CheckClassMemberListClass implements CheckClassMemberListBehavior {

	@Override
	public ArrayList<String> checkclassmemberlist(String teacherid) {
		// TODO 自动生成的方法存根
		//查看班级学生名单
			
		ArrayList<String> checkclassmemberlist = new ArrayList<String>();
		
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
        	
        	String sql = "SELECT * FROM 学生班级表,学生表 where " + phrase + " and 学生班级表.学生ID=学生表.学生ID";
        	ResultSet rs = statement.executeQuery(sql);
        	
        	Integer id = null;
        	String name = null;
        	
        	while(rs.next()) {
        		name = rs.getString("学生姓名");
        		checkclassmemberlist.add(name);
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
		
		return checkclassmemberlist;
	}

}
