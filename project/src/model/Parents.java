package model;

public class Parents extends Person{
	/*全部 是私有变量，通过set方法从数据库中获取，通过get方法提供给外部访问*/
	/*数据类型根据数据库设计，后面可能需要修改*/
	private String gender=" ";
	private int enrollemtYear=0;
	private int age=0;
	private String politicsStatus=" ";
	private String teacherName =" ";
	
	/*除了查看学生基本信息的功能，其他功能的数据结构使用java现有的工具包和提供的数据类型*/
	
	protected void checkStudentInfo() {
		//查看学生基本信息
	}
	
	
	protected void checkTrackInfo() {
		//查看成长档案
	}
	protected void checkStudentGradeInfo() {
		//查看学业画像
	}
	
	private void checkStudentConsumptionInfo() {
		//查看消费情况
	}
	
	protected void checkAttendanceRecord() {
		//查看出勤情况
	}
	
	public void addInfo() {
		//增加信息，写入数据库
	}
}
