package Controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

import View.TeachersView;
import model.Teachers;

public class main {

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		//先创建一个controller类
		TeacherController teacherController = new TeacherController();
		//在Controller里面先设定model和View
		teacherController.setTeachersModel(new Teachers());
		teacherController.setTeachersView(new TeachersView());
		
		//需要设定查看老师基本信息的行为类
		//teacherController.setTeachersCheckTeacherInfoBehavior(new CheckTeacherInfoClass());
		//调用视图就可以查看老师的基本信息了
		//teacherController.getTeacherInfoView();
		
		//设定查看班级学生的行为类
		//teacherController.setTeachersCheckClassMemberListBehavior(new CheckClassMemberListClass());
		//调用试图就可以查看老师的基本信息了
		//teacherController.getClassMemberListView();
		
		Socket socket = null;
	    try {
	     socket = new Socket("172.16.107.100",8081);//创建Socket, 请求服务端
	     System.out.println("客户端已经连接上");
	     while(true){
	      BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	      PrintStream ps = new PrintStream(socket.getOutputStream());
	      Scanner scanner = new Scanner(System.in);   // 创建Scanner
	      System.out.println("请输入一个字符串6:");    // 给出提示输入
	      String line = scanner.nextLine();     // 从键盘输入读取一行
	      ps.println(line);//发送到服务端
	      ps.flush();
	      if((socket.getInputStream().available())==0)
	      System.out.println(br.readLine());// 读取服务端发回的字符串, 打印  
	         }
	    } catch (Exception e){
	     e.printStackTrace();
	    }finally{
	     if(socket != null){
	      try {
	       socket.close();
	      } catch (IOException e) {
	       e.printStackTrace();
	      }
	     }
	    }
	   }
	}

