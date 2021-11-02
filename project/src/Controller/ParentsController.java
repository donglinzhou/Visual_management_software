package Controller;
import model.*;
import View.*;

public class ParentsController {
	private Parents parents;
	private ParentsView parentsView;
	
	public ParentsController(Parents parents,ParentsView parentsView) {
		this.parents=parents;
		this.parentsView=parentsView;
	}
	
	public void getStudentInfoView() {
		//打印学生的基本信息
		parentsView.printStudentInfo();
	}
	
	public void getStudentGradeInfoView() {
		//打印学生学业信息
		parentsView.printStudentGradeInfo();
	}
	
	private void getStudentConsumptionInfoView() {
		//打印学生消费信息
		parentsView.printStudentConsumptionInfo();
	}
	
	public void getAttendanceRecordView() {
		//打印考勤记录
		parentsView.printAttendanceRecord();
	}
	
	public void getTrackInfoView() {
		//打印成长档案
		parentsView.printTrackInfo();
	}
	
	public void setInfo() {
		//增加信息
		parents.addInfo();
	}
}
