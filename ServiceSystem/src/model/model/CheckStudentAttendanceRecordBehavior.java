package model;

import java.util.ArrayList;

public interface CheckStudentAttendanceRecordBehavior {
	//查看出勤情况
	public ArrayList<Integer> checkStudentAttendanceRecord(int studentID, int n);
}
