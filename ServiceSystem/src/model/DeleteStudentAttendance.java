package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class DeleteStudentAttendance implements DatabaseOperation{
	/**
	 * ����ID����������ID��ѧ��ID��ʱ�� 
	 * */
	public static DatabaseModel database = new DatabaseModel();
	
	public void deleteStudentAttendance1(ArrayList<String> data) {
	/**
	 * ɾ���������ڼ�¼
	 * */
		
		database.connect();
		
		try {

			database.delete("ѧ�����ڱ�", "����ID", data);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteStudentAttendance2(ArrayList<String> data) {
		/**
		 * ɾ��ĳ��ѧ�������п��ڼ�¼
		 * */
		
		database.connect();
		
		try {

			database.delete("ѧ�����ڱ�", "ѧ��ID", data);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void databaseOperation(ArrayList<String> data, int choose) {
		// TODO Auto-generated method stub

		switch(choose) {
		case 1:
			deleteStudentAttendance1(data); // ɾ���������ڼ�¼
			break;
		case 2:
			deleteStudentAttendance2(data); // ɾ��ĳ��ѧ�������п��ڼ�¼
			break;
		default:
			System.out.println("ERROR!");
		}
	}
}
