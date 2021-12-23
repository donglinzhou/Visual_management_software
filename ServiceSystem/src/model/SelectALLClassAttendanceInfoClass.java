package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SelectALLClassAttendanceInfoClass implements SelectALLClassAttendanceInfoBehavior {
	/**
	 * 查看每个班级在某时间段内总的缺勤人数
	 * 输入：时间段
	 * 返回：二维数组
	 * 
	 * */
	/**
	 * [班级ID，缺勤人数]
	 * */
	
	
	public static DatabaseModel database = new DatabaseModel();

	@Override
	public ArrayList<ArrayList<String>> selectALLClassAttendanceInfo(ArrayList<String> data) {
		
		ArrayList<ArrayList<String>> selectALLClassAttendanceInfo = new ArrayList<ArrayList<String>>();
		database.connect();
		
		try {
			String sql = "SELECT 班级ID, COUNT(学生ID) AS 缺勤人数\r\n"
					+ "					FROM 学生班级表 AS c LEFT JOIN 学生考勤表 AS a USING(学生ID)\r\n"
					+ "					INNER JOIN 考勤类型表 AS t USING(考勤类型ID)\r\n"
					+ "					WHERE DATE_FORMAT(时间,'%Y-%m-%d %H:%I') BETWEEN DATE_FORMAT(?,'%Y-%m-%d %H:%I') AND DATE_FORMAT(?,'%Y-%m-%d %H:%I')\r\n"
					+ "					GROUP BY 班级ID\r\n"
					+ "					ORDER BY 班级ID";
			
			ResultSet rs=database.execResult(sql,data);
	
			Integer num = null;//缺勤人数
			Integer classid = null;//班级id

			while(rs.next()) {
				
				//写入Arraylist数组中
	        	ArrayList<String> onerow = new ArrayList<String>();	// 创建一维数组输入

	        	classid = rs.getInt("班级ID");//获取班级ID
	        	num = rs.getInt("缺勤人数");//获取缺勤人数
	        
				//将数据类型进行转换
	        	String classids = Integer.toString(classid);
				String nums = Integer.toString(num);
				
				//写入数组
				onerow.add(classids);
				onerow.add(nums);

				selectALLClassAttendanceInfo.add(onerow);
        	}
        	rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return selectALLClassAttendanceInfo;
	}

}
