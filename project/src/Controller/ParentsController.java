package Controller;
import model.*;

import java.util.Vector;

import View.*;

public class ParentsController {
	private Parents parents;
	private ParentsView parentsView;
	
	public ParentsController(){
	}
	//初始化parents类
	public void setParentsModel(Parents parents) {
		this.parents=parents;
	}
	//初始化parentsView视图
	public void setParentsView(ParentsView parentsView) {
		this.parentsView=parentsView;
	}
	
	public void getStudentInfoView() {
		//打印学生的基本信息
		parentsView.printStudentInfo(parents.performCheckStudentInfo());
	}
	
	public void getStudentGradeInfoView() {
		//打印学生学业信息
		parentsView.printStudentGradeInfo(parents.performCheckStudentGradeInfo());
	}
	
	//--------DL-----------//
	public void getStudentAttendanceRecordView() {
		//打印考勤记录
		parentsView.printStudentAttendanceRecord(parents.performCheckStudentAttendanceRecord());
		System.out.println("");
	}
	
	public void getStudentTrackInfoView() {
		//打印成长档案
		parentsView.printStudentTrackInfo(parents.performCheckStudentTrackInfo());
		System.out.println("");
	}
	
	
	/*动态设置Parents类中的行为对象:对修改开放*/
	public void setParentsCheckStudentInfoBehavior(CheckStudentInfoBehavior checkStudentInfoBehavior) {
		parents.setCheckStudentInfoBehavior(checkStudentInfoBehavior);
	}//学生基本信息
	
	public void setParentsCheckStudentGradeInfoBehavior(CheckStudentGradeInfoBehavior checkStudentGradeInfoBehavior) {
		parents.setCheckStudentGradeInfoBehavior(checkStudentGradeInfoBehavior);
	}
	
	public void setParentsCheckStudentConsumptionInfoBehavior(CheckStudentConsumptionInfoBehavior checkStudentConsumptionInfoBehavior) {
		parents.setCheckStudentConsumptionInfoBehavior(checkStudentConsumptionInfoBehavior);
	}
	
	//--------DL---------//
	public void setParentsCheckStudentTrackInfoBehavior(CheckStudentTrackInfoBehavior checkTrackInfoBehavior) {
		parents.setCheckStudentTrackInfoBehavior(checkTrackInfoBehavior);
	}//成长档案
	
	public void setParentsCheckStudentAttendanceRecordBehavior(CheckStudentAttendanceRecordBehavior checkAttendanceRecordBehavior) {
		parents.setCheckStudentAttendanceRecordBehavior(checkAttendanceRecordBehavior);
	}//考勤记录
	
	public void setParentsAddStudentInfoBehavior(AddStudentInfoBehavior addStudentInfoBehavior) {
		parents.setAddStudentInfoBehavior(addStudentInfoBehavior);
	}//增加信息
}
