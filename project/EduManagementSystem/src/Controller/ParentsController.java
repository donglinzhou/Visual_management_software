package Controller;
import model.*;

import java.util.Vector;

import View.*;

public class ParentsController {
	private Parents parents;
	private ParentsView parentsView;
	
	
	public ParentsController(){
	}
	
	public void setParentsModel(Parents parents) {
		this.parents=parents;
	}
	
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
	
	public void getStudentAttendanceRecordView() {
		//打印考勤记录
		parentsView.printStudentAttendanceRecord();
	}
	
	public void getStudentTrackInfoView() {
		//打印成长档案
		parentsView.printStudentTrackInfo();
	}
	
	/*动态设置Parents类中的行为对象:对修改开放*/
	public void setParentsCheckStudentInfoBehavior(CheckStudentInfoBehavior checkStudentInfoBehavior) {
		parents.setCheckStudentInfoBehavior(checkStudentInfoBehavior);
	}
	
	public void setParentsCheckStudentTrackInfoBehavior(CheckStudentTrackInfoBehavior checkTrackInfoBehavior) {
		parents.setCheckStudentTrackInfoBehavior(checkTrackInfoBehavior);
	}
	
	public void setParentsCheckStudentGradeInfoBehavior(CheckStudentGradeInfoBehavior checkStudentGradeInfoBehavior) {
		parents.setCheckStudentGradeInfoBehavior(checkStudentGradeInfoBehavior);
	}
	
	public void setParentsCheckStudentConsumptionInfoBehavior(CheckStudentConsumptionInfoBehavior checkStudentConsumptionInfoBehavior) {
		parents.setCheckStudentConsumptionInfoBehavior(checkStudentConsumptionInfoBehavior);
	}
	
	public void setParentsCheckStudentAttendanceRecordBehavior(CheckStudentAttendanceRecordBehavior checkAttendanceRecordBehavior) {
		parents.setCheckStudentAttendanceRecordBehavior(checkAttendanceRecordBehavior);
	}
	
	public void setParentsAddStudentInfoBehavior(AddStudentInfoBehavior addStudentInfoBehavior) {
		parents.setAddStudentInfoBehavior(addStudentInfoBehavior);
	}
}