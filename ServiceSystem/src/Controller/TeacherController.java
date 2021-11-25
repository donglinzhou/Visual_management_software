package Controller;
import View.TeachersView;
import model.CheckClassHistoryGradeListBehavior;
import model.CheckClassMemberListBehavior;
import model.CheckClassStudentGradeBehavior;
import model.CheckClassStudentSubjectHistoryListBehavior;
import model.CheckClassedListBehavior;
import model.CheckTeacherInfoBehavior;
import model.Teachers;
public class TeacherController {
	private Teachers teachers;
	private TeachersView teachersView;
	public TeacherController() {	
	}
	
	public void setTeachersModel(Teachers teachers) {
		this.teachers=teachers;
	}
	
	public void setTeachersView(TeachersView teachersView) {
		this.teachersView = teachersView;
	}
    
	/*整合时加入
	public void getStudentInfoView() {
		//打印学生的基本信息
		teachersView.printStudentInfo(teachers.performCheckStudentInfo());
	}
	
	public void getStudentGradeInfoView() {
		//打印学生学业信息
		teachersView.printStudentGradeInfo(teachers.performCheckStudentGradeInfo());
	}
	
	public void getStudentAttendanceRecordView() {
		//打印考勤记录
		teachersView.printStudentAttendanceRecord();
	}
	
	public void getStudentTrackInfoView() {
		//打印成长档案
		teachersView.printStudentTrackInfo();
	}
	*/
	
	public void getClassListView() {
		//打印任课班级名单
		Teachers person = new Teachers();
		int id = person.getId();
		String teacherid = Integer.toString(id);
		teachersView.printClassList(teachers.performCheckClassedList(teacherid));
	}
	
	public void getClassHistoryGradeView() {
		//打印班级历史总成绩排名表
		teachersView.printClassHistoryGrade(teachers.performCheckClassHistoryGradeList());
	}
	
	public void getClassMemberListView() {
		//打印班级学生名单
		Teachers person = new Teachers();
		int id = person.getId();
		String teacherid = Integer.toString(id);
		teachersView.printClassMemberList(teachers.performCheckClassMemberList(teacherid));
	}
	
	public void getClassStudentGradeView() {
		//打印班级学生成绩
		teachersView.printClassStudentGrade(teachers.performCheckClassStudentGrade());
	}
    
	public void getClassStudentSubjectHistoryListView() {
		//打印班级内部学生各个科目的历史成绩排名表
		teachersView.printClassStudentSubjectHistoryList(teachers.performCheckClassStudentSubjectHistoryList());
	}
	
	public void getTeacherInfoView() {
		//打印老师基本信息
		Teachers person = new Teachers();
		int id = person.getId();
		String teacherid = Integer.toString(id);
		teachersView.printTeacherInfo(teachers.performCheckTeacherInfo(teacherid));
	}
	
	
	/*动态设置Teachers类中的行为对象:对修改开放*/
	public void setTeachersCheckClassedListBehavior(CheckClassedListBehavior checkClassedListBehavior) {
		teachers.setCheckClassedListBehavior(checkClassedListBehavior);
	}
	
	public void setTeachersCheckClassHistoryGradeListBehavior(CheckClassHistoryGradeListBehavior checkClassHistoryGradeListBehavior) {
		teachers.setCheckClassHistoryGradeListBehavior(checkClassHistoryGradeListBehavior);
	}
	
	public void setTeachersCheckClassMemberListBehavior(CheckClassMemberListBehavior checkClassMemberListBehavior) {
		teachers.setCheckClassMemberListBehavior(checkClassMemberListBehavior);
	}
	
	public void setTeachersCheckClassStudentGradeBehavior(CheckClassStudentGradeBehavior checkClassStudentGradeBehavior) {
		teachers.setCheckClassStudentGradeBehavior(checkClassStudentGradeBehavior);
	}
	
	public void setTeachersCheckClassStudentSubjectHistoryListBehavior(CheckClassStudentSubjectHistoryListBehavior checkClassStudentSubjectHistoryListBehavior) {
		teachers.setCheckClassStudentSubjectHistoryListBehavior(checkClassStudentSubjectHistoryListBehavior);
	}
	
	public void setTeachersCheckTeacherInfoBehavior(CheckTeacherInfoBehavior checkTeacherInfoBehavior) {
		teachers.setCheckTeacherInfoBehavior(checkTeacherInfoBehavior);
	}
	
	/*整合时加入
	public void setTeachersCheckStudentInfoBehavior(CheckStudentInfoBehavior checkStudentInfoBehavior) {
		teachers.setCheckStudentInfoBehavior(checkStudentInfoBehavior);
	}
	
	public void setTeachersCheckStudentTrackInfoBehavior(CheckStudentTrackInfoBehavior checkTrackInfoBehavior) {
		teachers.setCheckStudentTrackInfoBehavior(checkTrackInfoBehavior);		
	}
	
	public void setTeachersCheckStudentGradeInfoBehavior(CheckStudentGradeInfoBehavior checkStudentGradeInfoBehavior) {
		teachers.setCheckStudentGradeInfoBehavior(checkStudentGradeInfoBehavior);
	}
	
	public void setTeachersCheckStudentConsumptionInfoBehavior(CheckStudentConsumptionInfoBehavior checkStudentConsumptionInfoBehavior) {
		teachers.setCheckStudentConsumptionInfoBehavior(checkStudentConsumptionInfoBehavior);
	}
	
	public void setTeachersCheckStudentAttendanceRecordBehavior(CheckStudentAttendanceRecordBehavior checkAttendanceRecordBehavior) {
		teachers.setCheckStudentAttendanceRecordBehavior(checkAttendanceRecordBehavior);
	}
	
	public void setTeachersAddStudentInfoBehavior(AddStudentInfoBehavior addStudentInfoBehavior) {
		teachers.setAddStudentInfoBehavior(addStudentInfoBehavior);
	}
	*/
}
