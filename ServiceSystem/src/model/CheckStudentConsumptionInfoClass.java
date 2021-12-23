<<<<<<< HEAD
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CheckStudentConsumptionInfoClass implements CheckStudentConsumptionInfoBehavior {//²éÑ¯Ñ§ÉúÏû·Ñ¼ÇÂ¼

//	static String ID="15888";//´«ÈëµÄÑ§ÉúID
//	static int n=5;
	//static ArrayList<Double>studentInfo= new ArrayList<Double>();
	//static ArrayList<Double>studentInfo3= new ArrayList<Double>();
	//static ArrayList<ArrayList<String>> studentInfo2 = new ArrayList<ArrayList<String>>();//ÀàµÄÈ«¾Ö±äÁ¿£¬ÓÃÀ´´æ´¢·µ»ØÑ§ÉúÏû·Ñ¼ÇÂ¼
	//static ArrayList<ArrayList<String>> studentInfo1 = new ArrayList<ArrayList<String>>();//ÀàµÄÈ«¾Ö±äÁ¿£¬ÓÃÀ´´æ´¢·µ»ØÑ§ÉúÎŞÓÃÏû·Ñ¼ÇÂ¼

	@Override
	public  ArrayList<Double> checkStudentConsumptionInfo(String ID,int n) {//·µ»ØµÄÑ§ÉúÏû·Ñ¼ÇÂ¼
		 ArrayList<Double>studentInfo= new ArrayList<Double>();
		 ArrayList<Double>studentInfo3= new ArrayList<Double>();
		 ArrayList<ArrayList<String>> studentInfo2 = new ArrayList<ArrayList<String>>();//ÀàµÄÈ«¾Ö±äÁ¿£¬ÓÃÀ´´æ´¢·µ»ØÑ§ÉúÏû·Ñ¼ÇÂ¼
		 ArrayList<ArrayList<String>> studentInfo1 = new ArrayList<ArrayList<String>>();//ÀàµÄÈ«¾Ö±äÁ¿£¬ÓÃÀ´´æ´¢·µ»ØÑ§ÉúÎŞÓÃÏû·Ñ¼ÇÂ¼

		//System.out.println("²é¿´Ñ§Éú¸öÈËĞÅÏ¢");
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		 try {
	            // The newInstance() call is a work around for some
	            // broken Java implementations

	            Class.forName("com.mysql.cj.jdbc.Driver");
	            System.out.println("¼ÓÔØ³É¹¦");
	        } catch (Exception ex) {
	        	System.out.println("¼ÓÔØÊ§°Ü");
	            // handle the error
	        }
		
		try {
		    conn =
		       DriverManager.getConnection("jdbc:mysql://172.16.107.100:3306/Èí¹¤Ğ¡×éÏîÄ¿","×ŞÕñÍ¥","1234");
		       //´Ë´¦Èí¹¤ÏîÄ¿Ğ¡×éÎªmysqlÌáÇ°½¨Á¢µÄÊı¾İ¿â£¬×ŞÕñÍ¥ÎªÓÃ»§Ãû£¬×îºóÎªÃÜÂë£º1234

		   System.out.println("Á¬½Ó³É¹¦");

		   //Ò»ÏÂ²âÊÔÊä³öÊı¾İ¿âÄÚÊı¾İ£¬ÌáÇ°ÔÚÊı¾İ¿âÄÚ½¨Á¢user±í£¬Ìí¼ÓnumºÍname
		   
		  // ps = conn.prepareStatement("select Ñ§ÉúID,Ñ§ÉúĞÕÃû from Èí¹¤Ğ¡×éÏîÄ¿.Ñ§Éú±í;");
		   ps = conn.prepareStatement(""
			   		+ "select Ñ§Éú±í.Ñ§ÉúĞÕÃû,Ñ§Éú±í.Ñ§ÉúID,Ïû·ÑÊ±¼ä,Ïû·Ñ½ğ¶î\r\n" + 
			   		"from Èí¹¤Ğ¡×éÏîÄ¿.Ñ§Éú±í,Èí¹¤Ğ¡×éÏîÄ¿.Ïû·Ñ±í\r\n" + 
			   		"where Ñ§Éú±í.Ñ§ÉúID=Ïû·Ñ±í.Ñ§ÉúID\r\n" + 
			   		"      and Ñ§Éú±í.Ñ§ÉúID=" +ID);
		   rs = ps.executeQuery();
		   while(rs.next()) {
			   ArrayList<String> people =new ArrayList<String>();//´æ´¢Ò»ÌõÑ§ÉúÏû·Ñ¼ÇÂ¼µÄÔª×é
			   //Ñ§ÉúID£¬Ñ§ÉúĞÕÃû£¬Ïû·ÑÊ±¼ä£¬Ïû·Ñ½ğ¶î
			   int num = rs.getInt("Ñ§ÉúID");
			   String name = rs.getString("Ñ§ÉúĞÕÃû");
			   String consumptionTimeYear = rs.getString("Ïû·ÑÊ±¼ä").substring(0, 4);
			   String consumptionTimeMonth = rs.getString("Ïû·ÑÊ±¼ä").substring(5,6);
			   double consumptionAmount = rs.getInt("Ïû·Ñ½ğ¶î");
			   System.out.print(num+"\t"+name+"\t"+consumptionTimeYear+"\t"+consumptionTimeMonth+"\t"+consumptionAmount);
			   System.out.println("");
			   
			  
			   
			 //½«Ñ§ÉúID£¬Ñ§ÉúĞÕÃû£¬Ïû·ÑÊ±¼ä£¬Ïû·Ñ½ğ¶î²åÈëpeople
			   people.add(name);
			   people.add(Integer.toString(num));
			   people.add(consumptionTimeYear);
			   people.add(consumptionTimeMonth);
			   people.add(String.valueOf(consumptionAmount));
			   //½«people²åÈëstudentInfo
			   studentInfo2.add(people);
			   
			   /*ArrayList<String> name1=new ArrayList<String>();
			   ArrayList<String> consumptionTime1=new ArrayList<String>();
			   ArrayList<String> consumptionAmount1=new ArrayList<String>();
			   ArrayList<String> num1=new ArrayList<String>();*/
			   
			   /*name1.add(name);
			   num1.add(Integer.toString(num));
			   consumptionTime1.add(consumptionTime);
			   consumptionAmount1.add(String.valueOf(consumptionAmount));*/
			   
			   /*studentInfo.add(name1);
			   studentInfo.add(num1);
			   studentInfo.add(consumptionTime1);
			   studentInfo.add(consumptionAmount1);*/   
			   
		   }

		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		    System.out.println("Á¬½ÓÊ§°Ü");
		}
		String FLAG=studentInfo2.get(0).get(3);
		double sum=0.0;
		for(int i=0;i<studentInfo2.size();i++) {
			if (studentInfo2.get(i).get(3).equals(FLAG)) {
				
				sum += Double.parseDouble(studentInfo2.get(i).get(4));
				if(i==studentInfo2.size()-1) studentInfo3.add(sum);
				}
			
			else 
			{
				FLAG=studentInfo2.get(i).get(3);
				studentInfo3.add(sum);
				sum=0;
				sum += Double.parseDouble(studentInfo2.get(i).get(4));
				
			
		}
		
		
	}
		if(studentInfo3.size()<n) 
			n=studentInfo3.size();
		
		for (int c=0;c<n;c++) {
			studentInfo.add(studentInfo3.get(c));
			
		}
		//System.out.println(studentInfo3);//¼ì²éÊÇ·ñÕıÈ·´«Èë
	
		return studentInfo;
		
	}


}

=======
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CheckStudentConsumptionInfoClass implements CheckStudentConsumptionInfoBehavior {//æŸ¥è¯¢å­¦ç”Ÿæ¶ˆè´¹è®°å½•

//	static String ID="15888";//ä¼ å…¥çš„å­¦ç”ŸID
//	static int n=5;
//	static ArrayList<Double>studentInfo= new ArrayList<Double>();
//	static ArrayList<Double>studentInfo3= new ArrayList<Double>();
//	static ArrayList<ArrayList<String>> studentInfo2 = new ArrayList<ArrayList<String>>();//ç±»çš„å…¨å±€å˜é‡ï¼Œç”¨æ¥å­˜å‚¨è¿”å›å­¦ç”Ÿæ¶ˆè´¹è®°å½•
//	static ArrayList<ArrayList<String>> studentInfo1 = new ArrayList<ArrayList<String>>();//ç±»çš„å…¨å±€å˜é‡ï¼Œç”¨æ¥å­˜å‚¨è¿”å›å­¦ç”Ÿæ— ç”¨æ¶ˆè´¹è®°å½•

	@Override
	public  ArrayList<Double> checkStudentConsumptionInfo(String ID,int n) {//è¿”å›çš„å­¦ç”Ÿæ¶ˆè´¹è®°å½•
		ArrayList<Double>studentInfo= new ArrayList<Double>();
		ArrayList<Double>studentInfo3= new ArrayList<Double>();
		ArrayList<ArrayList<String>> studentInfo2 = new ArrayList<ArrayList<String>>();//ç±»çš„å…¨å±€å˜é‡ï¼Œç”¨æ¥å­˜å‚¨è¿”å›å­¦ç”Ÿæ¶ˆè´¹è®°å½•
		ArrayList<ArrayList<String>> studentInfo1 = new ArrayList<ArrayList<String>>();//ç±»çš„å…¨å±€å˜é‡ï¼Œç”¨æ¥å­˜å‚¨è¿”å›å­¦ç”Ÿæ— ç”¨æ¶ˆè´¹è®°å½•
		//System.out.println("æŸ¥çœ‹å­¦ç”Ÿä¸ªäººä¿¡æ¯");
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		 try {
	            // The newInstance() call is a work around for some
	            // broken Java implementations

	            Class.forName("com.mysql.cj.jdbc.Driver");
	            System.out.println("åŠ è½½æˆåŠŸ");
	        } catch (Exception ex) {
	        	System.out.println("åŠ è½½å¤±è´¥");
	            // handle the error
	        }
		
		try {
			//String url = "jdbc:mysql://172.16.107.100:3306/è½¯å·¥å°ç»„é¡¹ç›®";  //åœ°å€çº¿è·¯1
	        String url = "jdbc:mysql://10.22.27.7:3306/è½¯å·¥å°ç»„é¡¹ç›®";   //åœ°å€çº¿è·¯2
		    conn =
		       DriverManager.getConnection(url,"æ—é‘«ç¿","1234");
		       //æ­¤å¤„è½¯å·¥é¡¹ç›®å°ç»„ä¸ºmysqlæå‰å»ºç«‹çš„æ•°æ®åº“ï¼Œé‚¹æŒ¯åº­ä¸ºç”¨æˆ·åï¼Œæœ€åä¸ºå¯†ç ï¼š1234

		   System.out.println("è¿æ¥æˆåŠŸ");

		   //ä¸€ä¸‹æµ‹è¯•è¾“å‡ºæ•°æ®åº“å†…æ•°æ®ï¼Œæå‰åœ¨æ•°æ®åº“å†…å»ºç«‹userè¡¨ï¼Œæ·»åŠ numå’Œname
		   
		  // ps = conn.prepareStatement("select å­¦ç”ŸID,å­¦ç”Ÿå§“å from è½¯å·¥å°ç»„é¡¹ç›®.å­¦ç”Ÿè¡¨;");
		   ps = conn.prepareStatement(""
			   		+ "select å­¦ç”Ÿè¡¨.å­¦ç”Ÿå§“å,å­¦ç”Ÿè¡¨.å­¦ç”ŸID,æ¶ˆè´¹æ—¶é—´,æ¶ˆè´¹é‡‘é¢\r\n" + 
			   		"from è½¯å·¥å°ç»„é¡¹ç›®.å­¦ç”Ÿè¡¨,è½¯å·¥å°ç»„é¡¹ç›®.æ¶ˆè´¹è¡¨\r\n" + 
			   		"where å­¦ç”Ÿè¡¨.å­¦ç”ŸID=æ¶ˆè´¹è¡¨.å­¦ç”ŸID\r\n" + 
			   		"      and å­¦ç”Ÿè¡¨.å­¦ç”ŸID=" +ID);
		   rs = ps.executeQuery();
		   while(rs.next()) {
			   ArrayList<String> people =new ArrayList<String>();//å­˜å‚¨ä¸€æ¡å­¦ç”Ÿæ¶ˆè´¹è®°å½•çš„å…ƒç»„
			   //å­¦ç”ŸIDï¼Œå­¦ç”Ÿå§“åï¼Œæ¶ˆè´¹æ—¶é—´ï¼Œæ¶ˆè´¹é‡‘é¢
			   int num = rs.getInt("å­¦ç”ŸID");
			   String name = rs.getString("å­¦ç”Ÿå§“å");
			   String consumptionTimeYear = rs.getString("æ¶ˆè´¹æ—¶é—´").substring(0, 4);
			   String consumptionTimeMonth = rs.getString("æ¶ˆè´¹æ—¶é—´").substring(5,6);
			   double consumptionAmount = rs.getInt("æ¶ˆè´¹é‡‘é¢");
			   System.out.print(num+"\t"+name+"\t"+consumptionTimeYear+"\t"+consumptionTimeMonth+"\t"+consumptionAmount);
			   System.out.println("");
			   
			  
			   
			 //å°†å­¦ç”ŸIDï¼Œå­¦ç”Ÿå§“åï¼Œæ¶ˆè´¹æ—¶é—´ï¼Œæ¶ˆè´¹é‡‘é¢æ’å…¥people
			   people.add(name);
			   people.add(Integer.toString(num));
			   people.add(consumptionTimeYear);
			   people.add(consumptionTimeMonth);
			   people.add(String.valueOf(consumptionAmount));
			   //å°†peopleæ’å…¥studentInfo
			   studentInfo2.add(people);
			   
			   /*ArrayList<String> name1=new ArrayList<String>();
			   ArrayList<String> consumptionTime1=new ArrayList<String>();
			   ArrayList<String> consumptionAmount1=new ArrayList<String>();
			   ArrayList<String> num1=new ArrayList<String>();*/
			   
			   /*name1.add(name);
			   num1.add(Integer.toString(num));
			   consumptionTime1.add(consumptionTime);
			   consumptionAmount1.add(String.valueOf(consumptionAmount));*/
			   
			   /*studentInfo.add(name1);
			   studentInfo.add(num1);
			   studentInfo.add(consumptionTime1);
			   studentInfo.add(consumptionAmount1);*/   
			   
		   }

		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		    System.out.println("è¿æ¥å¤±è´¥");
		}
		String FLAG=studentInfo2.get(0).get(3);
		double sum=0.0;
		for(int i=0;i<studentInfo2.size();i++) {
			if (studentInfo2.get(i).get(3).equals(FLAG)) {
				
				sum += Double.parseDouble(studentInfo2.get(i).get(4));
				if(i==studentInfo2.size()-1) studentInfo3.add(sum);
				}
			
			else 
			{
				FLAG=studentInfo2.get(i).get(3);
				studentInfo3.add(sum);
				sum=0;
				sum += Double.parseDouble(studentInfo2.get(i).get(4));
				
			
		}
		
		
	}
		if(studentInfo3.size()<n) 
			n=studentInfo3.size();
		
		for (int c=0;c<n;c++) {
			studentInfo.add(studentInfo3.get(c));
			
		}
		//System.out.println(studentInfo3);//æ£€æŸ¥æ˜¯å¦æ­£ç¡®ä¼ å…¥
	
		return studentInfo;
		
	}


}

>>>>>>> 408f01557a212803392a6fde5c7b35e7b8cd5c8b
