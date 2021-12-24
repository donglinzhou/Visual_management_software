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

import controller.DeptController;
import controller.ParentsController;
import controller.TeacherController;
import model.AddStudentInfoClass;
import model.AddTeacherInfoClass;
import model.CheckClassMemberListClass;
import model.CheckClassStudentGradeClass;
import model.CheckClassedListClass;
import model.CheckStudentAttendanceRecordClass;
import model.CheckStudentConsumptionInfoClass;
import model.CheckStudentGradeInfoClass;
import model.CheckStudentInfoClass;
import model.CheckStudentTrackInfoClass;
import model.CheckTeacherInfoClass;
import model.Dept;
import model.Parents;
import model.SelectALLAttendanceInfoByTypeClass;
import model.SelectALLClassAttendanceInfoClass;
import model.SelectALLClassGradeInfoClass;
import model.SelectALLStuGradeInfoClass;
import model.SelectClassGradeInfoClass;
import model.SelectClassStuNameClass;
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
        	//教务端
        	DeptController deptController = new DeptController();
        	
            //获取输入流，并读取客户端信息
            is = socket.getInputStream();
            //获取输出流，响应客户端的请求
            os = socket.getOutputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
           ObjectOutputStream oos = new ObjectOutputStream(os);
            //获取传输的对象
            int code = (int) ois.readObject();
            ArrayList<String> list = (ArrayList<String>) ois.readObject();
            ArrayList<String> login = (ArrayList<String>) ois.readObject();
            System.out.println(code);
            System.out.println(list);
            System.out.println(login);
            //登录验证后的数组存放在服务器端
	        ArrayList<Object> checklogin = new ArrayList<Object>();
	        checklogin = logincheck.logincheck(login.get(0), login.get(1));
	        if(checklogin.get(0).equals("true")) {
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
					deptController.setDeptModel(new Dept());
				}
	        }
	        else {
	        	
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
					message.add(checklogin.get(1));
					oos.writeObject(message);
				}
            	break;
            }
            case 1: {
            	//查看学生个人信息
            	parentsController.setParentsCheckStudentInfoBehavior(new CheckStudentInfoClass());
            	ArrayList<String> studentinfo = parentsController.getStudentInfoView(list.get(0));
            	
            	oos.writeObject(studentinfo);
				break;
			}
            case 2: {
      
            	//查看成长档案
            	parentsController.setParentsCheckStudentTrackInfoBehavior(new CheckStudentTrackInfoClass());
            	ArrayList<Integer> studenttrackinfo = parentsController.getStudentTrackInfoView(list.get(0), list.get(1));
            	
            	oos.writeObject(studenttrackinfo);
            	break;
			}
            case 3: {
            	
            	//查看考勤记录
            	parentsController.setParentsCheckStudentAttendanceRecordBehavior(new CheckStudentAttendanceRecordClass());
            	ArrayList<Integer> studentgardeinfo = parentsController.getStudentAttendanceRecordView(list.get(0), list.get(1));
				
            	oos.writeObject(studentgardeinfo);
				break;
			}
            case 4: {
            	
            	//查看消费记录
            	parentsController.setParentsCheckStudentConsumptionInfoBehavior(new CheckStudentConsumptionInfoClass());
            	ArrayList<Double> studentconsumptioninfo = parentsController.getStudentConsumptionInfoView(list.get(0), list.get(1));
            	
            	oos.writeObject(studentconsumptioninfo);
				break;
			}
            case 5: {
            	
            	//查看学业画像
            	parentsController.setParentsCheckStudentGradeInfoBehavior(new CheckStudentGradeInfoClass());
            	ArrayList<ArrayList<Integer>> studentgradeinfo = parentsController.getStudentGradeInfoView(list.get(0), list.get(1));
            	
            	oos.writeObject(studentgradeinfo);
            	break;
            }
            case 6: {
            	
            	//查看班级学生信息
            	teacherController.setTeachersCheckStudentInfoBehavior(new CheckStudentInfoClass());
            	ArrayList<String> studentinfo = teacherController.getStudentInfoView(list.get(0));
            	
            	oos.writeObject(studentinfo);
            	break;
            }
            case 7: {
            	
            	//查看学生考勤记录
            	teacherController.setTeachersCheckStudentAttendanceRecordBehavior(new CheckStudentAttendanceRecordClass());
            	ArrayList<Integer> studentgardeinfo = teacherController.getStudentAttendanceRecordView(list.get(0), list.get(1));
				
            	oos.writeObject(studentgardeinfo);
            	break;
            }
            case 8: {
            	
            	//查看学生成长档案
            	teacherController.setTeachersCheckStudentTrackInfoBehavior(new CheckStudentTrackInfoClass());
            	ArrayList<Integer> studenttrackinfo = teacherController.getStudentTrackInfoView(list.get(0), list.get(1));
            	
            	oos.writeObject(studenttrackinfo);
            	break;
            }
            case 9: {
            	
            	//查看学生的学业画像
            	teacherController.setTeachersCheckStudentGradeInfoBehavior(new CheckStudentGradeInfoClass());
            	ArrayList<ArrayList<Integer>> studentgradeinfo = teacherController.getStudentGradeInfoView(list.get(0), list.get(1));
            	
            	oos.writeObject(studentgradeinfo);
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
				deptController.setCheckStudentInfoBehavior(new CheckStudentInfoClass());
				ArrayList<String> studentinfo = deptController.getStudentInfoView(list.get(0));
				System.out.println(studentinfo);
				oos.writeObject(studentinfo);
            	break;
            }
			case 15: {
            	
            	//查看学生考勤记录
            	deptController.setCheckStudentAttendanceRecordBehavior(new CheckStudentAttendanceRecordClass());
            	ArrayList<Integer> studentgardeinfo = deptController.getCheckStudentAttendanceRecordView(list.get(0), list.get(1));
				
            	oos.writeObject(studentgardeinfo);
            	break;
            }
			case 16: {
            	
            	//查看学生成长档案
            	deptController.setCheckStudentTrackInfoBehavior(new CheckStudentTrackInfoClass());
            	ArrayList<Integer> studenttrackinfo = deptController.getStudentTrackInfoView(list.get(0), list.get(1));
            	
            	oos.writeObject(studenttrackinfo);
            	break;
            }
			case 17: {
            	
            	//查看学生的学业画像
            	deptController.setCheckStudentGradeInfoBehavior(new CheckStudentGradeInfoClass());
            	ArrayList<ArrayList<Integer>> studentgradeinfo = deptController.getStudentGradeView(list.get(0), list.get(1));
            	
            	oos.writeObject(studentgradeinfo);
            	break;
            }
			case 18: {
            	
            	//查看老师基本信息
            	deptController.setCheckTeacherInfoBehavior(new CheckTeacherInfoClass());
            	ArrayList<String> teacherinfo = deptController.getTeacherInfoView(list.get(0));
				System.out.println(teacherinfo);
				oos.writeObject(teacherinfo);
            	break;
            }
			case 19: {
            	
            	//查看班级学生信息表
            	deptController.setSelectClassStuNameBehavior(new SelectClassStuNameClass());
            	ArrayList<String> classstuname = deptController.getSelectClassStuNameBehavior(list);
            	
            	oos.writeObject(classstuname);
            	break;
            }
			case 20: {
				
            	//录入学生信息
            	deptController.setAddStudentInfoBehavior(new AddStudentInfoClass());
            	ArrayList<String> addstudentinfo = deptController.getAddStudentInfoBehavior(list);
            	System.out.println(addstudentinfo);
            	
            	oos.writeObject(addstudentinfo);
            	break;
            }
			case 21: {
				
            	//录入教师信息
				deptController.setAddTeacherInfoBehavior(new AddTeacherInfoClass());
            	ArrayList<String> addteacherinfo = deptController.getAddTeacherInfoBehavior(list);
            	
            	oos.writeObject(addteacherinfo);
            	break;
            }
			case 22: {
				
            	//按照考勤类型查看考勤情况
            	deptController.setSelectALLAttendanceInfoByTypeBehavior(new SelectALLAttendanceInfoByTypeClass());
            	System.out.println(list);
            	ArrayList<ArrayList<String>> allattendanceinfobytype = deptController.getSelectALLAttendanceInfoByTypeBehavior(list);
            	
            	oos.writeObject(allattendanceinfobytype);
            	break;
            }
			case 23: {
				
            	//按照班级查看考勤情况
				deptController.setSelectALLClassAttendanceInfoBehavior(new SelectALLClassAttendanceInfoClass());
				ArrayList<ArrayList<String>> allclassattendanceinfo = deptController.getSelectALLClassAttendanceInfoBehavior(list);
            	
				oos.writeObject(allclassattendanceinfo);
            	break;
            }
			case 24: {
				
            	//统计年级学业
            	deptController.setSelectALLStuGradeInfoBehavior(new SelectALLStuGradeInfoClass());
            	ArrayList<ArrayList<String>> allstugradeinfo = deptController.getSelectALLStuGradeInfoBehavior(list);
            	
            	oos.writeObject(allstugradeinfo);
            	break;
            }
			case 25: {
				
            	//统计班级学业
            	deptController.setSelectClassGradeInfoBehavior( new SelectClassGradeInfoClass());
            	ArrayList<ArrayList<String>> classgradeinfo = deptController.getSelectClassGradeInfoBehavior(list);
            	
            	oos.writeObject(classgradeinfo);
            	break;
            }
			case 26: {
            	int n =1;
            	//查看年级班级学业情况
            	deptController.setSelectALLClassGradeInfoBehavior(new SelectALLClassGradeInfoClass());
            	ArrayList<ArrayList<String>> allclassgradeinfo = deptController.getSelectALLClassGradeInfoBehavior(list);
            	
            	oos.writeObject(allclassgradeinfo);
            	break;
            }
			default:
				throw new IllegalArgumentException("Unexpected value: " + code);
			}
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