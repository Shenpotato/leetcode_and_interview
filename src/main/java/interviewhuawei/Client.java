package interviewhuawei;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * 要求：
 *      客户端开启发送消息和接收消息线程
 */

public class Client implements Runnable{
    Socket cs = null;
    String host;   //远端服务器名称和端口
    int port;

    public Client(String host, int port){
        this.host = host;
        this.port = port;
    }


    public void run() {
        try{
            cs = new Socket(InetAddress.getByName(host), port);//建立连接

            new RecThread(cs).start(); //解决接收数据时产生的阻塞
            new SendThread(cs).start();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    class RecThread extends Thread{ //接收消息线程
        Socket cs = null;

        public RecThread(Socket cs){
            this.cs = cs;
        }

        public void run(){
            String str;
            DataInputStream dis = null;
            try {
                dis = new DataInputStream(cs.getInputStream());//输入流
                while((str = dis.readUTF())!=null){ // 网络阻塞点，读取数据
                    System.out.println(str);   //消息打印在控制台，模拟客户端收到消息
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {  //释放资源
                if(dis!=null){
                    try {
                        dis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

        }
    }

    class SendThread extends Thread{  //客户端发送线程
        Socket cs = null;
        public SendThread(Socket cs){
            this.cs = cs;
        }

        public void run(){
            String str;
            DataOutputStream dos = null;
            try{
                Scanner input = new Scanner(System.in);  //客户端输入消息
                dos = new DataOutputStream(cs.getOutputStream());//输出流
                while((str = input.next())!=null){ //键盘阻塞
                    if("886".equals(str)){ //客户端结束聊天，主动断开Socket连接
                        dos.writeUTF("Byebye!");
                        dos.flush();
                        break;
                    }
                    dos.writeUTF(str);  //输出
                    dos.flush();   //立即从缓冲发送

                }
            }catch(Exception e){
                e.printStackTrace();
            }finally {  //释放资源
                if(dos!=null){
                    try {
                        dos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }





    public static void main(String [] args){
        Client c = new Client("localhost", 8080);
        new Thread(c).start();

    }

}

