package model;

import java.util.ArrayList;
import java.util.Vector;

public class Parents extends Person{
	/*全部 是私有变量，通过set方法从数据库中获取，通过get方法提供给外部访问*/
	/*数据类型根据数据库设计，后面可能需要修改*/
	//	private String gender=" ";
	//	private int enrollemtYear=0;
	//	private int age=0;
	//	private String politicsStatus=" ";
	//	private String teacherName =" ";
	
	/*除了查看学生基本信息的功能，其他功能的数据结构使用java现有的工具包和提供的数据类型*/
	/*使用行为接口类型声明引用变量*/
	CheckStudentInfoBehavior checkStudentInfoBehavior;
	CheckStudentTrackInfoBehavior checkStudentTrackInfoBehavior;
	CheckStudentGradeInfoBehavior checkStudentGradeInfoBehavior;
	CheckStudentConsumptionInfoBehavior checkStudentConsumptionInfoBehavior;
	CheckStudentAttendanceRecordBehavior checkStudentAttendanceRecordBehavior;
	AddStudentInfoBehavior addStudentInfoBehavior;
	
	/*行为委托给行为类-需要写成return 数据,因此返回值需要改变*/
	public ArrayList<String> performCheckStudentInfo() {
		//查看学生基本信息
		return checkStudentInfoBehavior.checkStudentInfo();
	}
	
	public void performCheckStudentTrackInfo() {
		//查看成长档案
		checkStudentTrackInfoBehavior.checkStudentTrackInfo(this.id);
	}
	
	public ArrayList<ArrayList<String>> performCheckStudentGradeInfo() {
		//查看学业画像
		return checkStudentGradeInfoBehavior.checkStudentGradeInfo();
	}
	
	public void performCheckStudentConsumptionInfo() {
		//查看消费情况
		checkStudentConsumptionInfoBehavior.checkStudentConsumptionInfo();
	}
	
	public void performCheckStudentAttendanceRecord() {
		//查看出勤情况
		checkStudentAttendanceRecordBehavior.checkStudentAttendanceRecord();
		
	}
	
	public void performAddStudentInfo() {
		//增加信息，写入数据库
		addStudentInfoBehavior.addStudentInfo();
	}
	
	/*动态设定行为，实际上传入的应该是一个类的实例*/
	public void setCheckStudentInfoBehavior(CheckStudentInfoBehavior checkStudentInfoBehavior) {
		this.checkStudentInfoBehavior = checkStudentInfoBehavior;
	}
	
	public void setCheckStudentTrackInfoBehavior(CheckStudentTrackInfoBehavior checkTrackInfoBehavior) {
		this.checkStudentTrackInfoBehavior = checkTrackInfoBehavior;
	}
	
	public void setCheckStudentGradeInfoBehavior(CheckStudentGradeInfoBehavior checkStudentGradeInfoBehavior) {
		this.checkStudentGradeInfoBehavior = checkStudentGradeInfoBehavior;
	}
	
	public void setCheckStudentConsumptionInfoBehavior(CheckStudentConsumptionInfoBehavior checkStudentConsumptionInfoBehavior) {
		this.checkStudentConsumptionInfoBehavior = checkStudentConsumptionInfoBehavior;
	}
	
	public void setCheckStudentAttendanceRecordBehavior(CheckStudentAttendanceRecordBehavior checkAttendanceRecordBehavior) {
		this.checkStudentAttendanceRecordBehavior = checkAttendanceRecordBehavior;
	}
	
	public void setAddStudentInfoBehavior(AddStudentInfoBehavior addStudentInfoBehavior) {
		this.addStudentInfoBehavior = addStudentInfoBehavior;
	}
	
	
}