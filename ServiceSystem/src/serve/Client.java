package serve;

import java.util.ArrayList;

/*
 * 客户端
 */
public class Client {
    public static void main(String[] args) {
        ClientThread clientthread = new ClientThread();
        //声明一个Arraylist用于测试
        //传入的参数数组
        ArrayList<String> list = new ArrayList<String>();
        //传入的登录数组
        ArrayList<String> login = new ArrayList<String>();
        //list数组为需要传入的参数
//        list.add("901");
        list.add("7");
        list.add("3");

        //下面传入登录数组元素
        login.add("1234");
        login.add("1234");
        
        //调用类中的方法，传入参数为接口序号，输入参数
        clientthread.client(24,list,login);
//        Object object = clientthread.client(26,list,login);
//        System.out.println(object);
    }
}