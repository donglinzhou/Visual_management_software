package serve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import Controller.ParentsController;
import Controller.TeacherController;
import model.CheckClassMemberListClass;
import model.CheckClassedListClass;
import model.CheckStudentGradeInfoClass;
import model.CheckStudentInfoClass;
import model.CheckTeacherInfoClass;
import model.Parents;
import model.Teachers;

/*
 * 服务器线程处理类
 */
public class ServerThread extends Thread {
    // 和本线程相关的Socket
    Socket socket = null;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }
    
    //线程执行的操作，响应客户端的请求
    @Override
	public void run(){
    	
    	TeacherController teacherController = new TeacherController();
    	teacherController.setTeachersModel(new Teachers());
    	ParentsController parentsController = new ParentsController();
    	parentsController.setParentsModel(new Parents());
    	
        InputStream is=null;
        InputStreamReader isr=null;
        BufferedReader br=null;
        OutputStream os=null;
        PrintWriter pw=null;
        try {
			
            //获取输入流，并读取客户端信息
            is = socket.getInputStream();
//            isr = new InputStreamReader(is);
//            br = new BufferedReader(isr);
//            String info=null;
//            while((info=br.readLine())!=null){//循环读取客户端的信息
//                System.out.println("我是服务器，客户端说："+info);
//            }
//            socket.shutdownInput();//关闭输入流
            //获取输出流，响应客户端的请求
            os = socket.getOutputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
           ObjectOutputStream oos = new ObjectOutputStream(os);
            //获取传输的对象
            int code = (int) ois.readObject();
            ArrayList<String> list = (ArrayList<String>) ois.readObject();
            
            switch (code) {
            case 1: {
            	//学生基本画像
            	parentsController.setParentsCheckStudentInfoBehavior(new CheckStudentInfoClass());
            	ArrayList<String> studentinfo = parentsController.getStudentInfoView();
				
            	oos.writeObject(studentinfo);
				break;
			}
            case 2: {
            	//学生学业画像
            	parentsController.setParentsCheckStudentGradeInfoBehavior(new CheckStudentGradeInfoClass());
            	ArrayList<ArrayList<String>> studentgardeinfo = parentsController.getStudentGradeInfoView();
				
            	oos.writeObject(studentgardeinfo);
				break;
			}
            case 6: {
            	//查询老师基本信息
            	teacherController.setTeachersCheckTeacherInfoBehavior(new CheckTeacherInfoClass());
            	ArrayList<String> teacherinfo = teacherController.getTeacherInfoView(list.get(0));
				
            	oos.writeObject(teacherinfo);
				break;
			}
			case 7: {
				//查看任课班级名单
				teacherController.setTeachersCheckClassedListBehavior(new CheckClassedListClass());
				ArrayList<String> classList = teacherController.getClassListView(list.get(0));
				
				oos.writeObject(classList);
				break;
			}
			case 8: {
				//查看班级学生名单
				teacherController.setTeachersCheckClassMemberListBehavior(new CheckClassMemberListClass());
				ArrayList<String> classmemberList = teacherController.getClassMemberListView(list.get(0));
				
				oos.writeObject(classmemberList);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + code);
			}
//            System.out.println(code);
//            System.out.println(list);
            
            
            //声明一个对象用于测试
            
            

//            pw = new PrintWriter(os);
//            pw.write("欢迎您！");
//            pw.flush();//调用flush()方法将缓冲输出
        } catch (IOException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            //关闭资源
            try {
                if(pw!=null)
                    pw.close();
                if(os!=null)
                    os.close();
                if(br!=null)
                    br.close();
                if(isr!=null)
                    isr.close();
                if(is!=null)
                    is.close();
                if(socket!=null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}