package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

import model.Dept;

public class main {
    public static void main(String[] args){
		// TODO 自动生成的方法存根
		//先创建一个controller类
		DeptController deptController = new DeptController();
		//在Controller里面先设定model和View
		deptController.setDeptModel(new Dept());
//		暂时还没写 View
//		deptController.setDeptView(new DeptView());
		
		Socket socket = null;
	    try {
	    	socket = new Socket("localhost",8081);//创建Socket, 请求服务端
	    	System.out.println("客户端已经连接上");
    		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    		PrintStream ps = new PrintStream(socket.getOutputStream());
    		Scanner scanner = new Scanner(System.in);   // 创建Scanner
    		System.out.println("请输入一个字符串:");    // 给出提示输入
            scanner.useDelimiter("\r\n");
            String msg = null;
            while( !(msg = scanner.next()).equals("Bye") ){
                System.out.printf("Send Msg --> %s \n", msg);
	    		ps.println(msg);//发送到服务端
	    		ps.flush(); // 立即发送，否则需要积累到一定大小才一次性发送
	    		if((socket.getInputStream().available())==0)
	    			System.out.println(br.readLine());// 读取服务端发回的字符串, 打印  
	    	}
            scanner.close();
            
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

