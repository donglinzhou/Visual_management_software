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
import model.CheckClassStudentGradeClass;
import model.CheckClassedListClass;
import model.CheckStudentAttendanceRecordClass;
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
    	
        InputStream is=null;
        InputStreamReader isr=null;
        BufferedReader br=null;
        OutputStream os=null;
        PrintWriter pw=null;
        
        
       
        try {
			//初始化类：
        	//登陆验证
        	Logincheck logincheck = new Logincheck();
        	//家长端
        	ParentsController parentsController = new ParentsController();
        	//老师端
        	TeacherController teacherController = new TeacherController();
        	
        	
            //获取输入流，并读取客户端信息
            is = socket.getInputStream();
            //获取输出流，响应客户端的请求
            os = socket.getOutputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
           ObjectOutputStream oos = new ObjectOutputStream(os);
            //获取传输的对象
            int code = (int) ois.readObject();
            ArrayList<String> list = (ArrayList<String>) ois.readObject();
            
            //登录验证后的数组存放在服务器端
	        ArrayList<Object> checklogin = new ArrayList<Object>();
	        checklogin = logincheck.logincheck(list.get(list.size()-2), list.get(list.size()-1));
	        if(checklogin.get(1).equals("0")) {
	        	//家长端
	        	parentsController.setParentsModel(new Parents());
		        	
		        	
			}
			if (checklogin.get(1).equals("1")) {
				//教师端
				teacherController.setTeachersModel(new Teachers());		
			}
			if (checklogin.get(1).equals("2")) {
				//教务端
				
			}
            switch (code) {
	           
            case 0: {
            	
            	ArrayList<Object> message = new ArrayList<Object>();
            	
            	if (checklogin == null || checklogin.get(0).equals("false")) {
            		//验证失败
					String error = new String("输入的账户或密码错误请重新输入");
					message.add("false");
					message.add(error);
            		oos.writeObject(message);
            		break;
				}else {
					//验证通过
					message.add("true");
					message.add("登陆成功！");
					oos.writeObject(message);
				}
            	break;
            }
            case 1: {
            	//查看学生个人信息
            	
				break;
			}
            case 2: {
            	
            	//查看成长档案
            	break;
			}
            case 3: {
            	
            	//查看考勤记录
            	parentsController.setParentsCheckStudentAttendanceRecordBehavior(new CheckStudentAttendanceRecordClass());
            	//ArrayList<Integer> studentgardeinfo = parentsController.getStudentAttendanceRecordView(list.get(0), list.get(1));
				
            	//oos.writeObject(studentgardeinfo);
				break;
			}
            case 4: {
            	
            	//查看消费记录
            	
            	
				break;
			}
            case 5: {
            	
            	//查看学业画像
            	
            	break;
            }
            case 6: {
            	
            	//查看班级学生信息
            	
            	break;
            }
            case 7: {
            	
            	//查看学生考勤记录
            	
            	break;
            }
            case 8: {
            	
            	//查看学生成长档案

            	
            	break;
            }
            case 9: {
            	
            	//查看学生的学业画像
            	
            	break;
            }
            case 10: {
            	
            	//查看班级学业信息
            	teacherController.setTeachersCheckClassStudentGradeBehavior(new CheckClassStudentGradeClass());
            	ArrayList<ArrayList<Integer>> classstudentgrade = teacherController.getClassStudentGradeView(list.get(0),list.get(1),list.get(2),list.get(3));
				
            	oos.writeObject(classstudentgrade);
				break;
			}
			case 11: {
				
				//查看老师信息
				teacherController.setTeachersCheckTeacherInfoBehavior(new CheckTeacherInfoClass());
				ArrayList<String> teacherinfo = teacherController.getTeacherInfoView(list.get(0));
				
				oos.writeObject(teacherinfo);
				break;
			}
			case 12: {
				
				//查看任课班级
				teacherController.setTeachersCheckClassedListBehavior(new CheckClassedListClass());
				ArrayList<String> classList = teacherController.getClassListView(list.get(0));
				
				oos.writeObject(classList);
				break;
			}
			case 13: {
				
				//查看班级学生名单
				teacherController.setTeachersCheckClassMemberListBehavior(new CheckClassMemberListClass());
				ArrayList<String> classmemberList = teacherController.getClassMemberListView(list.get(0));
				
				oos.writeObject(classmemberList);
				break;
			}
			case 14: {
            	
            	//查看学生的基本信息
			
            	break;
            }
			case 15: {
            	
            	//查看学生考勤记录
            	
            	break;
            }
			case 16: {
            	
            	//查看学生成长档案
            	
            	break;
            }
			case 17: {
            	
            	//查看学生的学业画像
            	
            	break;
            }
			case 18: {
            	
            	//查看老师基本信息
            	
            	break;
            }
			case 19: {
            	
            	//查看班级学生信息表
            	
            	break;
            }
			case 20: {
            	
            	//录入学生信息
            	
            	break;
            }
			case 21: {
            	
            	//录入教师信息
            	
            	break;
            }
			case 22: {
            	
            	//查看班级人数
            	
            	break;
            }
			case 23: {
            	
            	//查看考勤情况
            	
            	break;
            }
			case 24: {
            	
            	//统计年级学业
            	
            	break;
            }
			case 25: {
            	
            	//统计班级学业
            	
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