package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SelectClassStuNameClass implements SelectClassStuNameBehavior {
	/**
	 * 查看班级学生信息表
	 * 联表查询（学生表 + 学生班级表）
	 * 输入：班级ID
	 * 返回：一维数组【班级的每个学生的名字】
	 * */

	public static DatabaseModel database = new DatabaseModel();
	
	@Override
	public ArrayList<String> selectClassStuName(ArrayList<String> data) {
		
		ArrayList<String> selectClassStuName = new ArrayList<String>();
		database.connect();
		
		try {
			String sql = "SELECT 学生姓名 FROM 学生表, 学生班级表 WHERE 学生表.学生ID = 学生班级表.学生ID AND 班级ID = ? ";
			ResultSet rs=database.execResult(sql,data);

			String stuName = null;//姓名
		
			while(rs.next()) {

	        	stuName = rs.getString("学生姓名");//获取姓名

				//写入数组
	        	selectClassStuName.add(stuName);
        		
        	}
        	rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return selectClassStuName;
	}

}
