package View;
import java.util.ArrayList;
import java.util.Vector;

import model.*;

public class ParentsView {
	
	/*问题在于最后需要传输的数据-参数需要改变*/
	public void printStudentInfo(ArrayList<String> studentInfo) {
		//打印学生的基本信息
		System.out.println(studentInfo);
	}
	
	public void printStudentGradeInfo(ArrayList<ArrayList<String>> gradeInfo) {
		//打印学生学业信息
		System.out.println(gradeInfo);
		
	}
	
	public void printStudentConsumptionInfo() {
		//打印学生消费信息
	}
	
	public void printStudentAttendanceRecord() {
		//打印考勤记录
	}
	
	public void printStudentTrackInfo() {
		//打印成长档案
	}
	
}
