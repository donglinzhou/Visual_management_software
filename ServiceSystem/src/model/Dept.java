package model;

import java.util.ArrayList;

public class Dept extends Person{
	CheckStudentInfoBehavior checkStudentInfoBehavior;
	CheckStudentTrackInfoBehavior checkStudentTrackInfoBehavior;
	CheckStudentGradeInfoBehavior checkStudentGradeInfoBehavior;
	CheckStudentConsumptionInfoBehavior checkStudentConsumptionInfoBehavior;
	CheckTeacherInfoBehavior checkTeacherInfoBehavior;
	CheckStudentAttendanceRecordBehavior checkStudentAttendanceRecordBehavior;
	AddStudentInfoBehavior addStudentInfoBehavior;
	AddTeacherInfoBehavior addTeacherInfoBehavior;
	SelectALLAttendanceInfoByTypeBehavior selectALLAttendanceInfoByTypeBehavior;
	SelectALLClassAttendanceInfoBehavior selectALLClassAttendanceInfoBehavior;
	SelectALLClassGradeInfoBehavior selectALLClassGradeInfoBehavior;
	SelectALLStuGradeInfoBehavior selectALLStuGradeInfoBehavior;
	SelectClassStuNameBehavior selectClassStuNameBehavior;
	SelectClassGradeInfoBehavior selectClassGradeInfoBehavior;
	//CheckStudentAttendanceRecordBehavior checkStudentAttendanceRecordBehavior;
	
	public void setCheckStudentInfoBehavior(CheckStudentInfoBehavior checkStudentInfoBehavior) {
		this.checkStudentInfoBehavior = checkStudentInfoBehavior;
	}
	
	public void setCheckStudentTrackInfoBehavior(CheckStudentTrackInfoBehavior checkTrackInfoBehavior) {
		this.checkStudentTrackInfoBehavior = checkTrackInfoBehavior;
	}
	
	public void setCheckStudentGradeInfoBehavior(CheckStudentGradeInfoBehavior checkStudentGradeInfoBehavior) {
		this.checkStudentGradeInfoBehavior = checkStudentGradeInfoBehavior;
	}
	
	public void setCheckStudentConsumptionInfoBehavior(CheckStudentConsumptionInfoBehavior checkStudentConsumptionInfoBehavior) {
		this.checkStudentConsumptionInfoBehavior = checkStudentConsumptionInfoBehavior;
	}
	/*
	public void setCheckStudentAttendanceRecordBehavior(CheckStudentAttendanceRecordBehavior checkAttendanceRecordBehavior) {
		this.checkStudentAttendanceRecordBehavior = checkAttendanceRecordBehavior;
	}
	*/
	public void setCheckTeacherInfoBehavior(CheckTeacherInfoBehavior checkTeacherInfoBehavior) {
		this.checkTeacherInfoBehavior = checkTeacherInfoBehavior;
	}
	public void setCheckStudentAttendanceRecordBehavior(CheckStudentAttendanceRecordBehavior checkStudentAttendanceRecordBehavior) {
		this.checkStudentAttendanceRecordBehavior = checkStudentAttendanceRecordBehavior;
	}
	public void setAddStudentInfoBehavior(AddStudentInfoBehavior addStudentInfoBehavior) {
		this.addStudentInfoBehavior = addStudentInfoBehavior;
	}
	public void setAddTeacherInfoBehavior(AddTeacherInfoBehavior addTeacherInfoBehavior) {
		this.addTeacherInfoBehavior = addTeacherInfoBehavior;
	}
	public void setSelectALLAttendanceInfoByTypeBehavior(SelectALLAttendanceInfoByTypeBehavior selectALLAttendanceInfoByTypeBehavior) {
		this.selectALLAttendanceInfoByTypeBehavior = selectALLAttendanceInfoByTypeBehavior;
	}
	public void setSelectALLClassAttendanceInfoBehavior(SelectALLClassAttendanceInfoBehavior selectALLClassAttendanceInfoBehavior) {
		this.selectALLClassAttendanceInfoBehavior = selectALLClassAttendanceInfoBehavior;
	}
	public void setSelectALLClassGradeInfoBehavior(SelectALLClassGradeInfoBehavior selectALLClassGradeInfoBehavior) {
		this.selectALLClassGradeInfoBehavior = selectALLClassGradeInfoBehavior;
	}
	public void setSelectALLStuGradeInfoBehavior(SelectALLStuGradeInfoBehavior selectALLStuGradeInfoBehavior) {
		this.selectALLStuGradeInfoBehavior = selectALLStuGradeInfoBehavior;
	}
	public void setSelectClassStuNameBehavior(SelectClassStuNameBehavior selectClassStuNameBehavior) {
		this.selectClassStuNameBehavior =selectClassStuNameBehavior;
	}
	public void setSelectClassGradeInfoBehavior(SelectClassGradeInfoBehavior selectClassGradeInfoBehavior) {
		this.selectClassGradeInfoBehavior = selectClassGradeInfoBehavior;
	}
	
	
	public ArrayList<String> performAddStudentInfo(ArrayList<String> data) {
		return addStudentInfoBehavior.addStudentInfo(data);
	}
	public ArrayList<String> performAddTeacherInfoBehavior(ArrayList<String> data) {
		return addTeacherInfoBehavior.addTeacherInfo(data);
	}
	public ArrayList<ArrayList<String>> performSelectALLAttendanceInfoByTypeBehavior(ArrayList<String> data) {
		return selectALLAttendanceInfoByTypeBehavior.selectALLAttendanceInfoByType(data);
	}
	public ArrayList<ArrayList<String>> performSelectALLClassAttendanceInfoBehavior(ArrayList<String> data) {
		return selectALLClassAttendanceInfoBehavior.selectALLClassAttendanceInfo(data);
	}
	public ArrayList<ArrayList<String>> performSelectALLClassGradeInfoBehavior(ArrayList<String> data) {
		return selectALLClassGradeInfoBehavior.selectALLClassGradeInfo(data);
	}
	public ArrayList<ArrayList<String>> performSelectALLStuGradeInfoBehavior(ArrayList<String> data) {
		return selectALLStuGradeInfoBehavior.selectALLStuGradeInfo(data);
	}
	public ArrayList<String> performSelectClassStuNameBehavior(ArrayList<String> data) {
		return selectClassStuNameBehavior.selectClassStuName(data);
	}
	public ArrayList<ArrayList<String>> performSelectClassGradeInfoBehavior(ArrayList<String> data) {
		return selectClassGradeInfoBehavior.selectClassGradeInfo(data);
	}
//	public ArrayList<String> performDatabaseOperation1D(ArrayList<String> data, int choose){
//    	return DatabaseOperation1D.databaseOperation1D(data, choose);
//    }
//	
//	public ArrayList<ArrayList<String>> performDatabaseOperation2D(ArrayList<String> data, int choose){
//    	return DatabaseOperation2D.databaseOperation2D(data, choose);
//    }
//	
	
	public ArrayList<String> performCheckStudentInfo(String ID) {
		//查看学生基本信息
		return checkStudentInfoBehavior.checkStudentInfo(ID);
	}
	
	public ArrayList<Integer> performCheckStudentTrackInfo(String ID, int n) {
		//查看成长档案
		return checkStudentTrackInfoBehavior.checkStudentTrackInfo(ID,n);
	}
	
	public ArrayList<ArrayList<Integer>> performCheckStudentGradeInfo(String ID, int n) {
		//查看学业画像
		return checkStudentGradeInfoBehavior.checkStudentGradeInfo(ID,n);
	}
	
	public ArrayList<Double> performCheckStudentConsumptionInfo(String ID, int n) {
		//查看消费情况
		return checkStudentConsumptionInfoBehavior.checkStudentConsumptionInfo(ID,n);
	}
	
	public ArrayList<String> performCheckTeacherInfo(String ID) {
		//查看教师基本信息
		return checkTeacherInfoBehavior.checkteacherinfo(ID);
	}
	public ArrayList<Integer> performCheckStudentAttendanceRecordInfo(int studentID, int n) {
		//查看教师基本信息
		return checkStudentAttendanceRecordBehavior.checkStudentAttendanceRecord(studentID,n);
	}
	
	
	
	/*
	public ArrayList<Integer> performCheckStudentAttendanceRecord(int studentID, int n) {
		//查看出勤情况
		return checkStudentAttendanceRecordBehavior.checkStudentAttendanceRecord(studentID, n);
		*/
	

}
