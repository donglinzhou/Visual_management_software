package model;

import java.util.ArrayList;

public class Teachers extends Person{
	
	/*查询学生信息部分，整合时加入
	CheckStudentInfoBehavior checkStudentInfoBehavior;
	CheckStudentTrackInfoBehavior checkStudentTrackInfoBehavior;
	CheckStudentGradeInfoBehavior checkStudentGradeInfoBehavior;
	CheckStudentConsumptionInfoBehavior checkStudentConsumptionInfoBehavior;
	CheckStudentAttendanceRecordBehavior checkStudentAttendanceRecordBehavior;
	*/
	
	CheckClassedListBehavior checkClassedListBehavior;
	CheckClassHistoryGradeListBehavior checkClassHistoryGradeListBehavior;
    CheckClassMemberListBehavior checkClassMemberListBehavior;
    CheckClassStudentGradeBehavior checkClassStudentGradeBehavior;
    CheckClassStudentSubjectHistoryListBehavior checkClassStudentSubjectHistoryListBehavior;
    CheckTeacherInfoBehavior checkTeacherInfoBehavior;
    
    public ArrayList<String> performCheckClassedList(String teacherid){
    	return checkClassedListBehavior.checkclassedlist(teacherid);
    }
    
    public ArrayList<ArrayList<String>> performCheckClassHistoryGradeList(){
    	return checkClassHistoryGradeListBehavior.checkclasshistorygradeList(null, null, null);
    }
    
    public ArrayList<String> performCheckClassMemberList(String teacherid){
    	return checkClassMemberListBehavior.checkclassmemberlist(teacherid);
    }
    
    public ArrayList<ArrayList<String>> performCheckClassStudentGrade(){
    	return checkClassStudentGradeBehavior.checkclassstudentgrade(null, null, null);
    }
    
    public ArrayList<ArrayList<String>> performCheckClassStudentSubjectHistoryList(){
    	return checkClassStudentSubjectHistoryListBehavior.checkclassstudentsubjecthistorygradeList(null, null, null, null);
    }
    
    public ArrayList<ArrayList<String>> performCheckTeacherInfo(String teacherid){
    	return checkTeacherInfoBehavior.checkteacherinfo(teacherid);
    }
    
    //this
    public void setCheckClassedListBehavior(CheckClassedListBehavior checkClassedListBehavior) {
    	this.checkClassedListBehavior = checkClassedListBehavior;
    }
    
    public void setCheckClassHistoryGradeListBehavior(CheckClassHistoryGradeListBehavior checkClassHistoryGradeListBehavior) {
    	this.checkClassHistoryGradeListBehavior = checkClassHistoryGradeListBehavior;
    }
    
    public void setCheckClassMemberListBehavior(CheckClassMemberListBehavior checkClassMemberListBehavior) {
    	this.checkClassMemberListBehavior = checkClassMemberListBehavior;
    }
    
    public void setCheckClassStudentGradeBehavior(CheckClassStudentGradeBehavior checkClassStudentGradeBehavior) {
    	this.checkClassStudentGradeBehavior = checkClassStudentGradeBehavior;
    }
    
    public void setCheckClassStudentSubjectHistoryListBehavior(CheckClassStudentSubjectHistoryListBehavior checkClassStudentSubjectHistoryListBehavior) {
    	this.checkClassStudentSubjectHistoryListBehavior = checkClassStudentSubjectHistoryListBehavior;
    }
    
    public void setCheckTeacherInfoBehavior( CheckTeacherInfoBehavior checkTeacherInfoBehavior) {
    	this.checkTeacherInfoBehavior = checkTeacherInfoBehavior;
    }
    
    /*查询学生信息部分，整合时加入
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
	
	public void setAddStudentInfoBehavior(AddStudentInfoBehavior addStudentInfoBehavior) {
		this.addStudentInfoBehavior = addStudentInfoBehavior;
	}
    */
}
