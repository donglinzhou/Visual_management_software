package View;

import java.util.ArrayList;

public class TeachersView {
	/*问题在于最后需要传输的数据-参数需要改变*/
	public void printStudentInfo(ArrayList<String> studentInfo) {
		//打印学生的基本信息
		System.out.println(studentInfo);
	}
	
	public void printStudentGradeInfo(ArrayList<ArrayList<String>> gradeInfo) {
		//打印学生学业信息
		System.out.println(gradeInfo);
		
	}
	
	public void printStudentConsumptionInfo() {
		//打印学生消费信息
	}
	
	public void printStudentAttendanceRecord() {
		//打印考勤记录
	}
	
	public void printStudentTrackInfo() {
		//打印成长档案
	}

	
	
	public void printClassList(ArrayList<String> classList) {
		//打印任课班级名单
	}
	
	public void printClassHistoryGrade(ArrayList<ArrayList<String>> classHistoryGrade) {
		//打印班级历史总成绩排名表
	}
	
	public void printClassMemberList(ArrayList<String> classMemberList) {
		//打印班级学生名单
		System.out.println(classMemberList);
	}
	
	public void printClassStudentGrade(ArrayList<ArrayList<String>> classStudentGrade) {
		//打印班级学生成绩
	}
	
	public void printClassStudentSubjectHistoryList(ArrayList<ArrayList<String>> classStudentSubjectHistoryList) {
		//打印班级内部学生各个科目的历史成绩排名表
	}
	
	public void printTeacherInfo(ArrayList<ArrayList<String>> teacherInfo) {
		//打印老师基本信息
		System.out.println(teacherInfo);
		
	}
}
