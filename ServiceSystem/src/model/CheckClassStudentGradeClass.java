package model;

import java.util.ArrayList;

public class CheckClassStudentGradeClass implements CheckClassStudentGradeBehavior {

	@Override
	public ArrayList<ArrayList<String>> checkclassstudentgrade(String teacherid, String examtime, String examtype) {
		// TODO 自动生成的方法存根
		//查看班级学生成绩?查看什么成绩？总成绩？单科成绩？
		//按理说查看的是总成绩，但实现起来好麻烦，不想搞
		//总之传入的是教师ID，考试时间，考试类型（这是查总成绩的参数）
		//实际上功能有点重叠
		ArrayList<ArrayList<String>> checkclassstudentgrade = new ArrayList<ArrayList<String>>();
		return checkclassstudentgrade;
	}

}
