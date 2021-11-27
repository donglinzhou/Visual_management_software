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
	public void client(int code, ArrayList<String> list) {
		try {
            //1.创建客户端Socket，指定服务器地址和端口
            Socket socket=new Socket("localhost", 8888);
            //2.获取输出流，向服务器端发送信息
            OutputStream os=socket.getOutputStream();//字节输出流
            InputStream is=socket.getInputStream();//字节输入流

            //创建输出对象流，将对象输出
            ObjectOutputStream oos = new ObjectOutputStream(os);
            ObjectInputStream ois = new ObjectInputStream(is);
            //oos.writeObject(test);
            //根据输入的序号执行对应的功能
            switch (code) {
            case 1: {
            	//查询老师基本信息
				oos.writeObject(code);
				ArrayList<String> object = (ArrayList<String>) ois.readObject();
				System.out.println(object); 
				break;
			}
            case 2: {
            	//学生学业画像
            	oos.writeObject(code);
            	ArrayList<ArrayList<String>> object = (ArrayList<ArrayList<String>>) ois.readObject();
				
            	oos.writeObject(object);
				break;
			}
            case 6: {
            	//查询老师基本信息
				oos.writeObject(code);
				oos.writeObject(list);
				ArrayList<String> object = (ArrayList<String>) ois.readObject();
				System.out.println(object); 
				break;
			}
			case 7: {
				//查看任课班级名单
				oos.writeObject(code);
				oos.writeObject(list);
				ArrayList<String> object = (ArrayList<String>) ois.readObject();
				System.out.println(object); 
				break;
			}
			case 8: {
				//查看班级学生名单
				oos.writeObject(code);
				oos.writeObject(list);
				ArrayList<String> object = (ArrayList<String>) ois.readObject();
				System.out.println(object); 
				break;
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
		} 
	}
}
