package model;

import java.util.ArrayList;

public interface DatabaseOperation {

	/**
	 * ʵ�����ݿ�������඼��Ҫʵ������ӿ� \\
	 * 
	 * choose -- ����¼����صĲ����������ж���ѡ�ĵ���¼�
	 * 
     * @param data��ArrayList<String> 
     * @param choose: int  
     * @throws SQLException
     * 
	 */
	
	public void databaseOperation(ArrayList<String> data, int choose);
}
