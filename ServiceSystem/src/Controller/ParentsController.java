package Controller;
import model.*;

import java.util.Vector;

public class ParentsController {
	private Parents parents;

	
	public ParentsController(){
	}
	
	public void setParentsModel(Parents parents) {
		this.parents=parents;
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
	
	public void setParentsAddStudentInfoBehavior(AddStudentInfoBehavior addStudentInfoBehavior) {
		parents.setAddStudentInfoBehavior(addStudentInfoBehavior);
	}
}