package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SelectALLClassGradeInfoClass implements SelectALLClassGradeInfoBehavior {
	/**
	 * 查看年级班级学业情况（以班级为单位，最近一次考试中各班级平均分的对比）
	 * 输入：考试科目
	 * 返回：二维数组
	 * */
	/**
	 * 所有班级
	 * [
	 * 	[班级ID，平均分，最高分，最低分]，
	 *  ……
	 * ]
	 * */
	
	public static DatabaseModel database = new DatabaseModel();
    @Override
	public ArrayList<ArrayList<String>> selectALLClassGradeInfo(ArrayList<String> data) {
		
		ArrayList<ArrayList<String>> selectALLClassGradeInfo = new ArrayList<ArrayList<String>>();
		database.connect();
		
		try {
			String sql = "SELECT 班级ID,考试开始时间,AVG(考试成绩) AS 平均分, MAX(考试成绩) AS 最高分, MIN(考试成绩) AS 最低分\r\n"
					+ "					FROM 学生成绩表 AS grade, 学生班级表 AS class\r\n"
					+ "					WHERE grade.学生ID = class.学生ID and grade.学期ID = class.学期ID and 学科ID = ?\r\n"
					+ "					GROUP BY 班级ID, 学科ID, grade.学期ID, 考试类型ID\r\n"
					+ "					order by 考试开始时间 desc, 班级ID\r\n"
					+ "					limit 25";

			ResultSet rs=database.execResult(sql,data);
	
			Integer classid = null;
			Integer avg = null;
			Integer max = null;
			Integer min = null;
		
			while(rs.next()) {
				
				//写入Arraylist数组中
	        	ArrayList<String> onerow = new ArrayList<String>();	// 创建一维数组输入

	        	classid = rs.getInt("班级ID");//获取班级ID
				avg = rs.getInt("平均分");//获取平均分
				max = rs.getInt("最高分");//获取最高分
				min = rs.getInt("最低分");//获取最低分
				
				//将数据类型进行转换
				String classids = Integer.toString(classid);
				String avgs = Integer.toString(avg);
				String maxs = Integer.toString(max);
				String mins = Integer.toString(min);

				//写入数组
        		onerow.add(classids);
        		onerow.add(avgs);
        		onerow.add(maxs);
        		onerow.add(mins);
				
        		selectALLClassGradeInfo.add(onerow);
        		
        	}
        	rs.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return selectALLClassGradeInfo;
	}

}
