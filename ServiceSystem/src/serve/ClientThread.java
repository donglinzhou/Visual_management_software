package serve;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class ClientThread {
<<<<<<< HEAD
	public void client(int code, ArrayList<String> list) {
		try {
            //1.创建客户端Socket，指定服务器地址和端口
			//如果不是本机链接，则将localhost改为链接服务器的IP
            Socket socket=new Socket("172.16.99.168", 8888);
=======
	public void client(int code, ArrayList<String> list, ArrayList<String> login) {
		try {
            //1.创建客户端Socket，指定服务器地址和端口
			//如果不是本机链接，则将localhost改为链接服务器的IP
            Socket socket=new Socket("localhost", 8888);
>>>>>>> 408f01557a212803392a6fde5c7b35e7b8cd5c8b
            //2.获取输出流，向服务器端发送信息
            OutputStream os=socket.getOutputStream();//字节输出流
            InputStream is=socket.getInputStream();//字节输入流

            //创建输出对象流，将对象输出
            ObjectOutputStream oos = new ObjectOutputStream(os);
            ObjectInputStream ois = new ObjectInputStream(is);
            //oos.writeObject(test);
            //根据输入的序号执行对应的功能
            //本功能目前没有实现传输数据，只是把得到的数据进行打印
            switch (code) {
            case 0: {
            	oos.writeObject(code);
            	oos.writeObject(list);
<<<<<<< HEAD
=======
            	oos.writeObject(login);
>>>>>>> 408f01557a212803392a6fde5c7b35e7b8cd5c8b
            	ArrayList<Object> object =  (ArrayList<Object>) ois.readObject();
            	System.out.println(object);
            	break;
            }
            case 1: {
            	
            	//查看学生个人信息
            	oos.writeObject(code);
				oos.writeObject(list);
<<<<<<< HEAD
=======
				oos.writeObject(login);
				ArrayList<String> object = (ArrayList<String>) ois.readObject();
				System.out.println(object); 
>>>>>>> 408f01557a212803392a6fde5c7b35e7b8cd5c8b
				break;
			}
            case 2: {
            	//查看成长档案
            	oos.writeObject(code);
				oos.writeObject(list);
<<<<<<< HEAD
=======
				oos.writeObject(login);
				ArrayList<Integer> object = (ArrayList<Integer>) ois.readObject();
				System.out.println(object); 
>>>>>>> 408f01557a212803392a6fde5c7b35e7b8cd5c8b
            	break;
			}
            case 3: {
            	//查看考勤记录
				oos.writeObject(code);
				oos.writeObject(list);
<<<<<<< HEAD
=======
				oos.writeObject(login);
>>>>>>> 408f01557a212803392a6fde5c7b35e7b8cd5c8b
				ArrayList<Integer> object = (ArrayList<Integer>) ois.readObject();
				System.out.println(object); 
				break;
			}
			case 4: {
				//查看消费记录
				oos.writeObject(code);
				oos.writeObject(list);
<<<<<<< HEAD
            	
=======
				oos.writeObject(login);
				ArrayList<Double> object = (ArrayList<Double>) ois.readObject();
				System.out.println(object); 
>>>>>>> 408f01557a212803392a6fde5c7b35e7b8cd5c8b
				break;
			}
			case 5: {
				//查看学业画像
				oos.writeObject(code);
				oos.writeObject(list);
<<<<<<< HEAD
=======
				oos.writeObject(login);
				ArrayList<ArrayList<Integer>> object = (ArrayList<ArrayList<Integer>>) ois.readObject();
				System.out.println(object); 
>>>>>>> 408f01557a212803392a6fde5c7b35e7b8cd5c8b
            	break;
			}
			case 6: {
				//查看班级学生信息
				oos.writeObject(code);
				oos.writeObject(list);
<<<<<<< HEAD
=======
				oos.writeObject(login);
				ArrayList<String> object = (ArrayList<String>) ois.readObject();
				System.out.println(object); 
>>>>>>> 408f01557a212803392a6fde5c7b35e7b8cd5c8b
            	break;
			}
			case 7: {
            	
            	//查看学生考勤记录
				oos.writeObject(code);
				oos.writeObject(list);
<<<<<<< HEAD
=======
				oos.writeObject(login);;
				ArrayList<Integer> object = (ArrayList<Integer>) ois.readObject();
				System.out.println(object);  
>>>>>>> 408f01557a212803392a6fde5c7b35e7b8cd5c8b
            	break;
            }
            case 8: {
            	
            	//查看学生成长档案
            	oos.writeObject(code);
				oos.writeObject(list);
<<<<<<< HEAD
            	
=======
				oos.writeObject(login);
				ArrayList<Integer> object = (ArrayList<Integer>) ois.readObject();
				System.out.println(object);
>>>>>>> 408f01557a212803392a6fde5c7b35e7b8cd5c8b
            	break;
            }
            case 9: {
            	
            	//查看学生的学业画像
            	oos.writeObject(code);
				oos.writeObject(list);
<<<<<<< HEAD
=======
				oos.writeObject(login);
				ArrayList<ArrayList<Integer>> object = (ArrayList<ArrayList<Integer>>) ois.readObject();
				System.out.println(object);
>>>>>>> 408f01557a212803392a6fde5c7b35e7b8cd5c8b
            	break;
            }
			case 10: {
				//查看班级学业信息
				oos.writeObject(code);
				oos.writeObject(list);
<<<<<<< HEAD
=======
				oos.writeObject(login);
>>>>>>> 408f01557a212803392a6fde5c7b35e7b8cd5c8b
				ArrayList<ArrayList<Integer>> object = (ArrayList<ArrayList<Integer>>) ois.readObject();
				System.out.println(object); 
				break;
			}
			case 11: {
            	//查询老师基本信息
				oos.writeObject(code);
<<<<<<< HEAD
=======
				oos.writeObject(list);
				oos.writeObject(login);
>>>>>>> 408f01557a212803392a6fde5c7b35e7b8cd5c8b
				ArrayList<String> object = (ArrayList<String>) ois.readObject();
				System.out.println(object); 
				break;
			}
            case 12: {
            	//查看任课班级
            	oos.writeObject(code);
            	oos.writeObject(list);
<<<<<<< HEAD
            	ArrayList<String> object = (ArrayList<String>) ois.readObject();
				
            	oos.writeObject(object);
=======
            	oos.writeObject(login);
            	ArrayList<String> object = (ArrayList<String>) ois.readObject();
            	System.out.println(object);
>>>>>>> 408f01557a212803392a6fde5c7b35e7b8cd5c8b
				break;
			}
            case 13: {
            	//查看班级学生名单
				oos.writeObject(code);
				oos.writeObject(list);
<<<<<<< HEAD
=======
				oos.writeObject(login);
>>>>>>> 408f01557a212803392a6fde5c7b35e7b8cd5c8b
				ArrayList<String> object = (ArrayList<String>) ois.readObject();
				System.out.println(object); 
				break;
			}
            case 14: {
            	
            	//查看学生的基本信息
            	oos.writeObject(code);
				oos.writeObject(list);
<<<<<<< HEAD
=======
				oos.writeObject(login);
				ArrayList<String> object = (ArrayList<String>) ois.readObject();
				System.out.println(object);
>>>>>>> 408f01557a212803392a6fde5c7b35e7b8cd5c8b
            	break;
            }
			case 15: {
            	
            	//查看学生考勤记录
				oos.writeObject(code);
				oos.writeObject(list);
<<<<<<< HEAD
=======
				oos.writeObject(login);
				ArrayList<Integer> object = (ArrayList<Integer>) ois.readObject();
				System.out.println(object); 
>>>>>>> 408f01557a212803392a6fde5c7b35e7b8cd5c8b
            	break;
            }
			case 16: {
            	
            	//查看学生成长档案
				oos.writeObject(code);
				oos.writeObject(list);
<<<<<<< HEAD
=======
				oos.writeObject(login);
				ArrayList<Integer> object = (ArrayList<Integer>) ois.readObject();
				System.out.println(object);
>>>>>>> 408f01557a212803392a6fde5c7b35e7b8cd5c8b
            	break;
            }
			case 17: {
            	
            	//查看学生的学业画像
				oos.writeObject(code);
				oos.writeObject(list);
<<<<<<< HEAD
=======
				oos.writeObject(login);
				ArrayList<ArrayList<Integer>> object = (ArrayList<ArrayList<Integer>>) ois.readObject();
				System.out.println(object); 
>>>>>>> 408f01557a212803392a6fde5c7b35e7b8cd5c8b
            	break;
            }
			case 18: {
            	
            	//查看老师基本信息
				oos.writeObject(code);
				oos.writeObject(list);
<<<<<<< HEAD
=======
				oos.writeObject(login);
				ArrayList<String> object = (ArrayList<String>) ois.readObject();
				System.out.println(object);
>>>>>>> 408f01557a212803392a6fde5c7b35e7b8cd5c8b
            	break;
            }
			case 19: {
            	
            	//查看班级学生信息表
				oos.writeObject(code);
				oos.writeObject(list);
<<<<<<< HEAD
=======
				oos.writeObject(login);
				ArrayList<ArrayList<Integer>> object = (ArrayList<ArrayList<Integer>>) ois.readObject();
				System.out.println(object);
>>>>>>> 408f01557a212803392a6fde5c7b35e7b8cd5c8b
            	break;
            }
			case 20: {
            	
            	//录入学生信息
				oos.writeObject(code);
				oos.writeObject(list);
<<<<<<< HEAD
=======
				oos.writeObject(login);
				ArrayList<String> object = (ArrayList<String>) ois.readObject();
				System.out.println(object);
>>>>>>> 408f01557a212803392a6fde5c7b35e7b8cd5c8b
            	break;
            }
			case 21: {
            	
            	//录入教师信息
				oos.writeObject(code);
				oos.writeObject(list);
<<<<<<< HEAD
=======
				oos.writeObject(login);
				ArrayList<String> object = (ArrayList<String>) ois.readObject();
				System.out.println(object);
>>>>>>> 408f01557a212803392a6fde5c7b35e7b8cd5c8b
            	break;
            }
			case 22: {
            	
<<<<<<< HEAD
            	//查看班级人数
				oos.writeObject(code);
				oos.writeObject(list);
=======
            	//按照考勤类型查看考勤情况
				oos.writeObject(code);
				oos.writeObject(list);
				oos.writeObject(login);
				ArrayList<ArrayList<String>> object = (ArrayList<ArrayList<String>>) ois.readObject();
				System.out.println(object);
>>>>>>> 408f01557a212803392a6fde5c7b35e7b8cd5c8b
            	break;
            }
			case 23: {
            	
<<<<<<< HEAD
            	//查看考勤情况
				oos.writeObject(code);
				oos.writeObject(list);
=======
            	//按照班级查看考勤情况
				oos.writeObject(code);
				oos.writeObject(list);
				oos.writeObject(login);
				ArrayList<ArrayList<String>> object = (ArrayList<ArrayList<String>>) ois.readObject();
				System.out.println(object);
>>>>>>> 408f01557a212803392a6fde5c7b35e7b8cd5c8b
            	break;
            }
			case 24: {
            	
<<<<<<< HEAD
            	//统计年级学业
				oos.writeObject(code);
				oos.writeObject(list);
=======
            	//统计年级学业情况
				oos.writeObject(code);
				oos.writeObject(list);
				oos.writeObject(login);
				ArrayList<ArrayList<String>> object = (ArrayList<ArrayList<String>>) ois.readObject();
				System.out.println(object);
>>>>>>> 408f01557a212803392a6fde5c7b35e7b8cd5c8b
            	break;
            }
			case 25: {
            	
            	//统计班级学业
				oos.writeObject(code);
				oos.writeObject(list);
<<<<<<< HEAD
            	break;
=======
				oos.writeObject(login);
				ArrayList<ArrayList<String>> object = (ArrayList<ArrayList<String>>) ois.readObject();
				System.out.println(object);
            	break;
            }
			case 26: {
            	
            	//查看年级班级学业情况
				oos.writeObject(code);
				oos.writeObject(list);
				oos.writeObject(login);
				ArrayList<ArrayList<String>> object = (ArrayList<ArrayList<String>>) ois.readObject();
				System.out.println(object);
            	break;
//				socket.close();
//				return object;
>>>>>>> 408f01557a212803392a6fde5c7b35e7b8cd5c8b
            }
			default:
				System.out.println("没有对应的序号：" + code);
				
			}
          
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
<<<<<<< HEAD
		} 
=======
		}
		//return null; 
>>>>>>> 408f01557a212803392a6fde5c7b35e7b8cd5c8b
	}
}
