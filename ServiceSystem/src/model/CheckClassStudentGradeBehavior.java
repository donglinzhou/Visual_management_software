package model;

import java.util.ArrayList;

public interface CheckClassStudentGradeBehavior {
	//查看班级学生成绩
	
	public ArrayList<ArrayList<Integer>> checkclassstudentgrade(String teacherid, String termid, String time, String examsubjectid);
}
