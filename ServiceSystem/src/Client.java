package serve;


import java.util.ArrayList;

/*
 * 客户端
 */
public class Client {
    public static void main(String[] args) {
        ClientThread clientthread = new ClientThread();
        //声明一个Arraylist用于测试
        ArrayList<String> list = new ArrayList<String>();
        list.add("15888");
        list.add("语文");
        
        //调用类中的方法，传入参数为接口序号，输入参数
        clientthread.client(1, list);
        
    }
}