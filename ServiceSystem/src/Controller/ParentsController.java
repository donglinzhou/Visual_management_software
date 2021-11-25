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
		//��ӡѧ���Ļ�����Ϣ
		parentsView.printStudentInfo(parents.performCheckStudentInfo());
	}
	
	public void getStudentGradeInfoView() {
		//��ӡѧ��ѧҵ��Ϣ
		
		parentsView.printStudentGradeInfo(parents.performCheckStudentGradeInfo());
	}
	
	/*public void getStudentAttendanceRecordView() {
		//��ӡ���ڼ�¼
		parentsView.printStudentAttendanceRecord();
	}
	
	public void getStudentTrackInfoView() {
		//��ӡ�ɳ�����
		parentsView.printStudentTrackInfo();
	}*/
	
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
	
	public void setParentsAddStudentInfoBehavior(AddStudentInfoBehavior addStudentInfoBehavior) {
		parents.setAddStudentInfoBehavior(addStudentInfoBehavior);
	}
}