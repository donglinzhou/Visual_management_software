package controller;
import java.util.ArrayList;

import View.TeachersView;
import model.CheckClassMemberListBehavior;
import model.CheckClassStudentGradeBehavior;
import model.CheckClassedListBehavior;
import model.CheckStudentAttendanceRecordBehavior;
import model.CheckStudentGradeInfoBehavior;
import model.CheckStudentInfoBehavior;
import model.CheckStudentTrackInfoBehavior;
import model.CheckTeacherInfoBehavior;
import model.Teachers;
public class TeacherController {
	private Teachers teachers;
	private TeachersView teachersView;
	public TeacherController() {	
	}
	
	public void setTeachersModel(Teachers teachers) {
		this.teachers=teachers;
	}
	
	public void setTeachersView(TeachersView teachersView) {
		this.teachersView = teachersView;
	}    
	
	public ArrayList<String> getStudentInfoView(String ID) {
		//查看学生基本信息
		return teachers.performCheckStudentInfo(ID);
	}
	
	public ArrayList<ArrayList<Integer>> getStudentGradeInfoView(String ID, String num) {
		//查看学生学业信息
		int n = Integer.parseInt(num);
		return teachers.performCheckStudentGradeInfo(ID, n);
	}
	
	public ArrayList<Integer> getStudentAttendanceRecordView(String ID, String num) {
		//查看学生考勤记录
		int n = Integer.parseInt(num);
		int studentID = Integer.parseInt(ID);
		return teachers.performCheckStudentAttendanceRecord(studentID, n);
	}
	
	public ArrayList<Integer> getStudentTrackInfoView(String ID, String num) {
		//查看学生成长档案
		int n = Integer.parseInt(num);
		System.out.println(teachers.performCheckStudentTrackInfo(ID, n));
		return teachers.performCheckStudentTrackInfo(ID, n);
	}
	
	
	public ArrayList<String> getClassListView(String teacherid) {
		//打印任课班级名单
		return teachers.performCheckClassedList(teacherid);
	}
	
	public ArrayList<String> getClassMemberListView(String teacherid) {
		//打印班级学生名单
		return teachers.performCheckClassMemberList(teacherid);
	}
	
	public ArrayList<ArrayList<Integer>> getClassStudentGradeView(String teacherid, String termid, String time, String examsubjectid) {
		//打印班级学生成绩
		return teachers.performCheckClassStudentGrade(teacherid, termid, time, examsubjectid);
	}
    
	public ArrayList<String> getTeacherInfoView(String teacherid) {
		//打印老师基本信息
		return teachers.performCheckTeacherInfo(teacherid);
	}
	
	
	/*动态设置Teachers类中的行为对象:对修改开放*/
	public void setTeachersCheckClassedListBehavior(CheckClassedListBehavior checkClassedListBehavior) {
		teachers.setCheckClassedListBehavior(checkClassedListBehavior);
	}
	
	public void setTeachersCheckClassMemberListBehavior(CheckClassMemberListBehavior checkClassMemberListBehavior) {
		teachers.setCheckClassMemberListBehavior(checkClassMemberListBehavior);
	}
	
	public void setTeachersCheckClassStudentGradeBehavior(CheckClassStudentGradeBehavior checkClassStudentGradeBehavior) {
		teachers.setCheckClassStudentGradeBehavior(checkClassStudentGradeBehavior);
	}
	
	public void setTeachersCheckTeacherInfoBehavior(CheckTeacherInfoBehavior checkTeacherInfoBehavior) {
		teachers.setCheckTeacherInfoBehavior(checkTeacherInfoBehavior);
	}
	
	//老师查看学生信息
	public void setTeachersCheckStudentInfoBehavior(CheckStudentInfoBehavior checkStudentInfoBehavior) {
		teachers.setCheckStudentInfoBehavior(checkStudentInfoBehavior);
	}
	
	public void setTeachersCheckStudentTrackInfoBehavior(CheckStudentTrackInfoBehavior checkTrackInfoBehavior) {
		teachers.setCheckStudentTrackInfoBehavior(checkTrackInfoBehavior);		
	}
	
	public void setTeachersCheckStudentGradeInfoBehavior(CheckStudentGradeInfoBehavior checkStudentGradeInfoBehavior) {
		teachers.setCheckStudentGradeInfoBehavior(checkStudentGradeInfoBehavior);
	}	
	
	public void setTeachersCheckStudentAttendanceRecordBehavior(CheckStudentAttendanceRecordBehavior checkAttendanceRecordBehavior) {
		teachers.setCheckStudentAttendanceRecordBehavior(checkAttendanceRecordBehavior);
	}		
	
}
