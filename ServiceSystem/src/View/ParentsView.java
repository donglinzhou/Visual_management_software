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
	
	
	//----------DL--------//
	public void printStudentAttendanceRecord(ArrayList<ArrayList<String>> attendanceRecord) {
		//打印考勤记录
		System.out.println(attendanceRecord);
		System.out.println("");
	}
	
	public void printStudentTrackInfo(ArrayList<String> trackInfo) {
		//打印成长档案
		System.out.println(trackInfo);
		System.out.println("");
	}
	
}
