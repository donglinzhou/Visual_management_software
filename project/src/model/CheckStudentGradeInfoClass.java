package model;

import java.util.ArrayList;

public class CheckStudentGradeInfoClass implements CheckStudentGradeInfoBehavior {

	@Override
	public ArrayList<ArrayList<String>> checkStudentGradeInfo() {
		// TODO 自动生成的方法存根
		System.out.println("查看学生成绩信息");
		
		ArrayList<ArrayList<String>> gradeInfo = new ArrayList<ArrayList<String>>();
		ArrayList<String> ss=new ArrayList<String>();
		ArrayList<String> ss1=new ArrayList<String>();
		ss.add("1");
		ss.add("5");
		ss.add("6");
		gradeInfo.add(ss);
		ss1.add("8");
		ss1.add("7");
		gradeInfo.add(ss1);
		return gradeInfo;

	}

}
