package model;

import java.util.ArrayList;

public interface CheckClassHistoryGradeListBehavior {
	//查看班级历史总成绩排名表
	
	public ArrayList<ArrayList<String>> checkclasshistorygradeList(String teacherid, String examtime, String examtype);
}
