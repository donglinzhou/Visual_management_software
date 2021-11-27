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
        list.add("49");
        
        clientthread.client(1, list);
        
    }
}