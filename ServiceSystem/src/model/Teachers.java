package model;

import java.util.ArrayList;

public class Teachers extends Person{
	
	//声明接口
	CheckClassedListBehavior checkClassedListBehavior;
    CheckClassMemberListBehavior checkClassMemberListBehavior;
    CheckClassStudentGradeBehavior checkClassStudentGradeBehavior;
    CheckTeacherInfoBehavior checkTeacherInfoBehavior;
    
    //调用方法
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
    

}
