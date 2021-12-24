package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SelectALLAttendanceInfoByTypeClass implements SelectALLAttendanceInfoByTypeBehavior {
	/**
	 * 查看每个缺勤类型在某时间段内总的缺勤人数
	 * 输入：时间段
	 * 返回：二维数组
	 * 
	 * */
	/**
	 * [xx缺勤类型，缺勤人数],
	 * [xx缺勤类型，缺勤人数],
	 * ……,
	 * [xx缺勤类型，缺勤人数]
	 * */
	
	
	public static DatabaseModel database = new DatabaseModel();
	
	@Override
	public ArrayList<ArrayList<String>> selectALLAttendanceInfoByType(ArrayList<String> data) {
		
		ArrayList<ArrayList<String>> selectALLAttendanceInfoByType = new ArrayList<ArrayList<String>>();
		database.connect();
		System.out.println(data);
		try {
			String sql = "SELECT 考勤名称, COUNT(学生ID) AS 缺勤人数\r\n"
					+ "					FROM 学生班级表 AS c LEFT JOIN 学生考勤表 AS a USING(学生ID)\r\n"
					+ "					INNER JOIN 考勤类型表 AS t USING(考勤类型ID)\r\n"
					+ "					WHERE DATE_FORMAT(时间,'%Y-%m-%d %H:%I') BETWEEN DATE_FORMAT(?,'%Y-%m-%d %H:%I') AND DATE_FORMAT(?,'%Y-%m-%d %H:%I')\r\n"
					+ "					GROUP BY 考勤名称\r\n"
					+ "					ORDER BY 缺勤人数 DESC";

			ResultSet rs=database.execResult(sql,data);
	
			String type = null;
			Integer num = null;

			while(rs.next()) {
				
				//写入Arraylist数组中
	        	ArrayList<String> onerow = new ArrayList<String>();	// 创建一维数组输入

	        	type = rs.getString("考勤名称");//获取考勤名称
	        	num = rs.getInt("缺勤人数");//获取缺勤人数
				
				//将数据类型进行转换
				String nums = Integer.toString(num);

				//写入数组
        		onerow.add(type);
        		onerow.add(nums);
				
        		selectALLAttendanceInfoByType.add(onerow);
        		
        	}
        	rs.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return selectALLAttendanceInfoByType;
	}
}
