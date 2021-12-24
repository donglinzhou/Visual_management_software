package controller;

import java.util.ArrayList;

import model.CheckStudentAttendanceRecordBehavior;
import model.CheckStudentConsumptionInfoBehavior;
import model.CheckStudentGradeInfoBehavior;
import model.CheckStudentInfoBehavior;
import model.CheckStudentTrackInfoBehavior;
import model.Parents;

public class ParentsController {
	private Parents parents;
	
	public ParentsController() {
	}
	
	public void setParentsModel(Parents parents) {
		this.parents=parents;
	}
	
	public ArrayList<String> getStudentInfoView(String ID) {
		//��ӡѧ���Ļ�����Ϣ
		return parents.performCheckStudentInfo(ID);
	}
	
	public ArrayList<ArrayList<Integer>> getStudentGradeInfoView(String ID, String num) {
		//��ӡѧ��ѧҵ��Ϣ
		int n = Integer.parseInt(num);
		return parents.performCheckStudentGradeInfo(ID, n);
	}
	
	public ArrayList<Integer> getStudentAttendanceRecordView(String ID, String num) {
		//��ӡ���ڼ�¼
		int n = Integer.parseInt(num);
		int studentID = Integer.parseInt(ID);
		return parents.performCheckStudentAttendanceRecord(studentID, n);
	}
	
	public ArrayList<Integer> getStudentTrackInfoView(String ID, String num) {
		//��ӡ�ɳ�����
		int n = Integer.parseInt(num);
		return parents.performCheckStudentTrackInfo(ID, n);
	}
	
	public ArrayList<Double> getStudentConsumptionInfoView(String ID, String num) {
		//��ӡ�ɳ�����
		int n = Integer.parseInt(num);
		return parents.performCheckStudentConsumptionInfo(ID, n);
	}
	
	/*��̬����Parents���е���Ϊ����:���޸Ŀ���*/
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
