package Controller;
<<<<<<< HEAD
import model.CheckClassHistoryGradeListBehavior;
import model.CheckClassMemberListBehavior;
import model.CheckClassStudentGradeBehavior;
import model.CheckClassStudentSubjectHistoryListBehavior;
import model.CheckClassedListBehavior;
import model.CheckTeacherInfoBehavior;
import model.Teachers;

=======
import java.util.ArrayList;

import View.*;
import model.*;
>>>>>>> 408f01557a212803392a6fde5c7b35e7b8cd5c8b
public class TeacherController {
	private Teachers teachers;
	public TeacherController() {	
	}
	
	public void setTeachersModel(Teachers teachers) {
		this.teachers=teachers;
	}
<<<<<<< HEAD
	   
	/*整合时加入
	public void getStudentInfoView() {
		//打印学生的基本信息
		teachersView.printStudentInfo(teachers.performCheckStudentInfo());
	}
=======
	
	public void setTeachersView(TeachersView teachersView) {
		this.teachersView = teachersView;
	}    
>>>>>>> 408f01557a212803392a6fde5c7b35e7b8cd5c8b
	
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
	
<<<<<<< HEAD
	public void getClassListView() {
		//打印任课班级名单
		Teachers person = new Teachers();
		int id = person.getId();
		String teacherid = Integer.toString(id);
		//teachersView.printClassList(teachers.performCheckClassedList(teacherid));
	}
	
	public void getClassHistoryGradeView() {
		//打印班级历史总成绩排名表
		//teachersView.printClassHistoryGrade(teachers.performCheckClassHistoryGradeList());
=======
	public ArrayList<Integer> getStudentTrackInfoView(String ID, String num) {
		//查看学生成长档案
		int n = Integer.parseInt(num);
		System.out.println(teachers.performCheckStudentTrackInfo(ID, n));
		return teachers.performCheckStudentTrackInfo(ID, n);
	}
	
	
	public ArrayList<String> getClassListView(String teacherid) {
		//打印任课班级名单
		return teachers.performCheckClassedList(teacherid);
>>>>>>> 408f01557a212803392a6fde5c7b35e7b8cd5c8b
	}
	
	public ArrayList<String> getClassMemberListView(String teacherid) {
		//打印班级学生名单
<<<<<<< HEAD
		Teachers person = new Teachers();
		int id = person.getId();
		String teacherid = Integer.toString(id);
=======
		return teachers.performCheckClassMemberList(teacherid);
	}
	
	public ArrayList<ArrayList<Integer>> getClassStudentGradeView(String teacherid, String termid, String time, String examsubjectid) {
		//打印班级学生成绩
		return teachers.performCheckClassStudentGrade(teacherid, termid, time, examsubjectid);
>>>>>>> 408f01557a212803392a6fde5c7b35e7b8cd5c8b
	}

    
<<<<<<< HEAD

	
	public void getTeacherInfoView() {
		//打印老师基本信息
		Teachers person = new Teachers();
		int id = person.getId();
		String teacherid = Integer.toString(id);
=======
	public ArrayList<String> getTeacherInfoView(String teacherid) {
		//打印老师基本信息
		return teachers.performCheckTeacherInfo(teacherid);
>>>>>>> 408f01557a212803392a6fde5c7b35e7b8cd5c8b
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
