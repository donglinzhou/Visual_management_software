package Controller;
import model.*;

import java.util.ArrayList;
import java.util.Vector;

import View.*;

public class ParentsController {
	private Parents parents;
	
	public ParentsController(){
	}
	
	public void setParentsModel(Parents parents) {
		this.parents=parents;
	}
	
	public ArrayList<String> getStudentInfoView(String ID) {
		//打印学生的基本信息
		return parents.performCheckStudentInfo(ID);
	}
	
	public ArrayList<ArrayList<Integer>> getStudentGradeInfoView(String ID, String num) {
		//打印学生学业信息
		int n = Integer.parseInt(num);
		return parents.performCheckStudentGradeInfo(ID, n);
	}
	
	public ArrayList<Integer> getStudentAttendanceRecordView(String ID, String num) {
		//打印考勤记录
		int n = Integer.parseInt(num);
		int studentID = Integer.parseInt(ID);
		return parents.performCheckStudentAttendanceRecord(studentID, n);
	}
	
	public ArrayList<Integer> getStudentTrackInfoView(String ID, String num) {
		//打印成长档案
		int n = Integer.parseInt(num);
		return parents.performCheckStudentTrackInfo(ID, n);
	}
	
	public ArrayList<Double> getStudentConsumptionInfoView(String ID, String num) {
		//打印成长档案
		int n = Integer.parseInt(num);
		return parents.performCheckStudentConsumptionInfo(ID, n);
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
	

}