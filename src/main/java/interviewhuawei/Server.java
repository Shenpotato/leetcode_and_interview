package interviewhuawei;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

/**
 * 要求：
 *      使用ServerSocket启动8080端口，监听客户端连接
 *      将与客户端连接的Socket保存在Vector中
 *      开启一个接收该客户端消息的线程
 */
public class Server implements Runnable{
    ServerSocket ss = null;
    int port = 8080;
    static Vector<Socket> v = new Vector<Socket>();  //存储Socket信息

    public  Server(int port) {  //带参构造，指定ServerSocket绑定端口号
        this.port = port;
    }
    // 服务端线程
    public void run() {
        try{
            ss = new ServerSocket(port);   //绑定端口号

            while (true){
                Socket cs = ss.accept();  //开启监听
                v.add(cs);   //将当前Socket信息存储到集合
                new Rec_Sen_Thread(cs).start();  //开启服务器消息接收并转发线程
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    class Rec_Sen_Thread extends Thread{ //服务器接收消息并转发
        Socket cs = null;

        public Rec_Sen_Thread(Socket cs) {
            this.cs = cs;
        }

        @Override
        public void run() {
            DataInputStream dis = null;  //输入流
            try {
                dis = new DataInputStream(cs.getInputStream());
                String str = null;
                while((str=dis.readUTF()) != null){ //读取数据
                    for (Socket socket : v) { //轮询发送
                        if (cs != socket) {  //不给消息来源客户端转发它自己的消息
                            DataOutputStream dos =
                                    new DataOutputStream(socket.getOutputStream());
                            dos.writeUTF(str);  //转发消息
                            dos.flush();
                            //System.out.println(str);
                        }
                    }

                }

/*
                byte[] bys = new byte[1024*8];
                int len = 0;
                while ((len=dis.read()) != -1){
                    for (Socket socket : v) {
                        if (cs != socket) {
                            DataOutputStream dos =
                                    new DataOutputStream(socket.getOutputStream());
                            dos.write(bys,0,len);
                        }
                    }
                }
*/
            } catch (IOException e) {
                e.printStackTrace();
            }finally {  //释放资源
                if(dis != null){
                    try {
                        dis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }






    public static void main(String[] args) {
        Server server = new Server(8080);
        new Thread(server).start();  //开启线程

    }


}

