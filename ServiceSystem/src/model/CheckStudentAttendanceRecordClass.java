package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CheckStudentAttendanceRecordClass implements CheckStudentAttendanceRecordBehavior {

	@SuppressWarnings("null")
	@Override
	public ArrayList<Integer> checkStudentAttendanceRecord(int studentID,int n) {
		// TODO 自动生成的方法存根
		System.out.println("查看学生考勤记录");
		System.out.println(n);
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		//--驱动程序名
		String driver = "com.mysql.cj.jdbc.Driver";
        //--URL指向要访问的数据库名mydata
        //String url = "jdbc:mysql://172.16.107.100:3306/软工小组项目";  //地址线路1
        String url = "jdbc:mysql://10.22.27.7:3306/软工小组项目";   //地址线路2
        //--MySQL配置时的用户名
        String user = "林鑫灿";
        //--MySQL配置时的密码
        String password = "1234"; 
        
		
		try { 
	            Class.forName(driver);   //加载驱动
	            System.out.println("加载成功");
	        } catch (Exception ex) {
	        	System.out.println("加载失败");
	            // handle the error
	        }
		
		try {
			conn =
		       DriverManager.getConnection(url+"?useSSL=false&serverTimezone=UTC",user,password);
//		       DriverManager.getConnection("jdbc:mysql://10.22.27.7:3306/软工小组项目?useSSL=false&serverTimezone=UTC","朱大霖","1234");
		       //此处软工项目小组为mysql提前建立的数据库，朱大霖为用户名，最后为密码：1234
               //其中有两条线路地址为172.16.107.100和10.22.27.7
		   System.out.println("连接成功");

		   //一下测试输出数据库内数据，提前在数据库内建立user表，添加num和name  and 学生姓名="+studentName+"
		   ps = conn.prepareStatement("select 学生表.学生ID,学生表.学生姓名,考勤类型表.考勤名称,学生考勤表.时间\n" + 
		   		"from  软工小组项目.学生表,软工小组项目.考勤类型表,软工小组项目.学生考勤表\n" + 
		   		"where 学生表.学生ID=学生考勤表.学生ID  and 考勤类型表.考勤类型ID=学生考勤表.考勤类型ID \n" + 
		   		"	   and 学生表.学生ID= "+studentID);
		   rs = ps.executeQuery();
		   
		   int temp=0;  //确定打印时刻,并记录信息条数
		   String attendance_temp[] = new String[256];  //记录考勤名称
		   int timeRecord_temp[] = new int[256];  //记录考勤时间
		   
//		   ArrayList<ArrayList<String>> attendanceRecord = new ArrayList<ArrayList<String>>();
		   while(rs.next()) {
			   //-------查询信息赋值------//
			   int num = rs.getInt("学生ID");
			   String name = rs.getString("学生姓名");
			   String attendance = rs.getString("考勤名称");
			   String timeRecord = rs.getString("时间");
			   

			 //获取String类型的时间数据的年月日  时分 =>转化为int型 如202109
			   SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd hh:mm");
			   try {
			       Date date = sf.parse(timeRecord);
			       Calendar calendar = Calendar.getInstance();
			       calendar.setTime(date);
			       
			       //整理成两列数组
				   attendance_temp[temp]=attendance;
			       timeRecord_temp[temp]=calendar.get(Calendar.YEAR)*100 
			    		                   + calendar.get(Calendar.MONTH) + 1;
			   } catch (ParseException e) {
			       e.printStackTrace();
			   }
			   

			   temp++;
			   //----打印查询信息-----//
			   if(temp==1)System.out.print("学生ID"+"\t"+"姓名"+"\t"+"考勤名称"+"\t\t"+"时间"+"\n");
			   System.out.print(num+"\t"+name+"\t"+attendance+"\t"+timeRecord);
			   System.out.println("");  //换行功能
		   }//while
		   System.out.println("共计条数："+temp);	   
		   
		   bubbleSort(timeRecord_temp,attendance_temp); //排序
		   System.out.println("排序结果");int num=1;
		   for(int i=0;i<temp;i++) //排序结果
			   System.out.println(timeRecord_temp[i]+" "+attendance_temp[i]+" "+(num++));
				
		   //确定符合年月的条数
		   int a[]=selectDelete(n,attendance_temp,timeRecord_temp,temp); //去掉不符合的项
		   
		   //将a[]读入attendanceRecord
		   ArrayList<Integer> attendanceRecord=new ArrayList<Integer>();
		   for(int i=0;i<a.length;i++) attendanceRecord.add(a[i]);
		   
		   
		   System.out.println("\n返回学生考勤记录信息");
		   return attendanceRecord;
		   
		   
		} catch (SQLException ex) {//------处理任何错误,错误提示------//
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		    System.out.println("连接失败");
		}
		//--------DL--------//
		
		//需要查看：学生ID，姓名，考勤名称，时间
		System.out.println("返回学生考勤记录信息");
		int a[]=new int[13];
		for(int i=0;i<a.length;i++)a[i]=0; //初始化
		ArrayList<Integer> attendanceRecord=new ArrayList<Integer>();
		for(int i=0;i<a.length;i++) attendanceRecord.add(a[i]);
		return attendanceRecord;  //返回一维数组数据

	}
	
	
	//--------排序算法-从大到小排序---------//
	public static void bubbleSort(int[] numbers,String[] name)
	{
	    int temp = 0;String temp2 = "";
	    int size = numbers.length;
	    for(int i = 0 ; i < size-1; i ++)
	    {
	    for(int j = 0 ;j < size-1-i ; j++)
	    {
	        if(numbers[j] < numbers[j+1])  //交换两数位置
	        {
	        temp = numbers[j];
	        numbers[j] = numbers[j+1];
	        numbers[j+1] = temp;
	        
	        temp2 = name[j];
	        name[j] = name[j+1];
	        name[j+1] = temp2;
	        }
	    }
	    }
	}
	
	//----筛选算法----//
	public static int[] selectDelete(int n,String[] attendance,int[] timeRecord,int number)
	{
		int temp=1;
		for(int i=0;i<number-1;i++) {  //选出前面符合的项,将后面不符合的项置零
			if(timeRecord[i+1]<timeRecord[i]) temp++;
			if(temp>n) {
				attendance[i+1]=null;
				timeRecord[i+1]=0;
			}
		}
		
		System.out.println("筛选结果");int num=1;
		for(int i=0;timeRecord[i]!=0;i++) //排序结果
			   System.out.println(timeRecord[i]+" "+attendance[i]+" "+(num++));
		
		int a[]=new int[13];
		for(int i=0;i<a.length;i++)a[i]=0; //初始化
		for(int i=0;timeRecord[i]!=0;i++) {
			switch(attendance[i]) {
			case "迟到[移动考勤机]":
				a[0]++;
				break;
			case "进校[移动考勤机]":
				a[1]++;
				break;
			case "课间操请假":
				a[2]++;
				break;
			case "离校[移动考勤机]":
				a[3]++;
				break;
			case "默认信息":
				a[4]++;
				break;
			case "请假离校":
				a[5]++;
				break;
			case "晚到学校":
				a[6]++;
				break;
			case "晚自修迟到":
				a[7]++;
				break;
			case "校服[移动考勤机]":
				a[8]++;
				break;
			case "校徽校服":
				a[9]++;
				break;
			case "早上迟到":
				a[10]++;
				break;
			case "早退[移动考勤机]":
				a[11]++;
				break;
			case "住宿早晨锻炼":
				a[12]++;
				break;
			default:
				//System.out.println("匹配失败");
			}
		}

		return a;
	}

	
}
