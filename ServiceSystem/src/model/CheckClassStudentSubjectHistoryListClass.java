package model;

import java.util.ArrayList;

public class CheckClassStudentSubjectHistoryListClass implements CheckClassStudentSubjectHistoryListBehavior {

	@Override
	public ArrayList<ArrayList<String>> checkclassstudentsubjecthistorygradeList(String teacherid, String subjectid, String examtime, String examtype) {
		// TODO 自动生成的方法存根
		//班级内部学生各个科目的历史成绩排名表
		//这个功能我想宣布直接与产看学生历史总成绩重复，但不被允许
		//就先传四个参数，教师ID，考试时间，考试科目，考试类型。
		ArrayList<ArrayList<String>> checkclassstudentsubjecthistorygradeList = new ArrayList<ArrayList<String>>();
		
		return checkclassstudentsubjecthistorygradeList;
	}

}
