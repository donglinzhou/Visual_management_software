package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SelectStudentSubject implements DatabaseOperation{
	/**
	 * 学生ID、主修学科ID、次修学科ID1、次修学科ID2
	 * */
	
	
	
	public static DatabaseModel database = new DatabaseModel();

	public ArrayList<ArrayList<String>> selectStudentSubject(ArrayList<String> data) {
		
		
		
		ArrayList<ArrayList<String>> selectStudentSubjectList = new ArrayList<ArrayList<String>>();
		database.connect();
		
		try {
			String sql = "SELECT * FROM 学生六选三表  WHERE 学生ID = ?";
			ResultSet rs=database.execResult(sql,data);
	
			
			
			Integer stuInt = null;//学生ID
			Integer mainSubjectId = null;//主修学科ID
			Integer Id1 = null;//次修学科ID1
			Integer Id2 = null;//次修学科ID2
			
			
			
			
			
			while(rs.next()) {
				
				//写入Arraylist数组中
	        	ArrayList<String> onerow = new ArrayList<String>();	// 创建一维数组输入
				
	        	stuInt = rs.getInt("学生ID");//获取学生ID
	        	mainSubjectId = rs.getInt("主修学科ID");//获取主修学科ID
	        	Id1 = rs.getInt("次修学科ID1");//获取次修学科ID1
	        	Id2 = rs.getInt("次修学科ID2");//获取次修学科ID2
	        	
				
				
        		
				//将数据类型进行转换
				String stu = Integer.toString(stuInt);
				String mainSubjectIdstr = Integer.toString(mainSubjectId);
				String Id1str = Integer.toString(Id1);
				String Id2str = Integer.toString(Id2);
				
				//写入数组
				onerow.add(stu);
        		onerow.add(mainSubjectIdstr);
        		onerow.add(Id1str);
        		onerow.add(Id2str);
        	
				
        		selectStudentSubjectList.add(onerow);
        		
        		
        	}
        	rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return selectStudentSubjectList;
	}

	@Override
	public ArrayList<ArrayList<String>> databaseOperation(ArrayList<String> data, int choose) {
		// TODO Auto-generated method stub
		
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		
		switch(choose) {
		case 1:
			result = selectStudentSubject(data);
			break;
		default:
			System.out.println("ERROR!");
		}
		return result;
	}

}
