package model;

import java.util.ArrayList;

public interface CheckStudentAttendanceRecordBehavior {
	//查看考勤记录
	public ArrayList<ArrayList<String>> checkStudentAttendanceRecord(int studentID);
}
