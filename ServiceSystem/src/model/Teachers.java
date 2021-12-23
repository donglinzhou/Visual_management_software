package model;

import java.util.ArrayList;

public class Teachers extends Person{
	
	//声明接口
	//学生端接口
	CheckStudentInfoBehavior checkStudentInfoBehavior;
	CheckStudentTrackInfoBehavior checkStudentTrackInfoBehavior;
	CheckStudentGradeInfoBehavior checkStudentGradeInfoBehavior;
	CheckStudentAttendanceRecordBehavior checkStudentAttendanceRecordBehavior;
	//教师端接口
	CheckClassedListBehavior checkClassedListBehavior;
    CheckClassMemberListBehavior checkClassMemberListBehavior;
    CheckClassStudentGradeBehavior checkClassStudentGradeBehavior;
    CheckTeacherInfoBehavior checkTeacherInfoBehavior;
       
    //调用方法
    public ArrayList<String> performCheckStudentInfo(String ID) {
    	//打印学生基本信息
		return checkStudentInfoBehavior.checkStudentInfo(ID);
	}
	
	public ArrayList<Integer> performCheckStudentTrackInfo(String ID, int n) {
		//打印学生成长档案
		return checkStudentTrackInfoBehavior.checkStudentTrackInfo(ID,n);
	}
	
	public ArrayList<ArrayList<Integer>> performCheckStudentGradeInfo(String ID, int n) {
		//打印学生学业信息
		return checkStudentGradeInfoBehavior.checkStudentGradeInfo(ID,n);
	}	
	
	public ArrayList<Integer> performCheckStudentAttendanceRecord(int studentID, int n) {
		//打印学生考勤记录
		return checkStudentAttendanceRecordBehavior.checkStudentAttendanceRecord(studentID, n);
		
	}
    
    
    public ArrayList<String> performCheckClassedList(String teacherid){
    	//打印任课班级名单
    	return checkClassedListBehavior.checkclassedlist(teacherid);
    }    
    
    public ArrayList<String> performCheckClassMemberList(String teacherid){
    	//打印班级学生名单
    	return checkClassMemberListBehavior.checkclassmemberlist(teacherid);
    }
    
    public ArrayList<ArrayList<Integer>> performCheckClassStudentGrade(String teacherid, String termid, String time, String examsubjectid){
    	//打印班级学生成绩
    	return checkClassStudentGradeBehavior.checkclassstudentgrade(teacherid, termid, time, examsubjectid);
    }   
    
    public ArrayList<String> performCheckTeacherInfo(String teacherid){
    	//打印老师基本信息
    	return checkTeacherInfoBehavior.checkteacherinfo(teacherid);
    }
    
    //设置接口
    public void setCheckClassedListBehavior(CheckClassedListBehavior checkClassedListBehavior) {
    	this.checkClassedListBehavior = checkClassedListBehavior;
    }

    public void setCheckClassMemberListBehavior(CheckClassMemberListBehavior checkClassMemberListBehavior) {
    	this.checkClassMemberListBehavior = checkClassMemberListBehavior;
    }
    
    public void setCheckClassStudentGradeBehavior(CheckClassStudentGradeBehavior checkClassStudentGradeBehavior) {
    	this.checkClassStudentGradeBehavior = checkClassStudentGradeBehavior;
    }
    
    public void setCheckTeacherInfoBehavior( CheckTeacherInfoBehavior checkTeacherInfoBehavior) {
    	this.checkTeacherInfoBehavior = checkTeacherInfoBehavior;
    }
    
    //学生端接口
    public void setCheckStudentInfoBehavior(CheckStudentInfoBehavior checkStudentInfoBehavior) {
		this.checkStudentInfoBehavior = checkStudentInfoBehavior;
	}
	
	public void setCheckStudentTrackInfoBehavior(CheckStudentTrackInfoBehavior checkTrackInfoBehavior) {
		this.checkStudentTrackInfoBehavior = checkTrackInfoBehavior;
	}
	
	public void setCheckStudentGradeInfoBehavior(CheckStudentGradeInfoBehavior checkStudentGradeInfoBehavior) {
		this.checkStudentGradeInfoBehavior = checkStudentGradeInfoBehavior;
	}	
	
	public void setCheckStudentAttendanceRecordBehavior(CheckStudentAttendanceRecordBehavior checkAttendanceRecordBehavior) {
		this.checkStudentAttendanceRecordBehavior = checkAttendanceRecordBehavior;
	}	

}
