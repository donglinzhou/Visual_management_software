package model;

import java.util.ArrayList;

public interface CheckClassStudentGradeBehavior {
	//查看班级学生成绩
	
	public ArrayList<ArrayList<String>> checkclassstudentgrade(String teacherid, String examtime, String examtype);
}
