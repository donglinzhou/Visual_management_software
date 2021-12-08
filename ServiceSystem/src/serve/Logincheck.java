package serve;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Logincheck {
	public ArrayList<Object> logincheck(String userid, String password) {
				//连接数据库
				//声明Connection对象
				Connection conn = null;
				//驱动程序名
				String driver = "com.mysql.cj.jdbc.Driver";
				//URL指向要访问的数据库名
				//第一个数据库端口
				String url = "jdbc:mysql://172.16.107.100:3306/软工小组项目";
				//第二个数据库端口
				//String url = "jdbc:mysql://10.22.27.7:3306/软工小组项目";
				 //MySQL配置时的用户名
		        String user = "林鑫灿";
		        //MySQL配置时的密码
		        String passw = "1234";
		        try {
					//加载数据库
		        	Class.forName(driver);
		        	//连接数据库
		        	conn = DriverManager.getConnection(url,user,passw);
		        	if(!conn.isClosed())
		        		System.out.println("数据库连接成功!");
		        	
		        	//创建statement对象，执行SQL语句
		        	Statement statement = conn.createStatement();
		        	//要执行的SQL语句
		        	String sql = "SELECT 密码,账户类型 FROM 软工小组项目.登录用户表 WHERE 用户ID = "+ userid;
		        	
		        	//ResultSet类，用来存放获取的结果集
		        	ResultSet rs = statement.executeQuery(sql);
		        	
		        	//获取密码和账户类型
		        	String passwordString = null;
		        	String usertype = null;
		        	
		        	//如果会使用账户类型就添加下列语句
		        	ArrayList<Object> logincheck = new ArrayList<Object>();
		        	
		        	//判断是否找到
		        	if(rs.next()) {
		        		passwordString = rs.getString("密码");
		        		usertype = rs.getString("账户类型");
		        		if(passwordString.equals(password)) {
		        			logincheck.add("true");
		        			logincheck.add(usertype);
		        			conn.close();
		        			//return true;
		        			return logincheck;
		        		}else {
		        			logincheck.add("false");
		        			conn.close();
							//return false;
							return logincheck;
						}
		        	}else {
		        		logincheck.add("false");
		        		conn.close();
						//return false;
						return logincheck;
					}
		        	
		        	
		        	
		        	
				} catch (ClassNotFoundException e) {
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
				//return false;
				return null;
		
	}
}
