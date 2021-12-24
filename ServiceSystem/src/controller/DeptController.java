package controller;
import java.util.ArrayList;

import View.DeptView;
import model.AddStudentInfoBehavior;
import model.AddTeacherInfoBehavior;
import model.CheckStudentAttendanceRecordBehavior;
import model.CheckStudentConsumptionInfoBehavior;
import model.CheckStudentGradeInfoBehavior;
import model.CheckStudentInfoBehavior;
import model.CheckStudentTrackInfoBehavior;
import model.CheckTeacherInfoBehavior;
import model.Dept;
import model.SelectALLAttendanceInfoByTypeBehavior;
import model.SelectALLClassAttendanceInfoBehavior;
import model.SelectALLClassGradeInfoBehavior;
import model.SelectALLStuGradeInfoBehavior;
import model.SelectClassGradeInfoBehavior;
import model.SelectClassStuNameBehavior;

public class DeptController {
	//教务端controller
	
	private Dept dept;
	private DeptView deptview;
	
	public DeptController() {
		
	}
	
	public void setDeptModel(Dept dept) {
		this.dept = dept;
	}
	
	public void setDeptView(DeptView deptview) {
		this.deptview = deptview;
	}
	
	
	
	
	
	public void setCheckStudentInfoBehavior(CheckStudentInfoBehavior checkStudentInfoBehavior) {
		dept.setCheckStudentInfoBehavior(checkStudentInfoBehavior);
	}
	
	
	public void setCheckStudentTrackInfoBehavior(CheckStudentTrackInfoBehavior checkStudentTrackInfoBehavior) {
		dept.setCheckStudentTrackInfoBehavior(checkStudentTrackInfoBehavior);
	}
	
	
	public void setCheckStudentConsumptionInfoBehavior(CheckStudentConsumptionInfoBehavior checkStudentConsumptionInfoBehavior) {
		dept.setCheckStudentConsumptionInfoBehavior(checkStudentConsumptionInfoBehavior);
	}
	
	public void setCheckStudentGradeInfoBehavior(CheckStudentGradeInfoBehavior checkStudentGradeInfoBehavior) {
		dept.setCheckStudentGradeInfoBehavior(checkStudentGradeInfoBehavior);
	}
	
	
	public void setCheckTeacherInfoBehavior(CheckTeacherInfoBehavior checkTeacherInfoBehavior) {
		dept.setCheckTeacherInfoBehavior(checkTeacherInfoBehavior);
	}
	
	public void setCheckStudentAttendanceRecordBehavior(CheckStudentAttendanceRecordBehavior checkStudentAttendanceRecordBehavior) {
		dept.setCheckStudentAttendanceRecordBehavior(checkStudentAttendanceRecordBehavior);
	}
	public void setAddStudentInfoBehavior(AddStudentInfoBehavior addStudentInfoBehavior) {
		dept.setAddStudentInfoBehavior(addStudentInfoBehavior);
	}
	public void setAddTeacherInfoBehavior(AddTeacherInfoBehavior addTeacherInfoBehavior) {
		dept.setAddTeacherInfoBehavior(addTeacherInfoBehavior);
	}
	public void setSelectALLAttendanceInfoByTypeBehavior(SelectALLAttendanceInfoByTypeBehavior selectALLAttendanceInfoByTypeBehavior) {
		dept.setSelectALLAttendanceInfoByTypeBehavior(selectALLAttendanceInfoByTypeBehavior);
	}
	public void setSelectALLClassAttendanceInfoBehavior(SelectALLClassAttendanceInfoBehavior selectALLClassAttendanceInfoBehavior) {
		dept.setSelectALLClassAttendanceInfoBehavior(selectALLClassAttendanceInfoBehavior);
	}
	public void setSelectALLClassGradeInfoBehavior(SelectALLClassGradeInfoBehavior selectALLClassGradeInfoBehavior) {
		dept.setSelectALLClassGradeInfoBehavior(selectALLClassGradeInfoBehavior);
	}
	public void setSelectALLStuGradeInfoBehavior(SelectALLStuGradeInfoBehavior selectALLStuGradeInfoBehavior) {
		dept.setSelectALLStuGradeInfoBehavior(selectALLStuGradeInfoBehavior);
	}
	public void setSelectClassStuNameBehavior(SelectClassStuNameBehavior selectClassStuNameBehavior) {
		dept.setSelectClassStuNameBehavior(selectClassStuNameBehavior);
	}
	public void setSelectClassGradeInfoBehavior(SelectClassGradeInfoBehavior selectClassGradeInfoBehavior) {
		dept.setSelectClassGradeInfoBehavior(selectClassGradeInfoBehavior);
	}
	
	
	
	
//	public ArrayList<String> getInfoView1D(ArrayList<String> data, int choose) {
//		//打印
//		return dept.performDatabaseOperation1D(data, choose);
//	}
//	
//	public ArrayList<ArrayList<String>> getInfoView2D(ArrayList<String> data, int choose) {
//		//打印
//		return dept.performDatabaseOperation2D(data, choose);
//	}
	public ArrayList<String> getAddStudentInfoBehavior(ArrayList<String> data) {
		return dept.performAddStudentInfo(data);
	}
	public ArrayList<String> getAddTeacherInfoBehavior(ArrayList<String> data) {
		return dept.performAddTeacherInfoBehavior(data);
	}
	public ArrayList<ArrayList<String>> getSelectALLAttendanceInfoByTypeBehavior(ArrayList<String> data) {
		System.out.println(data);
		return dept.performSelectALLAttendanceInfoByTypeBehavior(data);
	}
	public ArrayList<ArrayList<String>> getSelectALLClassAttendanceInfoBehavior(ArrayList<String> data) {
		return dept.performSelectALLClassAttendanceInfoBehavior(data);
	}
	public ArrayList<ArrayList<String>> getSelectALLClassGradeInfoBehavior(ArrayList<String> data) {
		return dept.performSelectALLClassGradeInfoBehavior(data);
	}
	public ArrayList<ArrayList<String>> getSelectALLStuGradeInfoBehavior(ArrayList<String> data) {
		return dept.performSelectALLStuGradeInfoBehavior(data);
	}
	public ArrayList<String> getSelectClassStuNameBehavior(ArrayList<String> data) {
		return dept.performSelectClassStuNameBehavior(data);
	}
	public ArrayList<ArrayList<String>> getSelectClassGradeInfoBehavior(ArrayList<String> data) {
		return dept.performSelectClassGradeInfoBehavior(data);
	}
	
	public ArrayList<String> getStudentInfoView(String ID) {
		//打印学生信息
		return dept.performCheckStudentInfo(ID);
	}
	
	public ArrayList<String> getTeacherInfoView(String ID) {
		//查看老师基本信息
		return dept.performCheckTeacherInfo(ID);
	}
	
	public ArrayList<Integer> getCheckStudentAttendanceRecordView(String studentID, String num) {
		//查看学生考勤记录
		int n = Integer.parseInt(num);
		int ID = Integer.parseInt(studentID);
		return dept.performCheckStudentAttendanceRecordInfo(ID, n);
	}
	
	public ArrayList<Integer> getStudentTrackInfoView(String ID, String num) {
		//打印学生成长档案
		int n = Integer.parseInt(num);
		return dept.performCheckStudentTrackInfo(ID, n);
	}
	
	public ArrayList<ArrayList<Integer>> getStudentGradeView(String ID, String num) {
		//打印学生学业画像
		int n = Integer.parseInt(num);
		return dept.performCheckStudentGradeInfo(ID, n);
	}
	
	/*
	public void getTeacherInfoView() {
		//打印学生学业画像
		deptview.printStudentGradeInfo() ;
	}*/
	

}
