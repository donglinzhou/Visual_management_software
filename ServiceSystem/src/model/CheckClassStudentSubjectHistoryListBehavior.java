package model;

import java.util.ArrayList;

public interface CheckClassStudentSubjectHistoryListBehavior {
	//班级内部学生各个科目的历史成绩排名表
	
	public ArrayList<ArrayList<String>> checkclassstudentsubjecthistorygradeList(String teacherid, String subjectid, String examtime, String examtype);
}
