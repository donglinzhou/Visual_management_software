package Controller;
import model.*;
import View.*;


public class main {	
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//先创建一个controller类
		ParentsController parentsController=new ParentsController();
		//在Controller里面先设定model和View
		parentsController.setParentsModel(new Parents());
		parentsController.setParentsView(new ParentsView());
		
		
		//需要设定查看学生基本信息的行为类
		parentsController.setParentsCheckStudentInfoBehavior(new CheckStudentInfoClass());
		//调用视图就可以查看学生的基本信息了
		parentsController.getStudentInfoView();
		
		parentsController.setParentsCheckStudentGradeInfoBehavior(new CheckStudentGradeInfoClass());
		parentsController.getStudentGradeInfoView();
		
		
		//--------DL----------//
		//查看成长档案
		parentsController.setParentsCheckStudentTrackInfoBehavior(new CheckStudentTrackInfoClass());
		parentsController.getStudentTrackInfoView();
		//查看考勤记录
		parentsController.setParentsCheckStudentAttendanceRecordBehavior(new CheckStudentAttendanceRecordClass());
		parentsController.getStudentAttendanceRecordView();
		//增加信息,写入数据库
		parentsController.setParentsAddStudentInfoBehavior(new AddStudentInfoClass());
		System.out.println("增加信息成功");
		
	}

}
