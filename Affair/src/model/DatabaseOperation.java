package model;

import java.util.ArrayList;

public interface DatabaseOperation {

	/**
	 * 实现数据库操作的类都需要实现这个接口 \\
	 * 
	 * choose -- 点击事件返回的参数，用于判断所选的点击事件
	 * 
     * @param data：ArrayList<String> 
     * @param choose: int  
     * @throws SQLException
     *
	 */
	
	public ArrayList<ArrayList<String>> databaseOperation(ArrayList<String> data, int choose);
	
}
