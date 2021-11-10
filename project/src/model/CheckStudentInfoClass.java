package model;

import java.util.ArrayList;
import java.util.Vector;

public class CheckStudentInfoClass implements CheckStudentInfoBehavior {

	@Override
	public ArrayList<String> checkStudentInfo() {
		// TODO 自动生成的方法存根
		//需要查看：姓名，年龄，性别，入学年份、政治面貌、班主任姓名
		System.out.println("查看学生个人信息");
//		Vector<String> info=new Vector<String>();
//		info.add("张三");
//		info.add("18");
//		info.add("2019");
//		info.add("团员");
//		info.add("王五");
//		return info;
//		
		ArrayList<String> studentInfo = new ArrayList<String>();
		studentInfo.add("张三");
		studentInfo.add("18");
		studentInfo.add("2019");
		studentInfo.add("团员");
		studentInfo.add("王五");
		return studentInfo;
		
	}

}
