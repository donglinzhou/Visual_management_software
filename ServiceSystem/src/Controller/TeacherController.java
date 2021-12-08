package Controller;
import java.util.ArrayList;

import View.*;
import model.*;
public class TeacherController {
	private Teachers teachers;
	private Parents parents;
	private TeachersView teachersView;
	private ParentsView parentsView;
	public TeacherController() {	
	}
	
	public void setTeachersModel(Teachers teachers) {
		this.teachers=teachers;
	}
	
	public void setTeachersView(TeachersView teachersView) {
		this.teachersView = teachersView;
	}
    
	public void setParentsModel(Parents parents) {
		this.parents=parents;
	}
	
	public void setParentsView(ParentsView parentsView) {
		this.parentsView=parentsView;
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
	
	
	public ArrayList<String> getClassListView(String teacherid) {
		//打印任课班级名单
		return teachers.performCheckClassedList(teacherid);
	}
	
	public ArrayList<String> getClassMemberListView(String teacherid) {
		//打印班级学生名单
		return teachers.performCheckClassMemberList(teacherid);
	}
	
	public ArrayList<ArrayList<Integer>> getClassStudentGradeView(String teacherid, String termid, String time, String examsubjectid) {
		//打印班级学生成绩
		return teachers.performCheckClassStudentGrade(teacherid, termid, time, examsubjectid);
	}
    
	public ArrayList<String> getTeacherInfoView(String teacherid) {
		//打印老师基本信息
		return teachers.performCheckTeacherInfo(teacherid);
	}
	
	
	/*动态设置Teachers类中的行为对象:对修改开放*/
	public void setTeachersCheckClassedListBehavior(CheckClassedListBehavior checkClassedListBehavior) {
		teachers.setCheckClassedListBehavior(checkClassedListBehavior);
	}
	
	public void setTeachersCheckClassMemberListBehavior(CheckClassMemberListBehavior checkClassMemberListBehavior) {
		teachers.setCheckClassMemberListBehavior(checkClassMemberListBehavior);
	}
	
	public void setTeachersCheckClassStudentGradeBehavior(CheckClassStudentGradeBehavior checkClassStudentGradeBehavior) {
		teachers.setCheckClassStudentGradeBehavior(checkClassStudentGradeBehavior);
	}
	
	public void setTeachersCheckTeacherInfoBehavior(CheckTeacherInfoBehavior checkTeacherInfoBehavior) {
		teachers.setCheckTeacherInfoBehavior(checkTeacherInfoBehavior);
	}
	
	//老师查看学生信息
	public void setTeachersCheckStudentInfoBehavior(CheckStudentInfoBehavior checkStudentInfoBehavior) {
		parents.setCheckStudentInfoBehavior(checkStudentInfoBehavior);
	}
	
	public void setTeachersCheckStudentTrackInfoBehavior(CheckStudentTrackInfoBehavior checkTrackInfoBehavior) {
		parents.setCheckStudentTrackInfoBehavior(checkTrackInfoBehavior);		
	}
	
	public void setTeachersCheckStudentGradeInfoBehavior(CheckStudentGradeInfoBehavior checkStudentGradeInfoBehavior) {
		parents.setCheckStudentGradeInfoBehavior(checkStudentGradeInfoBehavior);
	}	
	
	public void setTeachersCheckStudentAttendanceRecordBehavior(CheckStudentAttendanceRecordBehavior checkAttendanceRecordBehavior) {
		parents.setCheckStudentAttendanceRecordBehavior(checkAttendanceRecordBehavior);
	}		
	
}
