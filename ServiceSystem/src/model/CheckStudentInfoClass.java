<<<<<<< HEAD
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import com.sun.java_cup.internal.runtime.Scanner;

public class CheckStudentInfoClass implements CheckStudentInfoBehavior {//²é¿´Ñ§Éú»­Ïñ

	
//	//static int ID=13012;//´«ÈëµÄÑ§ÉúID
//	static String ID="13012";
//	static 
//	
//	 public void setStudentInfo(String ID) {
//			this.ID=ID;
//		}
//	 
	@Override
	public ArrayList<String> checkStudentInfo(String ID) {//·µ»ØÑ§ÉúĞÅÏ¢µÄÔª×é
		ArrayList<String> studentInfo = new ArrayList<String>();//ÀàµÄÈ«¾Ö±äÁ¿£¬ÓÃÀ´´æ´¢·µ»ØÑ§ÉúĞÅÏ¢µÄÔª×é
		//ĞèÒª²é¿´£ºĞÕÃû£¬ÄêÁä£¬ĞÔ±ğ£¬ÈëÑ§Äê·İ¡¢ÕşÖÎÃæÃ²¡¢°àÖ÷ÈÎĞÕÃû
		//System.out.println("²é¿´Ñ§Éú¸öÈËĞÅÏ¢");
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		 try {// ¼ì²éÊÇ·ñÄÜÁ¬½ÓÊı¾İ¿â
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            System.out.println("¼ÓÔØ³É¹¦");
	        } catch (Exception ex) {
	        	System.out.println("¼ÓÔØÊ§°Ü");
	            // ´¦Àí´íÎó
	        }
		
		try {
		    conn =DriverManager.getConnection("jdbc:mysql://10.22.27.7:3306/Èí¹¤Ğ¡×éÏîÄ¿","×ŞÕñÍ¥","1234");
		       //´Ë´¦Èí¹¤ÏîÄ¿Ğ¡×éÎªmysqlÌáÇ°½¨Á¢µÄÊı¾İ¿â£¬×ŞÕñÍ¥ÎªÓÃ»§Ãû£¬×îºóÎªÃÜÂë£º1234
		       System.out.println("Á¬½Ó³É¹¦");
		      //Ò»ÏÂ²âÊÔÊä³öÊı¾İ¿âÄÚÊı¾İ£¬ÌáÇ°ÔÚÊı¾İ¿âÄÚ½¨Á¢user±í£¬Ìí¼ÓnumºÍname
		      // ps = conn.prepareStatement("select Ñ§ÉúID,Ñ§ÉúĞÕÃû from Èí¹¤Ğ¡×éÏîÄ¿.Ñ§Éú±í;");
		   ps = conn.prepareStatement(""
		   		+ "select distinct Ñ§Éú±í.Ñ§ÉúID,Ñ§Éú±í.Ñ§ÉúĞÕÃû,Ñ§Éú±í.³öÉúÈÕÆÚ, Ñ§Éú±í.ĞÔ±ğ,Ñ§Éú±í.ÈëÑ§Äê·İ,Ñ§Éú±í.ÕşÖÎÃæÃ²,(½ÌÊ¦±í.½ÌÊ¦Ãû)as °àÖ÷ÈÎ\r\n" + 
		   		"from Èí¹¤Ğ¡×éÏîÄ¿.Ñ§Éú±í,Èí¹¤Ğ¡×éÏîÄ¿.Ñ§Éú°à¼¶±í,Èí¹¤Ğ¡×éÏîÄ¿.½ÌÊ¦±í,Èí¹¤Ğ¡×éÏîÄ¿.`Ñ§ÆÚ-½ÌÊ¦-Ñ§¿Æ-°à¼¶±í`\r\n" + 
		   		"where Ñ§Éú±í.Ñ§ÉúID=Ñ§Éú°à¼¶±í.Ñ§ÉúID and Ñ§Éú±í.Ñ§ÉúID="+ID+" and Ñ§Éú°à¼¶±í.°àÖ÷ÈÎID=½ÌÊ¦±í.½ÌÊ¦ID" );
		   rs = ps.executeQuery();
		   while(rs.next()) {
			   //ÒÔÏÂ±äÁ¿¶ÔÓ¦£ºĞÕÃû£¬ÄêÁä£¬ĞÔ±ğ£¬ÈëÑ§Äê·İ¡¢ÕşÖÎÃæÃ²¡¢°àÖ÷ÈÎĞÕÃû
			   int num = rs.getInt("Ñ§ÉúID");
			   String name = rs.getString("Ñ§ÉúĞÕÃû");
			   String birthDay  = rs.getString("³öÉúÈÕÆÚ").substring(0, 4);
			   String gender = rs.getString("ĞÔ±ğ");
			   int enrollmentYear = rs.getInt("ÈëÑ§Äê·İ");
			   String politicsStatus = rs.getString("ÕşÖÎÃæÃ²");
			   String teacherName = rs.getString("°àÖ÷ÈÎ");
			   int age = 2021- Integer.parseInt(birthDay);
			   System.out.print(num+"\t"+name+"\t"+age+"\t"+gender+"\t"+enrollmentYear+"\t"+politicsStatus+"\t"+teacherName);
			   System.out.println("");
			   
			   //½«ĞÕÃû£¬ÄêÁä£¬ĞÔ±ğ£¬ÈëÑ§Äê·İ¡¢ÕşÖÎÃæÃ²¡¢°àÖ÷ÈÎĞÕÃû¼ÓÈëstudentInfoµÄlistÖĞ
			   studentInfo.add(name);
			   studentInfo.add(Integer.toString(num));
			   studentInfo.add(Integer.toString(age));
			   studentInfo.add(gender);
			   studentInfo.add(Integer.toString(enrollmentYear));
			   studentInfo.add(politicsStatus);
			   studentInfo.add(teacherName);
			   //System.out.println(studentInfo);
		   }

		} catch (SQLException ex) { // ´¦Àí´íÎó
		   
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		    System.out.println("Á¬½ÓÊ§°Ü");
		}
		//System.out.println(studentInfo);//¼ì²éÊÇ·ñÕıÈ·´«Èë
		
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

public class CheckStudentInfoClass implements CheckStudentInfoBehavior {//æŸ¥çœ‹å­¦ç”Ÿç”»åƒ

	
//	//static int ID=13012;//ä¼ å…¥çš„å­¦ç”ŸID
//	static String ID="13012";
//	static 
//	
//	 public void setStudentInfo(String ID) {
//			this.ID=ID;
//		}
//	 
	@Override
	public ArrayList<String> checkStudentInfo(String ID) {//è¿”å›å­¦ç”Ÿä¿¡æ¯çš„å…ƒç»„
		//éœ€è¦æŸ¥çœ‹ï¼šå§“åï¼Œå¹´é¾„ï¼Œæ€§åˆ«ï¼Œå…¥å­¦å¹´ä»½ã€æ”¿æ²»é¢è²Œã€ç­ä¸»ä»»å§“å
		//System.out.println("æŸ¥çœ‹å­¦ç”Ÿä¸ªäººä¿¡æ¯");
		ArrayList<String> studentInfo = new ArrayList<String>();//ç±»çš„å…¨å±€å˜é‡ï¼Œç”¨æ¥å­˜å‚¨è¿”å›å­¦ç”Ÿä¿¡æ¯çš„å…ƒç»„
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		 try {// æ£€æŸ¥æ˜¯å¦èƒ½è¿æ¥æ•°æ®åº“
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            System.out.println("åŠ è½½æˆåŠŸ");
	        } catch (Exception ex) {
	        	System.out.println("åŠ è½½å¤±è´¥");
	            // å¤„ç†é”™è¯¯
	        }
		
		try {
			//String url = "jdbc:mysql://172.16.107.100:3306/è½¯å·¥å°ç»„é¡¹ç›®";  //åœ°å€çº¿è·¯1
	        String url = "jdbc:mysql://10.22.27.7:3306/è½¯å·¥å°ç»„é¡¹ç›®";   //åœ°å€çº¿è·¯2
		    conn =DriverManager.getConnection(url,"æ—é‘«ç¿","1234");
		       //æ­¤å¤„è½¯å·¥é¡¹ç›®å°ç»„ä¸ºmysqlæå‰å»ºç«‹çš„æ•°æ®åº“ï¼Œé‚¹æŒ¯åº­ä¸ºç”¨æˆ·åï¼Œæœ€åä¸ºå¯†ç ï¼š1234
		       System.out.println("è¿æ¥æˆåŠŸ");
		      //ä¸€ä¸‹æµ‹è¯•è¾“å‡ºæ•°æ®åº“å†…æ•°æ®ï¼Œæå‰åœ¨æ•°æ®åº“å†…å»ºç«‹userè¡¨ï¼Œæ·»åŠ numå’Œname
		      // ps = conn.prepareStatement("select å­¦ç”ŸID,å­¦ç”Ÿå§“å from è½¯å·¥å°ç»„é¡¹ç›®.å­¦ç”Ÿè¡¨;");
		   ps = conn.prepareStatement(""
		   		+ "select distinct å­¦ç”Ÿè¡¨.å­¦ç”ŸID,å­¦ç”Ÿè¡¨.å­¦ç”Ÿå§“å,å­¦ç”Ÿè¡¨.å‡ºç”Ÿæ—¥æœŸ, å­¦ç”Ÿè¡¨.æ€§åˆ«,å­¦ç”Ÿè¡¨.å…¥å­¦å¹´ä»½,å­¦ç”Ÿè¡¨.æ”¿æ²»é¢è²Œ,(æ•™å¸ˆè¡¨.æ•™å¸ˆå)as ç­ä¸»ä»»\r\n" + 
		   		"from è½¯å·¥å°ç»„é¡¹ç›®.å­¦ç”Ÿè¡¨,è½¯å·¥å°ç»„é¡¹ç›®.å­¦ç”Ÿç­çº§è¡¨,è½¯å·¥å°ç»„é¡¹ç›®.æ•™å¸ˆè¡¨,è½¯å·¥å°ç»„é¡¹ç›®.`å­¦æœŸ-æ•™å¸ˆ-å­¦ç§‘-ç­çº§è¡¨`\r\n" + 
		   		"where å­¦ç”Ÿè¡¨.å­¦ç”ŸID=å­¦ç”Ÿç­çº§è¡¨.å­¦ç”ŸID and å­¦ç”Ÿè¡¨.å­¦ç”ŸID="+ID+" and å­¦ç”Ÿç­çº§è¡¨.ç­ä¸»ä»»ID=æ•™å¸ˆè¡¨.æ•™å¸ˆID" );
		   rs = ps.executeQuery();
		   while(rs.next()) {
			   //ä»¥ä¸‹å˜é‡å¯¹åº”ï¼šå§“åï¼Œå¹´é¾„ï¼Œæ€§åˆ«ï¼Œå…¥å­¦å¹´ä»½ã€æ”¿æ²»é¢è²Œã€ç­ä¸»ä»»å§“å
			   int num = rs.getInt("å­¦ç”ŸID");
			   String name = rs.getString("å­¦ç”Ÿå§“å");
			   String birthDay  = rs.getString("å‡ºç”Ÿæ—¥æœŸ").substring(0, 4);
			   String gender = rs.getString("æ€§åˆ«");
			   int enrollmentYear = rs.getInt("å…¥å­¦å¹´ä»½");
			   String politicsStatus = rs.getString("æ”¿æ²»é¢è²Œ");
			   String teacherName = rs.getString("ç­ä¸»ä»»");
			   int age = 2021- Integer.parseInt(birthDay);
			   System.out.print(num+"\t"+name+"\t"+age+"\t"+gender+"\t"+enrollmentYear+"\t"+politicsStatus+"\t"+teacherName);
			   System.out.println("");
			   
			   //å°†å§“åï¼Œå¹´é¾„ï¼Œæ€§åˆ«ï¼Œå…¥å­¦å¹´ä»½ã€æ”¿æ²»é¢è²Œã€ç­ä¸»ä»»å§“ååŠ å…¥studentInfoçš„listä¸­
			   studentInfo.add(name);
			   studentInfo.add(Integer.toString(num));
			   studentInfo.add(Integer.toString(age));
			   studentInfo.add(gender);
			   studentInfo.add(Integer.toString(enrollmentYear));
			   studentInfo.add(politicsStatus);
			   studentInfo.add(teacherName);
			   //System.out.println(studentInfo);
		   }

		} catch (SQLException ex) { // å¤„ç†é”™è¯¯
		   
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		    System.out.println("è¿æ¥å¤±è´¥");
		}
		//System.out.println(studentInfo);//æ£€æŸ¥æ˜¯å¦æ­£ç¡®ä¼ å…¥
		
		return studentInfo;
	}
}




>>>>>>> 408f01557a212803392a6fde5c7b35e7b8cd5c8b
