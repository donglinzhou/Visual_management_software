package model;

import java.util.ArrayList;

public class Parents extends Person{
	/*ȫ�� ��˽�б�����ͨ��set���������ݿ��л�ȡ��ͨ��get�����ṩ���ⲿ����*/
	/*�������͸������ݿ���ƣ����������Ҫ�޸�*/
	//	private String gender=" ";
	//	private int enrollemtYear=0;
	//	private int age=0;
	//	private String politicsStatus=" ";
	//	private String teacherName =" ";
	String ID;
	int n;
	/*���˲鿴ѧ��������Ϣ�Ĺ��ܣ��������ܵ����ݽṹʹ��java���еĹ��߰����ṩ����������*/
	/*ʹ����Ϊ�ӿ������������ñ���*/
	CheckStudentInfoBehavior checkStudentInfoBehavior;
	CheckStudentTrackInfoBehavior checkStudentTrackInfoBehavior;
	CheckStudentGradeInfoBehavior checkStudentGradeInfoBehavior;
	CheckStudentConsumptionInfoBehavior checkStudentConsumptionInfoBehavior;
	CheckStudentAttendanceRecordBehavior checkStudentAttendanceRecordBehavior;
	
	/*��Ϊί�и���Ϊ��-��Ҫд��return ����,��˷���ֵ��Ҫ�ı�*/
	public ArrayList<String> performCheckStudentInfo(String ID) {
		//�鿴ѧ��������Ϣ
		return checkStudentInfoBehavior.checkStudentInfo(ID);
	}
	
	public ArrayList<Integer> performCheckStudentTrackInfo(String ID, int n) {
		//�鿴�ɳ�����
		return checkStudentTrackInfoBehavior.checkStudentTrackInfo(ID,n);
	}
	
	public ArrayList<ArrayList<Integer>> performCheckStudentGradeInfo(String ID, int n) {
		//�鿴ѧҵ����
		return checkStudentGradeInfoBehavior.checkStudentGradeInfo(ID,n);
	}
	
	public ArrayList<Double> performCheckStudentConsumptionInfo(String ID, int n) {
		//�鿴�������
		return checkStudentConsumptionInfoBehavior.checkStudentConsumptionInfo(ID,n);
	}
	
	public ArrayList<Integer> performCheckStudentAttendanceRecord(int studentID, int n) {
		//�鿴�������
		return checkStudentAttendanceRecordBehavior.checkStudentAttendanceRecord(studentID, n);
		
	}
	
	/*��̬�趨��Ϊ��ʵ���ϴ����Ӧ����һ�����ʵ��*/
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
	
}