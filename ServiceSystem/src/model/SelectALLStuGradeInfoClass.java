package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SelectALLStuGradeInfoClass implements SelectALLStuGradeInfoBehavior {
	/**
	 * 查看年级学业情况（整个年级的平均分在几次考试中的对比）
	 * 输入：学科ID、最近n次时间（最近3次、5次、10次）
	 * 返回：二维数组
	 * */
	/**
	 * [
	 * 	[第1次考试平均分，第1次考试最高分，第1次考试最低分]，
	 * 	[第2次考试平均分，第2次考试最高分，第2次考试最低分]，
	 * 	……
	 * ]
	 * */
	
	public static DatabaseModel database = new DatabaseModel();
	private Connection connection;
	private PreparedStatement preparedStatement;//动态查询
	//private String url = "jdbc:mysql://172.16.107.100:3306/软工小组项目";
    private String url = "jdbc:mysql://10.22.27.7:3306/软工小组项目";
    //mysql 默认端口3306
    //协议 ：// 主机地址 ： 端口号 / 数据库名 ？ 参数1 & 参数2 & 参数3
    private String userName = "林鑫灿";
    private String password = "1234";
    private final static String driver = "com.mysql.cj.jdbc.Driver";
	@Override
	public ArrayList<ArrayList<String>> selectALLStuGradeInfo(ArrayList<String> data) {
		
		ArrayList<ArrayList<String>> selectALLStuGradeInfo = new ArrayList<ArrayList<String>>();
		database.connect();
		//由于SQL语句中limit只能接受整数类型，所以传入的参数需要转换为整数类型
		ArrayList<Integer> dataset = new ArrayList<Integer>();
		int numone = Integer.parseInt(data.get(0));
		int numtwo = Integer.parseInt(data.get(1));
		dataset.add(numone);
		dataset.add(numtwo);
		try {
			String sql = "SELECT AVG(考试成绩) AS 平均分, MAX(考试成绩) AS 最高分, MIN(考试成绩) AS 最低分 FROM 学生成绩表 AS grade, 学生班级表 AS class\r\n"
					+ "					WHERE grade.学生ID = class.学生ID and grade.学期ID = class.学期ID and 学科ID = ? \r\n"
					+ "					GROUP BY 考试开始时间, 学科ID, grade.学期ID, 考试类型ID\r\n"
					+ "					order by  考试开始时间 desc\r\n"
					+ "					LIMIT 0,?" ;
			
			Class.forName(driver); //固定写法，加载驱动
            connection = DriverManager.getConnection(url, userName, password);
			preparedStatement = connection.prepareStatement(sql);
	        
	        for (int i = 1; i <= dataset.size(); i++) {
	            preparedStatement.setLong(i, dataset.get(i-1));
	        }
	        //System.out.println(preparedStatement);
	        
	        
			ResultSet rs=preparedStatement.executeQuery(); //查询操作，返回ResultSet
	
			Integer avg = null;
			Integer max = null;
			Integer min = null;
		
			while(rs.next()) {
				
				//写入Arraylist数组中
	        	ArrayList<String> onerow = new ArrayList<String>();	// 创建一维数组输入

				avg = rs.getInt("平均分");//获取平均分
				max = rs.getInt("最高分");//获取最高分
				min = rs.getInt("最低分");//获取最低分
				
				//将数据类型进行转换
				String avgs = Integer.toString(avg);
				String maxs = Integer.toString(max);
				String mins = Integer.toString(min);

				//写入数组
        		onerow.add(avgs);
        		onerow.add(maxs);
        		onerow.add(mins);
				
        		selectALLStuGradeInfo.add(onerow);
        		
        	}
        	rs.close();
			
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return selectALLStuGradeInfo;
	}

}
